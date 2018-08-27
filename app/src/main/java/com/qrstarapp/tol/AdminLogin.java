package com.qrstarapp.tol;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {


    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);




// Set SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("username", "Salar");
        editor.putString("password", "salar123");
        editor.apply();

// set UI

        final EditText username = (EditText) findViewById(R.id.editText1);
        final EditText password = (EditText) findViewById(R.id.editText2);

// get value from existing preference


        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // put value in preference on button click

                String name = "",pass = "";
                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//                String restoredText = prefs.getString("text", null);
//                if (restoredText != null) {
                    name = prefs.getString("username", "");//"No name defined" is the default value.
                    pass = prefs.getString("password", ""); //0 is the default value.
//                }

                String mName = username.getText().toString();
                String mPass = password.getText().toString();

                if (username != null && password != null && !mName.isEmpty() && !mPass.isEmpty()) {
                    if (!name.isEmpty() && name.equals(mName) && !pass.isEmpty() && pass.equals(mPass)){
                        Intent intent = new Intent(AdminLogin.this,Home.class);
                        intent.putExtra("pass","pass");
                        startActivity(intent);
                        Toast.makeText(AdminLogin.this, "pass", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(AdminLogin.this, "Please enter correct name && password", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(AdminLogin.this, "please enter User Name & Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
