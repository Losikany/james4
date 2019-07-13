package com.example.james4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class livestock_produce extends AppCompatActivity {
private TextView nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestock_produce);
       nm=findViewById(R.id.hello);
    }
}
