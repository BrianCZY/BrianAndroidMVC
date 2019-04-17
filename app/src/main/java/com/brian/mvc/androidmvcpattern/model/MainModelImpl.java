package com.brian.mvc.androidmvcpattern.model;

import com.brian.mvc.androidmvcpattern.contract.MainContract;

public class MainModelImpl implements MainContract.IModel {
    @Override
    public void requsetFile(String path, MainContract.IView iView) {
        iView.startloading();
        iView.readProtiesSuccess("");
        iView.stopLoading();
    }
}
