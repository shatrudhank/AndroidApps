package com.honeywell.dvm_media_player.video;

public class CameraItem {
    private  Camera camera;
    private  boolean isSelected;


    public  CameraItem(Camera camera,boolean isSelected)
    {
        this.camera=camera;
        this.isSelected=isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return camera;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
