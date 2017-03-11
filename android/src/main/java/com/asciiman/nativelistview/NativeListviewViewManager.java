package com.asciiman.nativelistview;

import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class NativeListviewViewManager extends ViewGroupManager<CustomRecyclerView> {

    @Override
    public String getName() {
        return NativeListviewView.class.getSimpleName();
    }

    @Override
    protected CustomRecyclerView createViewInstance(ThemedReactContext reactContext) {
        CustomRecyclerView view = new CustomRecyclerView(reactContext);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public void addView(CustomRecyclerView parent, View child, int index) {
        parent.addView(child);
    }

    @ReactProp(name = "numRows")
    public void setNumRows(CustomRecyclerView parent, int size) {

    }

    @ReactProp(name = "rowHeight")
    public void setRowHeight(CustomRecyclerView parent, int val) {

    }

    @Override
    public int getChildCount(CustomRecyclerView parent) {
        return parent.getChildCount();
    }

    @Override
    public void removeAllViews(CustomRecyclerView parent) {

    }
}
