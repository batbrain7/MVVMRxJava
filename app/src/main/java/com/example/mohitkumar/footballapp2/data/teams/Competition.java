package com.example.mohitkumar.footballapp2.data.teams;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class Competition {

//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
    @Expose(serialize = true, deserialize = false)
    public long id;

//    @ColumnInfo(name = "name")
    @Expose(serialize = true, deserialize = false)
    public String name;

//    @ColumnInfo(name = "code")
    @Expose(serialize = true, deserialize = false)
    public String code;

//    @ColumnInfo(name = "plan")
    @Expose(serialize = true, deserialize = false)
    public String plan;

//    @ColumnInfo(name = "area")
    @Expose(serialize = true, deserialize = false)
    public Area area;

}
