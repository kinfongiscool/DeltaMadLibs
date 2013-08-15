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
import java.util.Collection;

public class MainActivity extends Activity {

    TextView mTextView;
    Button mSwitcherButton;
    String myMadLib = "";
    String[] data;
    ArrayList<String> gotList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.storyText);

        data = new String[]{"Two ", "BLANK", ", both alike in dignity,\nIn fair ", "BLANK", ", wh" +
                "ere we lay our scene,\nFrom ancient break to new mutiny,\nWhere civil blood make" +
                "s civil hands unclean.\nFrom forth the fatal loins of these two foes\nApair of s" +
                "tar-cross`d ", "BLANK", " take their life;\nWhole misadventured piteous overthro" +
                "ws\nDo with their ", "BLANK", " bury their parents` strife.\nThe fearful passage" +
                " of their ", "BLANK", " love,\nAnd the continuance of their parents` rage,\nWhic" +
                "h, but their children`s end, nought could ", "BLANK", " ,\nIs now the ", "BLANK",
                " hours` traffic of our stage;\nThe which if you with ", "BLANK", " ", "BLANK", "" +
                " attend,\nWhat here shall ", "BLANK", ", our toil shall strive to mend."};

        Intent intent = getIntent();
        if (intent != null) {
            gotList = intent.getStringArrayListExtra("returnList");
            if(gotList != null) {
                editMadLibText(data);
            }
        }

        for (String string : data) {
            if(string != null) {
                myMadLib += string;
            }
        }

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

    public void editMadLibText(String[] input) {
        for(String gotString : gotList) {
            for(int i = 0; i < input.length; i++) {
                if(input[i].contains("BLANK")) {
                    input[i] = gotString;
                    break;
                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
