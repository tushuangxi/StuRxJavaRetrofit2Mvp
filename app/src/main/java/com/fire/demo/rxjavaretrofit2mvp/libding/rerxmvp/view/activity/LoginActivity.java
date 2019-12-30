package com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import com.fire.demo.rxjavaretrofit2mvp.R;
import com.fire.demo.rxjavaretrofit2mvp.libding.entity.GetListRsp;
import com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.base.MvpActivity;

import com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.fire.demo.rxjavaretrofit2mvp.libding.rerxmvp.presenter.UserLoginPresenter;
import com.fire.demo.rxjavaretrofit2mvp.libding.http.service.ServiceMapParams;
import com.fire.demo.rxjavaretrofit2mvp.libding.widget.DialogUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pc on 2016/9/26.
 */
public class LoginActivity extends MvpActivity<UserLoginPresenter> implements interfaceUtilsAll.IUserLoginView {
    private Context mContext;
    @BindView(R.id.editText_name)
    EditText mEtGwNumber;
    @BindView(R.id.editText_pwd)
    EditText mEtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
    }

    @Override
    protected UserLoginPresenter createPresenter() {
        return new UserLoginPresenter(this);
    }

    @OnClick(R.id.button_login)
    public void onClickLogin() {
        mvpPresenter.login(ServiceMapParams.getGetListRspMapParams());
    }

    @Override
    public void loginSuccess() {
//        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        startActivity(intent);
    }

    @Override
    public void loginFail(int toast, String reason) {
        if (reason.isEmpty()) {
            Toast.makeText(LoginActivity.this, getString(toast), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, reason, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showLoading() {
        DialogUtils.getInstance().popRemindDialog(mContext, "正在登录");
    }

    @Override
    public void hideLoading() {
        DialogUtils.getInstance().disMissRemind();
    }

    @Override
    public void saveCommonUserInfo(GetListRsp getListRsp) {
        //这里将登录接口返回的数据，根据实际情况存储在SP或者SQLite
        Toast.makeText(LoginActivity.this, getListRsp.getFemale().iterator().next().getName(), Toast.LENGTH_LONG).show();
    }
}
