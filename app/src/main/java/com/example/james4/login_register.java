package com.example.james4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.support.v7.widget.Toolbar;



public class login_register extends AppCompatActivity {

    private Button login, button_reg;
    private TextInputLayout login_email;

    private TextInputLayout login_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));

            //setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
           // getWindow().setStatusBarColor(R.getColor(0x01060015));
        }

        //  Toolbar tool =findViewById(R.id.apptoolbar);
        //setSupportActionBar(tool);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
// Remove default title text
        //  getSupportActionBar().setDisplayShowTitleEnabled(false);


        login_email = findViewById(R.id.login_text_email);
        login_pwd = findViewById(R.id.login_text_input_password);
        login = findViewById(R.id.button_login);
        login.setTextColor(getResources().getColor(android.R.color.white));
        button_reg = findViewById(R.id.button_register);
        button_reg.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              if (view.getId() == R.id.button_register) {

                                                  Intent rgst = new Intent(login_register.this, register.class);
                                                  startActivity(rgst);

                                              }
                                          }

                                      });







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

        public void setSupportActionBar (Toolbar tool){


        }

        private boolean login_validateEmail () {
            String str = login_email.getEditText().getText().toString().trim();

            if (str.isEmpty()) {
                login_email.setError("This field cant be empty");
                return false;


            } else {
                login_email.setError(null);
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

        private boolean login_validatePassword () {
            String login_strpw = login_pwd.getEditText().getText().toString().trim();

            if (login_strpw.isEmpty()) {
                login_pwd.setError("This field cant be empty");
                return false;


            } else {
                login_pwd.setError(null);
                return true;
            }

        }

        public void buttonHome (View v){

            if (!login_validateEmail() | !login_validatePassword()) {

                return;

            } else {
                launchLogin();

            }

        }

        private void launchLogin () {

            Intent launchreg = new Intent(this, home.class);
            startActivity(launchreg);
        }




        public static void setWindowFlag (Activity activity,final int bits, boolean on){
            Window win = activity.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }

    }


       /* String input="Email:" +email.getEditText().getText().toString();
        input+="\n";

        input +="Password:" +pwd.getEditText().getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_LONG).show();


*/





