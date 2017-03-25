package com.example.administrator.rcdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import divider.GrideMangerActivity;
import divider.LinearMangerActivity;
import divider.StickyActivity;
import spansize.SpanSizeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void linear(View v){
        startActivity(new Intent(this, LinearMangerActivity.class));
    }
     public void grid(View v){
        startActivity(new Intent(this, GrideMangerActivity.class));
    }
     public void sticky(View v){
        startActivity(new Intent(this, StickyActivity.class));
    }
    public void spanSize(View v){
        startActivity(new Intent(this, SpanSizeActivity.class));
    }


}
