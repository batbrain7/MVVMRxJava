package com.example.mohitkumar.footballapp2.data.teams;


import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class Season {

//    @ColumnInfo(name = "id")
//    @Expose(serialize = true, deserialize = false)
    public int id;

//    @ColumnInfo(name = "startDate")
//    @Expose(serialize = true, deserialize = false)
    public String startDate;

//    @ColumnInfo(name = "endDate")
//    @Expose(serialize = true, deserialize = false)
    public String endDate;

//    @ColumnInfo(name = "currentMatchday")
//    @Expose(serialize = true, deserialize = false)
    public int currentMatchday;

//    @ColumnInfo(name = "winner")
//    @Expose(serialize = true, deserialize = false)
    public String winner;
}
