package ru.netology.manager;

import ru.netology.domain.AfishaItem;

public class AfishaManager {

    private AfishaItem[] items = new AfishaItem[0];
    private int defaultAfishaLength = 10;
    private int customAfishaLength;

    public AfishaManager() {
    }

    public AfishaManager(int customAfishaLength) {
        this.customAfishaLength = customAfishaLength;
    }

    public void AddFilm(AfishaItem item) {

        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfishaItem[] getAll() {
        int length = items.length;

        if (customAfishaLength <= 0) {
            if (defaultAfishaLength < items.length) {
                length = defaultAfishaLength;
            }
        } else {
            if (customAfishaLength < items.length) {
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
