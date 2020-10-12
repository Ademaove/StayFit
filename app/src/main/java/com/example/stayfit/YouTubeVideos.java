package com.example.stayfit;

public class YouTubeVideos {
    String workout_name;
    String videoUrl;

    public YouTubeVideos() {
    }

    public YouTubeVideos( String workoutName, String videoUrl) {
        workout_name=workoutName;
        this.videoUrl = videoUrl;
    }

    public String getWorkout_name() {
        return workout_name;
    }

    //    public String getName() {
//        return workout_name;
//    }
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
