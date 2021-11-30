package com.example.lukasfuenzalidaprueba3votaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Res,Vot;
    RadioButton nul,boric,kast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Res = (Button) findViewById(R.id.BTN_RESULTADOS);
        Vot = (Button) findViewById(R.id.BTN_VOTAR);
        nul = (RadioButton) findViewById(R.id.rb_nulo);
        boric = (RadioButton) findViewById(R.id.rb_boric);
        kast = (RadioButton) findViewById(R.id.rb_kast);


        Vot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db;
                Dbhelper conn = new Dbhelper(getApplicationContext());
                db= conn.getWritableDatabase();
                ContentValues CV = new ContentValues();

                if(nul.isChecked()==false || boric.isChecked()==false || kast.isChecked()==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("¿Seguro que quiere dejar en blanco el voto?")
                            .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    Dbhelper conn = new Dbhelper(getApplicationContext());
                                    db = conn.getReadableDatabase();
                                    db.insert("Voto",null,CV);
                                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();
                    if(nul.isChecked()==true){
                        CV.put("rb_nulo",nul.getText().toString());
                        db.insert("Voto",null,CV);
                        Toast.makeText(getApplicationContext(),"Voto Guardado", Toast.LENGTH_LONG).show();
                        Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(I);
                    }
                    if(boric.isChecked()==true){

                        CV.put("rb_boric",boric.getText().toString());
                        db.insert("Voto",null,CV);
                        Toast.makeText(getApplicationContext(),"Voto Guardado", Toast.LENGTH_LONG).show();
                        Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(I);
                    }
                    if(kast.isChecked()==true){
                        CV.put("rb_kast",kast.getText().toString());
                        db.insert("Voto",null,CV);
                        Toast.makeText(getApplicationContext(),"Voto Guardado", Toast.LENGTH_LONG).show();
                        Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(I);
                    }
                }
            }
        });

        Res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(I);
            }
        });
    }
}