package com.example.english;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ActivitySecond extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
    }
    public void moveToResults(View view) {
        Intent intent = new Intent(ActivitySecond.this, ActivityThird.class);
        startActivity(intent);
    }
}