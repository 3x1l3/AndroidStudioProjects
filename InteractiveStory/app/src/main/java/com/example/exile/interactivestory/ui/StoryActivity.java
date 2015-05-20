package com.example.exile.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exile.interactivestory.R;
import com.example.exile.interactivestory.model.Page;
import com.example.exile.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView  mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        Log.d("", mName);

        mImageView = (ImageView)findViewById(R.id.imageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int index) {
        mPage = mStory.getPage(index);
        mImageView.setImageDrawable(getResources().getDrawable(mPage.getImageId()));

        String pageText = mPage.getText();

        pageText = String.format(pageText,mName);

        mTextView.setText(pageText);

         if (mPage.isFinal()) {
             mChoice1.setVisibility(View.INVISIBLE);
             mChoice2.setText("Play Again");

             mChoice2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                    finish();
                 }
             });

         } else {
             mChoice1.setText(mPage.getChoice1().getText());
             mChoice2.setText(mPage.getChoice2().getText());


             mChoice1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int nextPage = mPage.getChoice1().getNextPage();
                     loadPage(nextPage);
                 }
             });
             mChoice2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int nextPage = mPage.getChoice2().getNextPage();
                     loadPage(nextPage);
                 }
             });
         }


    }

}