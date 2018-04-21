package com.alatheer.refaaq.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alatheer.refaaq.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login,register;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intentView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
           type = intent.getStringExtra("type");
        }
    }

    private void intentView() {
        login=findViewById(R.id.btn_signin);
        register=findViewById(R.id.btn_signup);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {

            case R.id.btn_signin:
                if (type.equals("donor"))
                {
                    Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else if (type.equals("sponsor"))
                {
                    Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent1);
                    finish();

                }if (type.equals("poor"))
                {
                Intent intent1=new Intent(LoginActivity.this,Family_Activity.class);
                startActivity(intent1);
                finish();
                }if (type.equals("family"))


                {
                Intent intent1=new Intent(LoginActivity.this,Family_Activity.class);
                startActivity(intent1);
                finish();
                }


                break;
            case R.id.btn_signup:
                if (type.equals("donor"))
                {
                    Intent intent1=new Intent(LoginActivity.this,RegisterDonerActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else if (type.equals("sponsor"))
                {
                    Intent intent1=new Intent(LoginActivity.this,RegisterKafeelActivity.class);
                    startActivity(intent1);
                    finish();
                }if (type.equals("poor"))

                {
                    Intent intent1=new Intent(LoginActivity.this,RegisterPoorActivity.class);
                    startActivity(intent1);
                    finish();
                }if (type.equals("family"))

                {
                    Intent intent1=new Intent(LoginActivity.this,RegisterFamilyActivity.class);
                    startActivity(intent1);
                    finish();
                }


                break;
        }

    }
}
