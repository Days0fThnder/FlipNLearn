package com.rusangiza.jean_leman.flipnlearn;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
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

public class Deck extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    private TextView cardMsg;
    private ArrayList<Question> cards = new ArrayList<Question>();
    private RelativeLayout lowestLayout;
    static final String logTag = "Deck";
    private Gesture gesture;
    View.OnTouchListener gestureListener;
    private Activity activity;
    static final int MIN_DISTANCE = 100;
    private float downX, downY, upX, upY;
    private int deckSize;
    private int cardSize;
    int current_page = 0;
    private boolean fliped;
    int current_card;


    class Question {
        String q;
        String a;

        Question(String q, String a) {
            this.q = q;
            this.a = a;
        }
    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("current_page", current_page);
    }

    public ArrayList<Question> buildCard () {
        cards.add(new Question("Java", "Programming language"));
        cards.add(new Question("2+2", "4"));
        cards.add(new Question("color of the sky", "blue"));
        cards.add(new Question("color of the sky2", "blue2"));
        cards.add(new Question("color of the sky3", "blue3"));
        cards.add(new Question("color of the sky4", "blue4"));
        cards.add(new Question("color of the sky5", "blue5"));

        //setCardMsg(cardMsg);
        //getCardMsg().setText("Swipe for question and answers");
        return cards;

    }
    public void flipCard() {
        Log.i(logTag, "flipCard");

        if (!getCardMsg().getText().equals("Swipe for question and answers")) {
            if (!fliped) {
                cardMsg.setText(cards.get(current_page).a);
                fliped = true;
            } else {
                cardMsg.setText(cards.get(current_page).q);
                fliped = false;
            }
        }
    }

    public void onRightSwipe() {
        Log.i(logTag, "LeftToRightSwipe!");
        if (current_page <= deckSize) {
            if (getCardMsg().getText().equals("Swipe for question and answers")) {
                if (!fliped) {
                    cardMsg.setText(cards.get(current_page).q);
                    fliped = false;
                }else{
                    cardMsg.setText(cards.get(current_page).a);
                    fliped = true;
                }
            } else {
                if (!fliped) {
                    cardMsg.setText(cards.get(current_page + 1).q);
                    current_page++;
                    fliped = false;
                }else{
                    cardMsg.setText(cards.get(current_page + 1).a);
                    current_page++;
                    fliped = true;
                }
            }

        } else {
            if(!fliped) {
                current_page = 0;
                cardMsg.setText(cards.get(current_page).q);
            }else{
                current_page = 0;
                cardMsg.setText(cards.get(current_page).a);
            }

        }
    }

    public void onLeftSwipe() {
        Log.i(logTag, "RightToLeftSwipe!");
        if (current_page > 0) {
            if (!fliped) {
                cardMsg.setText(cards.get(current_page - 1).q);
                current_page--;
            }else{
                cardMsg.setText(cards.get(current_page - 1).a);
                current_page--;
            }
        } else if (current_page == 0) {
            if(!fliped) {
                cardMsg.setText(cards.get(cards.size() - 1).q);
                current_page = cards.size() - 1;
            }else{
                cardMsg.setText(cards.get(cards.size() - 1).a);
                current_page = cards.size() - 1;;
            }
        }

    }

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        cardMsg = (TextView) findViewById(R.id.textview1);
        cards = buildCard();
        deckSize = cards.size() - 2;
        cardSize = deckSize * 2;
        getCardMsg().setText("Swipe for question and answers");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.i(logTag, "onDown: " + event.toString());
        return false;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.i(logTag, "onFling: " + event1.toString() + event2.toString());
        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            if (Math.abs(velocityX) > MIN_DISTANCE) {
                // right or left
                if (velocityX < 0) {
                    onRightSwipe();
                }
                if (velocityX > 0) {
                    onLeftSwipe();
                    //this.onLeftSwipe(); return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.i(logTag, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent event, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.i(logTag, "onScroll: " + event.toString() + e2.toString());
        //onRightSwipe();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.i(logTag, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.i(logTag, "onSingleTapUp: " + event.toString());
        flipCard();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.i(logTag, "onDoubleTap: " + event.toString());
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.i(logTag, "onDoubleTapEvent: " + event.toString());
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.i(logTag, "onSingleTapConfirmed: " + event.toString());
        return false;
    }


    public TextView getCardMsg() {
        return cardMsg;
    }

    public void setCardMsg(TextView cardMsg) {
        this.cardMsg = cardMsg;
    }

}

