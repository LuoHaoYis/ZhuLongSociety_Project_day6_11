package com.lhy.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void showLog(Object content){
        Log.e("呜呜呜", "showLog: "+content.toString() );
    }
    public void showToast(Object content){
        Toast.makeText(getActivity(), content.toString(), Toast.LENGTH_SHORT).show();
    }
}
