package co.il.shivhit.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etLow;
    private EditText etHigh;
    private Button   btnPlay;

    private Random  random;
    private int     low;
    private int     high;
    private int     appNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeViews();
        SetListeners();

        random = new Random();
    }

    private void InitializeViews() {
        etLow   = findViewById(R.id.etLow);
        etHigh  = findViewById(R.id.etHigh);
        btnPlay = findViewById(R.id.btnPlay);
    }

    private void SetListeners() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLow.getText().toString().isBlank() || etHigh.getText().toString().isBlank()) {
                    AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Error")
                            .setMessage("Low or High are empty")
                            .setIcon(R.drawable.exclamation)
                            .setPositiveButton("Ok", null)
                            .setCancelable(true)
                            .show();
                } else {
                    if (Integer.parseInt(etLow.getText().toString()) >= Integer.parseInt(etHigh.getText().toString())) {
                        AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Error")
                                .setMessage("Low musr be smaller then High")
                                .setIcon(R.drawable.exclamation)
                                .setPositiveButton("Ok", null)
                                .setCancelable(true)
                                .show();
                    } else {
                        low = Integer.parseInt(etLow.getText().toString());
                        high = Integer.parseInt(etHigh.getText().toString());
                        appNumber = random.nextInt(high - low) + low;

                        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                        intent.putExtra("APPNUM", appNumber);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}