package com.lhy.base;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void showLog(Object content){
        Log.e("哈哈哈", "showLog: "+content.toString() );
    }
    public void showToast(Object content){
        Toast.makeText(this, content.toString(), Toast.LENGTH_SHORT).show();
    }
}
