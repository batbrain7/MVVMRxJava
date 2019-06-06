package com.example.mohitkumar.footballapp2.core.team;


import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohitkumar.footballapp2.R;
import com.example.mohitkumar.footballapp2.Utils.Utils;
import com.example.mohitkumar.footballapp2.data.teams.TeamData;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApiClient;
import com.example.mohitkumar.footballapp2.databinding.FragmentTeamBinding;

import java.util.List;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

public class TeamFragment extends Fragment {


    public TeamFragment() {
        // Required empty public constructor
    }

    private List<TeamData> teamDataList;
    private TeamViewModel teamViewModel;
    private FragmentTeamBinding fragmentTeamBinding;
    int leagueCode;
    String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentTeamBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false);
        name = getActivity().getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name))
            leagueCode = Utils.map.get(name);

        Log.d(TAG, leagueCode + " ");
        teamViewModel = ViewModelProviders.of(this).get(TeamViewModel.class);
        return fragmentTeamBinding.getRoot();
    }

    @SuppressLint("CheckResult")
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Loading the teams");
        loadTeams();
    }

    private void loadTeams() {

        teamViewModel.getTeamData(leagueCode, new TeamsApiClient(getActivity())).observe(this, new Observer<List<TeamData>>() {
            @Override
            public void onChanged(@Nullable List<TeamData> teamData) {
                Log.d(TAG, teamData.size() + " " + teamData.toString());
            }
        });
//            teamDataList = list;
//            if (list != null)
//                Log.d(TAG, list.size() + " " + list.toString());
//            else
//                Log.d(TAG, "Empty list");
//        });
    }

}
