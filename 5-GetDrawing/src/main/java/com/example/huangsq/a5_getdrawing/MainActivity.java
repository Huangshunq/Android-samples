package com.example.huangsq.a5_getdrawing;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huangsq.a5_getdrawing.util.DateUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private TextView tv_capture;
    private ImageView iv_capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_capture = (TextView)findViewById(R.id.tv_capture);
        iv_capture = (ImageView)findViewById(R.id.iv_capture);
        tv_capture.setDrawingCacheEnabled(true);
        findViewById(R.id.btn_chat).setOnClickListener(this);
        findViewById(R.id.btn_chat).setOnLongClickListener(this);
        findViewById(R.id.btn_capture).setOnClickListener(this);

        tv_capture.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        tv_capture.setLines(20);
        tv_capture.setMaxLines(20);
        tv_capture.setMovementMethod(new ScrollingMovementMethod());
    }

    private String[] mChatStr = { "你吃饭了吗？", "今天天气真好",
            "今晚吃什么好？", "我们去看电影吧", "晚上干什么好？"};

    @Override
    public boolean onLongClick(View v){
        if(v.getId() == R.id.btn_chat){
            tv_capture.setText("");
        }
        return true;
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btn_chat){
            int random = (int)(Math.random() * 10) % 5;
            String newStr = String.format("%s\n%s %s",
                    tv_capture.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
            tv_capture.setText(newStr);
        }else if (v.getId() == R.id.btn_capture){
            Bitmap bitmap = tv_capture.getDrawingCache();
            iv_capture.setImageBitmap(bitmap);

            mHandler.postDelayed(mResetCache, 200);
        }
    }

    private Handler mHandler = new Handler();
    private Runnable mResetCache = new Runnable(){
        @Override
        public void run (){
            tv_capture.setDrawingCacheEnabled(false);
            tv_capture.setDrawingCacheEnabled(true);
        }
    };
}
