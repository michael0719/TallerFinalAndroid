package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taller2.numeros.AleatoriosLogica;
import com.example.taller2.posicionrandom.PosicionLogica;

public class OperacacionesAleatorias extends AppCompatActivity {

    private Vibrator vibrator;
    private int respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacaciones_aleatorias);

        AleatoriosLogica aleatoriosLogica= new AleatoriosLogica();
        PosicionLogica posicionLogica=new PosicionLogica();

        final EditText numeroRespuesta=findViewById(R.id.txtrespuesta);
        final ImageView resBuena=findViewById(R.id.imgcorrecta);
        final ImageView resMala=findViewById(R.id.imgincorrecta);
        final Button botonVerificar=findViewById(R.id.btnverificar);
        Button botonRefrescar=findViewById(R.id.btnrefrescar);
        Button botonVolver=findViewById(R.id.btnvolver);
        TextView numero1=findViewById(R.id.lblnumero1);
        TextView numero2=findViewById(R.id.lblnumero2);
        final TextView resultado=findViewById(R.id.lblresultado);
        TextView signo=findViewById(R.id.lblsigno);
        posicionLogica.setNumeroMax(50);
        int num1=posicionLogica.posicionrandom();
        int num2=posicionLogica.posicionrandom();
        posicionLogica.setNumeroMax(4);
        int  random=posicionLogica.posicionrandom()+1;
        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        // random 1=suma,2=resta,3=multiplicacion y 4=division

        aleatoriosLogica.setNumero1(num1);
        aleatoriosLogica.setNumero2(num2);
        numero1.setText(""+num1);
        numero2.setText(""+num2);

       switch (random){
            case 1:
                signo.setText("+");
                respuesta=aleatoriosLogica.suma();
                break;
            case 2:
                signo.setText("-");
                respuesta=aleatoriosLogica.resta();
                break;
            case 3:
                signo.setText("x");
                respuesta=aleatoriosLogica.multiplicacion();
                break;
            case 4:
                signo.setText("/");
                respuesta=aleatoriosLogica.division();
                break;
                default:
                    break;
        }

        botonVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(numeroRespuesta.getText().toString())==respuesta){
                    resultado.setVisibility(View.VISIBLE);
                    resultado.setText("Respuesta correcta");
                    resBuena.setVisibility(View.VISIBLE);
                    numeroRespuesta.setEnabled(false);
                    botonVerificar.setEnabled(false);
                }else{
                    resultado.setVisibility(View.VISIBLE);
                    resultado.setText("Respuesta incorrecta");
                    resMala.setVisibility(View.VISIBLE);
                    numeroRespuesta.setEnabled(false);
                    botonVerificar.setEnabled(false);
                    vibrator.vibrate(1000);
                }
            }
        });

       botonRefrescar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent refresh = new Intent(OperacacionesAleatorias.this, OperacacionesAleatorias.class);
               startActivity(refresh);
               finish();
           }
       });

       botonVolver.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent back= new Intent(OperacacionesAleatorias.this,MainActivity.class);
               startActivity(back);
               finish();
           }
       });

    }

}
