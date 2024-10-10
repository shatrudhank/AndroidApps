package com.honeywell.dvm_media_player.video;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.honeywell.dvm_media_player.R;

public final class CameraDialog {

    public static class ResultListener {
        public void onResult() {}
    }
    public static void Show(Context context,ResultListener resultListener)
    {
       View view =LayoutInflater.from(context).inflate(R.layout.camera_dialog,null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.AlertDialogStyle);
        builder.setTitle(R.string.add_camera);
        builder.setView(view);


        builder .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                TextInputEditText nameTi=view.findViewById(R.id.camera_name);
                TextInputEditText urlTi=view.findViewById(R.id.camera_url);

                String cameraName=nameTi.getEditableText().toString();
                String cameraUrl=urlTi.getEditableText().toString();

                CameraData.add(cameraName,cameraUrl);

                Toast.makeText(context,R.string.msg_new_video,Toast.LENGTH_LONG).show();
                resultListener.onResult();
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancels the dialog.
                }
        });

        builder.show();

    }
}
