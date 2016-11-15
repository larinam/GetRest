package ru.naumen.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import ru.naumen.model.WeatherData;

/**
 * Created by ykalemi on 06.11.2016.
 */
@Named
public class HashMapStorage implements Storage {

    private Map<Integer, WeatherData> storage = new HashMap<>();

    @Override
    public List<WeatherData> getAllData() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public WeatherData get(int id) {
        return storage.get(id);
    }

    @Override
    public void add(WeatherData data) {
        storage.put(data.getId(), data);
    }

    @Override
    public void remove(int id) {
        storage.remove(id);
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}