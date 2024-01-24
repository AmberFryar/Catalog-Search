package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.UUID;

public class Tool implements CatalogItem{
    private String id;
    private String type;
    private String manufacturer;
    private int count;

    public Tool (String type, String manufacturer, int count){
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    @Override
    public String toString(){
        return "* " + type + System.lineSeparator()
                + " - Manufactured by: " + manufacturer + System.lineSeparator()
                + " - Count: " + count + System.lineSeparator()
                + " - ID: " + id;
    }
    @Override
    public boolean matchesName(String searchStr) {
        if (searchStr == null) {
            System.out.println("Please enter Type");
        }
        return type.contains(searchStr);
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if (searchStr == null) {
            System.out.println("Please enter Manufacturer");
        }
        return manufacturer.contains(searchStr);
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() throws FileStorageException, FileNotFoundException {
        id = UUID.randomUUID().toString() + "created on: " + LocalDateTime.now();
        String destinationFile = "C:\\Users\\Student\\workspace\\amber-fryar-student-code\\java\\module-1\\week-9\\final-project\\src\\main\\resources\\logs\\register-log-tool.txt";
        FileStorageService.writeContentsToFile(toString(), destinationFile, true);
    }
}
