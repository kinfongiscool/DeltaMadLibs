package com.delta.deltamadlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    ArrayList<String> returnList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setupEditText(R.id.editText0);
        setupEditText(R.id.editText1);
        setupEditText(R.id.editText2);
        setupEditText(R.id.editText3);
        setupEditText(R.id.editText4);
        setupEditText(R.id.editText5);
        setupEditText(R.id.editText6);
        setupEditText(R.id.editText7);
        setupEditText(R.id.editText8);
        setupEditText(R.id.editText9);

        Button mReturnButton = (Button) findViewById(R.id.returnButton);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                populateReturnList();
                i.putStringArrayListExtra("returnList", returnList);
                startActivity(i);
                finish();
            }
        });
    }
    private static EditText editText;
    private void setupEditText(int id) {
        editText = (EditText)findViewById(id);
    }

    public void populateReturnList() {
        returnList.add(((EditText)findViewById(R.id.editText0)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText1)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText2)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText3)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText4)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText5)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText6)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText7)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText8)).getText().toString());
        returnList.add(((EditText)findViewById(R.id.editText9)).getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

