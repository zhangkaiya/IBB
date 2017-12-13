package com.example.ibb.utils;

import com.example.ibb.apimanager.RetrofitApi;
import com.example.ibb.entity.HomeBean;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张凯雅 on 2017/12/13.
 */

public class RetrofitUtil {
    private static final int MAXTIME = 50;
    private final RetrofitApi api;
    private static RetrofitUtil retrofitUtil;

    private RetrofitUtil(String baseurl){
        OkHttpClient client=new OkHttpClient.Builder()
                .connectTimeout(MAXTIME, TimeUnit.SECONDS)
                .readTimeout(MAXTIME,TimeUnit.SECONDS)
                .writeTimeout(MAXTIME,TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request=chain.request()
                                .newBuilder()
                                .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                                .addHeader("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8"))
                                .build();
                        return chain.proceed(request);
                    }
                }).build();

        api = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitApi.class);
    }

    public static RetrofitUtil instance(String baseurl){

        if (retrofitUtil == null){
            synchronized (RetrofitUtil.class){
                if (retrofitUtil == null){
                    retrofitUtil = new RetrofitUtil(baseurl);
                }
            }
        }

        return retrofitUtil;
    }

    public void Webhome(Observer observer){

        Observable<HomeBean> getbanner = api.gethome();
        getbanner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
