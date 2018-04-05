package com.example.sam.votingsystem;

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

public class Main2Activity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText username,password;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        db = openOrCreateDatabase("VoterDB", Context.MODE_PRIVATE, null);

//        db = openOrCreateDatabase("VoterDB", Context.MODE_PRIVATE, null);
//
//
//        Cursor c=db.rawQuery("SELECT * FROM voter WHERE username='"+username.getText().toString()+"'", null);
//        username.setText(c.getString(0));
//        password.setText(c.getString(1));



        b1=(Button) findViewById(R.id.b1);

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {







        Cursor c = db.rawQuery("SELECT * FROM voter WHERE username='" +username.getText().toString()+"'", null);
        if (c.moveToFirst()) {

            String usrname=c.getString(1);
            String pass=c.getString(2);


            if(username.getText().toString().equals(usrname)&&password.getText().toString().equals(pass))
            {
                        Intent i = new Intent(Main2Activity.this, Caste.class);
        startActivity(i);
            }else
            {
                showMessage("Oops", "Username and password doesn't matches");
            }

        } else {
            showMessage("Error", "Invalid Rollno");
           username.setText("");
           password.setText("");
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
