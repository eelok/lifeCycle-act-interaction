package com.eelok.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eelok.lifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewBinding.buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = viewBinding.textField.getText().toString().trim();

                if(!userInput.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, ShowGuss.class);
                    intent.putExtra("textFieldInput", userInput);
                    intent.putExtra("name", "John Smith");
                    intent.putExtra("age", 30);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Enter a word", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Toast.makeText(MainActivity.this, "onStart() Called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//
//        Toast.makeText(MainActivity.this, "onPostResume() Called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        Toast.makeText(MainActivity.this, "onPause() Called", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        Toast.makeText(MainActivity.this, "onStop() Called", Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        Toast.makeText(MainActivity.this, "onDestroy() Called", Toast.LENGTH_SHORT).show();
//    }
}