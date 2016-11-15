package ru.naumen.storage;

import java.util.List;
import ru.naumen.model.WeatherData;

/**
 * @author ykalemi
 * @since 15.11.16
 */
public interface Storage {

    List<WeatherData> getAllData();

    WeatherData get(int id);

    void add(WeatherData data);

    void remove(int id);

    boolean isEmpty();
}
