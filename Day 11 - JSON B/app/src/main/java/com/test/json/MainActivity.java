package com.test.json;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Datum> dataList = new ArrayList<>();
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear_layout);
        String myjson = loadJSONFromAsset();

        try {
            JSONObject json = new JSONObject(myjson);
            Log.e("json", json.toString());
            String page = json.getString("page");
            Log.e("kkkk", page);

            JSONArray myArrayjson = json.getJSONArray("data");
            for (int i = 0; i < myArrayjson.length(); i++) {
                JSONObject jsonArr = myArrayjson.getJSONObject(i);
                // String email = jsonArr.getString("email");

                Gson gson = new Gson();
                Datum datum = gson.fromJson(String.valueOf(jsonArr), Datum.class);
                Log.e("from mode", datum.getFirstName());
                dataList.add(datum);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dataList.size(); i++) {
            View myVieww = getLayoutInflater().inflate(R.layout.row_list, linearLayout, false);
            ImageView imgView = myVieww.findViewById(R.id.img);
            TextView name = myVieww.findViewById(R.id.tv_name);
            TextView email = myVieww.findViewById(R.id.tv_email);

            Glide.with(MainActivity.this).load("ç").into(imgView);

            name.setText(dataList.get(i).getFirstName() + " " + dataList.get(i).getLastName());
            email.setText(dataList.get(i).getEmail());

            linearLayout.addView(myVieww);

        }

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("my_files.json");
            int size = inputStream.available();


            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}