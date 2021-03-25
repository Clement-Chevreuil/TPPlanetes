package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class PlaneteAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private Data listePlanete ;
    private Button but;
   Integer nb = 0;
   private ArrayList<Planete> listePlanetes = new ArrayList<Planete>();

    public PlaneteAdapter(Context context, Data listePlanete, Button but)
    {
        this.context = context;
        this.listePlanete = listePlanete;
        this.inflater = LayoutInflater.from(context);
        this.but = but;
    }

    @Override
    public int getCount() {
        return listePlanete.getAllData().size();
    }
    @Override
    public Object getItem(int arg0) {
        return listePlanete.getAllData().get(arg0);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)

                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(listePlanete.getAllData().get(position).getNom());

        String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, taillePlanetes);

        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Planete planettes = new Planete();

                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {


                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();

                    planettes.setNom(nomPlanete.getText().toString());

                    String tailleChar = spinner.getSelectedItem().toString();
                    int taille = Integer.parseInt(tailleChar);

                    planettes.setPoid(taille);

                    listePlanetes.add(planettes);

                    nb = nb + 1;
                    if(nb.equals(9))
                    {
                        but.setEnabled(true);
                    }

                }
                else {


                    planettes.setNom(nomPlanete.getText().toString());
                    listePlanetes.remove(planettes);
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                    nb = nb - 1;
                    but.setEnabled(false);

                    for(int i = 0; i != listePlanetes.size() +1 ; i++ )
                    {
                        if(listePlanete.getAllData().get(i).getNom().equals(planettes.getNom()))
                        {
                            listePlanetes.remove(i);
                        }

                    }
                }
            }
        });


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phrase = "";
                for(int i = 0; i < listePlanetes.size(); i++ )
                {
                    for(int o = 0; o < listePlanete.getAllData().size(); o++)
                    {
                        if(listePlanete.getAllData().get(o).getNom().equals(listePlanetes.get(i).getNom()))
                        {
                            phrase = phrase + listePlanetes.get(i).getNom()  + " = " + String.valueOf(listePlanete.getAllData().get(o).getPoid()) + "Votre Reponse " + listePlanetes.get(i).getPoid() + "\n";
                        }
                    }

                }

                Toast.makeText(context, phrase, Toast.LENGTH_SHORT).show();
            }
        });


        return itemView;
    }


}
