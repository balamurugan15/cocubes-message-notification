package com.balamurugan.cocubesmessagenotification;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button loginButton;
    TextView tv;
    Switch toggleSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginButton = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.newuser);
        toggleSwitch = (Switch) findViewById(R.id.switch1);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, WebViewActivity.class), Constants.REQUEST_CODE);
            }
        });

        SharedPreferences pref2 = getSharedPreferences(Constants.PREFERENCE_NAME, 0); // 0 - for private mode
        if(!pref2.contains(Constants.PREFERENCE_TAG)){
            toggleSwitch.setEnabled(false);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == Constants.REQUEST_CODE && resultCode == RESULT_OK) {

                Toast.makeText(MainActivity.this, "Logged in",Toast.LENGTH_LONG).show();
                toggleSwitch.setEnabled(true);
                tv.setVisibility(View.VISIBLE);

            }
    }


}
