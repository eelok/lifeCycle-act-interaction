package com.eelok.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.eelok.lifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;
    private final int REQUEST_CODE_MAIN = 2;

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
                    startActivityForResult(intent, REQUEST_CODE_MAIN);
//                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Enter a word", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MAIN){
            assert data != null;
            String message = data.getStringExtra("message_back");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
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