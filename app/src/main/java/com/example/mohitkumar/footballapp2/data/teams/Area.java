package com.example.mohitkumar.footballapp2.data.teams;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class Area {

//    @ColumnInfo(name = "id")
    @Expose(serialize = true, deserialize = false)
    public int id;

//    @ColumnInfo(name = "name")
    @Expose(serialize = true, deserialize = false)
    public String name;

}
