package com.asciiman.nativelistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private JSONArray eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView matchCode, mbsText, shortLeagueText;
        public TextView homeTeamText, awayTeamText, detailText;
        public OddButton oddButton1, oddButtonX, oddButton2;

        public MyViewHolder(View view) {
            super(view);
            matchCode = findTextView(view, R.id.matchCode);
            mbsText = findTextView(view, R.id.mbsText);
            shortLeagueText = findTextView(view, R.id.shortLeagueText);
            homeTeamText = findTextView(view, R.id.homeTeamText);
            awayTeamText = findTextView(view, R.id.awayTeamText);
            detailText = findTextView(view, R.id.detailText);
            oddButton1 = (OddButton) view.findViewById(R.id.oddButton1);
            oddButtonX = (OddButton) view.findViewById(R.id.oddButtonX);
            oddButton2 = (OddButton) view.findViewById(R.id.oddButton2);
        }
    }

    private TextView findTextView(View parentView, int id) {
        TextView tv = (TextView) parentView.findViewById(id);
        tv.setTypeface(CustomFontManager.DINNextFont);
        return tv;
    }

    public EventsAdapter() {
    }

    public void setEventList(JSONArray eventList) {
        this.eventList = eventList;
    }

    public JSONArray getEventList() {
        return this.eventList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        JSONObject event = JSONHelper.getObjectAt(eventList, position);
        holder.matchCode.setText(JSONHelper.getString(event, "matchCode"));
        holder.mbsText.setText(JSONHelper.getString(event, "mbs"));
        holder.shortLeagueText.setText(JSONHelper.getString(event, "tournamentName"));
        holder.homeTeamText.setText(JSONHelper.getString(event, "homeTeam").toUpperCase());
        holder.awayTeamText.setText(JSONHelper.getString(event, "awayTeam").toUpperCase());
        holder.detailText.setText(JSONHelper.getString(event, "eventDate"));
        holder.oddButton1.setValues("1", "1.50", JSONHelper.getString(event, "homeTeam"));
        holder.oddButtonX.setValues("X", "1.50", "Berabere");
        holder.oddButton2.setValues("2", "1.50", JSONHelper.getString(event, "awayTeam"));
        //
        holder.oddButton1.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.length();
    }
}
