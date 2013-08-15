package com.delta.deltamadlibs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView mTextView;
    Button mSwitcherButton;
    String myMadLib;
    ArrayList<String> gotList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.storyText);

        myMadLib = "Two BLANK, both alike in dignity,\n" +
                "In fair BLANK, where we lay our scene,\n" +
                "From ancient break to new mutiny,\n" +
                "Where civil blood makes civil hands unclean.\n" +
                "From forth the fatal loins of these two foes\n" +
                "A pair of star-cross`d BLANK take their life;\n" +
                "Whole misadventured piteous overthrows\n" +
                "Do with their BLANK bury their parents` strife.\n" +
                "The fearful passage of their BLANK love,\n" +
                "And the continuance of their parents` rage,\n" +
                "Which, but their children`s end, nought could BLANK ,\n" +
                "Is now the BLANK hours` traffic of our stage;\n" +
                "The which if you with BLANK BLANK attend,\n" +
                "What here shall BLANK, our toil shall strive to mend.";

        Intent intent = getIntent();
        handleSentStuff(intent);

        mTextView.setText(myMadLib);

        //setup our listener onclick
        mSwitcherButton = (Button) findViewById(R.id.switchButton);
        mSwitcherButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void handleSentStuff(Intent intent){
        gotList = intent.getStringArrayListExtra("returnList");
        if(gotList != null) {
            editMadLibText();
        }
    }

    public void editMadLibText() {
        for(String gotString : gotList) {
            myMadLib.replaceFirst("BLANK", gotString);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
