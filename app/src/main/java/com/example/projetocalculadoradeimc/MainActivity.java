package com.example.projetocalculadoradeimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.projetocalculadoradeimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView resultadoDoCalculo = findViewById(R.id.resultadoDoCalculo);

        TextView classificacao = findViewById(R.id.classificao);

        Button botaoCalcular = findViewById(R.id.botaoCalcular);

        botaoCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                calcular();
            }
            private void calcular(){
                EditText peso = findViewById(R.id.inputPeso);

                EditText altura = findViewById(R.id.inputAltura);

                double valorCalculado = Double.parseDouble(peso.getText().toString()) / (Double.parseDouble(altura.getText().toString()) * Double.parseDouble(altura.getText().toString())) ;


                if (valorCalculado < 16.9) {
                    classificacao.setText(String.valueOf("Muito abaixo do peso"));

                } else if (valorCalculado < 18.4) {
                    classificacao.setText(String.valueOf("Abaixo do peso"));

                } else if (valorCalculado < 24.9) {
                    classificacao.setText(String.valueOf("Peso normal"));

                } else if (valorCalculado < 29.9) {
                    classificacao.setText(String.valueOf("Acima do peso"));

                }else if (valorCalculado < 34.9) {
                    classificacao.setText(String.valueOf("Obesidade grau 1"));

                }else if (valorCalculado < 40) {
                    classificacao.setText(String.valueOf("Obesidade grau 2"));

                }else {
                    classificacao.setText(String.valueOf("Obesidade grau 3"));
                }
                classificacao.setVisibility(View.VISIBLE);

                resultadoDoCalculo.setText(String.valueOf(valorCalculado));
                resultadoDoCalculo.setVisibility(View.VISIBLE);
            }

        });
    }
}