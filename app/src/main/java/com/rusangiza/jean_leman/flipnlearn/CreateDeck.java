package com.rusangiza.jean_leman.flipnlearn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateDeck extends Activity {

    private Button createDeck;
    private Button cancel;
    private EditText deckName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle bundle = new Bundle();
        final Intent i = new Intent(this, CreateCardFront.class);
        setContentView(R.layout.activity_create_deck);
        createDeck = (Button) findViewById(R.id.create_deck);
        deckName = (EditText) findViewById(R.id.deck_name_text);
        cancel = (Button) findViewById(R.id.cancel_deck);

        createDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!deckName.getText().toString().equals("")) {
                    bundle.putString("deck_name", deckName.getText().toString());
                    i.putExtras(bundle);
                    startActivity(i);
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter and deck name";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
            }
        });

    }

}
