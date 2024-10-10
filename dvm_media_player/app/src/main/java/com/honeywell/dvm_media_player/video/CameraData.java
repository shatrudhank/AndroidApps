package com.honeywell.dvm_media_player.video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CameraData {

    private static List<CameraItem> cameraList= new ArrayList<>(Arrays.asList(
//            new CameraItem(
//                    new Camera("Camera 1","rtsp://shiv_devi:shiv_devi@192.168.29.169/stream1")
//                    ,true),
//            new CameraItem(
//                    new Camera("Camera 2","rtsp://shiv_devi:shiv_devi@192.168.29.165/stream1")
//                    ,true),
//              new CameraItem(
//                    new Camera("Camera 3","rtsp://shiv_devi:shiv_devi@192.168.29.169/stream1")
//                    ,true),
//                            new CameraItem(
//                    new Camera("Camera 4","rtsp://shiv_devi:shiv_devi@192.168.29.165/stream1")
//                    ,true)
    ));



    public  static List<CameraItem> getData()
    {
        return  cameraList;
    }

    public static  void add(String name,String url)
    {
        cameraList.add(
                new CameraItem(
                        new Camera(name,url)
                        ,true));
    }

    public static  String GetFirstCamera()
    {
        return cameraList.get(0).getCamera().getUrl();
    }

}
