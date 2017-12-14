package ita.om.jsonproject.country_module;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ita.om.jsonproject.R;

/**
 * Created by sasmob on 12/13/2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
     Context mContext;
    ArrayList<CountryDetail> country_deatails;

 public  CountryAdapter (Context nContext,ArrayList<CountryDetail> country_deatails){
     this.mContext=nContext;
     this.country_deatails= country_deatails;
 }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.country_list,parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      CountryDetail country = country_deatails.get(position);
      holder.rank.setText(country.getRank());
      holder.population.setText(country.getPopulation());
        Picasso.with(mContext).load(country.getFlag()).into(holder.flag);
    }

    @Override
    public int getItemCount() {
        return country_deatails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView rank, population;
        private ImageView flag;

        public MyViewHolder(View itemView) {
            super(itemView);
            rank= (TextView) itemView.findViewById(R.id.rank);
            population=(TextView) itemView.findViewById(R.id.population);
           flag=(ImageView) itemView.findViewById(R.id.flag);
        }
    }
}
