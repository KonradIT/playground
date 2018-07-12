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
		for cam := range firm.Cameras {
			fmt.Printf("- %s [%s]\n", firm.Cameras[cam].Model_string, firm.Cameras[cam].Name)
		}

		reader := bufio.NewReader(os.Stdin)
		fmt.Print(">> Camera: ")
		choice, _ := reader.ReadString('\n')
		for cam := range firm.Cameras {
			if strings.Contains(choice, firm.Cameras[cam].Model_string) {
				fmt.Printf("== %s ==\nDate: %s\n", firm.Cameras[cam].Version, firm.Cameras[cam].Release_date)
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
