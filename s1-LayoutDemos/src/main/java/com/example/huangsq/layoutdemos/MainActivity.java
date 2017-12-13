package com.example.huangsq.layoutdemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_linear = (Button) findViewById(R.id.btn_linear);
        Button btn_relative = (Button) findViewById(R.id.btn_relative);
        Button btn_frame = (Button) findViewById(R.id.btn_frame);
        Button btn_table = (Button) findViewById(R.id.btn_table);

        btn_linear.setOnClickListener(this);
        btn_relative.setOnClickListener(this);
        btn_frame.setOnClickListener(this);
        btn_table.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent();
//        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.btn_linear:
                intent.setClass(this, LinearLayoutActivity.class);
                break;
            case R.id.btn_relative:
                intent.setClass(this, RelativeLayoutActivity.class);
                break;
            case R.id.btn_frame:
                intent.setClass(this, FrameLayoutActivity.class);
                break;
            case R.id.btn_table:
                intent.setClass(this, TableLayoutActivity.class);
                break;
            default:
                Toast.makeText(this, "按钮触击监听器错误！", Toast.LENGTH_LONG ).show();
                return;
        }
        startActivity(intent);
    }
}
