package com.example.user.siba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.sql.Struct;
import java.util.ArrayList;

public class FireActivity extends AppCompatActivity implements View.OnClickListener {
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
        final DatabaseReference myRef = database.getReference().child("Name");

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPro = (TextView) findViewById(R.id.tvPro);
        btSave = (Button) findViewById(R.id.btSave);
        lvUsers = (ListView) findViewById(R.id.lvUsers);
        users = new ArrayList<String>();
        ArrayAdapter adapter;
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,users);
        lvUsers.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tvEmail.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
