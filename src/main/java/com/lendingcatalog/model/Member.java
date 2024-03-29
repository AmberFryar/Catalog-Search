package com.lendingcatalog.model;

public class Member implements CatalogItem {
    private String firstName;
    private String lastName;

    public Member (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {

    }
}
