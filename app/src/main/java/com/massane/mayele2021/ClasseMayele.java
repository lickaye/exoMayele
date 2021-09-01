package com.massane.mayele2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ClasseMayele extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe_mayele);

        textView = findViewById(R.id.content);

        Intent intent = getIntent();
        String content = intent.getStringExtra("cycle");
        //textView.setText(content);
        Log.d("MesClasse",content);
    }
}