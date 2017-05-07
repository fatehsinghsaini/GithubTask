package saini.fateh.com.githubtask;

/**
 * Created by fateh on 11/3/17.
 */

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import saini.fateh.com.githubtask.helperClass.UriSerializer;


public class CustomOrgAdapter extends RecyclerView.Adapter<CustomOrgAdapter.MyViewHolder> {

    private final Context ctx;
    private List<organisationModel> orgList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView orgName;
        public LinearLayout orgLayout;

        public MyViewHolder(View view) {
            super(view);
            orgName = (TextView) view.findViewById(R.id.org_list);
            orgLayout = (LinearLayout) view.findViewById(R.id.orgLayout);


        }
    }


    public CustomOrgAdapter(ArrayList<organisationModel> orgList, Context ctx) {
        this.orgList = orgList;
        this.ctx=ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_org_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final organisationModel items = orgList.get(position);
        holder.orgName.setText(items.getName());


        holder.orgLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent=new Intent(ctx,DetailsFragment.class);
                intent.putExtra(ctx.getString(R.string.bundle_name), new Gson().toJson(items));
                ctx.startActivity(intent);*/

          /*      if((((Activity)ctx).findViewById(R.id.listFragment).isShown()))
                    ((Activity)ctx).findViewById(R.id.listFragment).setVisibility(View.GONE);*/

                Bundle bundle=new Bundle();
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Uri.class, new UriSerializer())
                        .create();
                bundle.putString(ctx.getString(R.string.bundle_name),gson.toJson(items));

                Fragment fragment = new DetailsFragment();
                fragment.setArguments(bundle);
                FragmentManager frgManager = ((Activity) ctx).getFragmentManager();
                frgManager.beginTransaction().replace(R.id.detailFragment, fragment).addToBackStack(null).commit();



            }
        });


    }

    @Override
    public int getItemCount() {
        return orgList.size();
    }
}