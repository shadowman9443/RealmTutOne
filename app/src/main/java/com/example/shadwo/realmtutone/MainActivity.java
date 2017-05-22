package com.example.shadwo.realmtutone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements   Crudview {
    Button add, view, update, delete;
    EditText roll_no, name;
    TextView text;
    Realm realm;
    Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button)findViewById(R.id.add);
        view = (Button)findViewById(R.id.view);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);
        roll_no = (EditText)findViewById(R.id.roll_no);
        name = (EditText)findViewById(R.id.name);
        text = (TextView)findViewById(R.id.text);

        Realm.init(this);
        realm = Realm.getDefaultInstance();
        presenter=new PrsenterImp(realm,this);
    }

    public void clickAction(View view){
        switch (view.getId()){
            case R.id.add:  //addRecord();
                presenter.addRecord(name.getText().toString(),roll_no.getText().toString());
                break;
            case R.id.view: //viewRecord();
                presenter.viewRecord();
                break;
            case R.id.update:  // updateRecord();
                presenter.updateRecord(name.getText().toString(),roll_no.getText().toString());
                break;
            case R.id.delete:   //deleteRecord();
                presenter.deleteRecord(roll_no.getText().toString());
        }
    }
  /*  public void addRecord(){
        realm.beginTransaction();

        Student student = realm.createObject(Student.class);
        student.setRoll_no(Integer.parseInt(roll_no.getText().toString()));
        student.setName(name.getText().toString());

        realm.commitTransaction();
    }

    public void viewRecord(){
        RealmResults<Student> results = realm.where(Student.class).findAll();

        text.setText("");

        for(Student student : results){
            text.append(student.getRoll_no() + " " + student.getName() + "\n");
        }
    }

    public void updateRecord(){
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(roll_no.getText().toString())).findAll();

        realm.beginTransaction();

        for(Student student : results){
            student.setName(name.getText().toString());
        }

        realm.commitTransaction();
    }

    public void deleteRecord(){
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(roll_no.getText().toString())).findAll();

        realm.beginTransaction();

        results.deleteAllFromRealm();

        realm.commitTransaction();
    }
*/
    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }

    @Override
    public void addSuccess() {
        Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
    }

    @Override
    public void deletSuccess() {
        Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateSucess() {
        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
    }

    @Override
    public void viewRecordToShow(RealmResults<Student> results) {
        text.setText("");

        for(Student student : results){
            text.append(student.getRoll_no() + " " + student.getName() + "\n");
        }

    }
}
