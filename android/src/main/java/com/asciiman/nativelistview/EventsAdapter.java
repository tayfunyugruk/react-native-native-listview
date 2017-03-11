package com.asciiman.nativelistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.asciiman.nativelistview.CustomFontManager.DINNextFont;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private List<Event> moviesList;

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
        tv.setTypeface(DINNextFont);
        return tv;
    }

    public EventsAdapter(List<Event> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Event event = moviesList.get(position);
        holder.matchCode.setText("523");
        holder.mbsText.setText("3");
        holder.shortLeagueText.setText("INPL");
        holder.homeTeamText.setText("GALATASARAY");
        holder.awayTeamText.setText("FENERBAHÇE");
        holder.detailText.setText("Maç başlamadı");
        holder.oddButton1.setValues("1", "1.50", "Galatasaray");
        holder.oddButtonX.setValues("X", "1.50", "Berabere");
        holder.oddButton2.setValues("2", "1.50", "Fenerbahçe");
        //
        holder.oddButton1.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
