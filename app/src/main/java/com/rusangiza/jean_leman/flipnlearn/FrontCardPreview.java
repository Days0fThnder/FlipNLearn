package com.rusangiza.jean_leman.flipnlearn;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by j_rus on 5/30/2016.
 */
public class FrontCardPreview extends Activity{
    private TextView previewText;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.front_card_preview);
        previewText = (TextView) findViewById(R.id.preview_text);
        cancel = (Button) findViewById(R.id.cancel_card);
        Bundle bundle = getIntent().getExtras();
        previewText.setText(bundle.getString("front_Card value"));

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


    }
}
