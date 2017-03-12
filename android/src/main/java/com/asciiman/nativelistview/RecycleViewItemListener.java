package com.asciiman.nativelistview;

import android.view.View;

/**
 * Created by typhoon on 12/03/2017.
 */

public interface RecycleViewItemListener {

    void itemClicked(View view, int clickedView, Object itemData);
}
