package com.honeywell.dvm_media_player;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;


public class MainActivity extends AppCompatActivity {



    private  void RtspPlayer()
    {
        ExoPlayer player = new ExoPlayer.Builder(MainActivity.this).build();
        player.setMediaItem(MediaItem.fromUri("rtsp://shiv_devi:shiv_devi@192.168.29.165/stream1"));
        player.prepare();
        PlayerView playerView=findViewById(R.id.player_view);
        playerView.setPlayer(player);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RtspPlayer();
    }
}