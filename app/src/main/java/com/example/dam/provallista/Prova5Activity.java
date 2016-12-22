package com.example.dam.provallista;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prova5Activity extends AppCompatActivity {

    public class Product {

        private long id;
        private String name;
        private float price;
        private boolean inStock;
        private int image;

        public Product(long id, String name, float price, boolean inStock, int image) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.inStock = inStock;
            this.image = image;
        }

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public float getPrice() {
            return price;
        }
        public void setPrice(float price) {
            this.price = price;
        }
        public boolean isInStock() {
            return inStock;
        }
        public void setInStock(boolean inStock) {
            this.inStock = inStock;
        }
        public int getImage() {
            return image;
        }
        public void setImage(int image) {
            this.image = image;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova5);
        ListView llista5 = (ListView) findViewById(R.id.llista5);

        List<Product> dades = new ArrayList<>();
        dades.add(new Product(1, "Disc SSD", 70.0f, true, R.drawable.ssd));
        dades.add(new Product(2, "Monitor 21", 179.99f, false, R.drawable.monitor));
        dades.add(new Product(3, "Arbre nadalenc", 19.99f, true, R.drawable.arbre));
        dades.add(new Product(4, "Barret xmas", 9.99f, true, R.drawable.barret));
        dades.add(new Product(5, "Campanetes", 9.99f, true, R.drawable.campanetes));
        dades.add(new Product(6, "Corona", 10.99f, true, R.drawable.corona));
        dades.add(new Product(7, "Santa Klaus", 99.99f, false, R.drawable.klaus));
        dades.add(new Product(8, "Paquet sorpresa", 12.99f, true, R.drawable.sorpresa));
        dades.add(new Product(9, "Tux nadalenc", 15.99f, true, R.drawable.tux));

        CatalogAdapter adapter = new CatalogAdapter(this,dades);
        llista5.setAdapter(adapter);
    }

    public class CatalogAdapter extends BaseAdapter{

        private Context context;
        private List<Product> catalog;

        public CatalogAdapter(Context context, List<Product> catalog) {
            this.context = context;
            this.catalog = catalog;
        }

        @Override
        public int getCount() {
            return catalog.size();
        }

        @Override
        public Object getItem(int position) {
            return catalog.get(position);
        }

        @Override
        public long getItemId(int position) {
            Product p = catalog.get(position);
            long id = p.getId();
            return id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(ContextThemeWrapper.LAYOUT_INFLATER_SERVICE);
            //View myView = inflater.inflate(R.layout.llista5_item, parent, false);
            //RECICLAT DE VISTES
            View myView = convertView;
            if (myView == null){
                myView = inflater.inflate(R.layout.llista5_item, parent, false);
            }
            //|-Per estalviar inflates.
            TextView tvNom = (TextView) myView.findViewById(R.id.nom);
            Product product = catalog.get(position);
            String nom = product.getName();
            tvNom.setText(nom);
            TextView tvPrice = (TextView) myView.findViewById(R.id.preu);
            float price = product.getPrice();
            tvPrice.setText(price + "€");
            ImageView imImage = (ImageView) myView.findViewById(R.id.imatge);
            int image = product.getImage();
            imImage.setImageResource(image);
            TextView tvStock = (TextView) myView.findViewById(R.id.stock);
            if (product.isInStock()){
                tvStock.setText("EN STOCK");
                tvStock.setTextColor(Color.GREEN);
            }else{
                tvStock.setText("NO STOCK");
                tvStock.setTextColor(Color.RED);
            }
            return myView;
        }
    }
}
