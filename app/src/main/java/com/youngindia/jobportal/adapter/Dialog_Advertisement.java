package com.youngindia.jobportal.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.youngindia.jobportal.R;

/**
 * Created by anupam on 02-06-2016.
 */
public class Dialog_Advertisement{
    int SPLASH_TIME_OUT=5000;
    public void showDialog(final Activity activity, String msg, int img) {
        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        final Dialog dialog = new Dialog(activity, R.style.MyDialog);
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_advertistment, null);
        ImageView imageView=(ImageView)view.findViewById(R.id.politician_pic);
        imageView.setImageResource(img);
        TextView textView=(TextView)view.findViewById(R.id.textView2);
        textView.setText(msg);
//        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.setContentView(view);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setWindowAnimations(R.style.MyDialog);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, SPLASH_TIME_OUT);
    }
}
