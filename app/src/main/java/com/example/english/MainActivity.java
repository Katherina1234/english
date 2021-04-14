package com.example.english;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.action_settings :
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.open_settings:
                Intent intent2 = new Intent(MainActivity.this, AllwordsActivity.class);
                startActivity(intent2);
                return true;
            case R.id.save_settings:
                Intent intent1 = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent1);
                return true;
            case R.id.change_color:
                ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.lay);
                bgElement.setBackgroundColor(Color.WHITE);
                return true;


        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }
}