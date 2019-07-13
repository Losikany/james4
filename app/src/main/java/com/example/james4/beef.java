package com.example.james4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class beef extends AppCompatActivity {
private TextView cat,meat_type, text_number_kg,text_price;
private Spinner category;
private EditText kg_number,price_per_kg;
private RadioGroup radiogroup;
private Button select_image;
String [] select_type={"Meat","Breed","Skin","Wool"};
ImageView image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beef);

        cat=findViewById(R.id.text1_category);
        category=findViewById(R.id.spinner1_category);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, select_type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);
        category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = parent.getSelectedItemPosition();
                switch (position) {
                    case 0:
                    
                        meat_type = findViewById(R.id.text2_category);
                        radiogroup = findViewById(R.id.radioGroup);
                        text_number_kg = findViewById(R.id.text_kg_number);
                        kg_number = findViewById(R.id.edit_text_meat_size);
                        text_price = findViewById(R.id.text_price);
                        price_per_kg = findViewById(R.id.edit_text_price);
                        select_image = findViewById(R.id.button_photo);

                        break;



                }
            }

                public void onNothingSelected(AdapterView<?> parent)
                {
                    //

            }
        });


    }
}
