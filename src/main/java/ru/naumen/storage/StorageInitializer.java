package ru.naumen.storage;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import ru.naumen.model.WeatherData;

/**
 * Инициализация хранилища значениями по умолчанию.
 * Значения добавляются только в том случае, если хранилище пустое.
 * Инициализация не зависит от конкретной реализации хранилища.
 *
 * @author ykalemi
 * @since 15.11.16
 */
@Named
public class StorageInitializer {

    @Inject
    private Storage storage;

    @PostConstruct
    public void init() {
        if (storage.isEmpty()) {
            storage.add(new WeatherData(1, "2011.05.15", 15));
            storage.add(new WeatherData(2, "2013.05.15", 3));
            storage.add(new WeatherData(3, "2014.05.15", 22));
        }
    }

}
