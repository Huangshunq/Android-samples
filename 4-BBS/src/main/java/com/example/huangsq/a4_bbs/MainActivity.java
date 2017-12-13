package com.example.huangsq.a4_bbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.huangsq.a4_bbs.util.DateUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private TextView tv_bbs;
    private TextView tv_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_control = (TextView) findViewById(R.id.tv_control);
        tv_control.setOnClickListener(this);
        tv_control.setOnLongClickListener(this);

        tv_bbs = (TextView) findViewById(R.id.tv_bbs);
        tv_bbs.setOnClickListener(this);
        tv_bbs.setOnLongClickListener(this);

        tv_bbs.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        tv_bbs.setLines(8);
        tv_bbs.setMaxLines(8);
        tv_bbs.setMovementMethod(new ScrollingMovementMethod());
    }

    private String[] mChatStr = { "你吃饭了吗？", "今天天气不错哟。", "我中奖啦！",
                                    "我们去看电影吧！", "晚上吃什么好？" };

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.tv_control || v.getId() == R.id.tv_bbs){
            int random = (int)(Math.random() * 10) % 5;
            String newStr = String.format("%s\n%s %s",
                    tv_bbs.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
            tv_bbs.setText(newStr);
        }
    }

    @Override
    public boolean onLongClick(View v){
        if (v.getId() == R.id.tv_control || v.getId() == R.id.tv_bbs){
            tv_bbs.setText("");
        }
        return true;
    }
}
