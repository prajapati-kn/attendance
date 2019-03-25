package com.example.exam.att_101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class student_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        TextView t1 = (TextView)findViewById(R.id.textView);

      TextView v1 = (TextView)findViewById(R.id.textView);
        v1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(student_info.this, "name of the student",Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
