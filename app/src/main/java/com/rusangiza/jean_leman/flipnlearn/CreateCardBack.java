package com.rusangiza.jean_leman.flipnlearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateCardBack extends Activity {
    private EditText back_card_input;
    private TextView card_back;
    private Button add_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle bundle = getIntent().getExtras();
        final Intent i = new Intent(this, BackCardPreview.class);
        setContentView(R.layout.activity_create_a_card_back);
        back_card_input = (EditText) findViewById(R.id.back_text_input);
        card_back = (TextView) findViewById(R.id.back_of_card);
        add_text = (Button) findViewById(R.id.add_back_text);

        if(add_text != null) {
            add_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!back_card_input.getText().toString().equals("")) {
                        bundle.putString("back_Card value", back_card_input.getText().toString());
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                }
            });
        }


    }

}
