package com.nehvin.homehelp;

import android.util.Log;
import java.io.Serializable;

/**
 * Created by Neha on 09-Nov-17.
 */

class ServiceView implements Serializable{

    public String name;
    public String license_no;
    public String services_offered;
    public String rate_per_hr;
    public String rating;
    public String user_comments;
    public String emailid;
    public String contactno;
    public String site_add;

    private static final String TAG = ServiceView.class.getSimpleName();

    public ServiceView(String name, String license_no, String services_offered, String rate_per_hr,
                       String rating, String user_comments, String emailid, String contactno, String site_add) {
        this.name = name;
        this.license_no = license_no;
        this.services_offered = services_offered;
        this.rate_per_hr = rate_per_hr;
        this.rating = rating;
        this.user_comments = user_comments;
        this.emailid = emailid;
        this.contactno = contactno;
        this.site_add = site_add;
    }

    @Override
    public String toString() {
        Log.i(TAG, "toString:name "+name);
        Log.i(TAG, "toString:license no "+license_no);
        Log.i(TAG, "toString:services offered "+services_offered);
        Log.i(TAG, "toString:rate per hour "+rate_per_hr);
        Log.i(TAG, "toString:rating "+rating);
        Log.i(TAG, "toString:user comments "+user_comments);
        return null;
    }
}