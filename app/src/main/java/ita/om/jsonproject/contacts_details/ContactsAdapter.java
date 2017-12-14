package ita.om.jsonproject.contacts_details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ita.om.jsonproject.R;
import ita.om.jsonproject.country_module.CountryDetail;

/**
 * Created by sasmob on 12/13/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>{
       Context mContext;
       ArrayList<ContactsPerson> contactsPeople;

       public  ContactsAdapter (Context mContext, ArrayList<CountryDetail> contactsPeople){
           this.mContext=mContext;
        // this.contactsPeople= contactsPeople;
       }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view= inflater.inflate(R.layout.list_item,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ContactsPerson person= contactsPeople.get(position);
        holder.name.setText(person.getName());
        holder.email.setText(person.getEmail());


    }
    @Override
    public int getItemCount() {
    return contactsPeople.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
           private TextView name, email;

        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            email=(TextView) itemView.findViewById(R.id.email);
        }
    }
}
