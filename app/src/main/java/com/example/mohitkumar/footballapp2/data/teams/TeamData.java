package com.example.mohitkumar.footballapp2.data.teams;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class TeamData {

//    @ColumnInfo(name = "id")
//    @Expose(serialize = true, deserialize = false)
    public long id;

//    @ColumnInfo(name = "name")
//    @Expose(serialize = true, deserialize = false)
    public String name;

//    @ColumnInfo(name = "shortName")
//    @Expose(serialize = true, deserialize = false)
    public String shortName;

//    @ColumnInfo(name = "tla")
//    @Expose(serialize = true, deserialize = false)
    public String tla;

//    @ColumnInfo(name = "crestUrl")
//    @Expose(serialize = true, deserialize = false)
    public String crestUrl;

//    @ColumnInfo(name = "address")
//    @Expose(serialize = true, deserialize = false)
    public String address;

//    @ColumnInfo(name = "phone")
//    @Expose(serialize = true, deserialize = false)
    public String phone;

//    @ColumnInfo(name = "website")
//    @Expose(serialize = true, deserialize = false)
    public String website;

//    @ColumnInfo(name = "email")
//    @Expose(serialize = true, deserialize = false)
    public String email;

//    @ColumnInfo(name = "founded")
//    @Expose(serialize = true, deserialize = false)
    public int founded;

//    @ColumnInfo(name = "clubColors")
//    @Expose(serialize = true, deserialize = false)
    public String clubColors;

//    @ColumnInfo(name = "venue")
//    @Expose(serialize = true, deserialize = false)
    public String venue;

//    @ColumnInfo(name = "area")
//    @Expose(serialize = true, deserialize = false)
   public Area area;

   public String lastUpdated;
}
