package com.example.sam.votingsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Caste extends AppCompatActivity {

    EditText partyname,candidatename;
    SQLiteDatabase db;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caste);

        partyname = (EditText) findViewById(R.id.editText);
        candidatename = (EditText) findViewById(R.id.editText2);

        db = openOrCreateDatabase("VoterDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS voter(name VARCHAR,username VARCHAR,password VARCHAR,voterid VARCHAR);");



    }
}
