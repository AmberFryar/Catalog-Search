package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Movie implements CatalogItem{
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public Movie (String name, String director, LocalDate releaseDate){
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public String toString(){
        return "* " + name + System.lineSeparator()
                + " - Directed by: " + director + System.lineSeparator()
                + " - Released: " + releaseDate + System.lineSeparator()
                + " - ID: " + id;
    }
    @Override
    public boolean matchesName(String searchStr) {
        if (searchStr == null) {
        System.out.println("Please enter Name");
    }
        return name.contains(searchStr);
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if (searchStr == null) {
            System.out.println("Please enter Director");
        }
        return director.contains(searchStr);
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return releaseDate.getYear() == searchYear;
    }

    @Override
    public void registerItem() throws FileStorageException, FileNotFoundException {
        id = UUID.randomUUID().toString() + "created on: " + LocalDateTime.now();
        String destinationFile = "C:\\Users\\Student\\workspace\\amber-fryar-student-code\\java\\module-1\\week-9\\final-project\\src\\main\\resources\\logs\\register-log-movie.txt";
        FileStorageService.writeContentsToFile(toString(), destinationFile, true);
    }
}
