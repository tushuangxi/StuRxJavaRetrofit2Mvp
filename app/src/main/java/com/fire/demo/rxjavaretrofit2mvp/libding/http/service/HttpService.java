package com.fire.demo.rxjavaretrofit2mvp.libding.http.service;

import com.fire.demo.rxjavaretrofit2mvp.libding.entity.GetListRsp;

import org.json.JSONObject;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by pc on 2016/8/23.
 */
public interface HttpService {


    //用户登录接口
    @GET(URLs.Login)
    Observable<GetListRsp> login(@QueryMap Map<String, String> maps);
}
