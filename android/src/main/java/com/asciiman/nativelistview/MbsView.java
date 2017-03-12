package oley.tayfun.com.oleybulletintest;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * Created by typhoon on 12/03/2017.
 */

public class MbsView extends android.support.v7.widget.AppCompatTextView {

    public MbsView(Context context) {
        super(context);
        initialize();
    }

    public MbsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MbsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        this.setText("0");
        this.setTextColor(Color.BLACK);
        this.setGravity(Gravity.CENTER);
    }

    public void setMbs(int mbs) {
        this.setTextColor(Color.WHITE);
        if (mbs == 1) {
            this.setText("1");
            this.setBackgroundResource(R.drawable.mbs_1);
        } else if (mbs == 2) {
            this.setText("2");
            this.setBackgroundResource(R.drawable.mbs_2);
        } else if (mbs == 3) {
            this.setText("3");
            this.setBackgroundResource(R.drawable.mbs_3);
        } else {
            this.setText("4");
            this.setBackgroundResource(R.drawable.mbs_4);
        }
    }
}
