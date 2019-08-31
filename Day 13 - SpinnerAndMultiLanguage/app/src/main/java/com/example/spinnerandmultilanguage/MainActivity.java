package com.example.spinnerandmultilanguage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_LANG = "pref_lang";
    private static String KEY_SELECTED_LANG = "selected_lang";

    String[] countries = {"Nepal", "United States", "United Kingdom", "Germany", "France", "Switzerland"};

    Button btnChangeLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPreviousLanguage();
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        btnChangeLanguage = findViewById(R.id.btn_choose_language);
        /*create adapter using data source from string-array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,
                        R.array.planets,
                        android.R.layout.simple_spinner_item
                );
        spinner.setAdapter(adapter);
*/
        //create adapter using string data source
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        adapter.setDropDownViewResource(R.layout.row_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                String planetName = (String) adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected Planet: " + planetName, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] language = {"English", "Nepali", "French"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose Language");
                builder.setSingleChoiceItems(language, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        if (position == 0) {
                            setLocal("en");
                            recreate();
                        }

                        if (position == 1) {
                            setLocal("ne");
                            recreate();
                        }

                        if (position == 2) {
                            setLocal("fr");
                            recreate();
                        }
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    private void setLocal(String selectedLanguage) {

        Locale locale = new Locale(selectedLanguage);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;

        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_LANG, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SELECTED_LANG, selectedLanguage);
        editor.commit();
    }

    private void loadPreviousLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_LANG, MODE_PRIVATE);
        String savedLanguage = sharedPreferences.getString(KEY_SELECTED_LANG, "en");
        setLocal(savedLanguage);

    }

}
