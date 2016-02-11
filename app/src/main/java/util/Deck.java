package util;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jean-Leman on 2/10/2016.
 */
public class Deck {



    private TextView cardMsg;
    private ArrayList<Card> cards = new ArrayList<>();
    private int deckSize;
    private int cardSize;


    public ArrayList<Card> buildCard () {
        cards.add(new Card("Java", "Programming language"));
        cards.add(new Card("2+2", "4"));
        cards.add(new Card("color of the sky", "blue"));
        cards.add(new Card("color of the sky2", "blue2"));
        cards.add(new Card("color of the sky3", "blue3"));
        cards.add(new Card("color of the sky4", "blue4"));
        cards.add(new Card("color of the sky5", "blue5"));

        //setCardMsg(cardMsg);
        //getCardMsg().setText("Swipe for question and answers");
        return cards;

    }

    public TextView getCardMsg() {
        return cardMsg;
    }

    public void setCardMsg(TextView cardMsg) {
        this.cardMsg = cardMsg;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public int getCardSize() {
        return cardSize;
    }

    public void setCardSize(int cardSize) {
        this.cardSize = cardSize;
    }


}
