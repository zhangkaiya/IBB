package com.example.ibb.utils;

import android.content.Context;

import com.example.ibb.R;
import com.example.ibb.custom_view.CustomDialog;

/**
 * Created by 张凯雅 on 2017/12/12.
 */

public class DialogUtil {

    private static DialogUtil dialogUtil;
    private CustomDialog dialog;


    public DialogUtil() {

    }

    public static DialogUtil instance(){

        if (dialogUtil == null){
            synchronized (DialogUtil.class){
                if (dialogUtil == null){
                    dialogUtil = new DialogUtil();
                }
            }
        }
        return dialogUtil;
    }

    //显示等待
    public void Showdialog(Context context){

        dialog = new CustomDialog(context, R.style.CustomDialog);
        dialog.show();
    }

    //隐藏等待
    public void Hidedialog(){

        dialog.dismiss();
    }
}
