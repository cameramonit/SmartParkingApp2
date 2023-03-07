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
    @Override
    /*
    *Method that executes when the app opens
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Identification of input boxes
        L_plate = findViewById(R.id.entered_plate);
        mno = findViewById(R.id.Phoneno);

        //Identification of buttons
        submit = findViewById(R.id.button);
        status = findViewById(R.id.status);

        //Firebase instance and referencing
        inf = FirebaseDatabase.getInstance();
        myRef = inf.getReference("Users");

        /*
         * Method that executes when "Submit" button is pressed
         */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting value into: "User"->L_plate(variable)->"Mobile number"->(value to be entered which is stored in 'mno')
                myRef.child(L_plate.getText().toString()).child("Mobile number").setValue(mno.getText().toString());

                //setting value into: "User"->L_plate(variable)->"Plate"->(value to be entered which is stored in 'L_plate')
                myRef.child(L_plate.getText().toString()).child("Plate").setValue(L_plate.getText().toString());

                submit.setText("Submitted");
                submit.setBackgroundColor(getResources().getColor(R.color.green));

            }
        });
        /*
         * Method that executes when "Status" button is pressed
         */
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent that sends the user to next activity(MainActivity2)
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("plate", L_plate.getText().toString());
                startActivityForResult(intent,0);
            }
        });
    }


    @Override
    /*
     * Method that checks value of result returned by "MainActivity2" after 'finish()' command is run
     */
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