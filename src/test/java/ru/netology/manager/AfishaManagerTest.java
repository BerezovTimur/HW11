package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    AfishaManager manager;
    AfishaManager managerCustom;

    private AfishaItem first = new AfishaItem(1, "Бладшот", "боевик");
    private AfishaItem second = new AfishaItem(2, "Вперед", "мультфильм");
    private AfishaItem third = new AfishaItem(3, "Отель Белград", "комедия");
    private AfishaItem fourth = new AfishaItem(4, "Джентельмены", "боевик");
    private AfishaItem fifth = new AfishaItem(5, "Человек-неведимка", "ужасы");
    private AfishaItem sixth = new AfishaItem(6, "Тролли", "мультфильм");
    private AfishaItem seventh = new AfishaItem(7, "Номер один", "комедия");
    private AfishaItem eighth = new AfishaItem(8, "Вторжение", "фантастика");
    private AfishaItem ninth = new AfishaItem(9, "Зеленая книга", "трагикомедия");
    private AfishaItem tenth = new AfishaItem(10, "Операция Арго", "боевик");
    private AfishaItem eleventh = new AfishaItem(11, "Движение вверх", "спорт");

    @BeforeEach
    void setUp() {
        manager = new AfishaManager();
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);

        managerCustom = new AfishaManager(5);
        managerCustom.addFilm(first);
        managerCustom.addFilm(second);
        managerCustom.addFilm(third);
        managerCustom.addFilm(fourth);
        managerCustom.addFilm(fifth);
    }

    @Test
    void shouldGetLastTen() {
        manager.addFilm(tenth);
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldGetLastTenIfEleven() {
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldGetAllFromTen() {
        AfishaItem[] actual = manager.getAll();
        AfishaItem[] expected = new AfishaItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldGetLastFive() {
        AfishaItem[] actual = managerCustom.getAll();
        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldGetLastFiveIfTen() {
        managerCustom.addFilm(sixth);
        managerCustom.addFilm(seventh);
        managerCustom.addFilm(eighth);
        managerCustom.addFilm(ninth);
        managerCustom.addFilm(tenth);
        AfishaItem[] expected = new AfishaItem[]{tenth, ninth, eighth, seventh, sixth};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFiveDefaultZero() {
        manager = new AfishaManager(0);
        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFiveAsDefaultOverZero() {
        manager = new AfishaManager(-10);
        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFiveDefaultUnderMax() {
        manager = new AfishaManager(100);
        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);
    }
}