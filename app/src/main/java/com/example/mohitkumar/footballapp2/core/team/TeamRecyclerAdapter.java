package com.example.mohitkumar.footballapp2.core.team;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohitkumar.footballapp2.R;
import com.example.mohitkumar.footballapp2.data.teams.TeamData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamRecyclerAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    private Context context;
    private List<TeamData> data;
    //GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

    public TeamRecyclerAdapter(Context context, List<TeamData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.team_card, viewGroup, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder teamViewHolder, int i) {
        TeamData teamData = data.get(i);
        teamViewHolder.name.setText(teamData.name);
        teamViewHolder.shortName.setText(teamData.shortName);
        teamViewHolder.venue.setText(teamData.venue);
        teamViewHolder.founded.setText(Integer.toString(teamData.founded));
        teamViewHolder.clubColors.setText(teamData.clubColors);
        teamViewHolder.website.setText(teamData.website);
        teamViewHolder.email.setText(teamData.email);

        if (!TextUtils.isEmpty(teamData.crestUrl)) {
            Picasso.get()
                    .load(teamData.crestUrl)
                    .placeholder(R.drawable.ic_stars_black_24dp)
                    .error(R.drawable.ic_error_black_24dp)
                    .into(teamViewHolder.crest);


        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
