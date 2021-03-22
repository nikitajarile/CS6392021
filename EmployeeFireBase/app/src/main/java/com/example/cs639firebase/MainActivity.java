package com.example.cs639firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    private EditText etFirstName;
    private EditText etLastName;
    private TextView tvEmployees;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.btnSubmit);
        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName =  (EditText)findViewById(R.id.etLastName);
        tvEmployees = (TextView) findViewById(R.id.tvEmployees);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Log.i("MAINACTIVITY",database.toString());
        DatabaseReference myRef = database.getReference("employees");

        //myRef.setValue("Hello, World!");


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                StringBuilder strEmployees = new StringBuilder();
                Employee emp;
                counter = 0;
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    emp = ds.getValue(Employee.class);
                    Log.i("MAINACTIVITY",counter+" - Firstname : "+emp.getFirstName()+" Lastname : "+emp.getLastName());
                    strEmployees.append("Employee No. = "+counter+"\n");
                    strEmployees.append(emp.toString());
                    strEmployees.append("\n");
                    strEmployees.append("\n");
                    counter = counter + 1;
                }

                tvEmployees.setText(strEmployees);
                Log.d("MAINACTIVITY", "Counter : " + counter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MAINACTIVITY", "Failed to read value.", error.toException());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();

                if(firstName != null && lastName != null){
                    Employee emp = new Employee(firstName,lastName);

                    myRef.child(String.valueOf(counter)).setValue(emp);
                    etFirstName.setText("");
                    etLastName.setText("");

                }
                else{
                    Log.i("MAINACTIVITY","First name and Last name is not entered!");
                }
            }
        });
    }
}