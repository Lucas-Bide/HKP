package com.hkp.car;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Person> people = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<>();
        people.add(new Person("Chuck Norris", "Polo", "1413409709", "V"));
        people.add(new Person("Peter Pollock", "E200", "7987969724", "M"));
        people.add(new Person("Chis James", "Almera", "0892402840", "N"));
        people.add(new Person("John Rambo", "E180", "7862342343", "M"));
        people.add(new Person("Nelson Mandela", "Kombi", "76384678", "V"));
        people.add(new Person("Paul Bunting", "Navara", "12341324", "N"));
    }
}
