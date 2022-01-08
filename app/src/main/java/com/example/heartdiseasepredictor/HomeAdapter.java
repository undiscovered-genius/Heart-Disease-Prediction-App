package com.example.heartdiseasepredictor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.homeViewHolder> {

    List<String> titles;
    List<String> info;
    LayoutInflater inflater;
//    Context cxt;
//    int lastPosition = -1;

    public HomeAdapter(Context cxt, List<String> titles, List<String> info){
        this.titles = titles;
        this.info = info;
        this.inflater = LayoutInflater.from(cxt);
//        this.cxt = cxt;
    }

    @NonNull
    @Override
    public HomeAdapter.homeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.info_card_layout,parent,false);
        return new homeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.homeViewHolder holder, int position) {
        homeViewHolder viewHolder = (homeViewHolder) holder;
        viewHolder.titleView.setText(titles.get(position));
        viewHolder.infoView.setText(info.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class homeViewHolder extends RecyclerView.ViewHolder{

        TextView titleView;
        TextView infoView;

        public homeViewHolder(@NonNull View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.infoItem);
            infoView = itemView.findViewById(R.id.detailItem);
        }
    }
}
