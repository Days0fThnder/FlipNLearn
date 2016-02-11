package com.rusangiza.jean_leman.flipnlearn;

import android.app.Fragment;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import util.Deck;

public class CardFlip extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    static final String logTag = "CardFlip";
    int current_page = 0;
    private boolean flipped = false;
    private Deck deck = new Deck();
    static final int MIN_DISTANCE = 100;
    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("current_page", current_page);
    }


    /*public void flipCard() {
        Log.i(logTag, "flipCard");

        if (!getCardMsg().getText().equals("Swipe for question and answers")) {
            if (!flipped) {
                cardMsg.setText(cards.get(current_page).a);
                flipped = true;
            } else {
                cardMsg.setText(cards.get(current_page).q);
                flipped = false;
            }
        }
    }*/



    public void onLeftSwipe(Deck deck) {
        Log.i(logTag, "RightToLeftSwipe!");
        if (current_page > 0) {
            if (!flipped) {
                deck.getCardMsg().setText(deck.getCards().get(current_page - 1).q);
                current_page--;
            }else{
                deck.getCardMsg().setText(deck.getCards().get(current_page - 1).a);
                current_page--;
            }
        } else if (current_page == 0) {
            if(!flipped) {
                deck.getCardMsg().setText(deck.getCards().get(deck.getCards().size() - 1).q);
                current_page = deck.getCards().size() - 1;
            }else{
                deck.getCardMsg().setText(deck.getCards().get(deck.getCards().size() - 1).a);
                current_page = deck.getCards().size() - 1;;
            }
        }

    }

    /**
     * A fragment representing the front of the card.
     */
    public static class CardFrontFragment extends Fragment {
        private TextView cardTxt;
        private Deck deck = new Deck();
        private int deckSize;
        int current_page = 0;
        private boolean flipped = false;

        public CardFrontFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View cardFace = inflater.inflate(R.layout.fragment_card_front, container, false);
            cardTxt = (TextView) cardFace.findViewById(R.id.textView);
            deck.setCardMsg(cardTxt);
            deck.setCards(deck.buildCard());
            deckSize = deck.getCards().size() - 2;
            deck.setCardSize(deckSize * 2);
            deck.getCardMsg().setText("Swipe for question and answers");

            return cardFace;
        }

        public void onRightSwipe() {
            Log.i(logTag, "LeftToRightSwipe!");
            if (current_page <= deck.getDeckSize()) {
                if (deck.getCardMsg().getText().equals("Swipe for question and answers")) {
                    if (!flipped) {
                        deck.getCardMsg().setText(deck.getCards().get(current_page).q);
                        flipped = false;
                    }else{
                        deck.getCardMsg().setText(deck.getCards().get(current_page).a);
                        flipped = true;
                    }
                } else {
                    if (!flipped) {
                        deck.getCardMsg().setText(deck.getCards().get(current_page + 1).q);
                        current_page++;
                        flipped = false;
                    }else{
                        deck.getCardMsg().setText(deck.getCards().get(current_page + 1).a);
                        current_page++;
                        flipped = true;
                    }
                }

            } else {
                if(!flipped) {
                    current_page = 0;
                    deck.getCardMsg().setText(deck.getCards().get(current_page).q);
                }else{
                    current_page = 0;
                    deck.getCardMsg().setText(deck.getCards().get(current_page).a);
                }

            }
        }
    }

    /**
     * A fragment representing the back of the card.
     */
    public static class CardBackFragment extends Fragment {
        public CardBackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_back, container, false);
        }
    }
    private void flipCard() {
        if (flipped) {
            getFragmentManager().popBackStack();
            flipped = false;
            return;
        }

        // Flip to the back.

        flipped = true;

        // Create and commit a new fragment transaction that adds the fragment for
        // the back of the card, uses custom animations, and is part of the fragment
        // manager's back stack.

        getFragmentManager()
                .beginTransaction()

                        // Replace the default fragment animations with animator resources
                        // representing rotations when switching to the back of the card, as
                        // well as animator resources representing rotations when flipping
                        // back to the front (e.g. when the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)

                        // Replace any fragments currently in the container view with a
                        // fragment representing the next page (indicated by the
                        // just-incremented currentPage variable).
                .replace(R.id.container, new CardBackFragment())

                        // Add this transaction to the back stack, allowing users to press
                        // Back to get to the front of the card.
                .addToBackStack(null)

                        // Commit the transaction.
                .commit();
    }

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);

        if (savedInstanceState == null) {
            // If there is no saved instance state, add a fragment representing the
            // front of the card to this activity. If there is saved instance state,
            // this fragment will have already been added to the activity.
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new CardFrontFragment())
                    .commit();
        }

        // Monitor back stack changes to ensure the action bar shows the appropriate
        // button (either "photo" or "info").
        //getFragmentManager().addOnBackStackChangedListener(this);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);


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
        CardFrontFragment cardFrontFragment = new CardFrontFragment();
        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            if (Math.abs(velocityX) > MIN_DISTANCE) {
                // right or left
                if (velocityX < 0) {
                    cardFrontFragment.onRightSwipe();
                }
                if (velocityX > 0) {
                    //onLeftSwipe(deck);
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


}

