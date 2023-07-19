package com.example.a3d4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText edtname, edtscore;
    TextView result;
    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname = findViewById(R.id.name);
        edtscore = findViewById(R.id.diemTb);
        result= findViewById(R.id.result);
        btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    public class BackgroundTask extends AsyncTask<Void, Void ,Void> {
        URL url ;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                //
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line = "";

                StringBuffer stringBuffer = new StringBuffer();
                while ((line = bufferedReader.readLine()) != null){
                    stringBuffer.append(line);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }
}