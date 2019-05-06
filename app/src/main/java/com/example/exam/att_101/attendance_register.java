package com.example.exam.att_101;

import android.content.Intent;
import android.database.Cursor;
import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class attendance_register extends AppCompatActivity {
    DatabaseHelper myDb;
    CheckBox checkBox,ch ;
    LinearLayout linearLayout;
    View view2;
    int ids[]=new int[100];
    int numRows=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_register);
        myDb = new DatabaseHelper(this);
        TextView name = (TextView)findViewById(R.id.name);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            // show message
            // showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            checkBox = new CheckBox(this);
            checkBox.setText(res.getString(1));
            checkBox.setTag(res.getString(0));
            checkBox.setId(Integer.parseInt(res.getString(0)));
            linearLayout.addView(checkBox);

            numRows++;
        }

        // Show all data
        //showMessage("Data",buffer.toString());



    }
    public void submitAtt(View view) {
        Cursor res = myDb.getAllData();
        int idIndex = res.getColumnIndex("ID");
        for (int i=0,m=0;i<numRows;i++) {
            view2 = (View) view.getParent().getParent();
            ch = (CheckBox) view2.findViewWithTag(res.getString(0));

            if (ch.isChecked()) {

                ids[m] =ch.getId();
    System.out.println("ch id :"+ids[m]);
                m++;


            }
            res.moveToNext();
        }


        myDb.update(ids,numRows);


    }
   /* public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/

}
