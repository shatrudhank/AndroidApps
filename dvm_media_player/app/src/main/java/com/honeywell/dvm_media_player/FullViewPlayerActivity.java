package com.honeywell.dvm_media_player;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.honeywell.dvm_media_player.video.CameraData;
import com.honeywell.dvm_media_player.video.DvmPlayer;

public class FullViewPlayerActivity extends AppCompatActivity {
    private ExoPlayer exoPlayer;
    private PlayerView playerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_view_player);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Init();
    }
    @OptIn(markerClass = UnstableApi.class)
    private  void Init()
    {
        exoPlayer =  new ExoPlayer.Builder(FullViewPlayerActivity.this).build();;
        exoPlayer.setMediaItem(MediaItem.fromUri(CameraData.GetFirstCamera()));
        exoPlayer.prepare();
        exoPlayer.play();
        playerView=findViewById(R.id.player_view);
        playerView.setPlayer(exoPlayer);
    }

    @Override
    protected void onStop() {
        Toast.makeText(this,"Player Stopped",Toast.LENGTH_LONG).show();
        super.onStop();
        playerView.setPlayer(null);
        exoPlayer.stop();
        exoPlayer.release();

        exoPlayer = null;
        playerView      = null;

        setContentView(new View(this));
        System.gc();
        finish();
    }


}