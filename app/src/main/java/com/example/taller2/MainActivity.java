package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aleatorio= findViewById(R.id.btnaleatorios);
        Button culturaGeneral=findViewById(R.id.btnpreguntas);
        Button acercade=findViewById(R.id.btnacerca);
        Button promedio=findViewById(R.id.btnpromedio);

        aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actividad=new Intent(MainActivity.this,OperacacionesAleatorias.class);
                startActivity(actividad);
            }
        });

        culturaGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pregunta=new Intent(MainActivity.this,Preguntas.class);
                startActivity(pregunta);
            }
        });

        acercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acercade=new Intent(MainActivity.this,Acercade.class);
                startActivity(acercade);
            }
        });

        promedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prom= new Intent(MainActivity.this,MainNotesActivity.class);
                startActivity(prom);
            }
        });
    }
}
