package com.rusangiza.jean_leman.flipnlearn;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import util.ActivitySwipeDetector;

public class Deck extends Activity {



    private TextView cardMsg;
    private Set<String> questions;
    ContentValues values = new ContentValues();
    private GestureDetectorCompat gestureDetector;
    private RelativeLayout lowestLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);
        cardMsg = (TextView) findViewById(R.id.textview1);
        ActivitySwipeDetector activitySwipeDetector = new ActivitySwipeDetector(this);
        lowestLayout = (RelativeLayout)this.findViewById(R.id.lowestLayout);
        lowestLayout.setOnTouchListener(activitySwipeDetector);
        values.put("Java", "Programming language");
        values.put("2+2", "4");
        values.put("color of the sky", "blue");
        setCardMsg(cardMsg);
        getCardMsg().setText("Swipe for question and answers");

        questions = values.keySet();

    }

    public TextView getCardMsg() {
        return cardMsg;
    }

    public void setCardMsg(TextView cardMsg) {
        this.cardMsg = cardMsg;
    }

}
