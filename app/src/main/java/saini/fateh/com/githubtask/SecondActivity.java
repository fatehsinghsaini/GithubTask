package saini.fateh.com.githubtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fateh on 7/5/17.
 */

public class SecondActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.org_details_item);

        TextView orgName = (TextView) findViewById(R.id.name);
        TextView id = (TextView) findViewById(R.id.id);
        TextView url = (TextView) findViewById(R.id.url);
        LinearLayout orgLayout = (LinearLayout) findViewById(R.id.orgLayout);

        OrientationModel items = (OrientationModel) getIntent().getSerializableExtra("mylist");

        orgName.setText(items.getName());
       id.setText(items.getId());
        url.setText(items.getAvatar_url());




    }

}
