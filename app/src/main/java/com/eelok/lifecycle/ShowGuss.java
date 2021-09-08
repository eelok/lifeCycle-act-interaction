package com.eelok.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

//          first method to get something from mainActivity
//        if (getIntent().getStringExtra("textFieldInput") != null) {
//            received_textview.setText(getIntent().getStringExtra("textFieldInput"));
//        }

    }
}