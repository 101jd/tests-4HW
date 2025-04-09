package org._jd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.InjectMocks.*;
//TODO
// написать unit-тесты для BookService, используя
// Mockito для создания мок-объекта BookRepository

public class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    private Book book1;
    private Book book2;

    @BeforeEach
    public void initBooks(){
        book1 = new Book("1", "Book1", "Author1");
        book2 = new Book("2", "Book2", "Author2");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findById(){

        when(repository.findById("1")).thenReturn(book1);

        assertThat(service.findBookById("1")).isEqualTo(book1);

        verify(repository).findById("1");

    }

    @Test
    public void findAll(){
        List<Book> books = List.of(book1, book2);
        when(repository.findAll()).thenReturn(books);

        assertThat(service.findAllBooks()).isSameAs(books);

        verify(repository).findAll();
    }


}
