package com.vcs.webservices;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONActivity extends AppCompatActivity {

    /**
     * TextView
     */
    private TextView mTvJsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        initView();
//        getjsonOb();
        getJSONArrayba();
    }

    private void getJSONArrayba() {

        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "http://192.168.2.9/andbackend/getJSONArray.php";
        JsonObjectRequest jsr = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsar = response.getJSONArray("students");
                    for (int i=0 ; i<jsar.length();i++ ){
                        JSONObject job = jsar.getJSONObject(i);
                        mTvJsonData.setText(job.getString("name"));
                        mTvJsonData.append(job.getString("age"));
//                        mTvJsonData.append(response.getString("class"));

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JSONActivity.this, error.toString(), Toast.LENGTH_SHORT).show();


            }
        });
        rq.add(jsr);
    }

    private void getjsonOb() {
        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "http://192.168.2.9/andbackend/getjson.php";
        JsonObjectRequest jsr = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                mTvJsonData.setText(response.toString());
                try {
                    mTvJsonData.setText(response.getString("name"));
                    mTvJsonData.append(response.getString("age"));
                    mTvJsonData.append(response.getString("class"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JSONActivity.this, error.toString(), Toast.LENGTH_SHORT).show();


            }
        });
            rq.add(jsr);

    }

    private void initView() {
        mTvJsonData = (TextView) findViewById(R.id.tv_jsonData);
    }
}
