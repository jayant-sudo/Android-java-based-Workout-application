package com.example.workoutapp.Modal;

public class RandomWorkout {
    private String title;
    private int image;
    private int time;
    private int play_image;

    public RandomWorkout(String title, int image,int time ,int play_image) {
        this.title = title;
        this.image = image;
        this.time = time;
        this.play_image = play_image;
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

    public int getPlay_image() {
        return play_image;
    }

    public void setPlay_image(int play_image) {
        this.play_image = play_image;
    }
}
