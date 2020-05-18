package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();
    AfishaItem first = new AfishaItem(1, "Бладшот", "боевик");
    AfishaItem second = new AfishaItem(2, "Вперед", "мультфильм");
    AfishaItem third = new AfishaItem(3, "Отель Белград", "комедия");
    AfishaItem fourth = new AfishaItem(4, "Джентельмены", "боевик");
    AfishaItem fifth = new AfishaItem(5, "Человек-неведимка", "ужасы");
    AfishaItem sixth = new AfishaItem(6, "Тролли", "мультфильм");
    AfishaItem seventh = new AfishaItem(7, "Номер один", "комедия");
    AfishaItem eighth = new AfishaItem(8, "Вторжение", "фантастика");

    @Test
    void shouldSave() {
        repository.save(first);
        AfishaItem[] expected = new AfishaItem[]{first};
        AfishaItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind =7;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.findById(idToFind);
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove =4;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.removeById(idToRemove);
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{first,second,third, fifth};
        assertArrayEquals(expected, actual);
    }

    /*@Test
    void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(idToRemove);
        repository.removeById(idToRemove);
        AfishaItem[] expected = new AfishaItem[]{first, second, third};
        AfishaItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }*/

    @Test
    void shouldRemoveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.removeAll();
        AfishaItem[] expected = new AfishaItem[]{};
        AfishaItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}