package com.example.james4;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class register extends AppCompatActivity    {

    String[] counties_list = { "select", "Mombasa", "Kwale", "Kilifi", "Tana River", "Lamu", "Taita Taveta", "Garisa", "Wajir", "Mandera","Marsabit", "Isiolo",
    "Meru", "Tharaka Nithi", "Embu", "Kitui"};
    String[] farmers_buyers_options={"select","Farmer", "Buyer", "Both (Farmer & Buyer)"};
private TextInputLayout email;
private Spinner counties_names, farmers_buyers;
private TextView counties, farmers_buyers_text_view;
    private TextInputLayout pwd;
    private TextInputLayout input_names,phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //make fully Android Status bar green
        if (Build.VERSION.SDK_INT >= 21) {
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));

            //setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            // getWindow().setStatusBarColor(R.getColor(0x01060015));
        }

        input_names=findViewById(R.id.text_input_names);
        phone_number=findViewById(R.id.text_input_phone_number);
        counties=findViewById(R.id.textview_counties);

        email=findViewById(R.id.text_email);
        pwd=findViewById(R.id.text_input_password);
        counties_names=findViewById(R.id.spinner_counties);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, counties_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        counties_names.setAdapter(adapter);

        farmers_buyers_text_view=findViewById(R.id.text_view_farmer_buyer);
        farmers_buyers=findViewById(R.id.spinner_farmer_buyer);

        ArrayAdapter<String> farm_buyer = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, farmers_buyers_options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        farmers_buyers.setAdapter(farm_buyer);

        /*counties_names.setOnItemSelectedListener(this);


    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), "Selected User: "+users[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        //
    }
}*/

    }
    private boolean validateEmail(){
        String str= email.getEditText().getText().toString().trim();

        if (str.isEmpty()){
            email.setError("This field cant be empty");
            return false;


        }else {
          email.setError(null);
          return true;
        }

    }
   /*
private boolean validateUsername() {
String strusername=textusername.getEditText().getText().toString().trim();
if(strusername.isEmpty()){
    textusername.setError("Field cant be Empty");
    return false;}
else if (strusername.length()> 15){
    textusername.setError("Username too long");
    return false;

}else {
    textusername.setError(null);
    return true;


}
}*/

    private boolean validatePassword(){
        String strpw= pwd.getEditText().getText().toString().trim();

        if (strpw.isEmpty()){
            pwd.setError("This field cant be empty");
            return false;


        }else {
            pwd.setError(null);
            return true;
        }

    }

    public void confirmInput(View v){

        if(!validateEmail() | ! validatePassword()){

return;

                }
        else {
            launchHome();

        }

        }

        private void launchHome() {

            Intent intent = new Intent(register.this,com.example.james4.home.class);
            startActivity(intent);
        }
    }


       /* String input="Email:" +email.getEditText().getText().toString();
        input+="\n";

        input +="Password:" +pwd.getEditText().getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_LONG).show();


*/





