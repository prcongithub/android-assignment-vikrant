package com.example.prashant.androidassignment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.prashant.androidassignment.com.example.model.DataModel;
import com.example.prashant.androidassignment.com.example.network.APIService;
import com.example.prashant.androidassignment.com.example.network.RestClient;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View v){
        getDataFromAPI();
    }

    private void getDataFromAPI(){
        RestClient restClient = new RestClient();
        APIService apiService = restClient.getApiService();
        apiService.getData(new Callback<List<DataModel>>() {
            @Override
            public void success(List<DataModel> dataModels, Response response) {
                Log.v("Resopnse",dataModels.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("Error",error.getMessage());
            }
        });
    }
}
