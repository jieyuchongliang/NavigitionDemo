package com.example.fj.navigitiondemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fj.navigitiondemo.R;

/**
 * Created by 860617010 on 2017/7/3.
 */

public class DiscoverFragment extends Fragment {
    public static DiscoverFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name",name);
        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discorver_fragment,container,false);
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText(getArguments().getString("name"));
        return view;
    }
}
