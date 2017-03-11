package com.asciiman.nativelistview;

import android.graphics.Typeface;

import com.facebook.react.bridge.ReactApplicationContext;

/**
 * Created by typhoon on 11/03/2017.
 */

public class CustomFontManager {

    public static Typeface DINNextFont;

    public static void initialize(ReactApplicationContext reactApplicationContext) {
        if (DINNextFont != null) {
            DINNextFont = Typeface.createFromAsset(reactApplicationContext.getAssets(), "DdNNextLTPro-MediumCond.ttf");
        }
    }
}
