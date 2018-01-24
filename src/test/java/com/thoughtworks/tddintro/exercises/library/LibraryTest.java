package com.thoughtworks.tddintro.exercises.library;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = new Library(books, printStream, bufferedReader);
    }

    @Test
    // Remove each @Ignore and implement test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by the printStream
        //This verify statement causes the test to pass:
        verify(printStream).println("Book Title"+"\n");
    }

    @Test
    // Remove each @Ignore and implement test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        library.listBooks();

        verify(printStream).println("");

        //now this test passes, printStream printed an empty string since no books were added.
    }

    @Test
    // Remove each @Ignore and implement test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        // implement me
        String title1 = "Book 1";
        String title2 = "Book 2";

        books.add(title1);

        books.add(title2);

        library.listBooks();

        verify(printStream).println("Book 1" + "\n"+"Book 2"+"\n");
    }

    @Test
    public void shouldAddBookToCollectionWhenEnteredByUser() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Hobbit");
        library.enterBook();
        assertThat(books, hasItems("The Hobbit"));
    }

    @Test
    // Remove each @Ignore and implement test
    public void shouldDeleteBookFromCollectionWhenRemovedByUser() throws IOException {
        // Add when/thenReturn here
        when(bufferedReader.readLine()).thenReturn("The Two Towers");
        //Added, now the test works.

        books.add("The Two Towers");
        library.removeBook();

        assertThat(books, not(hasItems("The Two Towers")));
    }
}
