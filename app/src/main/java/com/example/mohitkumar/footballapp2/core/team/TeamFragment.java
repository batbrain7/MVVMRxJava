package com.example.mohitkumar.footballapp2.core.team;


import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mohitkumar.footballapp2.R;
import com.example.mohitkumar.footballapp2.Utils.Utils;
import com.example.mohitkumar.footballapp2.data.teams.TeamData;
import com.example.mohitkumar.footballapp2.data.teams.TeamResponse;
import com.example.mohitkumar.footballapp2.data.teams.TeamsApiClient;
import com.example.mohitkumar.footballapp2.databinding.FragmentTeamBinding;

import java.util.List;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

public class TeamFragment extends Fragment {


    public TeamFragment() {
        // Required empty public constructor
    }

    private TeamResponse response;
    private TeamViewModel teamViewModel;
    private FragmentTeamBinding fragmentTeamBinding;
    int leagueCode;
    String name;
    TeamRecyclerAdapter adapter;

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
        if (!Utils.hasNetwork()) {
            Toast.makeText(getActivity(), "Network not available", Toast.LENGTH_LONG).show();
        }
        teamViewModel.getProgress().observe(this, fragmentTeamBinding.progressBar::setVisibility);
        loadTeams();

        fragmentTeamBinding.pullToRefresh.setOnRefreshListener(() -> {
            if (!Utils.hasNetwork()) {
                Toast.makeText(getActivity(), "Network not available", Toast.LENGTH_LONG).show();
                fragmentTeamBinding.pullToRefresh.setRefreshing(false);
                return;
            }
            teamViewModel.getProgress().observe(this, fragmentTeamBinding.progressBar::setVisibility);
            loadTeams();
            fragmentTeamBinding.pullToRefresh.setRefreshing(false);
        });
    }

    private void loadTeams() {

        teamViewModel.getTeamData(leagueCode).observe(this, teamResponse -> {
            Log.d(TAG, "Inside fragment  "); //+ teamData.size() + " " + teamData.toString());
            response = teamResponse;
            if (response != null && response.teams != null) {
                setRecyclerView(teamResponse.teams);
            }
        });
    }

    public void setRecyclerView(List<TeamData> teamData) {
        fragmentTeamBinding.teamsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TeamRecyclerAdapter(getContext(), teamData);
        fragmentTeamBinding.teamsRecyclerView.setAdapter(adapter);
    }

}
