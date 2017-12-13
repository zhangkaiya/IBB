package com.example.ibb.apimanager;

import com.example.ibb.entity.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 张凯雅 on 2017/12/13.
 */

public interface RetrofitApi {

    //    http://www.ipanda.com/kehuduan/shouye/index.json
    @GET("kehuduan/shouye/index.json")
    Observable<HomeBean> gethome();


}
