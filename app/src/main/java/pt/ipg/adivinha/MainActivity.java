package pt.ipg.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int numeroAdivinhar = NumerosAleatorios.proximoNumero();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void adivinha(View view) {
        Intent intent = new Intent(this, NumerosAleatorios.class);

        EditText editTextNumero = (EditText) findViewById(R.id.editTextNumero);

        String strNumero = editTextNumero.getText().toString();
        int numero;
        try{
            int numero = Integer.parseInt(strNumero);
        } catch (NumberFormatException e){
            editTextNumero.setError("Numero Invalido");
            editTextNumero.requestFocus();
            return;
        }

        if (numero < 1 || numero > 10) {
            editTextNumero.setError("O numero que estou a pensar é entre 1 e 10");
            editTextNumero.requestFocus();
            return;
        }

        startActivity(intent);
    }
}
