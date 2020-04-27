package com.example.nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    DatabaseHelper users;
    Button cancel, register;
    EditText firstName, lastName, email, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button register = (Button) findViewById(R.id.register);
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        users = new DatabaseHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String First_Name = firstName.getText().toString();
                String Last_Name = lastName.getText().toString();
                String newEmail = email.getText().toString();
                String newPassword = password.getText().toString();
                if(First_Name.length() != 0 && Last_Name.length() != 0
                && newEmail.length() != 0 && newPassword.length() != 0 ){
                    AddData(newEmail, newPassword, First_Name, Last_Name);

                    Intent intent = new Intent(Register.this, launch.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Register.this, "Invalid Entry", Toast.LENGTH_SHORT);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, launch.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, launch.class);
                startActivity(intent);
            }
        });



    }
    public void AddData(String email, String password, String firstName, String lastName) {

        boolean insertData = users.addData(email, password, firstName, lastName);

        if(insertData==true){
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show();
        }
    }




}
