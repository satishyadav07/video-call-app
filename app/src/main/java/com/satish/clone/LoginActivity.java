package com.satish.clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.hbb20.CountryCodePicker;

public class LoginActivity extends AppCompatActivity {


    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    Button sendOtpBtn;


    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        countryCodePicker=findViewById(R.id.login_countryCode);
        phoneInput=findViewById(R.id.login_mobile_number);
        sendOtpBtn=findViewById(R.id.sendOtpBtn);
        progressBar=findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);


        countryCodePicker.registerCarrierNumberEditText(phoneInput);
        sendOtpBtn.setOnClickListener(view -> {
            if(!countryCodePicker.isValidFullNumber()){
                phoneInput.setError("Phone number not valid");
                return;
            }

            Intent intent=new Intent(LoginActivity.this,LoginOtpActivity.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });
    }
}