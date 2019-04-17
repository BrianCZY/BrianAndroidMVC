package com.brian.mvc.androidmvcpattern.model;

import android.content.Context;

import com.brian.mvc.androidmvcpattern.bean.PropertiesBean;
import com.brian.mvc.androidmvcpattern.contract.MainContract;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainModelImpl implements MainContract.IModel {

    MainContract.IView iView;

    @Override
    public void requsetFile(Context context, String file) {

        Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(@NonNull ObservableEmitter observableEmitter) throws Exception {

                Thread.sleep(1000); //模拟延时
                PropertiesBean propertiesBean = loadProperties(context, file);
                observableEmitter.onNext(propertiesBean);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PropertiesBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PropertiesBean propertiesBean) {
                if (iView != null) {
                    iView.readProtiesSuccess(propertiesBean);
                }
            }


            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (iView != null) {

                    iView.onError("读取文件失败");
                }
            }

            @Override
            public void onComplete() {

            }
        });


    }

    private PropertiesBean loadProperties(Context context, String file) {

//            String config_file = "config.properties";
        try {

            InputStream in = context.getApplicationContext().getAssets().open(file);  //打开assets目录下的config.properties文件
            Properties prop = new Properties();

            prop.load(new InputStreamReader(in, "utf-8"));
            String baseUrl = prop.getProperty("baseUrl");
            String testUrl = prop.getProperty("testUrl");

            PropertiesBean propertiesBean = new PropertiesBean();
            propertiesBean.setBaseUrl(baseUrl);
            propertiesBean.setTestUrl(testUrl);
            return propertiesBean;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public void bindView(MainContract.IView iView) {
        this.iView = iView;
    }

}
