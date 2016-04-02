package com.rusangiza.jean_leman.flipnlearn;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class DeckMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle bundle = new Bundle();
        setContentView(R.layout.activity_deck_menu);
        Button homeBtn = (Button)findViewById(R.id.home_menu_btn);
        Button deckBtn1 = (Button)findViewById(R.id.deck_1);
        Button deckBtn2 = (Button)findViewById(R.id.deck_2);
        Button deckBtn3 = (Button)findViewById(R.id.deck_3);
        Button deckBtn4 = (Button)findViewById(R.id.deck_4);
        Button deckBtn5 = (Button)findViewById(R.id.deck_5);
        Button deckBtn6 = (Button)findViewById(R.id.deck_6);
        Button deckBtn7 = (Button)findViewById(R.id.deck_7);
        Button deckBtn8 = (Button)findViewById(R.id.deck_8);
        Button deckBtn9 = (Button)findViewById(R.id.deck_9);
        Button deckBtn10 = (Button)findViewById(R.id.deck_10);
        final Intent i = new Intent(this, CardFlip.class);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        deckBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck1");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck2");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck3");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck4");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck5");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck6");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck7");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck8");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck9");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        deckBtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("deck","deck10");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

}
