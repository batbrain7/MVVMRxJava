package com.example.mohitkumar.footballapp2.data.teams;

import java.util.List;

import lombok.Data;

@Data
public class TeamResponse {
    public List<TeamData> teams;
    public int count;
    public Competition competition;
    public Season season;
}
