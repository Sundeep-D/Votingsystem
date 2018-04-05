package com.example.sam.votingsystem;

import android.accessibilityservice.GestureDescription;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import  android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.jar.Attributes;

public class Register extends AppCompatActivity {
    EditText name, username, password, voterid;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.editText);
        username = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.ed5);
        voterid = (EditText) findViewById(R.id.editText4);


        db = openOrCreateDatabase("VoterDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS voter(name VARCHAR,username VARCHAR,password VARCHAR,voterid VARCHAR);");

        Button b4;
        b4 = (Button) findViewById(R.id.b4);


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Checking for empty fields

                try {
                    if (name.getText().toString().trim().length() == 0 ||
                            username.getText().toString().trim().length() == 0 ||
                            voterid.getText().toString().trim().length() == 0 ||
                            password.getText().toString().trim().length() == 0) {

                        //showMessage("Error", "Please enter all values");
                        return;
                    }
                    db.execSQL("INSERT INTO voter VALUES('" + name.getText() + "','" + username.getText() +
                            "','" + password.getText() + "','" + voterid.getText() + "');");

                    Context context = getApplicationContext();
                    CharSequence text = "Registered successfully!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(Register.this,"data saved successfully",Toast.LENGTH_LONG).show();

                    Intent i =new Intent(Register.this,Main2Activity.class);
                    startActivity(i);

//                    Cursor c = db.rawQuery("SELECT * FROM voter", null);
//                    if (c.getCount() == 0) {
//                        showMessage("Error", "No records found");
//                        return;
//                    }
//                    StringBuffer buffer = new StringBuffer();
//                    while (c.moveToNext()) {
//                        buffer.append("NAME: " + c.getString(0) + "\n");
//                        buffer.append("USER NAME: " + c.getString(1) + "\n");
//                        buffer.append("PASSWORD: " + c.getString(2) + "\n\n");
//                    }
//
//                    showMessage("DETAILS", buffer.toString());
                }

                catch (Exception e)
                {
                    Toast.makeText(Register.this,"data failed to save",Toast.LENGTH_LONG).show();
                }

            }




        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

