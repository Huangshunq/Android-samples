package com.example.huangsq.a1_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_hello = (TextView)findViewById(R.id.hello);

        tv_hello.setText("我的第一个安卓demo");

        tv_hello.setTextColor(android.graphics.Color.RED);

        tv_hello.setTextSize(30);
    }
}
