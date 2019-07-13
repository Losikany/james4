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

public class fragment_livestock extends Fragment  {
    private Button beef, dairy, poultry;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_livestock, container, false);


        beef = view.findViewById(R.id.button_beef);
        beef.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button_beef) {
                Intent fruit_window = new Intent(getActivity(), beef.class);
                startActivity(fruit_window);
            }
        }

    });

        dairy = view.findViewById(R.id.button_dairy);
        poultry=view.findViewById(R.id.button_poultry);
        return view;
    }
}

