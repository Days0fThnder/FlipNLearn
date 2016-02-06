package com.rusangiza.jean_leman.flipnlearn;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import util.ActivitySwipeDetector;
import util.Gesture;

public class Deck extends Activity {



    private TextView cardMsg;
    private ArrayList<Question> cards = new ArrayList<Question>();
    ContentValues values = new ContentValues();
    private GestureDetectorCompat gestureDetector;
    private RelativeLayout lowestLayout;
    static final String logTag = "Deck";
    private Activity activity;
    static final int MIN_DISTANCE = 100;
    private float downX, downY, upX, upY;
    private int deckSize;
    private int cardSize;
    int current_page = 0;
    int current_card;


    class Question {
        String q;
        String a;

        Question(String q,String a) {
            this.q = q;
            this.a = a;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("current_page", current_page);
    }

    public ArrayList<Question> buildCard(){
        cards.add(new Question("Java", "Programming language"));
        cards.add(new Question("2+2", "4"));
        cards.add(new Question("color of the sky", "blue"));

        //setCardMsg(cardMsg);
        //getCardMsg().setText("Swipe for question and answers");
        return cards;

    }
    public void onRightSwipe(){
        Log.i(logTag, "RightToLeftSwipe!");
        if(current_page < deckSize ) {
            cardMsg.setText(cards.get(current_page).q);
            current_page++;
        }else{
            current_page = 0;
            cardMsg.setText(cards.get(current_page).q);
            current_page++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);
        ScrollView sv = (ScrollView) findViewById(R.id.scrollview1);
        cardMsg = (TextView) findViewById(R.id.textview1);
        ActivitySwipeDetector activitySwipeDetector = new ActivitySwipeDetector(this);
        GestureListener gl = new GestureListener();
        lowestLayout = (RelativeLayout)this.findViewById(R.id.lowestLayout);
        lowestLayout.setOnTouchListener(activitySwipeDetector);
        cards = buildCard();
        deckSize = cards.size();
        cardSize = deckSize * 2;
        getCardMsg().setText("Swipe for question and answers");

        sv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        downX = event.getX();
                        downY = event.getY();
                        return true;
                    }
                    case MotionEvent.ACTION_UP: {
                        upX = event.getX();
                        upY = event.getY();

                        float deltaX = downX - upX;
                        float deltaY = downY - upY;

                        // swipe horizontal?
                        if (Math.abs(deltaX) > Math.abs(deltaY)) {
                            if (Math.abs(deltaX) > MIN_DISTANCE) {
                                // left or right
                                if (deltaX > 0) {
                                    onRightSwipe();
                                    return true;
                                }
                                if (deltaX < 0) {
                                    //this.onLeftSwipe(); return true;
                                }
                            } else {
                                Log.i(logTag, "Horizontal Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE);
                                return false; // We don't consume the event
                            }
                        }
                        // swipe vertical?
                        else {
                            if (Math.abs(deltaY) > MIN_DISTANCE) {
                                // top or down
                                if (deltaY < 0) { /*this.onDownSwipe(); return true;*/ }
                                if (deltaY > 0) { /*this.onUpSwipe(); return true;*/ }
                            } else {
                                Log.i(logTag, "Vertical Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE);
                                return false; // We don't consume the event
                            }
                        }

                        return true;
                    }
                }
                return false;
            }
        });



    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();

            Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

            return true;

        }
    }

    public TextView getCardMsg() {
        return cardMsg;
    }

    public void setCardMsg(TextView cardMsg) {
        this.cardMsg = cardMsg;
    }

}
