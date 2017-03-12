package oley.tayfun.com.oleybulletintest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by typhoon on 12/03/2017.
 */

public class FontAwesomeIcon extends TextView {

    public FontAwesomeIcon(Context context) {
        super(context);
        setTypeface(CustomFontManager.FontAwesome);
    }

    public FontAwesomeIcon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTypeface(CustomFontManager.FontAwesome);
    }

    public FontAwesomeIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(CustomFontManager.FontAwesome);
    }


}
