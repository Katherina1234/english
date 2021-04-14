package com.example.english;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.english.Models.Word;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;


public class ActivitySecond extends Activity {
    TextView textView ;
    EditText edittext;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.txt2);
        edittext = (EditText) findViewById(R.id.editText);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Words").child("1");
        ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
String word=dataSnapshot.child("eng").getValue().toString();
                        String translate=dataSnapshot.child("ukr").getValue().toString();
                        textView.setText(word);
                        edittext.setText(translate);}

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }
    public void moveToResults(View view) {
        Intent intent = new Intent(ActivitySecond.this, ActivityThird.class);

        intent.putExtra(textView.getText().toString(), edittext.getText().toString());


        startActivity(intent);
    }
    public void moveToNext(View view) {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Words");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                count=Integer.parseInt(String.valueOf(dataSnapshot.getChildrenCount()));
                int min = 1;
                int max = count;
                int diff = max - min;
                Random random = new Random();
                int i = random.nextInt(diff + 1);
                i += min;
                DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference().child("Words").child(String.valueOf(i));
                ref1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String word=dataSnapshot.child("eng").getValue().toString();
                        String translate=dataSnapshot.child("ukr").getValue().toString();
                        textView.setText(word);
                        edittext.setText(translate);}

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
       });

    }
}