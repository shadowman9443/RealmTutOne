package com.example.shadwo.realmtutone;

/**
 * Created by shadwo on 5/22/2017.
 */

public interface Presenter {
    void addRecord(String name, String rollNo);

    void viewRecord();

    void updateRecord(String name, String rollNo);

    void deleteRecord(String rollNo);
}
