package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainNotesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes);
        Button normal=findViewById(R.id.btnnormal);
        Button porcentaje=findViewById(R.id.btnporcentaje);
        Button back=findViewById(R.id.btnback);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nor=new Intent(MainNotesActivity.this,NormalAverageActivity.class);
                startActivity(nor);
            }
        });

        porcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent porcen=new Intent(MainNotesActivity.this,PorcentageAverageActivity.class);
                startActivity(porcen);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback=new Intent(MainNotesActivity.this,MainActivity.class);
                startActivity(goback);
                finish();
            }
        });
    }
}
