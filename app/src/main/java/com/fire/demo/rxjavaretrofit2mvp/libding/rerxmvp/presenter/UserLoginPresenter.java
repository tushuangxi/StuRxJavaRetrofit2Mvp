package com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.presenter;

import com.fire.demo.rxjavaretrofit2mvp.libding.entity.GetListRsp;
import com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.base.BasePresenter;
import com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.model.UserLoginModel;
import java.util.Map;

/**
 * Created by pc on 2016/9/26.
 */
public class UserLoginPresenter extends BasePresenter<interfaceUtilsAll.IUserLoginView> implements interfaceUtilsAll.IUserLoginPresenter {
    private interfaceUtilsAll.IUserLoginModel iUserLoginModel;

    public UserLoginPresenter(interfaceUtilsAll.IUserLoginView view) {
        attachView(view);
        iUserLoginModel = new UserLoginModel();
    }

    @Override
    public void login(Map<String, String> maps) {
        mvpView.showLoading();
        addSubscription(iUserLoginModel.login(maps, new interfaceUtilsAll.LoginRsp() {
            @Override
            public void loginSuccess(GetListRsp userInfo) {
                mvpView.loginSuccess();
                if (null != userInfo) {
                    mvpView.saveCommonUserInfo(userInfo);
                }
            }

            @Override
            public void loginFailed(int toast, String reason) {
                mvpView.loginFail(toast, reason);
            }

            @Override
            public void requestCompleted() {
                mvpView.hideLoading();
            }
        }));
    }
}
