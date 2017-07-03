package com.example.fj.navigitiondemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fj.navigitiondemo.R;

/**
 * Created by 860617010 on 2017/7/3.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {


    public static HomeFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("name",str);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        Bundle arguments = getArguments();
        textView.setText(arguments.getString("name"));
        Log.i(TAG, "onCreateView: "+ arguments.getString("name"));
        textView.setOnClickListener(this);

        return view;
    }

    private static final String TAG = "HomeFragment";

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(),"点击了文字",Toast.LENGTH_SHORT).show();
    }
}
