package com.example.comunicacionactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button verificar;
    private EditText nombre;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.editTextEntrada);
        verificar = findViewById(R.id.bVerificar);
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarSegundaActivity();
            }
        });
        resultado = findViewById(R.id.textViewResultado);
    }
    public void lanzarSegundaActivity(){
        Intent intent = new Intent(this, SegundaActivity.class);


        intent.putExtra("usuario", nombre.getText().toString());
        startActivityForResult(intent, 1234);
//        intent.putExtra("edad", 27);
//        startActivity(intent);
    }
    @Override protected void onActivityResult(int requestCode, int resultCode,
                                              Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1234 && resultCode==RESULT_OK) {
            String res = data.getExtras().getString("resultado");
            resultado.setText("Resultado " + res);
        }else{
            String res = data.getExtras().getString("resultado");
            resultado.setText( "Resultado " + res);
        }
    }


}