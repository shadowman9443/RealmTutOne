package com.example.shadwo.realmtutone;

import io.realm.RealmResults;

/**
 * Created by shadwo on 5/22/2017.
 */

public interface Crudview {
    void addSuccess();

    void deletSuccess();

    void updateSucess();

    void viewRecordToShow(RealmResults<Student> results);
}
