package com.hddev.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.hddev.task2.adapter.postAdapter;
import com.hddev.task2.model.Customer;
import com.hddev.task2.model.Item;

import java.util.List;

import static com.hddev.task2.util.Constants.ARRAY_STRING;
import static com.hddev.task2.util.Constants.CATEGORY_STRING;
import static com.hddev.task2.util.Constants.NAME_STRING;

public class savedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        Intent intent = getIntent();
        List<Item> items = intent.getParcelableArrayListExtra(ARRAY_STRING);
        TextView nameText = findViewById(R.id.textView);
        TextView category = findViewById(R.id.textView2);
        RecyclerView recyclerView = findViewById(R.id.post_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameText.setText(intent.getStringExtra(NAME_STRING));
        category.setText(intent.getStringExtra(CATEGORY_STRING));
        postAdapter adapter = new postAdapter(items);
        Log.d("TheBug", "onCreate:Activity "+items.get(0).getItem1());
        recyclerView.setAdapter(adapter);
    }
}