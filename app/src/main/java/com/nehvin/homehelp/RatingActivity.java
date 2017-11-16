package com.nehvin.homehelp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    private RatingBar rBar;
    private TextView tv_serviceRatingComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        initializeVariables();
    }

    private void initializeVariables() {
        rBar = findViewById(R.id.ratingService);
        tv_serviceRatingComments = findViewById(R.id.tv_serviceRatingComments);
    }

    public void thankYouPage(View view) {
        rBar.getRating();
        Toast.makeText(getApplicationContext(), ""+rBar.getRating()+" star rating\r\n"+tv_serviceRatingComments.getText(), Toast.LENGTH_SHORT).show();
    }
}
