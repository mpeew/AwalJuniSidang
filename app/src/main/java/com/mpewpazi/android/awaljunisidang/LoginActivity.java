package com.mpewpazi.android.awaljunisidang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String EXTRA_ID_USER="usr";

    private Button mSignInButton;
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;


    private String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mUsernameEditText=(EditText)findViewById(R.id.login_username);
        mPasswordEditText=(EditText)findViewById(R.id.login_password);

        mSignInButton=(Button)findViewById(R.id.login_btn_signin);



        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserId=mUsernameEditText.getText().toString();
                if(mUserId.equals("perinurpazri")|| mUserId.equals("mpewpazi")){
                    Intent intent=new Intent(LoginActivity.this,HomePageActivity.class);
                    intent.putExtra(EXTRA_ID_USER,mUserId);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Salah",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
