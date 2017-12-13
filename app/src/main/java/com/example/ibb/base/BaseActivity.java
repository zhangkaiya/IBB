package com.example.ibb.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ibb.R;
import com.example.ibb.app.MyApp;
import com.zhy.autolayout.AutoLayoutActivity;

public abstract class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApp.activity = this;
        setContentView(initlayout());

        //视图
        initview();

        initdata();
    }

    protected abstract void initview();

    protected abstract void initdata();

    protected abstract int initlayout();

    @Override
    protected void onResume() {
        super.onResume();

        MyApp.activity = this;
    }
}
