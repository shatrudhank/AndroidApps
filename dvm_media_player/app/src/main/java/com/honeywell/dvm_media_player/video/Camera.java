package com.honeywell.dvm_media_player.video;

public class Camera {
    private String Name;
    private String url;


    public  Camera(String name,String url)
    {
        this.Name=name;
        this.url=url;
    }


    public String getName() {
        return Name;
    }

    public String getUrl() {
        return url;
    }


}
