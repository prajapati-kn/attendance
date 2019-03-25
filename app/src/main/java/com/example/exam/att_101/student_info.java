package com.example.exam.att_101;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class student_info extends AppCompatActivity {
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        myDb = new DatabaseHelper(this);
        TextView name = (TextView)findViewById(R.id.name);
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            // show message
           // showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("ROLL NO :"+ res.getString(2)+"\n");
            buffer.append("DEPT :"+ res.getString(3)+"\n\n");
            buffer.append("ATTENDANCE :"+ res.getString(4)+"\n\n");
           name.setText(buffer.toString());
        }

        // Show all data
        //showMessage("Data",buffer.toString());



    }

   /* public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/

}
