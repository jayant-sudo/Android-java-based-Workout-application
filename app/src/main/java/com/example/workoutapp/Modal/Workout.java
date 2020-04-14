package com.example.workoutapp.Modal;

import android.os.Parcel;
import android.os.Parcelable;

public class Workout implements Parcelable {
    private String title;
    private int image;
    private int time;
    private int tick;

    public Workout(String title, int image, int time,int tick) {
        this.title = title;
        this.image = image;
        this.time = time;
        this.tick=tick;
    }

    protected Workout(Parcel in) {
        title = in.readString();
        image = in.readInt();
        time = in.readInt();
        tick = in.readInt();
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeInt(image);
        parcel.writeFloat( time);
        parcel.writeInt(tick);
    }
}
