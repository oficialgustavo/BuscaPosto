package com.example.android.buscaposto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        ClickListener clickListener = new ClickListener();

        //find views and set onClick
        ImageView logoClick = (ImageView) findViewById(R.id.logoApp);
        logoClick.setOnClickListener(clickListener);
    }

    public class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.logoApp) {
                Intent intent = new Intent(MainActivity.this, ActivityInfoPosto.class);
                startActivity(intent);
            }
        }
    }
}
