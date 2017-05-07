package saini.fateh.com.githubtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by fateh on 7/5/17.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.org_details_item);


        TextView orgName = (TextView) findViewById(R.id.name);
        TextView id = (TextView) findViewById(R.id.id);
        TextView url = (TextView) findViewById(R.id.url);
        TextView type = (TextView) findViewById(R.id.type);
        TextView score = (TextView) findViewById(R.id.score);
        TextView followersUrl = (TextView) findViewById(R.id.followers_url);
        TextView gistsUrl = (TextView) findViewById(R.id.gists_url);
        TextView subscriptionsUrl = (TextView) findViewById(R.id.subscriptions_url);
        TextView organizationsUrl = (TextView) findViewById(R.id.organizations_url);
        TextView reposUrl = (TextView) findViewById(R.id.repos_url);
        TextView eventsUrl = (TextView) findViewById(R.id.events_url);


        Bundle extras = getIntent().getExtras();
        String jsonMyObject = null;
        if (extras != null) {
            jsonMyObject = extras.getString(getString(R.string.bundle_name));
        }
        organisationModel items = new Gson().fromJson(jsonMyObject, organisationModel.class);

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


    }

}
