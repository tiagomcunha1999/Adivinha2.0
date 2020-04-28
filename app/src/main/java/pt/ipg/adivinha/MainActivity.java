package pt.ipg.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int numeroAdivinhar = NumerosAleatorios.proximoNumero();
    private int tentativas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void adivinha(View view) {

        EditText editTextNumero = (EditText) findViewById(R.id.editTextNumero);

        String strNumero = editTextNumero.getText().toString();

        int numero;

        try{
            numero = Integer.parseInt(strNumero);
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

        TextView textViewResultado = (TextView) findViewById(R.id.textViewResultado);

        if (numero == numeroAdivinhar){
            textViewResultado.setText("Parabens, acertou!!!");
        } else if (numero < numeroAdivinhar){
            textViewResultado.setText("O numero que estou a pensar e maior. Tente outra vez");
        } else {//numero > numeroAdivinhar
            textViewResultado.setText("O numero que estou a pensar e menor. Tente outra vez");
        }

        public void onSaveInstanceState(Bundle savedInstanceState) {

            savedInstanceState.putInt(STATE_SCORE, currentScore);
            savedInstanceState.putInt(STATE_LEVEL, currentLevel);

            super.onSaveInstanceState(savedInstanceState);
        }


        tentativas++;
        TextView textViewtentativas = (TextView) findViewById((R.id.textViewTentativas));
        textViewtentativas.setText("Tentivas: " + tentativas);

    }

}
