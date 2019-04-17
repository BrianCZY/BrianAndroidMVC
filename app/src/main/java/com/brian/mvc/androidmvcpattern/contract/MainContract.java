package com.brian.mvc.androidmvcpattern.contract;

import com.brian.mvc.androidmvcpattern.base.IBaseModel;
import com.brian.mvc.androidmvcpattern.base.IBaseView;

public interface MainContract {
    interface IModel extends IBaseModel {
        void requsetFile(String path, IView iView);
    }

    interface IView extends IBaseView {

        void readProtiesSuccess(String str);

    }
}
