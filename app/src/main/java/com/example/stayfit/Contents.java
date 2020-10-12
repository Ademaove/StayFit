package com.example.stayfit;

public class Contents {
    private String name_of_exercise="None";
    private int video_id=nothing;
    private int img_id= R.drawable.m1;//nothing;
    private int music_id=nothing;
    private static final int nothing=-1;

    public Contents(String name, int Id, boolean f){ //for Journal and shop
        name_of_exercise=name;
        img_id=Id;

    }
    public Contents( int Id){//for profile for now
        img_id=Id;

    }
    public Contents(String name, int vID){//forVideo
        name_of_exercise=name;
        video_id=vID;


    }
    public Contents(String name, int Id, int mID){ //for meditation
        name_of_exercise=name;
        img_id=Id;
        music_id=mID;
    }
    public String get_name(){
        return name_of_exercise;
    }
    public int get_videoAPI(){
        return video_id;
    }
    public int get_imgID(){
        return img_id;
    }
    public int get_musicID(){
        return music_id;
    }

    public boolean hasAVideo(){
        return video_id!=nothing;
    }
    public boolean hasImage(){
        return img_id!=nothing;
    }
    public boolean hasAudio(){
        return music_id!=nothing;
    }
    public boolean hasName(){
        return name_of_exercise!="None";
    }
}
