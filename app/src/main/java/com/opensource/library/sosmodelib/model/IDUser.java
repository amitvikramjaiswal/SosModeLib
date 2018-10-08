package com.opensource.library.sosmodelib.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class IDUser implements Parcelable, ClusterItem {

    public static final Creator<IDUser> CREATOR = new Creator<IDUser>() {
        @Override
        public IDUser createFromParcel(Parcel in) {
            return new IDUser(in);
        }

        @Override
        public IDUser[] newArray(int size) {
            return new IDUser[size];
        }
    };
    private String name;
    private LatLng position;

    protected IDUser(Parcel in) {
        name = in.readString();
        position = in.readParcelable(LatLng.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeParcelable(position, i);
    }

    @Override
    public LatLng getPosition() {
        return position;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getSnippet() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }
}
