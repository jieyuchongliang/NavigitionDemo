package com.example.fj.navigitiondemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 860617010 on 2017/7/3.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(fragmentLayout(),container,false);
        fragmentView(view);
        return view;
    }
    //fragment对应的layout文件
    protected abstract int fragmentLayout();

    //初始化之后获取的view
    protected abstract void fragmentView(View view);
}
