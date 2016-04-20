package com.mpewpazi.android.awaljunisidang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private static final String EXTRA_ID_USER="usr";

    private Button mPeriButton;
    private Button mMpewpaziButton;

    private String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mPeriButton=(Button)findViewById(R.id.user_perinurpazri_btn);
        mMpewpaziButton=(Button)findViewById(R.id.user_mpewpazi_btn);

        mPeriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserId="perinurpazri";
                Intent intent=new Intent(LoginActivity.this,HomePageActivity.class);
                intent.putExtra(EXTRA_ID_USER,mUserId);
                startActivity(intent);
            }
        });

        mMpewpaziButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserId="mpewpazi";
                Intent intent=new Intent(LoginActivity.this,HomePageActivity.class);
                intent.putExtra(EXTRA_ID_USER,mUserId);
                startActivity(intent);
            }
        });
    }
}
