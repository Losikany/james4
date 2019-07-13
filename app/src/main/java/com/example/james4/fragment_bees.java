package com.example.james4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment_bees extends Fragment  {
    private Button honey, tools;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bees, container, false);


        honey = view.findViewById(R.id.button_honey);
        tools = view.findViewById(R.id.button_bees_tools);

        return view;
    }
}

