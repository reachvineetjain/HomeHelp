package com.nehvin.homehelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ServiceAdapter.ListItemClickListener {

    private RecyclerView listOfServices;
    List<ServiceView> electricalList = new ArrayList<>();
    List<ServiceView> carList = new ArrayList<>();
    List<ServiceView> homeList = new ArrayList<>();
    private ServiceAdapter mAdapter;
    private Spinner categorySpinner;
    private int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfServices = (RecyclerView) findViewById(R.id.listOfService);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listOfServices.setLayoutManager(layoutManager);
        listOfServices.setHasFixedSize(true);
        populateLists();
        mAdapter = new ServiceAdapter(this, electricalList, this);
        listOfServices.setAdapter(mAdapter);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateListView(parent,view,position,id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void updateListView(AdapterView<?> parent, View view, int position, long id)
    {
//        Log.i("Update List View", "parent: "+parent.toString());
//        Log.i("Update List View", "view: "+view.toString());
//        Log.i("Update List View", "position: "+position);
//        Log.i("Update List View", " id: "+id);

        switch (position) {
            case 0:
                mAdapter = new ServiceAdapter(this, electricalList, this);
                listOfServices.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                flag = 0;
                break;
            case 1:
                mAdapter = new ServiceAdapter(this, homeList, this);
                listOfServices.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                flag = 1;
                break;
            case 2:
                mAdapter = new ServiceAdapter(this, carList, this);
                listOfServices.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                flag = 2;
                break;
        }
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        //todo
// view individual service
//        Toast.makeText(MainActivity.this, "To be implemented", Toast.LENGTH_SHORT).show();
        ServiceView sv;
        Bundle bd = new Bundle();
        Intent dataToShow;
        switch (flag) {
            case 0:
                Log.i("electrical", "onListItemClick: "+clickedItemIndex);
                sv = electricalList.get(clickedItemIndex);
//                sv.toString();
                bd.putSerializable("dataToShow", sv);
                dataToShow = new Intent(getApplicationContext(), Main2Activity.class);
                dataToShow.putExtra("dataToShow", sv);
                startActivity(dataToShow);
                break;
            case 1:
                Log.i("home", "onListItemClick: "+clickedItemIndex);
                sv = homeList.get(clickedItemIndex);
//                sv.toString();
                bd.putSerializable("dataToShow", sv);
                dataToShow = new Intent(getApplicationContext(), Main2Activity.class);
                dataToShow.putExtra("dataToShow", sv);
                startActivity(dataToShow);
                break;
            case 2:
                Log.i("car", "onListItemClick: "+clickedItemIndex);
                sv = carList.get(clickedItemIndex);
//                sv.toString();
                bd.putSerializable("dataToShow", sv);
                dataToShow = new Intent(getApplicationContext(), Main2Activity.class);
                dataToShow.putExtra("dataToShow", sv);
                startActivity(dataToShow);
                break;
            default:
                Log.i("do nothing ","onListItemClick: ");
        }
   }


    public void populateLists()
    {

// electrical list
        electricalList.add(new ServiceView("Gala Electrical", "GSTN1234",
                "All kinds of electrical services from repairing of Air conditioners, " +
                        "bulbs, lights, fans etc", "$12/hr", "3", "comment 1, " +
                "comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Sidhi Electrical", "7890ABCL",
                "Any of the following Air conditioners, bulbs, lights, " +
                        "fans etc for repairing and servicing", "$15/hr", "4",
                "good, excellent service, nice", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Vineet Handyman", null,
                "All of the following for repairing and servicing Air conditioners, " +
                        "bulbs, lights, fans etc ", "$15/hr", "2.5",
                "fairly newly started service", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Sai Electrical", null,
                "All of the following for repairing and servicing Air conditioners, " +
                        "bulbs, lights, fans etc ", "$15/hr", "2.5",
                "fairly newly started service", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Kripa Electrical", null,
                "All of the following for repairing and servicing Air conditioners, " +
                        "bulbs, lights, fans etc ", "$15/hr", "2.5",
                "fairly newly started service", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Croma Electrical", null,
                "All of the following for repairing and servicing Air conditioners, " +
                        "bulbs, lights, fans etc ", "$15/hr", "2.5",
                "fairly newly started service", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Shivam Electrical", null,
                "All of the following for repairing and servicing Air conditioners, " +
                        "bulbs, lights, fans etc ", "$15/hr", "2.5",
                "fairly newly started service", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Mahavir Electrical", null,
                "All of the following for repairing and servicing Air conditioners, " +
                        "bulbs, lights, fans etc ", "$15/hr", "2.5",
                "fairly newly started service", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        electricalList.add(new ServiceView("Mahalaxmi Electrical", null,
                "All of the following for repairing and servicing Air conditioners, " +
                        "bulbs, lights, fans etc ", "$15/hr", "2.5",
                "fairly newly started service", "abcl@abcl.com", "+91-1234567890", "abc.com"));
// car list
        carList.add(new ServiceView("Harpreet Singh Auto Services", "GT521QWE",
                "All kinds and make of cars serviced at our garage, " +
                        "brakes, general service, lights air conditioning etc", "available " +
                "on request", "3.5",
                "takes good car of the car, no issues after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        carList.add(new ServiceView("Sai Auto Services", "LJDS9274LJD",
                "All kinds of car maintenance including denting and painting done, " +
                        "On delivery car will be look like a showroom piece", "available " +
                "on per job basis", "4.5", "takes good car of the car, no issues " +
                "after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        carList.add(new ServiceView("AutoShine Services", "LJDS9274LJD",
                "All kinds of car maintenance including denting and painting done, " +
                        "On delivery car will be look like a showroom piece", "available " +
                "on per job basis", "4.5", "takes good car of the car, no issues " +
                "after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        carList.add(new ServiceView("SB Car Cool Services", "LJDS9274LJD",
                "All kinds of car maintenance including denting and painting done, " +
                        "On delivery car will be look like a showroom piece", "available " +
                "on per job basis", "4.5", "takes good car of the car, no issues " +
                "after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        carList.add(new ServiceView("Shree Krishna Services", "LJDS9274LJD",
                "All kinds of car maintenance including denting and painting done, " +
                        "On delivery car will be look like a showroom piece", "available " +
                "on per job basis", "4.5", "takes good car of the car, no issues " +
                "after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        carList.add(new ServiceView("Eco Green Services", "LJDS9274LJD",
                "All kinds of car maintenance including denting and painting done, " +
                        "On delivery car will be look like a showroom piece", "available " +
                "on per job basis", "4.5", "takes good car of the car, no issues " +
                "after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        carList.add(new ServiceView("Rally Team Car Services", "LJDS9274LJD",
                "All kinds of car maintenance including denting and painting done, " +
                        "On delivery car will be look like a showroom piece", "available " +
                "on per job basis", "4.5", "takes good car of the car, no issues " +
                "after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        carList.add(new ServiceView("Zero Pollution Services", "LJDS9274LJD",
                "All kinds of car maintenance including denting and painting done, " +
                        "On delivery car will be look like a showroom piece", "available " +
                "on per job basis", "4.5", "takes good car of the car, no issues " +
                "after service, good work", "abcl@abcl.com", "+91-1234567890", "abc.com"));
// home list
        homeList.add(new ServiceView("Shreeji Home Services", "OIWEU9872UZ",
                "Complete house cleaning solutions , " +
                        "specialist in Diwali cleaning", "$10/hr", "3",
                "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("Mamta Home Cleaning", "OIWEU9872UZ",
                "Specialist in home cleaning and window cleaning from the inside and outside , " ,
                         "$25/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("Climate Cool Services", "OIWEU9872UZ",
                "Air conditioner services, " +
                        "Split as well as window or ceiling AC",
                "$10/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("Vora Interiors ", "OIWEU9872UZ",
                "Interior upholstery cleaning using mild shampoo , " +
                        "and other cleaning agents. Will also touch up lacquer and give the wood a new finish",
                "$10/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("Mukesh Carpenter", "OIWEU9872UZ",
                "Carpentry services " +
                        "for all your wood work and cabinet needs",
                "$10/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("My Home Maker Services", "OIWEU9872UZ",
                "Interior upholstery cleaning using mild shampoo , " +
                        "and other cleaning agents. Will also touch up lacquer and give the wood a new finish",
                "$10/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("Shree Krishna Services", "OIWEU9872UZ",
                "Interior upholstery cleaning using mild shampoo , " +
                        "and other cleaning agents. Will also touch up lacquer and give the wood a new finish",
                "$10/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("Home Clean Services", "OIWEU9872UZ",
                "Interior upholstery cleaning using mild shampoo , " +
                        "and other cleaning agents. Will also touch up lacquer and give the wood a new finish",
                "$10/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
        homeList.add(new ServiceView("Clean Home Services", "OIWEU9872UZ",
                "Interior upholstery cleaning using mild shampoo , " +
                        "and other cleaning agents. Will also touch up lacquer and give the wood a new finish",
                "$10/hr", "3", "comment 1, comment 2, comment 3", "abcl@abcl.com", "+91-1234567890", "abc.com"));
    }
}
