package com.rusangiza.jean_leman.flipnlearn;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class instructionMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_menu);
        Button createNewCardDeck = (Button) findViewById(R.id.create_new_deck_btn);
        createNewCardDeck.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View V) {
                     startActivity(new Intent("com.rusangiza.jean_leman.flipnlearn.create_a_card_front"));
                 }
             }
        );
    }

}
