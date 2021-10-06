package com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends Activity {
    private Button aceptar;
    private Button cancelar;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_actividad);
        aceptar = findViewById(R.id.bAceptar);
        cancelar = findViewById(R.id.bCancelar);
        texto = findViewById(R.id.textViewRecibido);
        aceptar.setOnClickListener(view -> boton(view));
        cancelar.setOnClickListener(view -> boton(view));
        try {
            Bundle extras = getIntent().getExtras();
            String s = extras.getString("usuario");
            texto.setText("Hola " + s +", ¿Aceptas las condiciones?");
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    public void boton(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.bAceptar:
                intent.putExtra("resultado","Aceptado");
                setResult(RESULT_OK, intent);
                break;
            case R.id.bCancelar:
                intent.putExtra("resultado","Rechazado");
                setResult(RESULT_CANCELED, intent);
                break;
        }

        finish();
    }
}
