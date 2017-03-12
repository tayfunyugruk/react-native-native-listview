package oley.tayfun.com.oleybulletintest;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by typhoon on 12/03/2017.
 */

public class CustomFontManager {

    public static Typeface DINNextFont;
    public static Typeface FontAwesome;

    public static void initialize(Context context) {
        AssetManager assetManager = context.getAssets();

        if (DINNextFont == null) {
            DINNextFont = Typeface.createFromAsset(assetManager, "DdNNextLTPro-MediumCond.ttf");
        }
        if (FontAwesome == null) {
            FontAwesome = Typeface.createFromAsset(assetManager, "FontAwesome.ttf");
        }
    }

}
