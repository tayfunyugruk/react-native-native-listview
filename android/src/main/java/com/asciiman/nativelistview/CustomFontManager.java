package com.asciiman.nativelistview;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by typhoon on 12/03/2017.
 */

public class CustomFontManager {

    public static Typeface DINNextFont;

    public static void initialize(Context context) {
        if (DINNextFont == null) {
            AssetManager assetManager = context.getAssets();
            DINNextFont = Typeface.createFromAsset(assetManager, "DdNNextLTPro-MediumCond.ttf");
        }
    }

}
