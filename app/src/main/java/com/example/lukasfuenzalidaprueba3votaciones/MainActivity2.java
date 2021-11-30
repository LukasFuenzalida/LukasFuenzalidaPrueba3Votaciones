package com.example.lukasfuenzalidaprueba3votaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button Volver2;
    TextView tv_blanco, tv_nulo, tv_boric, tv_kast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Volver2 = (Button) findViewById(R.id.button2);
        tv_blanco = (TextView)findViewById(R.id.txt_blanco);
        tv_nulo = (TextView)findViewById(R.id.txt_nulo);
        tv_boric = (TextView)findViewById(R.id.txt_boric);
        tv_kast = (TextView)findViewById(R.id.txt_kast);

        Integer TotalBlancos=0,TotalNulos=0,TotalBoric=0,TotalKast=0;
        SQLiteDatabase db;
        Dbhelper conn = new Dbhelper(getApplicationContext());
        db= conn.getReadableDatabase();
        Cursor C =db.query("Voto",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(2).equals(""))
                    {
                        TotalBlancos++;
                    }
                    if(C.getString(2).equals(""))
                    {
                        TotalNulos++;
                    }
                    if(C.getString(2).equals(""))
                    {
                        TotalBoric++;
                    }
                    if(C.getString(2).equals(""))
                    {
                        TotalKast++;
                    }
                }
                while(C.moveToNext());
            }
        }
        tv_blanco.setText(""+TotalBlancos);
        tv_nulo.setText(""+TotalNulos);
        tv_boric.setText(""+TotalBoric);
        tv_kast.setText(""+TotalKast);


        Volver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });
    }
}