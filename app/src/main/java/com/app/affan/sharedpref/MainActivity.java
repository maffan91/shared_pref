package com.app.affan.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    TextView dName;
    TextView dEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.edit_name);
        email = (EditText) findViewById(R.id.edit_email);


    }

    public void saveData(View view){

        SharedPreferences sharedPref = getSharedPreferences("com.app.sharedpref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username",name.getText().toString());
        editor.putString("email",email.getText().toString());
        Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show();
        editor.apply();
    }

    public void showData(View view){

        SharedPreferences sharedPref = getSharedPreferences("com.app.sharedpref", Context.MODE_PRIVATE);

        dName = (TextView) findViewById(R.id.disp_name);
        dEmail = (TextView) findViewById(R.id.disp_email);
        dName.setText(sharedPref.getString("username","null"));
        dEmail.setText(sharedPref.getString("email","null"));

    }
}
