package com.example.appchonhinh07062022;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by pphat on 8/6/2022.
 */
public class Animal implements Parcelable {
    String weight;

    public Animal(String weight) {
        this.weight = weight;
    }

    protected Animal(Parcel in) {
        weight = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(weight);
    }
}
