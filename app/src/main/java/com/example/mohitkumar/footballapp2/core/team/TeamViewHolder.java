package com.example.mohitkumar.footballapp2.core.team;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohitkumar.footballapp2.R;

public class TeamViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView shortName;
    TextView venue;
    TextView email;
    TextView website;
    TextView founded;
    TextView clubColors;
    ImageView crest;
   // TextView name;
   // TextView name;

    public TeamViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        shortName = itemView.findViewById(R.id.shortName);
        venue = itemView.findViewById(R.id.venue);
        email = itemView.findViewById(R.id.email);
        website = itemView.findViewById(R.id.website);
        founded = itemView.findViewById(R.id.founded);
        clubColors = itemView.findViewById(R.id.clubColors);
        crest = itemView.findViewById(R.id.crest);

    }
}