package com.delta.deltamadlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

/**
 * Activity that has EditText views to enter MadLib entries and button to change text.
 *
 * Created by Kin on 8/14/13.
 */
public class SecondActivity extends Activity {

    private EditText editText0;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;

    ArrayList<String> returnList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // This is bad. Too much duplication. I tried to use an array/loop to make it cleaner, but
        // I couldn't figure out R.id.editTextX part.
        editText0 = (EditText) findViewById(R.id.editText0);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);

        Button mReturnButton = (Button) findViewById(R.id.returnButton);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToReturnList();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putStringArrayListExtra("returnList", returnList);
                startActivity(i);
                finish();
            }
        });
    }

    // NullPointerException occurs here.
    private void addToReturnList() {
        returnList.add("a " + editText0.getText().toString().trim());
        returnList.add("a " + editText1.getText().toString().trim());
        returnList.add("a " + editText2.getText().toString().trim());
        returnList.add("a " + editText3.getText().toString().trim());
        returnList.add("a " + editText4.getText().toString().trim());
        returnList.add("a " + editText5.getText().toString().trim());
        returnList.add("a " + editText6.getText().toString().trim());
        returnList.add("a " + editText7.getText().toString().trim());
        returnList.add("a " + editText8.getText().toString().trim());
        returnList.add("a " + editText9.getText().toString().trim());
        returnList.add("a " + editText10.getText().toString().trim());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

