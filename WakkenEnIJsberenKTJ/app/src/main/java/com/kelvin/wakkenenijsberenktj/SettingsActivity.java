package com.kelvin.wakkenenijsberenktj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        editTextName = (EditText)findViewById(R.id.editTextName);






    }
}
