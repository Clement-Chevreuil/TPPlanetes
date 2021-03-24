package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    PlaneteAdapter adapter;
    ArrayList<Planete> data = new ArrayList<Planete>();
    Data listData = new Data();
    Button validation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        installePlanetes();



        validation = (Button) findViewById(R.id.send);


        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new PlaneteAdapter(this, listData, validation));

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox check = (CheckBox) findViewById(R.id.checkbox);
                    Toast.makeText(getApplicationContext(), "mon message", Toast.LENGTH_SHORT).show();
            }
        });



    }


    private void installePlanetes() {

        Planete planeteMercure = new Planete("Mercure", 4900);
        Planete planeteVenus = new Planete("Venus", 12000);
        Planete planeteTerre = new Planete("Terre", 12800);
        Planete planeteMars = new Planete("Mars", 6800);
        Planete planeteJupiter = new Planete("Jupiter", 144000);
        Planete planeteSaturne = new Planete("Saturne", 120000);
        Planete planeteUranus = new Planete("Uranus", 52000);
        Planete planeteNeptune = new Planete("Neptune", 50000);
        Planete planetePluton = new Planete("Pluton", 2300);


        data.add(planeteMercure);
        data.add(planeteVenus);
        data.add(planeteTerre);
        data.add(planeteMars);
        data.add(planeteJupiter);
        data.add(planeteSaturne);
        data.add(planeteUranus);
        data.add(planeteNeptune);
        data.add(planetePluton);

        listData.setAllData(data);
    }


}
