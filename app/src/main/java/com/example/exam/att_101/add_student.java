package com.example.exam.att_101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_student extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnAddData;
    EditText n1;
    EditText r1;
    EditText d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        myDb = new DatabaseHelper(this);

    }

    public void register(View view){
       n1 = (EditText)findViewById(R.id.editText6);
        String  name = n1.getText().toString();

         r1 = (EditText)findViewById(R.id.editText7);
        Integer roll = Integer.parseInt(r1.getText().toString());

         d1 = (EditText)findViewById(R.id.editText8);
        String  dept = d1.getText().toString();

        btnAddData = (Button)findViewById(R.id.button5);
        AddData();



    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(n1.getText().toString(),
                                r1.getText().toString(),
                                d1.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(add_student.this, "Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(add_student.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
