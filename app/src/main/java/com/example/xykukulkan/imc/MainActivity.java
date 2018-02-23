package com.example.xykukulkan.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected EditText mCampoPeso;
    protected EditText mCampoEstatura;
    protected Button mBotonCalcular;
    protected Button mBotonLimpiar;
    protected TextView mEtiquetaImc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCampoPeso = (EditText) findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText) findViewById(R.id.campo_estatura);
        mBotonCalcular = (Button) findViewById(R.id.boton_calcular);
        mBotonLimpiar = (Button) findViewById(R.id.boton_limpiar);
        mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);

        mBotonCalcular.setOnClickListener( e -> {
            String s = mCampoPeso.getText().toString();
            double peso = Double.parseDouble(s);
            s = mCampoEstatura.getText().toString();
            double estatura = Double.parseDouble(s);
            double imc = peso / (estatura * estatura);
            s = String.format("%2.2f", imc);
            mEtiquetaImc.setText(s);
        });

        mBotonLimpiar.setOnClickListener( e -> {
            mCampoPeso.setText("");
            mCampoEstatura.setText("");
            mEtiquetaImc.setText("0.0");
        });
    }
}
