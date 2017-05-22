package com.example.shadwo.realmtutone;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by shadwo on 5/22/2017.
 */

public class PrsenterImp implements  Presenter {
    Crudview crudview;
    Realm realm;
    public PrsenterImp( Realm realm,Crudview crudview) {
        this.realm=realm;
        this.crudview = crudview;
    }

    @Override
    public void addRecord(String name,String rollNo) {
        realm.beginTransaction();

        Student student = realm.createObject(Student.class);
        student.setRoll_no(Integer.parseInt(rollNo));
        student.setName(name);

        realm.commitTransaction();
        crudview.addSuccess();

    }

    @Override
    public void viewRecord() {
        RealmResults<Student> results = realm.where(Student.class).findAll();
        crudview.viewRecordToShow(results);

    }

    @Override
    public void updateRecord(String name,String rollNo) {
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(rollNo)).findAll();

        realm.beginTransaction();

        for(Student student : results){
            student.setName(name);
        }

        realm.commitTransaction();
        crudview.updateSucess();

    }

    @Override
    public void deleteRecord(String rollNo) {
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(rollNo)).findAll();

        realm.beginTransaction();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        crudview.deletSuccess();

    }
}
