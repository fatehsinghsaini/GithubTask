package saini.fateh.com.githubtask;

/**
 * Created by fateh on 11/3/17.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;



public class CustomOrgAdapter extends RecyclerView.Adapter<CustomOrgAdapter.MyViewHolder> {

    private final Context ctx;
    private List<OrientationModel> orgList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView orgName;
        public LinearLayout orgLayout;

        public MyViewHolder(View view) {
            super(view);
            orgName = (TextView) view.findViewById(R.id.org_list);
            orgLayout = (LinearLayout) view.findViewById(R.id.orgLayout);


        }
    }


    public CustomOrgAdapter(ArrayList<OrientationModel> orgList, Context ctx) {
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
        final OrientationModel items = orgList.get(position);
        holder.orgName.setText(items.getName());

        holder.orgLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ctx,SecondActivity.class);
                intent.putExtra(ctx.getString(R.string.bundle_name), new Gson().toJson(items));
                ctx.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return orgList.size();
    }
}