package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Book implements CatalogItem{
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book (String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString(){
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - ID: " + id;
    }
    @Override
    public boolean matchesName(String searchStr) {
        if (searchStr == null || searchStr == "") {
            System.out.println("Please enter Title");
        }
        return title.contains(searchStr);
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if (searchStr == null) {
            System.out.println("Please enter Author");
        }
       return author.contains(searchStr);
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return publishDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() throws FileStorageException, FileNotFoundException {
       id = UUID.randomUUID().toString() + "created on: " + LocalDateTime.now();
       String destinationFile = "C:\\Users\\Student\\workspace\\amber-fryar-student-code\\java\\module-1\\week-9\\final-project\\src\\main\\resources\\logs\\register-log-book.txt";
       FileStorageService.writeContentsToFile(toString(), destinationFile, true);
    }
}
//DateTimeFormatter.ofPattern("hh:mm a")