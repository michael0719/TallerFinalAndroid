package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PorcentageAverageActivity extends AppCompatActivity {

    private Double[][] x;

    private TextView title;
    private EditText data;
    private TextView title2;
    private EditText dataporcentage;
    private TextView answer;
    private Button buttondata;
    private Button buttonnote;
    private double note;
    private double porcentage;
    private int maximo;
    private int cont=1;
    private int i=0;
    private double prom=0;
    private double porcentagemax=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcentage_average);

        title=findViewById(R.id.lbltitle);
        data=findViewById(R.id.txtdata);
        title2=findViewById(R.id.lbltitle2);
        answer=findViewById(R.id.lblaverage);
        dataporcentage=findViewById(R.id.txtdataporcentage);
        buttondata=findViewById(R.id.btndata);
        buttonnote=findViewById(R.id.btnnote);
        Button buttonrefresh=findViewById(R.id.btnrefresh);
        Button buttonback=findViewById(R.id.btnbackporcentage);

        buttondata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maximo=Integer.parseInt(data.getText().toString());
                    buttondata.setVisibility(View.INVISIBLE);
                    data.setText("");
                    title.setText("Enter note "+cont);
                    title2.setVisibility(View.VISIBLE);
                    title2.setText("Enter % note "+cont);
                    dataporcentage.setVisibility(View.VISIBLE);
                    x=new Double[maximo][2];
            }
        });

        buttonnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont = cont + 1;
                title.setText("Enter note " + cont);
                title2.setText("Enter % note " + cont);
                x[i][0] = note = Double.parseDouble(data.getText().toString().trim());
                x[i][1] = porcentage = Double.parseDouble(dataporcentage.getText().toString().trim());
                i++;
                if (note <=5) {
                    if (cont > maximo) {
                        buttonnote.setEnabled(false);
                        title.setVisibility(View.INVISIBLE);
                        data.setVisibility(View.INVISIBLE);
                        title2.setVisibility(View.INVISIBLE);
                        dataporcentage.setVisibility(View.INVISIBLE);
                        for (int j = 0; j < maximo; j++) {
                            prom = prom + (x[j][0] * (x[j][1] / 100));
                            porcentagemax =porcentagemax+ x[j][1];
                        }

                        if (porcentagemax == 100) {
                            answer.setVisibility(View.VISIBLE);
                            answer.setText("Su promedio es: " + prom);
                            Toast.makeText(getApplicationContext(), "su promedio es: " + prom, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error ... su porcentaje es menor o mayor a 100 " , Toast.LENGTH_LONG).show();
                       }

                    }
                }else{
                    buttonnote.setEnabled(false);
                    title.setVisibility(View.INVISIBLE);
                    title2.setVisibility(View.INVISIBLE);
                    data.setVisibility(View.INVISIBLE);
                    dataporcentage.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), " Ingrese una nota entre 0 y 5 " , Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonrefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refresh=new Intent(PorcentageAverageActivity.this,PorcentageAverageActivity.class);
                startActivity(refresh);
                finish();
            }
        });

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(PorcentageAverageActivity.this,MainNotesActivity.class);
                startActivity(back);
                finish();
            }
        });
    }
}
