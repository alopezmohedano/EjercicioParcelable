package com.example.alvaro.ejercicioparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombre, apellido, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btnSiguiente);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nombre = (EditText)findViewById(R.id.txtNombre);
        apellido = (EditText)findViewById(R.id.txtApellido);
        edad = (EditText)findViewById(R.id.txtEdad);

        Intent intent = new Intent(this, DatosDireccionActivity.class);
        Persona persona = new Persona(nombre.getText().toString(), apellido.getText().toString(), Integer.parseInt(edad.getText().toString()));
        intent.putExtra("persona", persona);
        startActivity(intent);
    }
}