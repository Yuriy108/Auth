package com.example.auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText editTextmessage;
    ImageView imageViewSent;
    MessageAdapter adapter;
    List messages;
    FirebaseFirestore db;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.recyclerMessage);
        editTextmessage = findViewById(R.id.editTextTextMultiLine);
        imageViewSent = findViewById(R.id.imageViewSent);
        messages = new ArrayList();
        adapter = new MessageAdapter(messages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        imageViewSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sent();
            }
        });
        db.collection("myMessage2").orderBy("data").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                messages=value.toObjects(Message.class);
                adapter.setMessageList(messages);

            }
        });
        if (mAuth!=null){
            Toast.makeText(this,"Logged",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"no logged",Toast.LENGTH_LONG).show();
        }

    }

    private void sent() {
        String textMessage = editTextmessage.getText().toString().trim();

        editTextmessage.setText("");
        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
        db.collection("myMessage2").add(new Message("Yura",textMessage,System.currentTimeMillis()));



    }
}