package com.hclfn.yzsspeech;

import android.os.Bundle;

import com.sesxh.yzsspeech.YSpeech;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //语音初始化
        YSpeech.getInstance().initSpeech(this);
        YSpeech.getInstance().toSpeech("测试");
    }
}