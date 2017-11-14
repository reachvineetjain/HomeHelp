package com.nehvin.homehelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.StringTokenizer;

public class ServiceDetails extends AppCompatActivity {

    ServiceView sv;
    private TextView service_name;
    private TextView license_no;
    private TextView emailid;
    private TextView phoneno;
    private TextView site_add;
    private TextView rate_per_hour;
    private TextView services_offered;
    private RatingBar ratingBar;
    private TextView comments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_details);

        initializeVariables();

        Intent dataToShow = this.getIntent();
        Bundle serviceBundle = dataToShow.getExtras();
        sv = (ServiceView) serviceBundle.get("dataToShow");
        service_name.setText(sv.getName());
        license_no.setText(sv.getLicense_no());
        emailid.setText(sv.getEmailid());
        phoneno.setText(sv.getContactno());
        services_offered.setText(sv.getServices_offered());
        rate_per_hour.setText(sv.getRate_per_hr());
        site_add.setText("http://"+sv.getSite_add());
        ratingBar.setRating(Float.parseFloat(sv.getRating()));
        ratingBar.setIsIndicator(true);

        StringTokenizer comment = new StringTokenizer(sv.getUser_comments(),",");
        while (comment.hasMoreTokens()) {
            comments.setText(comments.getText()+comment.nextToken()+"\r\n\r\n");
        }
    }


    private void initializeVariables(){
        service_name = (TextView) findViewById(R.id.tv_service_name);
        license_no = (TextView) findViewById(R.id.tv_license);
        emailid = (TextView) findViewById(R.id.tv_emailid);
        phoneno = (TextView) findViewById(R.id.tv_phone_no);
        site_add = (TextView) findViewById(R.id.tv_site_add);
        rate_per_hour =  (TextView) findViewById(R.id.tv_rate_per_hour);
        services_offered = (TextView) findViewById(R.id.tv_service_offered);
        ratingBar = (RatingBar) findViewById(R.id.rb_ratingBar);
        comments = (TextView) findViewById(R.id.tv_comments);
    }

    public void scheduleAppt(View view) {
        Intent intToSchedule = new Intent(getApplicationContext(), ScheduleService.class );
        startActivity(intToSchedule);
    }

    public void goBack(View view) {
        onBackPressed();
    }
}