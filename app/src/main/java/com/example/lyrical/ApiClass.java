package com.example.lyrical;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClass {

    OkHttpClient mainclient = new OkHttpClient();

    ResultsActivity resultsActivity = new ResultsActivity();

    ExtraLogic extraLogic = new ExtraLogic();

    public final List<ItemClass> mainlist = new ArrayList<>();



    public void setListFromApiCall(String searchQuery, final RecyclerView rvmain, final Context context, final TextView txerror, final LinearLayout lnlayouterror) {

        //creating a new stringbuilder and appending the url and then the search query so the API returns the list of definitions of the given search query
        final StringBuilder mainstrbuilder = new StringBuilder();

        mainstrbuilder.append("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=");

        mainstrbuilder.append(searchQuery);

        try {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    final Request request = new Request.Builder().url(mainstrbuilder.toString())
                            .get()
                            .addHeader("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
                            .addHeader("x-rapidapi-key", "7e94b1bcc2mshfc292ee8ce5527ap108986jsn1ec40be8b063")
                            .build();

                    try {
                        Response mainresponse = mainclient.newCall(request).execute();

                        mainclient.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                Log.e("myTag", "Failure");

                            }

                            @Override
                            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {

                                //calling the error method, in the case that the API response failing
                                if (!response.isSuccessful()) {
                                    extraLogic.setErrormsg("Sorry! Techincal issues have arisen,", txerror, lnlayouterror, rvmain);
                                }

                                if (response.isSuccessful()) {
                                    try {

                                        //getting the JSON object that holds the JSON array which i need
                                        JSONObject startobject = new JSONObject(response.body().string());

                                        JSONArray mainarray = startobject.getJSONArray("list");

                                        //for loop that goes through the the JSON array with all the definitions, gets each object, the needed data in each object, that data is then stored in a new object (aka. ItemClass in this case), then adds that new object to the main array which im going to use for the recyclerview
                                        for (int i = 0; mainarray.length() > i; i++) {
                                            JSONObject definitionobject = mainarray.getJSONObject(i);

                                            String word = definitionobject.getString("word");
                                            String definition = definitionobject.getString("definition");
                                            String example = definitionobject.getString("example");
                                            String byline = definitionobject.getString("author");
                                            String intlikes = String.valueOf(definitionobject.getInt("thumbs_up"));
                                            String intdislikes = String.valueOf(definitionobject.getInt("thumbs_down"));

                                            mainlist.add(new ItemClass(word, definition, example, byline, intlikes, intdislikes));

                                            Log.e("tag", definition);


                                        }

                                        if (mainarray.length() == 0) {
                                            extraLogic.setErrormsg("Sorry! No definitions found for that word.", txerror, lnlayouterror, rvmain);

                                        }

                                        //Setting the recyclerview adapter
                                        new Handler(Looper.getMainLooper()).post(
                                                new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        RecyclerviewAdapterClass mainadapter = new RecyclerviewAdapterClass(context, mainlist);
                                                        rvmain.setAdapter(mainadapter);
                                                    }});

                                    } catch (JSONException | IOException j) {

                                        j.printStackTrace();
                                    }
                                }
                            }

                        });



                    } catch (IOException e) {

                        e.printStackTrace();

                    }
                }

            });

            //Starting the thread used for the API call
            thread.start();

        } catch (Exception f ) {
            f.printStackTrace();

        }


    }
}
