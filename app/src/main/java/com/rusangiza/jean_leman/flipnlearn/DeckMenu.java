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
    }

}
