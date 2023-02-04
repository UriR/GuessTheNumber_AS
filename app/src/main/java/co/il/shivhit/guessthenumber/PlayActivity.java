package co.il.shivhit.guessthenumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    private EditText etGuess;
    private Button   btnGuess;
    private TextView txttries;
    private TextView txtTooBig;
    private int appNum;
    private int guesses;
    private int guessNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        InitializeViews();
        SetListeners();

        appNum = getIntent().getIntExtra("APPNUM", -1);
        guesses = 0;

        Toast.makeText(this, String.valueOf(appNum), Toast.LENGTH_SHORT).show();
    }

    private void InitializeViews() {
        etGuess   = findViewById(R.id.etGuess);
        btnGuess  = findViewById(R.id.btnGuess);
        txttries  = findViewById(R.id.txttries);
        txtTooBig = findViewById(R.id.txtTooBig);
    }

    private void SetListeners() {
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etGuess.getText().toString().isBlank()){
                    AlertDialog dialog = new AlertDialog.Builder(PlayActivity.this)
                            .setTitle("Error")
                            .setMessage("Pleae enter your guess")
                            .setIcon(R.drawable.exclamation)
                            .setCancelable(true)
                            .setPositiveButton("OK", null)
                            .show();
                }
                else{

                    guesses++;
                    guessNum = Integer.valueOf(etGuess.getText().toString());

                    if (guessNum != appNum){
                        if (guessNum > appNum)
                            txtTooBig.setText("Too big");
                        else
                            txtTooBig.setText("Too small");

                        txttries.setText(guesses + " Guesses");
                    }
                    else{
                        Intent intent = new Intent(PlayActivity.this, WinActivity.class);
                        intent.putExtra("GUESSES", guesses);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}