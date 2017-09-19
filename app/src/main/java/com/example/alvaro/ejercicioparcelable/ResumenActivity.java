package com.example.alvaro.ejercicioparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResumenActivity extends AppCompatActivity {
    TextView nombre, apellido, edad, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);


        nombre = (TextView)findViewById(R.id.tvNombre);
        apellido = (TextView)findViewById(R.id.tvApellido);
        edad = (TextView)findViewById(R.id.tvEdad);
        direccion = (TextView)findViewById(R.id.tvDireccion);

        Persona persona = getIntent().getParcelableExtra("persona");

        nombre.setText(persona.getNombre());
        apellido.setText(persona.getApellido());
        edad.setText(persona.getEdad().toString());
        direccion.setText(persona.getDireccion().getCalle() + ", " + persona.getDireccion().getNumero() + ", " + persona.getDireccion().getCp());
    }
}
