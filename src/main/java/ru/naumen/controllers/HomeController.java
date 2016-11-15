package ru.naumen.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.model.WeatherData;
import ru.naumen.storage.Storage;

/**
 * Created by dkirpichenkov on 31.10.16.
 */
@Controller
public class HomeController {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    @Inject
    private Storage storage;

    @RequestMapping("/")
    public String index(Model model, HttpMethod method, HttpServletRequest request) {
        model.addAttribute("name", "World");
        //model.addAttribute("allItems", storage.getAllData());

        if (method == HttpMethod.POST) {
            String strId = request.getParameter("id");
            if (StringUtils.isEmpty(strId)) {
                throw new RuntimeException("id is empty");
            }
            int id = Integer.valueOf(strId);

            String strDate = request.getParameter("date");
            if (StringUtils.isEmpty(strDate)) {
                throw new RuntimeException("date is empty");
            }

            LocalDate date = LocalDate.parse(strDate, FORMAT);

            if (date.isAfter(LocalDate.of(2018, 7, 1))) {
                throw new RuntimeException("Date is too far in the future!");
            }

            String value = request.getParameter("value");
            if (StringUtils.isEmpty(value)) {
                throw new RuntimeException("value is empty");
            }
            int temperature = Integer.valueOf(value);

            storage.add(new WeatherData(id, strDate, temperature));
        }

        String result = "<form name='createWeather' id='createWeather' method='post' action='#'>";
        result += "<h2>Добавление данных о погоде</h2>";
        result += "<label for='id'>Идентификатор</label>";
        result += "<input type='text' id='id' name='id' size='30' value=''>";
        result += "<br/>";
        result += "<label for='date'>Дата</label>";
        result += "<input type='text' id='date' name='date' size='30' value=''>";
        result += "<br/>";
        result += "<label for='value'>Значение</label>";
        result += "<input type='text' id='value' name='value' size='30' value=''>";
        result += "<br/>";
        result += "<input type='submit' id='create' name='create' value='Сохранить'/>";
        result += "</form>";


        result += "<br/>";
        result += "<h2>Существующие значения</h2>";
        result += "<table border='1px'><tbody>";
        result += "<tr><th>Идентификатор</th><th>Дата</th><th>Значение (C)</th>";

        for (WeatherData data : storage.getAllData()) {
            result += "<tr>";
            result += "<td>" + data.getId() + "</td>";
            result += "<td>" + data.getDate() + "</td>";
            result += "<td>" + data.getTemperature() + "</td>";
            result += "</tr>";
        }

        result += "</tbody></table>";

        model.addAttribute("pageContent", result);

        return "index";
    }
}
