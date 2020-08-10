package com.example.lyrical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText edtxsearch;
    ImageButton imgbtsearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxsearch = findViewById(R.id.edtxsearch);
        imgbtsearch = findViewById(R.id.imgbtsearch);



        //setting the onclicklistener for the search ImageButton
        imgbtsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating a new intent that changes the Activity and also passes the search query taken from the EditText in the searchbar
                Intent mainintent = new Intent(MainActivity.this, ResultsActivity.class);

                mainintent.putExtra("searchQuery", edtxsearch.getText().toString());
                startActivity(mainintent);

            }
        });




    }
}