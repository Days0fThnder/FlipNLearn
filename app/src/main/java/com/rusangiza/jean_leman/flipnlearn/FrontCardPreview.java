package com.rusangiza.jean_leman.flipnlearn;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by j_rus on 5/30/2016.
 */
public class FrontCardPreview extends Activity{
    private TextView previewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.front_card_preview);
        previewText = (TextView) findViewById(R.id.preview_text);
        Bundle bundle = getIntent().getExtras();
        previewText.setText(bundle.getString("front_Card value"));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.6));

    }
}
