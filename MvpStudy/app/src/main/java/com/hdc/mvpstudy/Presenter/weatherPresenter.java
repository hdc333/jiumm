package com.hdc.mvpstudy.Presenter;

import com.hdc.mvpstudy.model.weatherModel;
import com.hdc.mvpstudy.model.weatherModelInterface;
import com.hdc.mvpstudy.view.IBaseView;

import java.util.Random;

public class weatherPresenter {
    IBaseView viewInterface;
    weatherModelInterface modelInterface;

    public weatherPresenter(IBaseView viewInterface) {
        this.viewInterface = viewInterface;
        modelInterface = new weatherModel();
    }

    public void requestWeatherInfo(){
        getNetWorkInfo();
    }

    private void getNetWorkInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    showwaitDialog();
                    Thread.sleep(2000);

                    String weatherInfo = "";
                    Random r =new Random();
                    int seed = r.nextInt(3);
                    if (seed % 2 == 0){
                        weatherInfo = "21度，晴转多云";
                    }else {
                        weatherInfo ="22度,晴";
                    }
                    setInfo(weatherInfo);
                    String localInfo = getInfo();

                    updateweather(localInfo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    dissmissDialog();
                }
            }
        }).start();
    }

    private void setInfo(String info){
        modelInterface.setInfo(info);
    }

    private String getInfo(){
        return modelInterface.getInfo();
    }

    private void updateweather(String info){
        if (viewInterface!=null){
            viewInterface.updateweather(info);
        }
    }
    private void showwaitDialog(){
        if (viewInterface!=null){
            viewInterface.showwaitDialog();
        }
    }
    private void dissmissDialog(){
        if (viewInterface!=null){
            viewInterface.dissmissDialog();
        }
    }
}
