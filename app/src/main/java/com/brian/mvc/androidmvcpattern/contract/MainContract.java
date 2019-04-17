package com.brian.mvc.androidmvcpattern.contract;

import android.content.Context;

import com.brian.mvc.androidmvcpattern.base.IBaseModel;
import com.brian.mvc.androidmvcpattern.base.IBaseView;
import com.brian.mvc.androidmvcpattern.bean.PropertiesBean;

public interface MainContract {
    interface IModel extends IBaseModel<IView> {
        void requsetFile(Context context, String file);
    }

    interface IView extends IBaseView {

        void readProtiesSuccess(PropertiesBean propertiesBean);

    }
}
