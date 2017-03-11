package com.asciiman.nativelistview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.asciiman.nativelistview.CustomFontManager.DINNextFont;

/**
 * Created by typhoon on 11/03/2017.
 */

public class OddButton extends LinearLayout {

    private TextView oddType;
    private TextView oddValue;
    private TextView oddDescription;

    public OddButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context);
    }

    /**
     * Load component XML layout
     */
    private void initControl(Context context) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.odd_button, this);

        oddType = findTextView(this, R.id.oddType);
        oddValue = findTextView(this, R.id.oddValue);
        oddDescription = findTextView(this, R.id.oddDescription);
    }

    public void setValues(String oddType, String oddValue, String oddDescription) {
        this.oddType.setText(oddType);
        this.oddValue.setText(oddValue);
        this.oddDescription.setText(oddDescription);

        this.setSelected(false);
    }

    public void setSelected(boolean selected) {
        if (selected) {
            this.setBackgroundResource(R.drawable.odd_button_selected);
            this.oddType.setTextColor(Color.parseColor("#FFFFFF"));
            this.oddValue.setTextColor(Color.parseColor("#FFFFFF"));
            this.oddDescription.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.setBackgroundResource(R.drawable.odd_button_normal);
        }
    }

    private TextView findTextView(View parentView, int id) {
        TextView tv = (TextView) parentView.findViewById(id);
        tv.setTypeface(DINNextFont);
        return tv;
    }
}
