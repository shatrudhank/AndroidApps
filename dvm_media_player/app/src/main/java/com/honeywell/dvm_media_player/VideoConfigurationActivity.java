package com.honeywell.dvm_media_player;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.honeywell.dvm_media_player.common.AppActionHandler;
import com.honeywell.dvm_media_player.video.CameraData;
import com.honeywell.dvm_media_player.video.CameraDialog;
import com.honeywell.dvm_media_player.video.RecyclerVideoAdapter;

public class VideoConfigurationActivity extends AppCompatActivity {
    RecyclerVideoAdapter recyclerVideoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_configuration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DVM");
        loadData();

    }

    private  void  loadData()
    {
        RecyclerView recyclerView=findViewById(R.id.recyclerViewVideo);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerVideoAdapter= new RecyclerVideoAdapter(CameraData.getData());
        recyclerView.setAdapter(recyclerVideoAdapter);
    }

    public void onClickBtn1x1(View view)
    {
        if(CameraData.getData().isEmpty())
        {
            Toast.makeText(this,"Please add camera data",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent=new Intent(this,FullViewPlayerActivity.class);
        startActivity(intent);
    }
    public void onClickBtn1x2(View view)
    {
        if(CameraData.getData().isEmpty())
        {
            Toast.makeText(this,"Please add camera data",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent=new Intent(this,GridPlayerActivity.class);
        intent.putExtra("col","1");
        startActivity(intent);
    }
    public void onClickBtn2x2(View view)
    {
        if(CameraData.getData().isEmpty())
        {
            Toast.makeText(this,"Please add camera data",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent=new Intent(this,GridPlayerActivity.class);
        intent.putExtra("col","2");
        startActivity(intent);
    }
    public void onClickBtn3x2(View view)
    {
        if(CameraData.getData().isEmpty())
        {
            Toast.makeText(this,"Please add camera data",Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent=new Intent(this,GridPlayerActivity.class);
        intent.putExtra("col","3");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.video, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.exit) {
            AppActionHandler.Exit(VideoConfigurationActivity.this);
            return true;
        }
        if (id==R.id.addCamera) {
            CameraDialog.Show(VideoConfigurationActivity.this,
                  new CameraDialog.ResultListener(){
                      @Override
                      public void onResult() {
                          recyclerVideoAdapter.notifyDataSetChanged();
                      }
                  }
            );
            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AppActionHandler.Exit(VideoConfigurationActivity.this);
        super.onBackPressed();
    }
}
