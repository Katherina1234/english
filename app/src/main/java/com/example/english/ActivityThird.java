package com.example.english;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityThird extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_third);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("Hello").toString();
        TextView textView = (TextView) findViewById(R.id.txt6);
        textView.setText("Hello -"+name );
    }
    public void onMove(View view) {
        Intent intent = new Intent(ActivityThird.this, MainActivity.class);
        startActivity(intent);
    }
}