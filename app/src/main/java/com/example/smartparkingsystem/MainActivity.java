package com.example.smartparkingsystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText uname, mno;
    Button submit, status;
    FirebaseDatabase inf;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = findViewById(R.id.editTextTextPersonName);
        mno = findViewById(R.id.editTextPhone);
        submit = findViewById(R.id.button);
        status = findViewById(R.id.button2);
        inf = FirebaseDatabase.getInstance();
        myRef = inf.getReference("Users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Saveuserfbd sfbd = new Saveuserfbd(uname.getText().toString(), mno.getText().toString());
                myRef.child(uname.getText().toString()).setValue(sfbd);


            }

        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("plate", uname.getText().toString());
                startActivity(intent);
            }
        });
    }


}