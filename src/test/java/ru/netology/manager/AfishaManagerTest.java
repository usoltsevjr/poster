package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)


class AfishaManagerTest {
    @Mock
    private AfishaRepository AfishaRepository;
    @InjectMocks
    private AfishaManager AfishaManager;
    private PurchaseItem first = new PurchaseItem(1, 1, "url1", "name1", "genre1", 6);
    private PurchaseItem second = new PurchaseItem(2, 2, "url2", "name2", "genre2", 14);
    private PurchaseItem third = new PurchaseItem(3, 3, "url3", "name3", "genre3", 18);
    private PurchaseItem forth = new PurchaseItem(4, 4, "url4", "name4", "genre1", 6);

    @BeforeEach
    public void setUp() {
        AfishaManager.add(first);
        AfishaManager.add(second);
        AfishaManager.add(third);
    }

    @Test
    public void shouldAdd() {
        AfishaManager.add(forth);

        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, forth};
        doReturn(returned).when(AfishaRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, forth};
        PurchaseItem[] actual = AfishaRepository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third};
        doReturn(returned).when(AfishaRepository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};
        PurchaseItem[] actual = AfishaManager.getAll();
        assertArrayEquals(expected, actual);

    }

}