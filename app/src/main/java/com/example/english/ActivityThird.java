package com.example.english;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityThird extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);
    }
    public void onMove(View view) {
        Intent intent = new Intent(ActivityThird.this, MainActivity.class);
        startActivity(intent);
    }
}