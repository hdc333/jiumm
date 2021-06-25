package com.hdc.daggerstudy;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private String name;
    private int age;

    public MainActivityModule(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Provides
    String provideName(){
        return name;
    }

    @Provides
    int provideAge(){
        return age;
    }
}
