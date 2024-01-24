package com.lendingcatalog.util;

import com.lendingcatalog.model.Book;
import com.lendingcatalog.model.CatalogItem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

import java.time.LocalDate;


public class BookTest {
    @Test
    public void does_searchStr_match_title(){
        //Arrange
        Book book = new Book("Harry Potter and The Half-Blood Prince", "J.K. Rowling", LocalDate.parse("2005-07-16"));

        //Act
        Boolean emptySearchString = book.matchesName("");
        Boolean lowerCasePartialSearch = book.matchesName("blo");
        Boolean upperCaseSearch = book.matchesName("HARRY POTTER AND THE HALF-BLOOD PRINCE");
        Boolean noMatchSearch = book.matchesName("hello");

        //Assert
        Assert.assertTrue(emptySearchString);
        Assert.assertTrue(lowerCasePartialSearch);
        Assert.assertTrue(upperCaseSearch);
        Assert.assertFalse(noMatchSearch);
    }

    @Test
    public void does_searchStr_match_author() {
        //Arrange
        Book book = new Book("Harry Potter and The Half-Blood Prince", "J.K. Rowling", LocalDate.parse("2005-07-16"));

        //Act
        Boolean emptySearchString = book.matchesCreator("");
        Boolean lowerCasePartialSearch = book.matchesCreator("rowl");
        Boolean upperCaseSearch = book.matchesCreator("J.K. ROWLING");
        Boolean noMatchSearch = book.matchesCreator("hello");

        //Assert
        Assert.assertTrue(emptySearchString);
        Assert.assertTrue(lowerCasePartialSearch);
        Assert.assertTrue(upperCaseSearch);
        Assert.assertFalse(noMatchSearch);
    }

}
