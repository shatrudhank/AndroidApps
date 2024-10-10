package com.honeywell.dvm_media_player.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;

import com.honeywell.dvm_media_player.GridPlayerActivity;
import com.honeywell.dvm_media_player.MainActivity;
import com.honeywell.dvm_media_player.R;

import java.util.List;

public class RecyclerPlayerAdapter extends  RecyclerView.Adapter<PlayerItemHolder> {
    ExoPlayer exoPlayer;
    List<CameraItem> videoList;
    Context context;

    public RecyclerPlayerAdapter(Context context, List<CameraItem> videoList)
    {
        this.videoList=videoList;
        this.context=context;
    }

    @NonNull
    @Override
    public PlayerItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.player,parent,false);
        return new PlayerItemHolder(view);
    }

    @OptIn(markerClass = UnstableApi.class)
    @Override
    public void onBindViewHolder(@NonNull PlayerItemHolder holder, int position) {
        CameraItem videoItem=videoList.get(position);
        holder.bind(videoItem.getCamera().getUrl());

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull PlayerItemHolder holder) {
        super.onViewDetachedFromWindow(holder);

        holder.releasePlayer();
    }

}

class  PlayerItemHolder extends RecyclerView.ViewHolder
{
    ExoPlayer exoPlayer;
    PlayerView playerView;
    public  PlayerItemHolder(View view)
    {
        super(view);
        playerView=view.findViewById(R.id.player_view);
        exoPlayer=new ExoPlayer.Builder(itemView.getContext()).build();
    }

    public  void bind(String cameraUrl)
    {
        exoPlayer.setMediaItem(MediaItem.fromUri(cameraUrl));
        exoPlayer.prepare();
        exoPlayer.play();
        playerView.setPlayer(exoPlayer);
    }
    public void releasePlayer() {
        if (exoPlayer != null) {
            exoPlayer.stop();
            exoPlayer.release();
            exoPlayer = null;
        }
    }
}