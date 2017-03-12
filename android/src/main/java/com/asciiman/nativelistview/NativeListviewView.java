package com.asciiman.nativelistview;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by typhoon on 11/03/2017.
 */

public class NativeListviewView extends RecyclerView implements RecycleViewItemListener {

    private EventsAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private RecycleViewItemListener parentRecycleViewItemListener;

    public NativeListviewView(Context context) {
        super(context);

        CustomFontManager.initialize(context);

        mAdapter = new EventsAdapter(this);
        mAdapter.setRecycleViewItemListener(this);

        this.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        this.setLayoutManager(mLayoutManager);
        this.setItemAnimator(new DefaultItemAnimator());
        this.setAdapter(mAdapter);
    }

    public void setBulletin(String bulletin) {
        try {
            JSONObject jsonObj = new JSONObject(bulletin);
            JSONArray jsonArray = jsonObj.getJSONArray("eventList");
            mAdapter.setEventList(jsonArray);
            mAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setSelectedOddList(String selectedOddListString) {
        try {
            JSONArray selectedOddList = new JSONArray(selectedOddListString);
            mAdapter.setSelectedOddList(selectedOddList);

            this.setAdapter(null);
            this.setLayoutManager(null);
            this.setAdapter(mAdapter);
            this.setLayoutManager(mLayoutManager);
            mAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setParentRecycleViewItemListener(RecycleViewItemListener parentRecycleViewItemListener) {
        this.parentRecycleViewItemListener = parentRecycleViewItemListener;
    }

    @Override
    public void itemClicked(View view, int clickedView, Object itemData) {
        JSONObject jsonObject = (JSONObject) itemData;
        this.parentRecycleViewItemListener.itemClicked(null, clickedView, jsonObject);
        //Toast.makeText(NativeListviewView.this.getContext(), clickedView + " clicked for " + JSONHelper.getString(jsonObject, "homeTeam") + " event is selected!", Toast.LENGTH_SHORT).show();
    }
}
