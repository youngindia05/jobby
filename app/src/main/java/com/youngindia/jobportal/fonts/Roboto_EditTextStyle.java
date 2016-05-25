package com.youngindia.jobportal.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 5/18/2016.
 */
public class Roboto_EditTextStyle extends EditText {

        public Roboto_EditTextStyle(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }


        public  Roboto_EditTextStyle(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public Roboto_EditTextStyle(Context context) {
            super(context);
            init();
        }

        private void init() {
            Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
            setTypeface(typeFace);
        }

    }
