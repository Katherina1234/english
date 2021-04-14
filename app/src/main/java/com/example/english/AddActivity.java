package com.example.english;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.english.Models.Word;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference words;
    Button addWord;
    EditText ukr;
    EditText eng;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
db= FirebaseDatabase.getInstance();
words=db.getReference("Words");
addWord=findViewById(R.id.AddWord);
        eng=findViewById(R.id.word);
        ukr=findViewById(R.id.translate);
count=1;
addWord.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(final View view) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Words");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            count=Integer.parseInt(String.valueOf(dataSnapshot.getChildrenCount()));
            Word word=new Word(ukr.getText().toString(), eng.getText().toString(), "all");
                words.child(String.valueOf(count+1)).setValue(word).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                          Snackbar.make(view, "Слово додано", Snackbar.LENGTH_SHORT).show();

                    }});
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
});
}}

