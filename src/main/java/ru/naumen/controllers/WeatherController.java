package ru.naumen.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.naumen.model.WeatherData;

/**
 * Created by dkirpichenkov on 31.10.16.
 *
 * Простой пример REST контрлллера, который будет обрабатывать запросы
 */
@RestController
public class WeatherController
{
    @RequestMapping("/weatherdata")
    public List<WeatherData> getWeather()
    {
        List<WeatherData> weather = new ArrayList<>();
        weather.add(new WeatherData("30-10-2016", -1));
        weather.add(new WeatherData("31-10-2016", -3));
        return weather;
    }
}
