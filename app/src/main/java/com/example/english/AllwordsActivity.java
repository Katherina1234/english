package com.example.english;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.Models.Word;
import com.example.english.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AllwordsActivity extends AppCompatActivity {
    FirebaseDatabase db;
   DatabaseReference words;
    EditText mul;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allwords);
        mul=findViewById(R.id.mul);
       db= FirebaseDatabase.getInstance();
       words=db.getReference("Words");
        words.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               // Word value =(Word) dataSnapshot.getValue();
               // mul.append(value.getEng());
               // Log.d(TAG, "Value is: " + value.getEng());
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }
        }
