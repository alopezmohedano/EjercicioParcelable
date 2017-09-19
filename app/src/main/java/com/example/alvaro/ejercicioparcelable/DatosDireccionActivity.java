package com.example.alvaro.ejercicioparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatosDireccionActivity extends AppCompatActivity implements View.OnClickListener{
    EditText direccion, numero, cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_direccion);

        Button btn = (Button)findViewById(R.id.btnSiguiente);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        direccion = (EditText)findViewById(R.id.txtDireccion);
        numero = (EditText)findViewById(R.id.txtNumero);
        cp = (EditText)findViewById(R.id.txtCP);

        Intent intent2 = new Intent(this, ResumenActivity.class);
        Direccion dir = new Direccion(direccion.getText().toString(), numero.getText().toString(), Integer.parseInt(cp.getText().toString()));
        Persona persona = getIntent().getParcelableExtra("persona");
        persona.setDireccion(dir);
        intent2.putExtra("persona", persona);
        startActivity(intent2);
    }
}
