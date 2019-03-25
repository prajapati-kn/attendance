package com.example.exam.att_101;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText myedit = (EditText) findViewById(R.id.editText3);

        myedit.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myedit.setTextColor(Color.rgb(255,0,0));
                }
            }
        });

    }

    public void doOnClick(View view) {

        EditText e1 = (EditText) findViewById(R.id.editText3);
        String username = e1.getText().toString();
        EditText e2 = (EditText) findViewById(R.id.editText4);
        String pwd = e2.getText().toString();
        if (username.equals(pwd)) {
            Intent myIntent = new Intent(this, teacher.class);
            this.startActivity(myIntent);
        } else {
            Toast.makeText(this, "Username and password should be same",Toast.LENGTH_LONG).show();
        }

    }
}