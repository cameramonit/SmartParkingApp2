package com.example.smartparkingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    EditText L_plate, mno;
    Button submit, status;
    FirebaseDatabase inf;
    DatabaseReference myRef;
    //TextView sub_con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L_plate = findViewById(R.id.editTextTextPersonName);
        mno = findViewById(R.id.editTextPhone);
        //sub_con=findViewById(R.id.submit_result);
        submit = findViewById(R.id.button);
        status = findViewById(R.id.logoutb);
        inf = FirebaseDatabase.getInstance();
        myRef = inf.getReference("Users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Saveuserfbd sfbd = new Saveuserfbd(L_plate.getText().toString(), mno.getText().toString());
               // myRef.child(L_plate.getText().toString()).setValue(sfbd);
                myRef.child(L_plate.getText().toString()).child("Mobile number:").setValue(mno.getText().toString());
                myRef.child(L_plate.getText().toString()).child("Plate:").setValue(L_plate.getText().toString());
                //sub_con.setText("SUBMITTED!, click status for more");
                submit.setText("Submitted");
                submit.setBackgroundColor(getResources().getColor(R.color.green));

            }

        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("plate", L_plate.getText().toString());
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            if(resultCode==RESULT_OK){
                TextView log=findViewById(R.id.textView);
                log.setText("LOGGED OUT!");
            }
        }

    }
}