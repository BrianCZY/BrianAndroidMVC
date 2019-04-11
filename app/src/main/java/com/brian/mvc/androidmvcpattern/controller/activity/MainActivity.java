package com.brian.mvc.androidmvcpattern.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.brian.mvc.androidmvcpattern.R;

/**
 * 读取proties 资源文件
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
