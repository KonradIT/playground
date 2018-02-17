package com.chernowii.practicemakesperfect.utils

/**
 * Created by konrad on 2/4/18.
 */
class Weather(var city: String){
    public fun getTemperature(): String {
        var temperature= "%s C | %s F"
        return temperature
    }

    public fun getCondition(): String {
        var forecast= "Cloudy"
        return forecast
    }

    public fun getForecast(): String {
        var forecast= "M: Sunny T: Sunny W: Sunny T: Sunny F: Sunny S: Sunny S: Sunny"
        return forecast
    }

    public fun getHumidity(): String {
        var humidity = "23%"
        return humidity
    }
    public fun getCityName(): String{
        return city;
    }
}