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

public class SkillLeadersAdapter extends RecyclerView.Adapter<SkillLeadersAdapter.ViewHolder> {
    private List<RetroLeaders> mdataList;
    private LayoutInflater mLayoutInflater;
    Context mContext;

    public SkillLeadersAdapter(Context context, List<RetroLeaders> dataList){
        mdataList = dataList;
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;

    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learners_layout, parent, false);
        return new ViewHolder(itemView);
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

        holder.hoursandcountry.setText(currentLeader.getScore() + " skill IQ Score, " + currentLeader.getCountry());

        //holder.mBadgeImageView.setImageResource();


    }



    @Override

    public int getItemCount() {
        return mdataList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mName;
        public final TextView hoursandcountry;
        public final ImageView mImage;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);

            hoursandcountry = itemView.findViewById(R.id.hours_and_country);

            mImage = itemView.findViewById(R.id.image);

        }

    }
}
