package com.rusangiza.jean_leman.flipnlearn;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class DeckMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_menu);
        Button homeBtn = (Button)findViewById(R.id.home_menu_btn);
        Button deckBtn = (Button)findViewById(R.id.deck_1);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              finish();
            }
        });
        //deckBtn.setOnClickListener();
    }

}
