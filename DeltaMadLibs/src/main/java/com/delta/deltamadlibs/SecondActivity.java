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

        // This is bad. Too much duplication. I tried to use an array/loop to make it cleaner, but
        // I couldn't figure out R.id.editTextX part.
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
//                addToReturnList();
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

//        final String tempString = editText.getText().toString().trim();
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
////                returnList.add(tempString);
//                try {
//                    //editText.setText("sdlkfjlsdkjf");
//                    //editText.append("b");
//                    returnList.add(editText.getText().toString().trim());
//                    Log.i("setupEditText", Integer.toString(returnList.size()));
//                } catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
////                returnList.add(editText.getText());
//            }
//        });
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

//    // NullPointerException occurs here.
//    private void addToReturnList() {
//        returnList.add("a " + editText0.getText().toString().trim());
//        returnList.add("a " + editText1.getText().toString().trim());
//        returnList.add("a " + editText2.getText().toString().trim());
//        returnList.add("a " + editText3.getText().toString().trim());
//        returnList.add("a " + editText4.getText().toString().trim());
//        returnList.add("a " + editText5.getText().toString().trim());
//        returnList.add("a " + editText6.getText().toString().trim());
//        returnList.add("a " + editText7.getText().toString().trim());
//        returnList.add("a " + editText8.getText().toString().trim());
//        returnList.add("a " + editText9.getText().toString().trim());
//        returnList.add("a " + editText10.getText().toString().trim());
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

