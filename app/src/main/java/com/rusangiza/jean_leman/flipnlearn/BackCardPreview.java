package com.rusangiza.jean_leman.flipnlearn;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import util.Card;
import util.Deck;

/**
 * Created by j_rus on 5/30/2016.
 */
public class BackCardPreview extends Activity{
    private TextView backText;
    private Button cancel;
    private Button addText;
    private Deck cardDeck = new Deck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.back_card_preview);
        backText = (TextView) findViewById(R.id.preview_back_text);
        addText = (Button) findViewById(R.id.add_back_card_text);
        cancel = (Button) findViewById(R.id.cancel_back_card);

        Bundle bundle = getIntent().getExtras();
        backText.setText(bundle.getString("back_Card value"));

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

            }
        });


    }
}
