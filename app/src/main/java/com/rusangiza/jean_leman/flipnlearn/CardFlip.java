package com.rusangiza.jean_leman.flipnlearn;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
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


import util.DataStorage;
import util.Deck;

public class CardFlip extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    static final String logTag = "CardFlip";
    int current_page = 0;
    private boolean flipped = false;
    private Deck deck = new Deck();
    static final int MIN_DISTANCE = 100;
    public static CardFrontFragment cardFrontFragment;

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("current_page", current_page);
    }

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
                current_page = deck.getCards().size() - 1;
            }
        }

    }

    /**
     * A fragment representing the front of the card.
     */
    public static class CardFrontFragment extends Fragment {
        private TextView cardTxt;
        public Deck deck = new Deck();
        private int deckSize;
        int current_page = 0;
        private boolean flipped = false;

        public CardFrontFragment() {
            setRetainInstance(true);
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
            if(DataStorage.getInstance().storage.get("current_page") != null) {
                current_page = (int)DataStorage.getInstance().storage.get("current_page");
                deck.getCardMsg().setText(deck.getCards().get(current_page).q);
            }
            else{
                deck.getCardMsg().setText("Swipe for question and answers");
            }

            return cardFace;
        }

        public void onRightSwipe() {
            Log.i(logTag, "RightToLeftSwipe!");
            if(DataStorage.getInstance().storage.get("current_page") != null)
                current_page = (int)DataStorage.getInstance().storage.get("current_page");
            if (current_page <= deck.getCardSize()) {
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
            DataStorage.getInstance().storage.put("current_page", current_page);
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
            getFragmentManager().beginTransaction().
                    setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out

                    ).replace(R.id.container, getCardFrontFragment()).addToBackStack(null).commit();
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
            cardFrontFragment = new CardFrontFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, cardFrontFragment, "TEST_TAG")
                    .commit();
        } else {
            cardFrontFragment = (CardFrontFragment) getFragmentManager().findFragmentByTag("TEST_TAG");
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
        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            if (Math.abs(velocityX) > MIN_DISTANCE) {
                // right or left
                if (velocityX < 0) {
                    getCardFrontFragment().onRightSwipe();
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

    public CardFrontFragment getCardFrontFragment() {
        return cardFrontFragment;
    }

    public void setCardFrontFragment(CardFrontFragment cardFrontFragment) {
        this.cardFrontFragment = cardFrontFragment;
    }


}

