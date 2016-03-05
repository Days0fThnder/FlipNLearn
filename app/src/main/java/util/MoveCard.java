package util;

import android.util.Log;

/**
 * Created by Jean-Leman on 3/5/2016.
 */
public class MoveCard {
    static final String logTag = "CardFlip";

    public void onRightSwipe(int current_page, Deck deck, boolean flipped) {
        Log.i(logTag, "RightToLeftSwipe!");
        if(DataStorage.getInstance().storage.get("current_page") != null)
            current_page = (int)DataStorage.getInstance().storage.get("current_page");
        if(DataStorage.getInstance().storage.get("flipped") != null)
            flipped = (boolean)DataStorage.getInstance().storage.get("flipped");
        if (current_page <= deck.getCardSize()  ) {
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
                    if(current_page == deck.getCards().size() - 1){
                        deck.getCardMsg().setText(deck.getCards().get(0).q);
                        current_page = 0;
                    }else {
                        deck.getCardMsg().setText(deck.getCards().get(current_page + 1).q);
                        current_page++;
                    }
                    flipped = false;
                }else{
                    if(current_page == deck.getCards().size() - 1) {
                        deck.getCardMsg().setText(deck.getCards().get(0).a);
                        current_page = 0;
                    }else{
                        deck.getCardMsg().setText(deck.getCards().get(current_page + 1).a);
                        current_page++;
                    }
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

    public void onLeftSwipe(int current_page, Deck deck, boolean flipped) {
        Log.i(logTag, "LeftToRightSwipe!");
        if(DataStorage.getInstance().storage.get("current_page") != null)
            current_page = (int)DataStorage.getInstance().storage.get("current_page");
        if(DataStorage.getInstance().storage.get("flipped") != null)
            flipped = (boolean)DataStorage.getInstance().storage.get("flipped");
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
        DataStorage.getInstance().storage.put("current_page", current_page);
    }
}

