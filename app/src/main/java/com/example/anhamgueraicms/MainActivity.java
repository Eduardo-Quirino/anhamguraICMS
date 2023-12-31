package com.example.anhamgueraicms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextEstado;
    private EditText mEditTextValor;
    private TextView mTextViewPorcentagem;
    private TextView mTextViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextEstado = findViewById(R.id.editTextEstado);
        mEditTextValor = findViewById(R.id.editTextValor);
        mTextViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        mTextViewTotal = findViewById(R.id.textViewTotal);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void calcular(View view) {
        String estado = mEditTextEstado.getText().toString();

        String valorString = mEditTextValor.getText().toString();
        float valor = Float.parseFloat(valorString);

        float porcentagem = 0;
        switch (estado) {
            case "RO":
                porcentagem = 17.5f;
                break;
            case "SP":
                porcentagem = 18;
                break;
        }
        float total = (valor * porcentagem / 100);
        mTextViewPorcentagem.setText(porcentagem + "%");
        mTextViewTotal.setText(String.format("R$ %.2f", total));
    }
}