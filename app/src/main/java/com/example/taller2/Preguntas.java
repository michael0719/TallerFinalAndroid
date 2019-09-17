package com.example.taller2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taller2.posicionrandom.PosicionLogica;

public class Preguntas extends Activity {
    private String[][] x=new String[15][2];
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        PosicionLogica posicionLogica=new PosicionLogica();
        final EditText respuesta=findViewById(R.id.txtrespuesta);
        TextView pregunta=findViewById(R.id.lblpregunta);
        final Button verificar=findViewById(R.id.btnrespuesta);
        final TextView resultado=findViewById(R.id.lblresultado);
        Button refrescar=findViewById(R.id.btnagain);
        Button volver=findViewById(R.id.btnvolver);
        final ImageView correcta=findViewById(R.id.imgcorrecta);
        final ImageView incorrecta=findViewById(R.id.imgincorrecta);

        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        posicionLogica.setNumeroMax(15);
        final int rand=posicionLogica.posicionrandom();
        llenarVector();
        pregunta.setText(""+x[rand][0]);

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(respuesta.getText().toString().toLowerCase().trim().equalsIgnoreCase(x[rand][1])){
                    resultado.setVisibility(View.VISIBLE);
                    correcta.setVisibility(View.VISIBLE);
                    resultado.setText("Respuesta correcta");
                    respuesta.setEnabled(false);
                    verificar.setEnabled(false);
                }else{
                    resultado.setVisibility(View.VISIBLE);
                    incorrecta.setVisibility(View.VISIBLE);
                    resultado.setText("Respuesta incorrecta");
                    respuesta.setEnabled(false);
                    verificar.setEnabled(false);
                    vibrator.vibrate(1000);
                }
            }
        });



        refrescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refresh = new Intent(Preguntas.this, Preguntas.class);
                startActivity(refresh);
                finish();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver= new Intent(Preguntas.this,MainActivity.class);
                startActivity(volver);
                finish();
            }
        });

    }

    private void llenarVector(){
        x[0][0]="¿Cual es el rio mas largo del mundo?";
        x[0][1]="amazonas";
        x[1][0]="¿En que pais se encuentra la torre de pizza?";
        x[1][1]="italia";
        x[2][0]="¿Que son los seres humanos:omnívoros,hervíboros o carnívoros?";
        x[2][1]="omnivoros";
        x[3][0]="¿Como se denomina el resultado de la multiplicación?";
        x[3][1]="producto";
        x[4][0]="¿Cual es el oceano mas grande?";
        x[4][1]="pacifico";
        x[5][0]="¿Cual es el disco mas vendido de la historia?";
        x[5][1]="thriller";
        x[6][0]="¿Cual es el tercer planeta en el sistema solar?";
        x[6][1]="tierra";
        x[7][0]="¿Que pais tiene forma de bota?";
        x[7][1]="italia";
        x[8][0]="¿Como se llama el animal mas rapido del mundo?";
        x[8][1]="guepardo";
        x[9][0]="¿Cual es el nombre de la lengua oficial en china?";
        x[9][1]="mandarin";
        x[10][0]="¿Que instrumento optico permite ver los astros de cerca?";
        x[10][1]="telescopio";
        x[11][0]="¿Que es mas pequeño,un átomo o una molécula?";
        x[11][1]="atomo";
        x[12][0]="¿A quien le crecia la nariz cuando mentia?";
        x[12][1]="pinocho";
        x[13][0]="¿Cuantos años tiene un lustro?";
        x[13][1]="5";
        x[14][0]="¿Donde se encuentra la capa de ozono?";
        x[14][1]="atmosfera";
    }

}
