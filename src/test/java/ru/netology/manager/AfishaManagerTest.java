package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    AfishaRepository repository;

    @InjectMocks

    AfishaManager manager = new AfishaManager(repository);
    AfishaManager managerCustom = new AfishaManager(repository, 5);

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
        manager = new AfishaManager(repository);
        managerCustom = new AfishaManager(repository, 5);
    }

    @Test
    void shouldGetLastTen() {
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        AfishaItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetLastTenIfEleven() {
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        AfishaItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetAllFromTen() {
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        AfishaItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetLastFive() {
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetLastFiveIfTen() {
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{tenth, ninth, eighth, seventh, sixth};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetFiveDefaultZero() {
        manager = new AfishaManager(repository,0);
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetFiveAsDefaultOverZero() {
        manager = new AfishaManager(repository,-10);
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldGetFiveDefaultUnderMax() {
        manager = new AfishaManager(repository,100);
        AfishaItem[] returned = new AfishaItem[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        AfishaItem[] expected = new AfishaItem[]{fifth, fourth, third, second, first};
        AfishaItem[] actual = managerCustom.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }
}