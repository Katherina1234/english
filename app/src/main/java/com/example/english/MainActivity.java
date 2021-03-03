package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        TextView textView = (TextView) findViewById(R.id.txt1);
        textView.setText("Дрищ К.В. ІПЗс-19-1 Інженерія програмного забезпечення" );
    }
    public void onMove(View view) {
        Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}