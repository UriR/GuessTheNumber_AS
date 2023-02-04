package co.il.shivhit.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    private TextView  txtTries;
    private ImageView ivFace;
    private Button    btnFinish;
    private int       guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        InitializeViews();
        SetLiseners();

        guesses = getIntent().getIntExtra("GUESSES", -1);

        txtTries.setText("You won " + guesses + " tries !");

        if (guesses < 5){
            ivFace.setImageResource(R.drawable.happy);
        }
        else{
            if (guesses < 10){
                ivFace.setImageResource(R.drawable.ooo);
            }
            else {
                ivFace.setImageResource(R.drawable.sad);
            }
        }
    }

    private void InitializeViews() {
        txtTries  = findViewById(R.id.txtTries);
        ivFace    = findViewById(R.id.ivFace);
        btnFinish = findViewById(R.id.btnFinish);
    }

    private void SetLiseners() {
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}