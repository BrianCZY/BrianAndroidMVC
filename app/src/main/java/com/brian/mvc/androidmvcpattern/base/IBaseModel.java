package com.brian.mvc.androidmvcpattern.base;

/**
 * 保留，可用于泛型绑定
 */
public interface IBaseModel<T extends IBaseView> {
    void bindView(T iView);
}


//public interface IBaseModel {
////    void bindView(IBaseView iBaseView);
//}
