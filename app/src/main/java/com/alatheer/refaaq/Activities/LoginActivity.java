package com.alatheer.refaaq.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alatheer.refaaq.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intentView();
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
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_signup:
                Intent intent1=new Intent(LoginActivity.this,ChooserActivity.class);
                startActivity(intent1);

                break;
        }

    }
}
