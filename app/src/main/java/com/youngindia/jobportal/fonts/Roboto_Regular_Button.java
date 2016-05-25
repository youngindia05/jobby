package com.youngindia.jobportal.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

public class Roboto_Regular_Button extends Button {
    public Roboto_Regular_Button(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    public Roboto_Regular_Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public Roboto_Regular_Button(Context context) {
        super(context);
        init();
    }
    private void init() {
        Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
        setTypeface(typeFace);
    }
}

