package com.example.exile.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.exile.interactivestory.R;
import com.example.exile.interactivestory.model.Page;


public class StoryActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        Log.d("", name);


    }

}