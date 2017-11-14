package com.nehvin.homehelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.fourmob.datetimepicker.date.DatePickerDialog.OnDateSetListener;
import com.sleepbot.datetimepicker.time.RadialPickerLayout;
import com.sleepbot.datetimepicker.time.TimePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ScheduleService extends FragmentActivity implements OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";
    private TextView dateTextView;
    private TextView timeTextView;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
    SimpleDateFormat stf = new SimpleDateFormat("HH:mm", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_service);

        dateTextView = (TextView)findViewById(R.id.tv_date);
        dateTextView.setText(sdf.format(new Date()));
        timeTextView = (TextView)findViewById(R.id.tv_time);
        timeTextView.setText(stf.format(new Date()));

        final Calendar calendar = Calendar.getInstance();

        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                true);
        final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(this,
                calendar.get(Calendar.HOUR_OF_DAY) ,calendar.get(Calendar.MINUTE), false,
                false);

        findViewById(R.id.btn_date).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                datePickerDialog.setVibrate(false);
                datePickerDialog.setYearRange(calendar.get(Calendar.YEAR), (calendar.get(Calendar.YEAR))+1);
                datePickerDialog.setCloseOnSingleTapDay(false);
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
            }
        });

        findViewById(R.id.btn_time).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.setVibrate(false);
                timePickerDialog.setStartTime(calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
                timePickerDialog.setCloseOnSingleTapMinute(false);
                timePickerDialog.show(getSupportFragmentManager(), TIMEPICKER_TAG);
            }
        });

        if (savedInstanceState != null) {
            DatePickerDialog dpd = (DatePickerDialog) getSupportFragmentManager().findFragmentByTag(DATEPICKER_TAG);
            if (dpd != null) {
                dpd.setOnDateSetListener(this);
            }

            TimePickerDialog tpd = (TimePickerDialog) getSupportFragmentManager().findFragmentByTag(TIMEPICKER_TAG);
            if (tpd != null) {
                tpd.setOnTimeSetListener(this);
            }
        }
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
//        Toast.makeText(ScheduleService.this, "new date:" + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);
        dateTextView.setText(sdf.format(new Date(calendar.getTimeInMillis())));
    }


    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
//        Toast.makeText(ScheduleService.this, "new time:" + hourOfDay + "-" + minute, Toast.LENGTH_LONG).show();
        timeTextView.setText(hourOfDay+" : "+minute);
    }

    public void payment_page(View view) {
//        Toast.makeText(this, "go to payment page", Toast.LENGTH_SHORT).show();
        Intent payment_intent = new Intent(this, PaymentActivity.class);
        startActivity(payment_intent);
    }

    public void goBack(View view) {
        onBackPressed();
    }
}
