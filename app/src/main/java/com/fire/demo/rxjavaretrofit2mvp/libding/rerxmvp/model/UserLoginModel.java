package com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.model;

import android.util.Log;
import com.fire.demo.rxjavaretrofit2mvp.libding.entity.GetListRsp;
import com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.fire.demo.rxjavaretrofit2mvp.libding.http.manager.RetrofitManage;
import com.fire.demo.rxjavaretrofit2mvp.libding.http.util.ApiCallback;
import com.fire.demo.rxjavaretrofit2mvp.libding.http.util.SubscriberCallBack;
import java.util.Map;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pc on 2016/9/26.
 */
public class UserLoginModel implements interfaceUtilsAll.IUserLoginModel {

    @Override
    public Subscription login(Map<String, String> maps, final interfaceUtilsAll.LoginRsp listener) {
        Observable<GetListRsp> observable = RetrofitManage.getInstance().getHttpServiceConnection().login(maps);
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscriberCallBack<>(new ApiCallback<GetListRsp>() {
                    @Override
                    public void onSuccess(GetListRsp getListRsp) {
//                        UserInfo userInfo = JsonHandleAdapter.getUserLoginInfo(model.toString());
//                        listener.loginSuccess(userInfo);

                        Log.i("MVPDemo", getListRsp.getFemale().iterator().next().getName());
                        listener.loginSuccess(getListRsp);
                    }

                    @Override
                    public void onFailure(int msg, String reason) {
                        listener.loginFailed(msg, reason);
                    }

                    @Override
                    public void onCompleted() {
                        listener.requestCompleted();
                    }
                }));
    }
}
