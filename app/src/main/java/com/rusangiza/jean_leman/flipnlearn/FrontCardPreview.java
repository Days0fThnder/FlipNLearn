package com.rusangiza.jean_leman.flipnlearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import util.Card;
import util.Deck;

/**
 * Created by j_rus on 5/30/2016.
 */
public class FrontCardPreview extends Activity{
    private TextView frontText;
    private Button cancel;
    private Button addText;
    private Deck cardDeck = new Deck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle bundle = getIntent().getExtras();
        final Intent i = new Intent(this, CreateCardBack.class);
        setContentView(R.layout.front_card_preview);

        frontText = (TextView) findViewById(R.id.preview_text);
        addText = (Button) findViewById(R.id.add_front_card_text);
        cancel = (Button) findViewById(R.id.cancel_card);

        //Bundle bundle = getIntent().getExtras();
        frontText.setText(bundle.getString("front_Card value"));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.6));
        cancel.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        addText.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //cardDeck.getCards().add(new Card(frontText.getText().toString(), null));
                //bundle.putString("_Card value", frontText.getText().toString());
                i.putExtras(bundle);
                startActivity(i);

            }
        });


    }
}
