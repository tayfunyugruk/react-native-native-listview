package com.asciiman.nativelistview;

import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactMethod;

public class NativeListviewViewManager extends ViewGroupManager<NativeListviewView> {

    @Override
    public String getName() {
        return NativeListviewView.class.getSimpleName();
    }

    @Override
    protected NativeListviewView createViewInstance(ThemedReactContext reactContext) {
        NativeListviewView view = new NativeListviewView(reactContext);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public void addView(NativeListviewView parent, View child, int index) {
        parent.addView(child);
    }

    @ReactProp(name = "setBulletin")
    public void setBulletin(NativeListviewView parent, String bulletin) {
        parent.setBulletin(bulletin);
    }

    @ReactMethod
    public void setSelectedOddList(NativeListviewView parent, String selectedOddList) {
        parent.setSelectedOddList(selectedOddList);
    }

    @Override
    public int getChildCount(NativeListviewView parent) {
        return parent.getChildCount();
    }

    @Override
    public void removeAllViews(NativeListviewView parent) {

    }
}
