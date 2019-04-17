package com.brian.mvc.androidmvcpattern.contract;

import android.content.Context;

import com.brian.mvc.androidmvcpattern.base.IBaseModel;
import com.brian.mvc.androidmvcpattern.base.IBaseView;

public interface MainContract {
    interface IModel<I extends IBaseView> extends IBaseModel {
        void requsetFile(Context context, String path, IView iView);
    }

    interface IView extends IBaseView {

        void readProtiesSuccess(String str);

    }
}
