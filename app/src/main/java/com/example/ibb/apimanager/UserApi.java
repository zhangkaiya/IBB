package com.example.ibb.apimanager;


import com.example.ibb.entity.SendEmilBase;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 张凯雅 on 2017/12/13.
 */

public interface UserApi {

    @GET("regist/getVerifiCode.action")
    Observable<ResponseBody> sendphonecode(@QueryMap Map<String,String> map);

    //发送邮箱
    @GET
    Observable<SendEmilBase> sendemils(@Url String url);
}
