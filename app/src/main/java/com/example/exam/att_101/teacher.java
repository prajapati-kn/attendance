package com.example.exam.att_101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class teacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }
    public void addStudent(View view) {
        Intent myIntent = new Intent(this, add_student.class);
        this.startActivity(myIntent);
    }
    public void viewStudent(View view) {
        Intent myIntent = new Intent(this, student_info.class);
        this.startActivity(myIntent);
    }
}
