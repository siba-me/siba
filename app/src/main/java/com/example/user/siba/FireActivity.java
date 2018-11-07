package com.example.user.siba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Map;

public class FireActivity extends AppCompatActivity  {
    EditText etEmail,etPass;
    TextView tvEmail,tvPro;
    Button btSave;
    ListView lvUsers;
    ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPro = (TextView) findViewById(R.id.tvPro);
        btSave = (Button) findViewById(R.id.btSave);
        lvUsers = (ListView) findViewById(R.id.lvUsers);
        users = new ArrayList<>();
        final ArrayAdapter adapter;
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,users);
        lvUsers.setAdapter(adapter);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                myRef.child("Name").setValue(email);
                myRef.child("Profession").setValue("student");
       //         myRef.child("Name").push().setValue(email);
            }
        });


    //listener
//        myRef.child("users").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Map<String,String> map = (Map<String, String>) dataSnapshot.getValue();
//                Log.v("E_VALUE","Data"+ dataSnapshot.getValue());
//                String name = map.get("name");
//                String profession = map.get("profession");
//                tvEmail.setText(name);
//                tvPro.setText(profession);
//                //String value = dataSnapshot.getValue(String.class);
//                // tvEmail.setText(value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//
//            }
//        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String name = dataSnapshot.getValue(String.class);
                users.add(name);
                adapter.notifyDataSetChanged();
                //refresh to the arrayList


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
