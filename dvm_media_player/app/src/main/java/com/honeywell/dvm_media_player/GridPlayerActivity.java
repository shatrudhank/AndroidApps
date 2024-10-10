package com.honeywell.dvm_media_player;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.honeywell.dvm_media_player.video.CameraData;
import com.honeywell.dvm_media_player.video.RecyclerPlayerAdapter;
import com.honeywell.dvm_media_player.video.RecyclerVideoAdapter;

public class GridPlayerActivity extends AppCompatActivity {
    RecyclerPlayerAdapter recyclerPlayerAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_player);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent=getIntent();
        String col=intent.getStringExtra("col");
        loadPlayer(Integer.parseInt(col) );
    }


    private  void  loadPlayer(int col)
    {
        recyclerView=findViewById(R.id.recyclerViewGridPlayer);
        recyclerView.setLayoutManager(new GridLayoutManager(this,col));
        recyclerPlayerAdapter= new RecyclerPlayerAdapter(GridPlayerActivity.this,CameraData.getData());
        recyclerView.setAdapter(recyclerPlayerAdapter);
    }
    @Override
    protected void onStop() {
        Toast.makeText(this,"Player Stopped",Toast.LENGTH_LONG).show();
        super.onStop();

        setContentView(new View(this));
        System.gc();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        recyclerView.setAdapter(null);
    }
}