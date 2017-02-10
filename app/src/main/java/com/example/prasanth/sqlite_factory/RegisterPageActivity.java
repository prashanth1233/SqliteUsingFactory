package com.example.prasanth.sqlite_factory;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPageActivity extends Activity {
    private Button sndData;
    private EditText first_Name,last_Name,age1;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        sndData=(Button)findViewById(R.id.button1);
        sndData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                first_Name=(EditText)findViewById(R.id.name1);
                last_Name=(EditText)findViewById(R.id.name2);
                age1=(EditText)findViewById(R.id.age);
                Model_Factory model_factory=Factory_pattern.getObjectRef("model");
                model_factory.setFirstName(first_Name.getText().toString());
                model_factory.setLastName(last_Name.getText().toString());
                model_factory.setNickName(age1.getText().toString());
                SqlData sqlData=new SqlData(RegisterPageActivity.this);
                long checking= sqlData.insertData(model_factory);
                if(checking==-1)
                    Toast.makeText(RegisterPageActivity.this, "REGISTRATION FAILED", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(RegisterPageActivity.this," DATA SUCSSFULLY INSERTED",Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegisterPageActivity.this, "SUCCESSFULLY REGISTERED", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterPageActivity.this,LoginPageActivity.class);
                    startActivity(intent);
                }

            }
        });
    }


}
