package com.lhy.zhulongsociety_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lhy.base.BaseMvpActivity;
import com.lhy.frams.ICommonModel;
import com.lhy.model.CommonModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity {


    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.texts)
    TextView texts;
    int content = 5;
    boolean bool = true;
    @BindView(R.id.image2)
    ImageView image2;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            int arr[] = {1, 2, 3, 4, 5};
            texts.setText("跳过" + arr[content]);
            if (content == 2) {
                image1.setImageResource(R.drawable.zhulong5);
                ViewGroup.LayoutParams layoutParams = image1.getLayoutParams();
                layoutParams.height=1680;
                layoutParams.width= GridLayout.LayoutParams.MATCH_PARENT;
                image1.setLayoutParams(layoutParams);
                image2.setVisibility(View.VISIBLE);
            }
            if (content == 0) {
                if (bool) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
            return false;
        }
    });

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (content > 0) {
                    try {
                        Thread.sleep(1000);
                        handler.sendEmptyMessage(0);
                        content--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        texts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                bool = false;
            }
        });
    }

    @Override
    protected ICommonModel getModel() {
        return new CommonModel();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void getSuccess(int which, int loadType, Object[] pD) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
