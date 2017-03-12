package com.asciiman.nativelistview;

import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

public class NativeListviewViewManager extends ViewGroupManager<NativeListviewView> implements RecycleViewItemListener {

    private ReactContext reactContext;

    @Override
    public String getName() {
        return NativeListviewView.class.getSimpleName();
    }

    @Override
    protected NativeListviewView createViewInstance(ThemedReactContext reactContext) {
        this.reactContext = reactContext;
        NativeListviewView view = new NativeListviewView(reactContext);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setPadding(5, 5, 5, 5);
        view.setParentRecycleViewItemListener(this);
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

    @ReactProp(name = "setSelectedOddList")
    public void setSelectedOddList(NativeListviewView parent, String selectedOddList) {
        parent.setSelectedOddList(selectedOddList);
    }

    @Override
    public int getChildCount(NativeListviewView parent) {
        return parent.getChildCount();
    }

    @Override
    public void removeAllViews(NativeListviewView parent) {
        parent.removeAllViews();
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
      reactContext
          .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
          .emit(eventName, params);
    }

    @Override
    public void itemClicked(View view, int clickedView, Object itemData) {
        WritableMap params = Arguments.createMap();
        params.set("viewId", clickedView);
        sendEvent(this.reactContext, "itemClicked", params);
    }
}
