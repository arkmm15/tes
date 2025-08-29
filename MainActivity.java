package com.ul.store;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    EditText searchBox;
    Button searchBtn;
    ListView resultList;
    ArrayAdapter<String> adapter;
    ArrayList<String> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBox = findViewById(R.id.searchBox);
        searchBtn = findViewById(R.id.searchBtn);
        resultList = findViewById(R.id.resultList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results);
        resultList.setAdapter(adapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchBox.getText().toString();
                if (!query.isEmpty()) {
                    results.clear();
                    results.add("🔎 Hasil pencarian: " + query);
                    results.add("🎵 Lagu 1 - " + query);
                    results.add("🎶 Lagu 2 - " + query);
                    results.add("🎧 Lagu 3 - " + query);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}