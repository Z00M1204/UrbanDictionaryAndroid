package com.example.lyrical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    RecyclerView rvmain;
    ImageButton imgbtback;
    LinearLayout lnlayouterror;
    TextView txerror;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        rvmain = findViewById(R.id.rvmain);
        imgbtback = findViewById(R.id.imgbtback);
        lnlayouterror = findViewById(R.id.lnlayouterror);
        txerror = findViewById(R.id.txerror);



        //Getting the searchquery passed from the MainActivity class
        Intent mainintent = getIntent();
        String searchQuery = mainintent.getStringExtra("searchQuery");

        //Defining my API class, and calling my API call that gets the definitions from the API
        ApiClass apiClass = new ApiClass();
        apiClass.setListFromApiCall(searchQuery, rvmain, this, txerror, lnlayouterror);

        //setting the layoutmanager of the recyclerview
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvmain.setLayoutManager(layoutManager);

        //setting an onclick event for the back arrow, and then sending the user back to the MainActivity when the ImageButton is clicked
        imgbtback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, MainActivity.class));

            }
        });



    }




}