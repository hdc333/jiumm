package com.hdc.mvpstudy.view;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hdc.mvpstudy.Presenter.weatherPresenter;
import com.hdc.mvpstudy.R;

import org.w3c.dom.Text;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainProgramEntry extends AppCompatActivity implements IBaseView {

    weatherPresenter weatherPresenter;
    TextView tvinfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherPresenter = new weatherPresenter(this);
        tvinfo = (TextView)findViewById(R.id.info);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherPresenter.requestWeatherInfo();
            }
        });

    }

    @Override
    public void updateweather(final String info) {

        Log.d("Liang","updateWeather: "+info);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvinfo.setText(info);
            }
        });
    }

    @Override
    public void showwaitDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                if (mDialog!=null&&mDialog = isShowing()){
//                    mDialog.dismiss();
//                }
//                mDialog = ProgressDialog.show(MainProgramEntry.this,"获取天气","正在获取...");
            }
        });
    }

    @Override
    public void dissmissDialog() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                if(mDialog != null && mDialog.isShowing()){
//                    mDialog.dismiss();
//                }
            }
        });
    }

}
