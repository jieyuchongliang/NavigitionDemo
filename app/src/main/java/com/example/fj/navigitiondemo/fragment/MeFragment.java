package com.example.fj.navigitiondemo.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fj.navigitiondemo.R;
import com.example.fj.navigitiondemo.base.BaseFragment;

/**
 * Created by 860617010 on 2017/7/3.
 */

public class MeFragment extends BaseFragment {
    public static MeFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name",name);
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void fragmentView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText(getArguments().getString("name"));
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.me_fragment;
    }
}
