package com.example.mohitkumar.footballapp2.data.teams;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class Competition {

//    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Expose(serialize = true, deserialize = false)
    public long idCompetition;

    @ColumnInfo(name = "name")
    @Expose(serialize = true, deserialize = false)
    public String leagueName;

    @ColumnInfo(name = "code")
    @Expose(serialize = true, deserialize = false)
    public String leagueCode;

    @ColumnInfo(name = "plan")
    @Expose(serialize = true, deserialize = false)
    public String leagueType;

    @ColumnInfo(name = "area")
    @Expose(serialize = true, deserialize = false)
    public Area area;

}
