package com.example.mohitkumar.footballapp2.core.standings;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohitkumar.footballapp2.R;
import com.example.mohitkumar.footballapp2.Utils.Utils;
import com.example.mohitkumar.footballapp2.databinding.FragmentStandingsBinding;

import static com.example.mohitkumar.footballapp2.MainApplication.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class StandingsFragment extends Fragment {

    public StandingsFragment() {
        // Required empty public constructor
    }

    FragmentStandingsBinding standingsBinding;
    String name;
    int leagueCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        standingsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_standings, container, false);
        name = getActivity().getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name))
            leagueCode = Utils.map.get(name);

        Log.d(TAG, leagueCode + " Standings");
        return standingsBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
