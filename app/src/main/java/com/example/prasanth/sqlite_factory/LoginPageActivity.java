package com.example.prasanth.sqlite_factory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginPageActivity extends Activity{

    private Button register,findAge;
    private EditText frstName,lstName;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);
        register=(Button)findViewById(R.id.register);
        findAge=(Button)findViewById(R.id.ageFind);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginPageActivity.this,RegisterPageActivity.class);
                startActivity(intent);
            }
        });
        findAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fstName,lastName;
                frstName=(EditText)findViewById(R.id.firstName);
                lstName=(EditText)findViewById(R.id.LastName);
                fstName=frstName.getText().toString();
                lastName=lstName.getText().toString();
                SqlData sqlData=new SqlData(LoginPageActivity.this);
                String age= sqlData.searchingData(fstName,lastName);
                if(age==null) {
                    Toast.makeText(LoginPageActivity.this, "DATA NOT FOUND.PLEASE REGISTER", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(LoginPageActivity.this,"YOUR NICKNAME IS "+age,Toast.LENGTH_LONG).show();
            }
        });
    }

}
