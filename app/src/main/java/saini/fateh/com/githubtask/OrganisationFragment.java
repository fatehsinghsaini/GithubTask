package saini.fateh.com.githubtask;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

/**
 * Created by fateh on 7/5/17.
 */

public class OrganisationFragment extends Fragment{

    private RecyclerView recyclerView;
    private ProgressBar progress_bar;

    private OnItemSelectedListener listener;
    public static final String EXTRA_URL ="url";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.organisations_layout, container, false);



        recyclerView=(RecyclerView)view.findViewById(R.id.orgView);
        progress_bar=(ProgressBar)view.findViewById(R.id.progress_bar);
        syncFromServer("https://api.github.com/search/users?q=type:org");

        return view;

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

                JSONArray itemArray= jsonObject.getJSONArray("items");
                ArrayList<organisationModel> orgList=new ArrayList<>();
                for(int i=0;i<itemArray.length();i++){



                    JSONObject jsonObject1=itemArray.getJSONObject(i);
                    String loginName=  jsonObject1.getString("login");
                    String id= jsonObject1.getString("id");
                    String avatar_url=jsonObject1.getString("avatar_url");
                    String type=jsonObject1.getString("type");
                    String score=jsonObject1.getString("score");
                    String url=jsonObject1.getString("url");
                    String followers_url=jsonObject1.getString("followers_url");
                    String gists_url=jsonObject1.getString("gists_url");
                    String subscriptions_url=jsonObject1.getString("subscriptions_url");
                    String organizations_url=jsonObject1.getString("organizations_url");
                    String repos_url=jsonObject1.getString("repos_url");
                    String events_url=jsonObject1.getString("events_url");

                    orgList.add(new organisationModel(loginName,id,avatar_url,url,type,score,followers_url,gists_url,subscriptions_url,organizations_url,repos_url,events_url));

                }

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                CustomOrgAdapter adapter = new CustomOrgAdapter(orgList, getActivity());
                recyclerView.setAdapter(adapter);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public interface OnItemSelectedListener {
        void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement ListFragment.OnItemSelectedListener");
        }
    }

}
