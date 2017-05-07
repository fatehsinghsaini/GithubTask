package saini.fateh.com.githubtask;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import saini.fateh.com.githubtask.helperClass.UriDeserializer;

/**
 * Created by fateh on 7/5/17.
 */

public class DetailsFragment extends Fragment  {

    TextView orgName,id,url,type,score,followersUrl,gistsUrl,subscriptionsUrl,organizationsUrl,reposUrl,eventsUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.org_details_item, container, false);

         orgName = (TextView) view.findViewById(R.id.name);
         id = (TextView)view. findViewById(R.id.id);
         url = (TextView)view. findViewById(R.id.url);
         type = (TextView) view.findViewById(R.id.type);
         score = (TextView)view. findViewById(R.id.score);
         followersUrl = (TextView)view. findViewById(R.id.followers_url);
         gistsUrl = (TextView) view.findViewById(R.id.gists_url);
         subscriptionsUrl = (TextView)view. findViewById(R.id.subscriptions_url);
         organizationsUrl = (TextView)view. findViewById(R.id.organizations_url);
         reposUrl = (TextView) view.findViewById(R.id.repos_url);
         eventsUrl = (TextView) view.findViewById(R.id.events_url);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Uri.class, new UriDeserializer())
                .create();

        Bundle extras = getArguments();
        String jsonMyObject = null;
        if (extras != null) {
            jsonMyObject = extras.getString(getString(R.string.bundle_name));
        }
        organisationModel items = gson.fromJson(jsonMyObject, organisationModel.class);

        if(items!=null){

            orgName.setText(items.getName());
            id.setText(items.getId());
            url.setText(items.getUrl());
            type.setText(items.getType());
            score.setText(items.getScore());
            followersUrl.setText(items.getFollowers_url());
            gistsUrl.setText(items.getGists_url());
            subscriptionsUrl.setText(items.getSubscriptions_url());
            organizationsUrl.setText(items.getOrganizations_url());
            reposUrl.setText(items.getRepos_url());
            eventsUrl.setText(items.getEvents_url());
        }

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
