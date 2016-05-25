package com.youngindia.jobportal.model;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.youngindia.jobportal.R;

/**
 * Created by anupam on 23-05-2016.
 */
public class DefaultDialog  {
    public void showDialog(final Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialogbox);

        TextView text = (TextView) dialog.findViewById(R.id.txt_header);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_no);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button dialogButton1 = (Button) dialog.findViewById(R.id.btn_yes);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}
