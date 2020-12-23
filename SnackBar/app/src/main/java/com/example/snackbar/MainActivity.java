package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main);
    }

    public void defaultClick(View view) {
        Snackbar snackbar = Snackbar.make(view, "This is default snack bar", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void actionClick(View view) {
        Snackbar snackbar = Snackbar
                .make(view, "Message is deleted", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackBar1 = Snackbar.make(view, "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackBar1.show();
                    }
                });


        snackbar.show();
    }

    public void customClick(View view) {

        // https://stackoverflow.com/questions/32453946/how-to-customize-snackbars-layout
        // The link above contain more about SnackBar

        Snackbar snackbar = Snackbar
                .make(view, "Christmas (or the Feast of the Nativity) is an annual " +
                        "festival commemorating the birth of Jesus Christ, observed " +
                        "primarily on December 25 as a religious and cultural celebration " +
                        "among billions of people around the world.", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO: action here
                    }
                });
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setMaxLines(5);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    public void clickButton(View view) {

        Snackbar snackbar = Snackbar.make(mainLayout,"",Snackbar.LENGTH_LONG);
        View custom = getLayoutInflater().inflate(R.layout.snackbar_custom,null);

        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

        snackbarLayout.setPadding(0,0,0,0);

        (custom.findViewById(R.id.actionText)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click the text", Toast.LENGTH_SHORT).show();
                snackbar.dismiss();
            }
        });

        snackbarLayout.addView(custom,0);
        snackbar.show();

    }
}