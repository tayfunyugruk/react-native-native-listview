package oley.tayfun.com.oleybulletintest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> implements RecycleViewItemListener {

    private JSONArray eventList;
    private JSONArray selectedOddList;
    private RecycleViewItemListener clickListener;
    private RecyclerView mRecyclerView;

    @Override
    public void itemClicked(View view, int clickedView, Object itemData) {
        clickListener.itemClicked(view, clickedView, itemData);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView matchCode, shortLeagueText;
        public TextView homeTeamText, awayTeamText, detailText;
        public OddButton oddButton1, oddButtonX, oddButton2;
        public MbsView mbsView;
        public View detailButton;

        public MyViewHolder(View view) {
            super(view);

            matchCode = findTextView(view, R.id.matchCode);
            shortLeagueText = findTextView(view, R.id.shortLeagueText);
            homeTeamText = findTextView(view, R.id.homeTeamText);
            awayTeamText = findTextView(view, R.id.awayTeamText);
            detailText = findTextView(view, R.id.detailText);
            oddButton1 = (OddButton) view.findViewById(R.id.oddButton1);
            oddButtonX = (OddButton) view.findViewById(R.id.oddButtonX);
            oddButton2 = (OddButton) view.findViewById(R.id.oddButton2);
            mbsView = (MbsView) view.findViewById(R.id.mbsView);
            detailButton = view.findViewById(R.id.detailButton);

            oddButton1.setOnClickListener(new CustomViewClickListener(EventsAdapter.this.mRecyclerView, EventsAdapter.this.eventList, 1, EventsAdapter.this));
            oddButtonX.setOnClickListener(new CustomViewClickListener(EventsAdapter.this.mRecyclerView, EventsAdapter.this.eventList, 2, EventsAdapter.this));
            oddButton2.setOnClickListener(new CustomViewClickListener(EventsAdapter.this.mRecyclerView, EventsAdapter.this.eventList, 3, EventsAdapter.this));
            detailButton.setOnClickListener(new CustomViewClickListener(EventsAdapter.this.mRecyclerView, EventsAdapter.this.eventList, 4, EventsAdapter.this));
        }
    }

    private TextView findTextView(View parentView, int id) {
        TextView tv = (TextView) parentView.findViewById(id);
        tv.setTypeface(CustomFontManager.DINNextFont);
        return tv;
    }

    public EventsAdapter(RecyclerView mRecyclerView) {
        this.mRecyclerView = mRecyclerView;
    }

    public void setEventList(JSONArray eventList) {
        this.eventList = eventList;
    }

    public JSONArray getEventList() {
        return this.eventList;
    }

    public void setSelectedOddList(JSONArray selectedOddList) {
        this.selectedOddList = selectedOddList;
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
        holder.mbsView.setMbs(JSONHelper.getInt(event, "mbs"));
        holder.shortLeagueText.setText(JSONHelper.getString(event, "tournamentName"));
        holder.homeTeamText.setText(JSONHelper.getString(event, "homeTeam").toUpperCase());
        holder.awayTeamText.setText(JSONHelper.getString(event, "awayTeam").toUpperCase());
        holder.detailText.setText(JSONHelper.getString(event, "eventDate"));
        holder.oddButton1.setValues("1", "1.50", JSONHelper.getString(event, "homeTeam"));
        holder.oddButtonX.setValues("X", "1.50", "Berabere");
        holder.oddButton2.setValues("2", "1.50", JSONHelper.getString(event, "awayTeam"));
        //
        showSelectedOdds(holder, event);
    }

    public void showSelectedOdds(MyViewHolder holder, JSONObject event) {
        if (selectedOddList != null) {
            for (int i = 0; i < selectedOddList.length(); i++) {
                JSONObject selectedOdd = JSONHelper.getObjectAt(selectedOddList, i);
                String matchCode = JSONHelper.getString(selectedOdd, "matchCode");
                if (matchCode.equals(JSONHelper.getString(event, "matchCode"))) {
                    // show selected odds..
                    String selection = JSONHelper.getString(selectedOdd, "selection");
                    if ("F.1".equals(selection)) {
                        holder.oddButton1.setSelected(true);
                    } else if ("F.X".equals(selection)) {
                        holder.oddButtonX.setSelected(true);
                    } else {
                        holder.oddButton2.setSelected(true);
                    }
                }
            }
        }
    }

    public void setRecycleViewItemListener(RecycleViewItemListener listener) {
        this.clickListener = listener;
    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.length();
    }
}
