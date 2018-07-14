package main

import (
	"bufio"
	"encoding/json"
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"os"
	"path"
	"strings"
	"jaytaylor.com/html2text"
	"github.com/olekukonko/tablewriter"
)

type Firmware struct {
	Version string
	Cameras []Cameras
}

type Cameras struct {
	Name         string
	Url          string
	Version      string
	Model_string string
	Release_date string
	Release_html string
}

func DownloadFile(url string) error {
	filepath := path.Base(url)
	out, err := os.Create(filepath)
	if err != nil {
		return err
	}
	defer out.Close()
	resp, err := http.Get(url)
	if err != nil {
		return err
	}
	defer resp.Body.Close()
	_, err = io.Copy(out, resp.Body)
	if err != nil {
		return err
	}
	return nil
}

func main() {

	response, err := http.Get("https://firmware-api.gopro.com/v2/firmware/catalog")
	if err != nil {
		fmt.Printf("%s", err)
		os.Exit(1)
	} else {
		defer response.Body.Close()
		contents, err := ioutil.ReadAll(response.Body)
		if err != nil {
			fmt.Printf("%s", err)
			os.Exit(1)
		}
		var firm Firmware
		json.Unmarshal([]byte(contents), &firm)
		choice := ""
		reader := bufio.NewReader(os.Stdin)
		
		if len(os.Args) > 1{
			choice = os.Args[1]
		} else {
			for cam := range firm.Cameras {
				fmt.Printf("- %s [%s]\n", firm.Cameras[cam].Model_string, firm.Cameras[cam].Name)
			}
			fmt.Print(">> Camera: ")
			choice, _ = reader.ReadString('\n')
		}
		for cam := range firm.Cameras {
			if strings.Contains(choice, firm.Cameras[cam].Model_string) {
				text, err := html2text.FromString(firm.Cameras[cam].Release_html, html2text.Options{PrettyTables: true})
				if err != nil {
					panic(err)
				}
				
				data := [][]string{
					[]string{text, firm.Cameras[cam].Release_date},
				}

				table := tablewriter.NewWriter(os.Stdout)
				table.SetHeader([]string{"Version", "Release-date"})

				for _, v := range data {
					table.Append(v)
				}
				table.Render() 
			
				fmt.Print(">> Download [Y/n]: ")
				choice, _ = reader.ReadString('\n')
				if choice == "Y\n" {
					//Download
					fmt.Printf("Downloading: %s\n", firm.Cameras[cam].Url)
					DownloadFile(firm.Cameras[cam].Url)
				}
			}
		}

	}
}
