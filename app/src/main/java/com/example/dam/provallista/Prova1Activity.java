package com.example.dam.provallista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Prova1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova1);
        ListView llista1 = (ListView) findViewById(R.id.llista1);
        String[] linies = new String[]{
          "Hola", "pepsicola", "caracola", "carambola",
          "Hola", "pepsicola", "caracola", "carambola",
          "Hola", "pepsicola", "caracola", "carambola",
          "Hola", "pepsicola", "caracola", "carambola",
          "Hola", "pepsicola", "caracola", "carambola",
          "Hola", "pepsicola", "caracola", "carambola",
          "Hola", "pepsicola", "caracola", "carambola"
        };
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, linies);
        llista1.setAdapter(adapter);
        llista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Prova1Activity.this, "Click en " + position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
