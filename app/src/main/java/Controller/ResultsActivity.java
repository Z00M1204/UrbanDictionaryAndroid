package Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lyrical.R;

import java.util.ArrayList;
import java.util.List;

import Model.ApiClass;

public class ResultsActivity extends AppCompatActivity {

    public RecyclerView rvmain;
    ImageButton imgbtback;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        rvmain = findViewById(R.id.rvmain);
        imgbtback = findViewById(R.id.imgbtback);

        //getting the searchquery passed from the MainActivity class
        Intent mainintent = getIntent();
        String searchQuery = mainintent.getStringExtra("searchQuery");

        //Defining my API class, and calling my API call that gets the definitions from the API
        ApiClass apiClass = new ApiClass();
        apiClass.setListFromApiCall(searchQuery, rvmain, this);

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

    public void showErrorIllustration() {

    }



}