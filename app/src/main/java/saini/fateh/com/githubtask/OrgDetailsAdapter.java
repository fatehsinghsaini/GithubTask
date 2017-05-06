package saini.fateh.com.githubtask;

/**
 * Created by fateh on 11/3/17.
 */

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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



            orgLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



/*
                        if (drawer.isDrawerOpen(GravityCompat.START)) {
                            drawer.closeDrawer(GravityCompat.START);
                    }

                    int position=getAdapterPosition();

                    System.out.println("product item click"+orgList.get(position).getItemId());
                    Bundle bundle=new Bundle();
                    bundle.putString("brand_id",orgList.get(position).getItemId());
                    bundle.putString("latest_products_rb","0");
                    bundle.putString("product_name",orgList.get(position).getItemName());

                    FrameLayout frameLayout = (FrameLayout) ((Activity) ctx).findViewById(R.id.outer_frame);
                    frameLayout.setVisibility(View.VISIBLE);
                    Fragment fragment = new LatestProducts();
                    fragment.setArguments(bundle);
                    FragmentManager frgManager = ((Activity) ctx).getFragmentManager();
                    frgManager.beginTransaction().replace(R.id.outer_frame, fragment).commit()*/;
                }
            });



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
        OrientationModel items = orgList.get(position);
        holder.orgName.setText(items.getName());
       // holder.drawer_icon.setImageResource(items.getItemId());
        //view.getResources().getDrawable(dItem.getItemId()

    }

    @Override
    public int getItemCount() {
        return orgList.size();
    }
}