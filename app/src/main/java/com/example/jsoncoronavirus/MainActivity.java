package com.example.jsoncoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    TextView textConf, textDead, textCrit, textRecover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textConf = findViewById(R.id.textConf);
        textDead = findViewById(R.id.textDead);
        textCrit = findViewById(R.id.textCrit);
        textRecover = findViewById(R.id.textRecover);

        public void afficher(){
            String url = "https://covid-19-data.p.rapidapi.com/totals";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                @Override
                        public void onResponse(JSONObject response){
                    try{
                        JSONObject confirmed = response.getJSONObject("confirmed");
                        JSONObject critical = response.getJSONObject("critical");
                        JSONObject deaths = response.getJSONObject("deaths");
                        JSONObject recovered = response.getJSONObject("recovered")

                                textConf.setText(confirmed);
                                textDead.setText(deaths);
                                textCrit.setText(critical);
                                textRecover.setText(recovered);
                    }
                }
                    }
        }
    }
}