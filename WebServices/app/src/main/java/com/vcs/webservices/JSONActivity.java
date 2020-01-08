package com.vcs.webservices;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JSONActivity extends AppCompatActivity {

    /**
     * TextView
     */
    private TextView mTvJsonData;
    private ImageView mIvProfilepic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        initView();
//        getjsonOb();
//        getJSONArrayba();
        getImagefromServer();

    }

    private void getImagefromServer() {
        RequestQueue rqimg = Volley.newRequestQueue(this);
        String imgurl = "https://www.fnordware.com/superpng/pnggrad16rgb.png";

        ImageRequest ivreq = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            ivreq = new ImageRequest(imgurl, new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                    mIvProfilepic.setImageBitmap(response);
                    String root = Environment.getExternalStorageDirectory().toString();

                    //                    File f_secs = new File(secStore);
                    try (FileOutputStream out = new FileOutputStream(root+"/new.png")) {
                        response.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
                        // PNG is a lossless format, the compression factor (100) is ignored
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }, 0, 0, null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
        rqimg.add(ivreq);


    }

    private void getJSONArrayba() {

        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "http://192.168.2.9/andbackend/getJSONArray.php";
        JsonObjectRequest jsr = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsar = response.getJSONArray("students");
                    for (int i = 0; i < jsar.length(); i++) {
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
        mIvProfilepic = (ImageView) findViewById(R.id.iv_profilepic);
    }
}
