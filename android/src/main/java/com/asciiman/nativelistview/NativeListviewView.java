package com.asciiman.nativelistview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by typhoon on 11/03/2017.
 */

public class NativeListviewView extends RecyclerView {

    private List<Event> eventList = new ArrayList<>();
    private EventsAdapter mAdapter;

    public NativeListviewView(Context context) {
        super(context);

        mAdapter = new EventsAdapter(eventList);

        this.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        this.setLayoutManager(mLayoutManager);
        this.setItemAnimator(new DefaultItemAnimator());
        this.setAdapter(mAdapter);

        this.addOnItemTouchListener(new RecyclerTouchListener(this.getContext(), this, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Event event = eventList.get(position);
                Toast.makeText(NativeListviewView.this.getContext(), event.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();
    }

    private void prepareMovieData() {
        Event event = new Event("Mad Max: Fury Road", "Action & Adventure", "2015");
        eventList.add(event);

        event = new Event("Inside Out", "Animation, Kids & Family", "2015");
        eventList.add(event);

        event = new Event("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        eventList.add(event);

        event = new Event("Shaun the Sheep", "Animation", "2015");
        eventList.add(event);

        event = new Event("The Martian", "Science Fiction & Fantasy", "2015");
        eventList.add(event);

        event = new Event("Mission: Impossible Rogue Nation", "Action", "2015");
        eventList.add(event);

        event = new Event("Up", "Animation", "2009");
        eventList.add(event);

        event = new Event("Star Trek", "Science Fiction", "2009");
        eventList.add(event);

        event = new Event("The LEGO Event", "Animation", "2014");
        eventList.add(event);

        event = new Event("Iron Man", "Action & Adventure", "2008");
        eventList.add(event);

        event = new Event("Aliens", "Science Fiction", "1986");
        eventList.add(event);

        event = new Event("Chicken Run", "Animation", "2000");
        eventList.add(event);

        event = new Event("Back to the Future", "Science Fiction", "1985");
        eventList.add(event);

        event = new Event("Raiders of the Lost Ark", "Action & Adventure", "1981");
        eventList.add(event);

        event = new Event("Goldfinger", "Action & Adventure", "1965");
        eventList.add(event);

        event = new Event("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        eventList.add(event);

        mAdapter.notifyDataSetChanged();
    }
}
