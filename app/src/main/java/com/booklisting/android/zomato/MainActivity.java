package com.booklisting.android.zomato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private static final String TAG = "MyActivity";

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            textViewResult = findViewById(R.id.text_view_result);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://developers.zomato.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


            getSearch();

    }

        private void getSearch() {
            Call<Post> call = jsonPlaceHolderApi
                    .getSearch(19.0760, 72.8777 );

            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {

                    if (!response.isSuccessful()) {
                        textViewResult.setText("Code: " + response.code());
                        return;
                    }

                    Post searches = response.body();


                    String content = "";


                    
                    content += "location_suggestions: " + searches.getLocationSuggestions() + "\n";
                    content += "getStatus: " + searches.getStatus() + "\n";
                    content += "getHas_more: " + searches.getHasMore() + "\n";
                    content += "getHas_total: " + searches.getHasTotal() + "\n";
                    textViewResult.append(content);



                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {
                    Log.e(TAG, "I am here");
                    textViewResult.setText(t.getMessage());
                }
            });
        }

}
