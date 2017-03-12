package com.asciiman.nativelistview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;

/**
 * Created by typhoon on 12/03/2017.
 */

public class CustomViewClickListener implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private RecycleViewItemListener recycleViewItemListener;
    private int viewId;
    private JSONArray dataArray;

    public CustomViewClickListener(RecyclerView mRecyclerView, JSONArray dataArray, int viewId, RecycleViewItemListener recycleViewItemListener) {
        this.mRecyclerView = mRecyclerView;
        this.viewId = viewId;
        this.dataArray = dataArray;
        this.recycleViewItemListener = recycleViewItemListener;
    }

    @Override
    public void onClick(View view) {
        View parent = (View) view.getParent();
        while (!(parent instanceof RecyclerView)) {
            view = parent;
            parent = (View) parent.getParent();
        }
        int itemPosition = mRecyclerView.getChildAdapterPosition(view);
        recycleViewItemListener.itemClicked(view, this.viewId, JSONHelper.getObjectAt(dataArray, itemPosition));
    }
}
