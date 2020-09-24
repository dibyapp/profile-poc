package com.ab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    Context context;
    ArrayList<String> userid;
    ArrayList<String> id;
    ArrayList<String> title;
    ArrayList<String> body;


    static class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView uidText;
        TextView idText;
        TextView titleText;
        TextView bodyText;

        public SearchViewHolder(View itemView) {
            super(itemView);
            uidText = itemView.findViewById(R.id.uid);
            idText = itemView.findViewById(R.id.iid);
            titleText = itemView.findViewById(R.id.title);
            bodyText = itemView.findViewById(R.id.body);
        }
    }

    public SearchAdapter(Context context, ArrayList<String> uidList, ArrayList<String> iidList, ArrayList<String> titleList, ArrayList<String> bodyList) {
        this.context = context;
        this.id = iidList;
        this.userid = uidList;
        this.title = titleList;
        this.body = bodyList;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_display_layout, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SearchViewHolder holder, final int position) {
        holder.uidText.setText(userid.get(position));
        holder.idText.setText(id.get(position));
        holder.titleText.setText(title.get(position));
        holder.bodyText.setText(body.get(position));
    }

    @Override
    public int getItemCount() {
        return userid.size();
    }
}

