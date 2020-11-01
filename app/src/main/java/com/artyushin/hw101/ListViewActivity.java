package com.artyushin.hw101;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListViewActivity extends AppCompatActivity {

    private ListView list;
    private List<Map<String, String>> content;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = findViewById(R.id.list);
        content = new ArrayList<>();

        content = prepareContent();

        String[] from = new String[]{"Header", "Length"};
        int[] to = new int[]{R.id.textHeader, R.id.textContent};
        adapter = new SimpleAdapter(this, content, R.layout.list_item, from, to);

        list.setAdapter(adapter);
    }

    @NonNull
    private ArrayList<Map<String, String>> prepareContent() {
        ArrayList<Map<String, String>> data;
        data = new ArrayList<>();
        String[] arrayContent = getString(R.string.large_text).split("\n\n");

        for(int i = 0; i < arrayContent.length; i++) {
            Map<String, String> RowMap = new HashMap<>();
            RowMap.put("Header", arrayContent[i]);
            RowMap.put("Length", String.valueOf(arrayContent[i].length()));
            data.add(i, RowMap);
        }

        return data;
    }

}