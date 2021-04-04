package com.example.fontsanddialogs;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvMyFont = findViewById(R.id.tvCustomFont);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/NotoSansUI-Bold.ttf");
        tvMyFont.setTypeface(typeFace);


        Button btnCustomDialog = findViewById(R.id.btnCustomDialog);
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "okay", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View customView = inflater.inflate(R.layout.layout_custom_dialog, null);
                Button btnBuy = customView.findViewById(R.id.btnBuy);
                Button btnSell = customView.findViewById(R.id.btnSell);
                ImageView img = customView.findViewById(R.id.imageView2);

                btnBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Buy Button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setView(customView);
                builder.create();
                builder.show();
            }
        });


        final Button btnDefaultDialog = findViewById(R.id.btnDefaultDialog);
        btnDefaultDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "okay", Toast.LENGTH_SHORT).show();

                //Alert dialogbox code starts
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Title");
                builder.setMessage("Message");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "okay", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });

                builder.setNeutralButton("Not sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Neutral Button Clicked", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
    }


}
