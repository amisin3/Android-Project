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
                    .baseUrl("https://maps.googleapis.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

            //getPosts();
            //getSearch();
        getNearbyPlaces();
    }

        private void getSearch() {
            Call<List<Search>> call = jsonPlaceHolderApi
                    .getSearch("c2582c8abe4da7e745a6aab45b94335a", 19.0760, 72.8777 );

            call.enqueue(new Callback<List<Search>>() {
                @Override
                public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {

                    if (!response.isSuccessful()) {
                        textViewResult.setText("Code: " + response.code());
                        return;
                    }

                    List<Search> searches = response.body();

                    for (Search  search: searches) {
                        String content = "";
                        content += "location_suggestions: " + search.getLocation_suggestions() + "\n";
                        content += "getStatus: " + search.getStatus() + "\n";
                        content += "getHas_more: " + search.getHas_more() + "\n";
                        content += "getHas_total: " + search.getHas_total() + "\n";

                        textViewResult.append(content);
                    }
                }

                @Override
                public void onFailure(Call<List<Search>> call, Throwable t) {
                    Log.e(TAG, "I am here");
                    textViewResult.setText(t.getMessage());
                }
            });
        }

    private void getNearbyPlaces() {
        Call<List<Post>> call = jsonPlaceHolderApi
                .getNearbyPlaces("-33.8670522,151.1957362", 1500, "AIzaSyBTY2-4PnHFYYlWyyMjsYp0nU4at_BKeFs" );

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> searches = response.body();

                for (Post  search: searches) {
                    String content = "";
                    content += "htmlAttributions: " + search.getHtmlAttributions() + "\n";
                    content += "results: " + search.getResults() + "\n";
                    content += "status: " + search.getStatus() + "\n";


                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e(TAG, "I am here");
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
