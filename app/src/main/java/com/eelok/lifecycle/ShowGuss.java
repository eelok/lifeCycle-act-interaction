package com.eelok.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowGuss extends AppCompatActivity {

    private TextView received_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guss);

        Bundle extra = getIntent().getExtras();
        received_textview = findViewById(R.id.received_textview);

        if(extra != null){
            received_textview.setText(extra.getString("textFieldInput"));
            Log.d("Name", extra.getString("name"));
            Log.d("Age", "" + extra.getInt("age"));
        }


        received_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "FROM second Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


}