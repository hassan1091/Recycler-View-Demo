package com.beatandroid.recyclerviewdemo.users_generator;

import java.util.ArrayList;

public class User {
    private String name;
    private String country;
    private String language;
    private boolean isMale;
    private boolean isWorking;
    private int age;

    public User() {
    }

    public User(String name, String country, String language, boolean isMale, boolean isWorking, int age) {
        this.name = name;
        this.country = country;
        this.language = language;
        this.isMale = isMale;
        this.isWorking = isWorking;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User>  users = new ArrayList<>();
        users.add(new User("Hassan","Ksa","ar",true,true,30));
        users.add(new User("Ali","Ksa","en",true,false,21));
        users.add(new User("Fatema","Bahrain","ar",false,true,28));
        users.add(new User("Noor","Kuwait","ar",false,true,24));
        users.add(new User("Samira","Egypt","en",false,false,26));
        users.add(new User("khalid","Ksa","ar",true,true,45));
        users.add(new User("nader","Morocco","ar",true,true,25));
        users.add(new User("Salem","Algeria","fr",true,false,35));
        users.add(new User("Faris","Emirates","ar",true,true,53));
        users.add(new User("Hasan","Jordan","en",true,true,37));
        //
        users.add(new User("Hasssan","Jordan","en",true,true,37));
        users.add(new User("Hasan","Ksa","en",true,false,18));
        users.add(new User("Hasan","UK","en",true,false,19));
        return users;
    }
}
