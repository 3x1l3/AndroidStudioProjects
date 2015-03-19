package com.example.exile.funfacts;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import static android.util.Log.*;


public class FunFactsMainActivity extends ActionBarActivity {
    private  FactBook factbook = new FactBook();
    private RelativeLayout rlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts_main);


        final TextView factLabel = (TextView)findViewById(R.id.factTextView);
        Button  showFactButton = (Button)findViewById(R.id.showFactButton);
        this.rlayout = (RelativeLayout)findViewById(R.id.layout);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String[] facts =

                String[] colors = {"blue","red","green","purple","orange","black","pink"};

                factLabel.setText(factbook.getFact());

                Random test = new Random();
                int color = test.nextInt(colors.length);
                Log.e("COLOR", Integer.toString(color));
                try {
                    rlayout.setBackgroundColor(Color.parseColor(colors[color]));
                } catch (Exception e) {


                }
            }
        };

        showFactButton.setOnClickListener(buttonListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fun_facts_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFactButtonPress(View view) {
    }
}
