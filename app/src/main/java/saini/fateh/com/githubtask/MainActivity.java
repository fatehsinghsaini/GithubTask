package saini.fateh.com.githubtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView=(RecyclerView)findViewById(R.id.orgView);
        progress_bar=(ProgressBar)findViewById(R.id.progress_bar);
        syncFromServer("https://api.github.com/search/users?q=type:org");


    }

    public void syncFromServer(String url) {

        progress_bar.setVisibility(View.VISIBLE);
        StringRequest strRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        VolleyLog.d("Response by:", response);
                        setOrganisation(response);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("Error in web service by:" + error);
                        if(progress_bar.isShown())
                        progress_bar.setVisibility(View.GONE);
                    }
                });


        strRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        ApplicationController.getInstance().addToRequestQueue(strRequest);

    }

    private void setOrganisation(String response){

        if(progress_bar.isShown())
        progress_bar.setVisibility(View.GONE);
        try {
            JSONObject jsonObject=new JSONObject(response);
            if(Integer.parseInt(jsonObject.getString("total_count"))>0){

           JSONArray itemArray= (JSONArray)jsonObject.getJSONArray("items");
                ArrayList<OrientationModel> orgList=new ArrayList<>();
            for(int i=0;i<itemArray.length();i++){

                JSONObject jsonObject1=(JSONObject)itemArray.getJSONObject(i);
               String loginName=  jsonObject1.getString("login");
                String id= jsonObject1.getString("id");
                String avatar_url=jsonObject1.getString("avatar_url");
                String url=jsonObject1.getString("url");
                orgList.add(new OrientationModel(loginName,id,avatar_url,url));

            }

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                CustomOrgAdapter adapter = new CustomOrgAdapter(orgList, this);
                recyclerView.setAdapter(adapter);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
