package com.example.james4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment_farmers extends Fragment  {
    private Button fruit, grain, vegetable;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farmers, container, false);


        grain = view.findViewById(R.id.button_grains);
        grain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button_grains) {
                    Intent fruit_window = new Intent(getActivity(), grains.class);
                    startActivity(fruit_window);
                }
            }

        });



        vegetable = view.findViewById(R.id.button_vegetables);
vegetable.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_vegetables) {
            Intent fruit_window = new Intent(getActivity(), vegetables.class);
            startActivity(fruit_window);
        }
    }
    });


        fruit = view.findViewById(R.id.button_fruits);

        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button_fruits) {
                    Intent fruit_window = new Intent(getActivity(), fruits.class);
                    startActivity(fruit_window);
            }
        }

    });
        return view;
    }
}

