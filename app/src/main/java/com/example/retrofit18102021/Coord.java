package com.example.retrofit18102021;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Coord {

@SerializedName("lon")
@Expose
private Float lon;
@SerializedName("lat")
@Expose
private Float lat;

public Float getLon() {
return lon;
}

public void setLon(Float lon) {
this.lon = lon;
}

public Float getLat() {
return lat;
}

public void setLat(Float lat) {
this.lat = lat;
}

}