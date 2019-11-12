package com.shuyin.opgg;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText summoner_text_input;
    private Button request_login_button;

    private String region = "na1";
    private String summoner;
    private String api_key;

    private TextView test_textview;

    private String sum_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        summoner_text_input = findViewById(R.id.summoner_lookup_et);
        request_login_button = findViewById(R.id.request_login_button);

        test_textview = findViewById(R.id.test_textview);

        request_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                summoner = summoner_text_input.getText().toString();
                api_key = "RGAPI-b30eeb3b-38ab-4c33-95a8-ff8f90de90a5";

                if(!summoner.isEmpty()){
                    try {
                        JSONObject obj = new JSONObject(region + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summoner + "?api_key=" + api_key);
                        String name = obj.getString("name");
                        test_textview.setText("Hi");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    test_textview.setText ("Hello World");
                }
            }
        });
    }

    public void setApiKey(String api_key){
        this.api_key = api_key;
    }

    public void requestSummoner(String summoner) {
        try {

            //sum_name = obj.getString("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("TAG","sum_name: " + sum_name);
    }
}
