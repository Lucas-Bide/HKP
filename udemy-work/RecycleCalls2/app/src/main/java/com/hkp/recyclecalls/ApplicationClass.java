package com.hkp.recyclecalls;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<>();
        people.add(new Person("Lucas", "123456784"));
        people.add(new Person("Alejo", "98764513"));
        people.add(new Person("Mammen", "9329832893"));
    }
}
