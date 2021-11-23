package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Product book1 = new Book(1, "b1", 100, "a1", 200, 2020 );
    Product blackShirt = new TShirt(2, "ts1", 200, "black", "M");

    @Test
    void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(blackShirt);
        repo.removeById(2);
        Product[] expected = repo.findAll();
        Product[] actual = {book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdThrow() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(blackShirt);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(3);
        });

    }
}