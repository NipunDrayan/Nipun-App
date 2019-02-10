package com.example.android.endeavour;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;


/*public class Notifications extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        String message = "";
        int id = 0;

        Bundle extras = getIntent().getExtras();// get intent data
        if (extras == null) {
            // If it is null then show error
            message = "error";
        }
        else
        {
            // get id and message
            id = extras.getInt("notificationId");
            message = extras.getString("messageBody");
        }
        TextView text = (TextView) findViewById(R.id.show_notificationmessage);
        message = "Notification Id : " + id + "n Message : " + message;// Concat
        // id
        // and
        // message
        text.setText(message);// set text
        Linkify.addLinks(text, Linkify.ALL);// Linkify textview for phone
        // numbers, url ,etc.
        NotificationManager myNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // remove the notification with the specific id
        myNotificationManager.cancel(id);

    }*/
public class Notifications extends AppCompatActivity implements Response.Listener<String>
{
    final String TAG = this.getClass().getSimpleName();
    ListView list;
    public ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Notifications");
        myToolbar.setNavigationIcon(R.drawable.backspace_white);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(getApplicationContext(),EventsFrag.class));
            }
        });

        String url = "";
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading!!!");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, (Response.Listener<String>) this, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Notifications.this, "Your Connection Might Be Slow!!! Try Again After Sometime.", Toast.LENGTH_SHORT).show();

            }
        }
        );


        MySingleton.getInstance(this).addToRequestQueue(stringRequest);
        list = (ListView) findViewById(R.id.listViewf2);
        progressDialog.show();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Notifications.this,"Position"+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onResponse(String response)
    {
      /*  Log.d(TAG,response);

        ArrayList<Product> productList = new JsonConverter<Product>().toArrayList(response,Product.class);
        BindDictionary<Product> dictionary = new BindDictionary<>();
        dictionary.addStringField(R.id.title, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product item, int position)
            {
                return item.title;
            }
        });
        dictionary.addStringField(R.id.desc, new StringExtractor<Product>()
        {
            @Override
            public String getStringValue(Product item, int position)
            {


                return item.description;
            }
        });

        FunDapter<Product> adapter = new FunDapter<>(this,productList,R.layout.product,dictionary);
        list.setAdapter(adapter);
        progressDialog.dismiss();

*/
    }



}