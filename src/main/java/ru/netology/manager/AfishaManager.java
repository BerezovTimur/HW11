package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {

    private AfishaRepository repository;

    private int defaultAfishaLength = 10;
    private int customAfishaLength;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int customAfishaLength) {
        this.repository = repository;
        this.customAfishaLength = customAfishaLength;
    }

    public void add(AfishaItem item) {
        repository.save(item);
    }

    public AfishaItem[] getAll() {
        AfishaItem[] items = repository.findAll();
        int length = items.length;

        if (customAfishaLength <= 0) {
            if (defaultAfishaLength < length) {
                length = defaultAfishaLength;
            }
        } else {
            if (customAfishaLength < length) {
                length = customAfishaLength;
            }
        }

        AfishaItem[] result = new AfishaItem[length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

