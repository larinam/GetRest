package ru.naumen.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.naumen.model.WeatherData;

/**
 * Created by dkirpichenkov on 31.10.16.
 *
 * Простой пример REST контрлллера, который будет обрабатывать запросы
 *
 * <b>Важно</b>
 * 
 * @RestController автоматическое преобразование данных из/в JSON. Применение - класс
 * @RequestMapping - указание URL и HTTP метода для обработки. Применение метод/класс
 * @PathVariable - получение данных из url. Применение аргумент метода
 * @RequestBody - получение объекта из тела запроса
 */
@RestController
public class WeatherController
{
    @RequestMapping(value = "/weatherdata", method = RequestMethod.GET)
    public List<WeatherData> getWeather()
    {
        return Arrays.asList(new WeatherData(0, "30-10-2016", -1), new WeatherData(1, "31-10-2016", -3));
    }

    @RequestMapping(value = "/weatherdata/{id}", method = RequestMethod.GET)
    public WeatherData getOneWeather(@PathVariable("id") int id)
    {
        return new WeatherData(id, "-1", -2 * id);
    }
}
