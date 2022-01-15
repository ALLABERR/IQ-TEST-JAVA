package com.allaber.iq;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.allaber.iq.navigator.NavigatorActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.startActivity(getIntentActivity());
        this.finishAffinity();
    }

    private Intent getIntentActivity() {
        return new Intent(this, NavigatorActivity.class);
    }
}