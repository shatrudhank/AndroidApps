package in.studolite.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView luckyNumberLbl=findViewById(R.id.luckyNumber);
        String luckyNum=generateRandom();
        Intent intent=getIntent();
        String userName=intent.getStringExtra("name");

        luckyNumberLbl.setText(luckyNum);

        Button btn=findViewById(R.id.btnShare);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareData( userName, luckyNum);
            }
        });

    }

    public  String generateRandom()
    {
        Random rd=new Random();
        return  String.valueOf(rd.nextInt(1000));
    }

    public void  ShareData(String userName,String luckyNumber)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,userName+" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"My luck number is "+luckyNumber);
        startActivity(Intent.createChooser(i,"Choose"));
    }
}