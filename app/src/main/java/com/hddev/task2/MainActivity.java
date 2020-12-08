package com.hddev.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.hddev.task2.adapter.RecyclerAdapter;
import com.hddev.task2.model.Customer;
import com.hddev.task2.model.Item;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.hddev.task2.util.Constants.ARRAY_STRING;
import static com.hddev.task2.util.Constants.CATEGORY_STRING;
import static com.hddev.task2.util.Constants.NAME_STRING;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private Spinner categorySpinner;
    private Button addButton;
    private Button saveButton;
    private ArrayList<Item> items;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    private Customer customer;
    private String []categories= new String[]{"break fast", "lunch", "dinner"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.name_edit_text);
        categorySpinner = findViewById(R.id.drop_down);
        recyclerView = findViewById(R.id.recycler_view);
        items = new ArrayList<>();
        customer = new Customer();
        customer.setmItems(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, items);
        recyclerView.setAdapter(adapter);
        addButton = findViewById(R.id.add_button);
        saveButton = findViewById(R.id.save_button);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this
                                                , android.R.layout.simple_spinner_dropdown_item, categories);
        categorySpinner.setAdapter(spinnerAdapter);
        setListener();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(new Item());
                //
                adapter.notifyItemInserted(items.size());
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEverThing();
            }
        });
    }

    private void saveEverThing() {
        adapter.notifyDataSetChanged();
        customer.setName(nameET.getText().toString());
        adapter.notifyDataSetChanged();
        customer.setmItems(adapter.getItemList());
        updateUI(customer);
    }

    private void updateUI(Customer customer) {
        Intent intent = new Intent(this, savedActivity.class);
        intent.putExtra(NAME_STRING, customer.getName());
        intent.putExtra(CATEGORY_STRING, customer.getCategory());
        intent.putParcelableArrayListExtra(ARRAY_STRING, items);
        startActivity(intent);
    }


    private void setListener() {
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                customer.setCategory(categories[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}