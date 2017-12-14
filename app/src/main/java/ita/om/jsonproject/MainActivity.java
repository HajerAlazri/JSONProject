package ita.om.jsonproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ita.om.jsonproject.country_module.CountryAdapter;
import ita.om.jsonproject.country_module.CountryDetail;

public class MainActivity extends AppCompatActivity {
  //  private static final  String JSONObjectURL="https://api.androidhive.info/contacts/";
  private  static final String  JSONObject2URL= " http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    public RequestQueue queue;
    public JsonObjectRequest objectRequest;
    //public ArrayList<ContactsPerson> contactsPeople;
//    public static final String CONTACTS=  "contacts";
//    public static final String ID="id";
//    public static final String NAME="name";
//    public static final String EMAIL="email";
//    public static final String ADDRESS= "address";
//    public static final String GENDER="gender";
//    public static final String PHONE="phone";
//    public static final String PHONE_MOBILE= "mobile";
//    public static final String PHONE_HOME="home";
//    public static final String PHONE_OFFICE="office";

    public ArrayList<CountryDetail> country_deatails;
    public static final String WORLDPOPULATION=  "worldpopulation";
    public static final String RANK="rank";
    public static final String POPULATION="population";
    public static final String FLAG="flag";

    RecyclerView recycler;
   CountryAdapter countryAdapter;
   CountryDetail country;
//    ContactsAdapter contactsAdapter;
//    ContactsPerson person;

    // public JsonArrayRequest arrayRequest;
   // public StringRequest stringRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler= findViewById(R.id.recycler);

        country_deatails= new ArrayList<>();
        queue= Volley.newRequestQueue(this);
        objectRequest=new JsonObjectRequest(Request.Method.GET, JSONObject2URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray worldpopulation= response.getJSONArray(WORLDPOPULATION);

                    Log.d("response:--->", worldpopulation.toString());
                    for (int i=0; i<worldpopulation.length(); i++){
                        JSONObject obj= worldpopulation.getJSONObject(i);
                        String rank= obj.getString(RANK);
                        String population= obj.getString(POPULATION);
                        String flag= obj.getString(FLAG);
                        country= new CountryDetail();
                        country.setRank(rank);
                        country.setPopulation(population);
                        country.setFlag(flag);
                        country_deatails.add(country);
                        Log.d("all the data", rank+ population+flag);
//                        String id= obj.getString(ID);
//                        String name= obj.getString(NAME);
//                        String email= obj.getString(EMAIL);
//                        String address= obj.getString(ADDRESS);
//                        String gender= obj.getString(GENDER);
//                        JSONObject phone= obj.getJSONObject(PHONE);
//                        String mobile= phone.getString(PHONE_MOBILE);
//                        String home= phone.getString(PHONE_HOME);
//                        String office= phone.getString(PHONE_OFFICE);
//                        person= new ContactsPerson();
//                        person.setId(id);
//                        person.setName(name);
//                        person.setEmail(email);
//                        person.setAddress(address);
//                        person.setGender(gender);
//                        person.setPhone_home(home);
//                        person.setPhone_mobile(mobile);
//                        person.setPhone_office(office);
//                        contactsPeople.add(person);
                        //    Log.d("all the data", id+ name+email+address+gender+phone+mobile+home+office);
                    }
                    setAdapter(country_deatails);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("reason error", error.getMessage());
            }
        });
        queue.add(objectRequest);



        }
    public  void setAdapter(ArrayList<CountryDetail> country_deatails){
        this.country_deatails=country_deatails;
        countryAdapter= new CountryAdapter(this,country_deatails);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(countryAdapter);
        countryAdapter.notifyDataSetChanged();

    }
}
