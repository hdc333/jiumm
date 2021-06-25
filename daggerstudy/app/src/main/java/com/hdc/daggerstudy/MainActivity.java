package com.hdc.daggerstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule("张三",22))
                .build()
                .inject(this);

        Log.v("===A====",person.getAge()+"====="+person.getName());
        person.setName("张三丰");
        Log.v("===B====",person.getAge()+"====="+person.getName());
    }
}