package com.example.english;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ActivitySecond extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
    }
    public void moveToResults(View view) {
        Intent intent = new Intent(ActivitySecond.this, ActivityThird.class);
        TextView textView = (TextView) findViewById(R.id.txt2);
        TextView edittext = (EditText) findViewById(R.id.editText);
        intent.putExtra(textView.getText().toString(), edittext.getText().toString());


        startActivity(intent);
    }
}