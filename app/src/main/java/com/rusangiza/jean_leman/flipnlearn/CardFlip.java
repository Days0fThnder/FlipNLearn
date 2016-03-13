package com.rusangiza.jean_leman.flipnlearn;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import util.DataStorage;
import util.Deck;
import util.MoveCard;

public class CardFlip extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    static final String logTag = "CardFlip";
    int current_page = 0;
    private boolean flipped = false;
    private Deck deck = new Deck();
    static final int MIN_DISTANCE = 100;
    private static CardFrontFragment cardFrontFragment;
    private static CardBackFragment cardBackFragment;
    private static String deckName;

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("current_page", current_page);
    }

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);
        Bundle bundle = getIntent().getExtras();
        deckName = bundle.getString("deck");

        if (savedInstanceState == null) {
            // If there is no saved instance state, add a fragment representing the
            // front of the card to this activity. If there is saved instance state,
            // this fragment will have already been added to the activity.
            cardFrontFragment = new CardFrontFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, cardFrontFragment, "FRONT_TAG")
                    .commit();
        } else {
            cardFrontFragment = (CardFrontFragment) getFragmentManager().findFragmentByTag("FRONT_TAG");
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

    /**
     * A fragment representing the front of the card.
     */
    public static class CardFrontFragment extends Fragment {
        private TextView cardTxt;
        private TextView deckName;
        public Deck deck = new Deck();
        public MoveCard mc = new MoveCard();
        private int deckSize;
        int current_page = 0;
        private boolean flipped = false;
        String deckId = CardFlip.deckName;

        public CardFrontFragment() {
            setRetainInstance(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View cardFace = inflater.inflate(R.layout.fragment_card_front, container, false);
            cardTxt = (TextView) cardFace.findViewById(R.id.textView);
            deckName = (TextView) cardFace.findViewById(R.id.deckId);
            Button deckMenuBtn = (Button)cardFace.findViewById(R.id.deckMenuBnt);

            deckName.setText(deckId);
            deck.setCardMsg(cardTxt);
            deck.setCards(deck.buildCard(deckId));
            deckSize = deck.getCards().size() - 2;
            deck.setCardSize(deckSize * 2);
            if(DataStorage.getInstance().storage.get("current_page") != null) {
                current_page = (int)DataStorage.getInstance().storage.get("current_page");
                if(current_page < deck.getCards().size()) {
                    deck.getCardMsg().setText(deck.getCards().get(current_page).q);
                }else{
                    current_page = 0;
                    deck.getCardMsg().setText(deck.getCards().get(current_page).q);
                }
            }
            else{
                deck.getCardMsg().setText("Swipe for question and answers");
            }
            deckMenuBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    DataStorage.getInstance().storage.clear();
                    getActivity().finish();
                }
            });
            return cardFace;
        }

        public void onRightSwipe() {
            mc.onRightSwipe(current_page, deck, flipped);
        }

        public void onLeftSwipe() {
            mc.onLeftSwipe(current_page, deck, flipped);
        }
    }

    /**
     * A fragment representing the back of the card.
     */
    public static class CardBackFragment extends Fragment {
        private TextView cardTxt;
        private TextView deckName;
        public Deck deck = new Deck();
        public MoveCard mc = new MoveCard();
        private int deckSize;
        int current_page = 0;
        private boolean flipped = false;
        String deckId = CardFlip.deckName;

        public CardBackFragment() {
            setRetainInstance(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View cardFace = inflater.inflate(R.layout.fragment_card_back, container, false);
            cardTxt = (TextView) cardFace.findViewById(R.id.answer);
            deckName = (TextView) cardFace.findViewById(R.id.deckId);
            Button deckMenuBtn = (Button)cardFace.findViewById(R.id.deckMenuBnt);

            deckName.setText(deckId);
            deck.setCardMsg(cardTxt);
            deck.setCards(deck.buildCard(deckId));
            deckSize = deck.getCards().size() - 2;
            deck.setCardSize(deckSize * 2);
            if(DataStorage.getInstance().storage.get("current_page") != null) {
                current_page = (int)DataStorage.getInstance().storage.get("current_page");
                if(current_page < deck.getCards().size()) {
                    deck.getCardMsg().setText(deck.getCards().get(current_page).a);
                }else{
                    current_page = 0;
                    deck.getCardMsg().setText(deck.getCards().get(current_page).a);
                }
            }
           deckMenuBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   DataStorage.getInstance().storage.clear();
                   getActivity().finish();
               }
           });

            return cardFace;
        }

        public void onRightSwipe() {
            mc.onRightSwipe(current_page, deck, flipped);
        }

        public void onLeftSwipe() {
            mc.onLeftSwipe(current_page, deck, flipped);
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
            DataStorage.getInstance().storage.put("flipped", flipped);
            return;
        }

        // Flip to the back.

        flipped = true;
        DataStorage.getInstance().storage.put("flipped", flipped);

        if(cardBackFragment == null){
            cardBackFragment = new CardBackFragment();
        }else if(!cardBackFragment.deckId.equals(CardFlip.deckName)){
            cardBackFragment = new CardBackFragment();
        }

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
                .replace(R.id.container, cardBackFragment)

                        // Add this transaction to the back stack, allowing users to press
                        // Back to get to the front of the card.
                .addToBackStack(null)

                        // Commit the transaction.
                .commit();
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
                    if(!flipped) {
                        getCardFrontFragment().onRightSwipe();
                    }else{
                        getCardBackFragment().onRightSwipe();
                    }
                }
                if (velocityX > 0) {
                    if(!flipped) {
                        getCardFrontFragment().onLeftSwipe();
                    }else{
                        getCardBackFragment().onLeftSwipe();
                    }
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
        if(DataStorage.getInstance().storage.get("current_page") != null)
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public CardFrontFragment getCardFrontFragment() {
        return cardFrontFragment;
    }

    public void setCardFrontFragment(CardFrontFragment cardFrontFragment) {
        this.cardFrontFragment = cardFrontFragment;
    }

    public static String getDeckName() {
        return deckName;
    }

    public static void setDeckName(String deckName) {
        CardFlip.deckName = deckName;
    }

    public static CardBackFragment getCardBackFragment() {
        return cardBackFragment;
    }

    public static void setCardBackFragment(CardBackFragment cardBackFragment) {
        CardFlip.cardBackFragment = cardBackFragment;
    }


}

