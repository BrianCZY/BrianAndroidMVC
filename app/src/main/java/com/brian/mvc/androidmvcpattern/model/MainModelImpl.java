package com.brian.mvc.androidmvcpattern.model;

import android.content.Context;

import com.brian.mvc.androidmvcpattern.base.IBaseView;
import com.brian.mvc.androidmvcpattern.contract.MainContract;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MainModelImpl implements MainContract.IModel<MainContract.IView> {

    MainContract.IView iView;

    @Override
    public void requsetFile(Context context, String path, MainContract.IView iView) {
        iView.startloading();

        this.iView = iView;
        loadProperties(context);
        iView.stopLoading();
    }

    private void loadProperties(Context context) {
        try {
//        InputStream in = context.getResourceAsStream("filePath");


            String config_file = "config.properties";
            InputStream in = context.getApplicationContext().getAssets().open(config_file);  //打开assets目录下的config.properties文件
            Properties prop = new Properties();
            prop.load(new InputStreamReader(in, "utf-8"));
            String baseUrl = prop.getProperty("baseUrl");
            String testUrl = prop.getProperty("testUrl");
            iView.readProtiesSuccess(baseUrl+"   "+ testUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void bindView(IBaseView iView) {

    }
//
//    @Override
//    public void bindView(IBaseView iBaseView) {
//
//    }
}
