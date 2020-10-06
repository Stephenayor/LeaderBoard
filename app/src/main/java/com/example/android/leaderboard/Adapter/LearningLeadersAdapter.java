package com.example.android.leaderboard.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.leaderboard.R;
import com.example.android.leaderboard.model.RetroLeaders;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder>{

    private List<RetroLeaders> mdataList;
    private LayoutInflater mLayoutInflater;
    Context mContext;

public LearningLeadersAdapter(Context context, List<RetroLeaders> dataList){
        mContext = context;
        mdataList = dataList;
        mLayoutInflater = LayoutInflater.from(context);
}


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learners_layout,parent,false);
        return new LearningLeadersAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RetroLeaders currentLeader = mdataList.get(position);
        Picasso.Builder builder = new Picasso.Builder(mContext);

        builder.downloader(new OkHttp3Downloader(mContext));

        builder.build().load(currentLeader.getBadgeUrl())

                .placeholder(R.drawable.ic_launcher_background)

                .error(R.drawable.ic_launcher_foreground)

                .into(holder.mImage);

        holder.mName.setText(currentLeader.getName());

        holder.hoursandCountry.setText(currentLeader.getHours() + " learning hours, " + currentLeader.getCountry());
    }


    @Override
    public int getItemCount() {
        return mdataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mName;
        public final TextView hoursandCountry;
        public final ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            hoursandCountry = itemView.findViewById(R.id.hours_and_country);
            mImage = itemView.findViewById(R.id.image);
        }
    }
}
