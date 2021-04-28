package com.example.english;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (ImageButton) findViewById(R.id.imageButton);
    }

    public void onPopup(View view) {


                        PopupMenu popup_menu = new PopupMenu(MainActivity.this, view);

                        popup_menu.inflate(R.menu.popup);
        popup_menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                        @Override
                                                        public boolean onMenuItemClick(MenuItem item) {
                                                            switch (item.getItemId()) {
                                                                case R.id.item1:
                                                                   btn.callOnClick();
                                                                    return true;
                                                                case R.id.item2:
                                                                    LayoutInflater inflater = getLayoutInflater();
                                                                    View layout = inflater.inflate(R.layout.toast,
                                                                            (ViewGroup) findViewById(R.id.toast_layout_root));
                                                                    ImageView image = (ImageView) layout.findViewById(R.id.image);
                                                                    image.setImageResource(R.drawable.l1);
                                                                    TextView text = (TextView) layout.findViewById(R.id.text);
                                                                    text.setText("Toast із зображенням");
                                                                    Toast toast = new Toast(getApplicationContext());
                                                                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                                                    toast.setDuration(Toast.LENGTH_LONG);
                                                                    toast.setView(layout);
                                                                    toast.show();
                                                                    return true;
                                                                case R.id.item3:
                                                                    Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                                                                    startActivity(intent);
                                                                     return true;
                                                                default:
                                                                    return false;
                                                            }}});
                        popup_menu.show();
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