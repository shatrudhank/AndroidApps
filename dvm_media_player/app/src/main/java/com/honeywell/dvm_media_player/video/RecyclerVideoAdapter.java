package com.honeywell.dvm_media_player.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.honeywell.dvm_media_player.R;

import java.util.List;

public class RecyclerVideoAdapter extends  RecyclerView.Adapter<CameraItemHolder> {

    List<CameraItem> videoList;

    public RecyclerVideoAdapter(List<CameraItem> videoList)
    {
        this.videoList=videoList;
    }
    @NonNull
    @Override
    public CameraItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        return new CameraItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CameraItemHolder holder, int position) {
        CameraItem videoItem=videoList.get(position);
        holder.txtVwVideoName.setText(videoItem.getCamera().getName());
       // holder.chkBoxIsSelected.sebo(videoItem.isSelected());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}

class  CameraItemHolder extends RecyclerView.ViewHolder
{
    TextView txtVwVideoName;
    CheckBox chkBoxIsSelected;

    public  CameraItemHolder(View view)
    {
        super(view);
        this.txtVwVideoName=view.findViewById(R.id.txtVwCameraName);
        this.chkBoxIsSelected=view.findViewById(R.id.chkboxIsCameraSelected);
    }
}