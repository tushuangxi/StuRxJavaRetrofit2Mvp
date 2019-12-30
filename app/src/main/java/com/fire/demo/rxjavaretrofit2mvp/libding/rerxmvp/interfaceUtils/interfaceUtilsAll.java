package com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.interfaceUtils;

import com.fire.demo.rxjavaretrofit2mvp.libding.entity.GetListRsp;

import java.util.Map;

import rx.Subscription;

/**
 * @author V.
 * @created on: 2018/10/25 下午3:29
 * @description
 * @remark
 */
public interface interfaceUtilsAll {


    interface LoginRsp {

        void loginSuccess(GetListRsp getListRsp);

        void loginFailed(int toast, String reason);

        void requestCompleted();
    }

    interface IUserLoginView {
        void loginSuccess();

        void loginFail(int toast, String reason);

        void showLoading();

        void hideLoading();

        void saveCommonUserInfo(GetListRsp getListRsp);
    }

    interface IUserLoginModel {
        Subscription login(Map<String, String> maps, interfaceUtilsAll.LoginRsp listener);
    }

    interface IUserLoginPresenter {
        void login(Map<String, String> maps);
    }
}
