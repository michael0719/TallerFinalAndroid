package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taller2.modelo.Promedios;

public class NormalAverageActivity extends AppCompatActivity {

    private Button enterdata;
    private Button enternote;
    private TextView title;
    private TextView answer;
    private EditText data;
    private double max;
    private double prom;
    private double num;
    private int cont=1;
    private String promedio="";
    private String numero="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_average);
        title=findViewById(R.id.lbltitle);
        data=findViewById(R.id.txtdata);
        enterdata=findViewById(R.id.btnenterdata);
        enternote=findViewById(R.id.btnenternote);
        Button restar=findViewById(R.id.btnrestart);
        Button volver=findViewById(R.id.btnback);
        answer=findViewById(R.id.lblanswer);

        enterdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              max=Double.parseDouble(data.getText().toString().trim());
              if(max<0){
                  Toast.makeText(getApplicationContext(),"Ingrese un valor positivo",Toast.LENGTH_LONG).show();
              }else{
                  enterdata.setVisibility(View.INVISIBLE);
                  data.setText("");
                  title.setText("Enter note "+cont);
              }
            }
        });

            enternote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numero=numero+"note "+cont+" "+data.getText().toString().trim()+"\n";
                    cont=cont+1;
                    title.setText("Enter note "+cont);
                    num=Double.parseDouble(data.getText().toString().trim());
                    prom=prom+Double.parseDouble(data.getText().toString().trim());
                    if(num>=0 && num<=5) {
                        if (cont > max) {
                            promedio="promedio: "+prom/max;
                            Promedios promedios=new Promedios();
                            promedios.setNotas(numero);
                            promedios.setPromedio(promedio);
                            enternote.setEnabled(false);
                            title.setVisibility(View.INVISIBLE);
                            data.setVisibility(View.INVISIBLE);
                            answer.setVisibility(View.VISIBLE);
                            answer.setText("Su promedio es: "+prom / max);
                            Toast.makeText(getApplicationContext(), "su promedio es: " + prom / max, Toast.LENGTH_LONG).show();
                        }
                        data.setText("");
                    }else{
                        title.setVisibility(View.INVISIBLE);
                        data.setVisibility(View.INVISIBLE);
                        enternote.setEnabled(false);
                        Toast.makeText(getApplicationContext(), "Ingrese una nota entre 0 y 5 " , Toast.LENGTH_LONG).show();
                    }
                }
            });

            restar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent refresh=new Intent(NormalAverageActivity.this,NormalAverageActivity.class);
                    startActivity(refresh);
                    finish();
                }
            });

            volver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent volver=new Intent(NormalAverageActivity.this,MainNotesActivity.class);
                    startActivity(volver);
                    finish();
                }
            });

    }

}
