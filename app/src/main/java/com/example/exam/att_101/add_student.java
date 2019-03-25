package com.example.exam.att_101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class add_student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
    }

    public void register(View view){
        EditText n1 = (EditText)findViewById(R.id.editText6);
        String  name = n1.getText().toString();

        EditText r1 = (EditText)findViewById(R.id.editText7);
        Integer roll = Integer.parseInt(r1.getText().toString());

        EditText d1 = (EditText)findViewById(R.id.editText8);
        String  dept = d1.getText().toString();

        Intent myIntent = new Intent(this, teacher.class);
        this.startActivity(myIntent);

    }
}
