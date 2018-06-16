package com.chernowii.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.chernowii.retrofitexample.ApiSections.PebbleApp;
import com.chernowii.retrofitexample.ApiSections.PebbleList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<PebbleList> call = apiInterface.CategoryRemotes();
        call.enqueue(new Callback<PebbleList>() {
            @Override
            public void onResponse(Call<PebbleList> call, Response<PebbleList> response) {
                PebbleList resource = response.body();
                for (PebbleApp app: resource.data){
                    Log.d("Appl", app.name);
                }
            }

            @Override
            public void onFailure(Call<PebbleList> call, Throwable t) {

            }
        });
        Call<PebbleList> AppId = apiInterface.getAppDetail("5845742a00355af16100035d");
        AppId.enqueue(new Callback<PebbleList>() {
            @Override
            public void onResponse(Call<PebbleList> call, Response<PebbleList> response) {
                Log.d("App",response.body().data.toString());
                PebbleList resource = response.body();
                for(PebbleApp app : resource.data){
                    Log.d("AppWeb",app.website);

                }
            }

            @Override
            public void onFailure(Call<PebbleList> call, Throwable t) {
                Log.d("App","Failure",t);
            }
        });
    }
}
