package com.hdc.mvpstudy.model;

public class weatherModel implements weatherModelInterface{

    private String weatherInfo;

    @Override
    public String getInfo() {
        return weatherInfo;
    }

    @Override
    public void setInfo(String info) {
        weatherInfo = info;
    }
}
