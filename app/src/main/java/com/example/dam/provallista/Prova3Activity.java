package com.example.dam.provallista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prova3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova2);
        ListView llista2 = (ListView) findViewById(R.id.llista2);

        List<Map<String, String>> dades = new ArrayList<>();
        Map<String, String> producte1 = new HashMap<>();
        Map<String, String> producte2 = new HashMap<>();
        producte1.put("Producte", "Disc SSD");
        producte1.put("Stock", "Disponible en stock");
        producte1.put("Preu", "49€");
        dades.add(producte1);
        producte2.put("Producte", "Monitor 21");
        producte2.put("Stock", "No disponible fins el 20/12/2016");
        producte2.put("Preu", "100€");
        dades.add(producte2);

        SimpleAdapter adapter = new SimpleAdapter(
                Prova3Activity.this, dades,
                R.layout.llista3_item,
                new String[] {"Producte","Preu", "Stock"},
                new int[] { R.id.nom, R.id.preu, R.id.stock }
        );
        llista2.setAdapter(adapter);
    }
}
