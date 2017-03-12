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

public class NativeListviewView extends RecyclerView {

    private EventsAdapter mAdapter;

    public NativeListviewView(Context context) {
        super(context);

        CustomFontManager.initialize(context);

        mAdapter = new EventsAdapter();

        this.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        this.setLayoutManager(mLayoutManager);
        this.setItemAnimator(new DefaultItemAnimator());
        this.setAdapter(mAdapter);

        this.addOnItemTouchListener(new RecyclerTouchListener(this.getContext(), this, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                JSONObject event = JSONHelper.getObjectAt(mAdapter.getEventList(), position);
                Toast.makeText(NativeListviewView.this.getContext(), JSONHelper.getString(event, "homeTeam") + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
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
            mAdapter.notifyDataSetChanged();
            requestLayout();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
