package com.alatheer.refaaq.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alatheer.refaaq.R;

/**
 * Created by Emad on 2018-04-19.
 */

public class Parent_Info_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parent_info_fragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
    }
}
