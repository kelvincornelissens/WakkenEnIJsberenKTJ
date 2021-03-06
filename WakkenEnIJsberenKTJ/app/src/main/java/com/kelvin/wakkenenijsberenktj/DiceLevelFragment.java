package com.kelvin.wakkenenijsberenktj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import GameClasses.Level;
import GameClasses.Result;

/**
 * Created by Tim on 9-12-2016.
 */

public class DiceLevelFragment extends Fragment {


    DiceLevelListener listener;

    EditText editTextWakken,editTextIjsberen,editTextPinguins,editTextGoed,editTextFout;
    TextView textViewPinguins;
    Button buttonAnswer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dicelevel,null);

        Level level = (Level) getActivity().getIntent().getExtras().getSerializable("level");

        editTextWakken   = (EditText)view.findViewById(R.id.editTextWakken);
        editTextIjsberen = (EditText)view.findViewById(R.id.editTextIjsberen);
        editTextPinguins = (EditText)view.findViewById(R.id.editTextPinguins);
        textViewPinguins = (TextView)view.findViewById(R.id.textView12);




        if(!level.isPinguins()){
            editTextPinguins.setVisibility(View.INVISIBLE);
            textViewPinguins.setVisibility(View.INVISIBLE);

        }


        buttonAnswer = (Button)view.findViewById(R.id.buttonAnswer);
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){

                    if(editTextWakken.getText().toString().isEmpty()){
                        editTextWakken.setText("0");
                    }
                    if (editTextIjsberen.getText().toString().isEmpty()){
                        editTextIjsberen.setText("0");
                    }
                    if(editTextPinguins.getText().toString().isEmpty()){
                        editTextPinguins.setText("0");
                    }

                    Result result = new Result();
                    result.setIjsberen(Integer.parseInt(editTextIjsberen.getText().toString()));
                    result.setWakken(Integer.parseInt(editTextWakken.getText().toString()));

                    if(((Level)getActivity().getIntent().getExtras().getSerializable("level")).isPinguins()) {
                        result.setPinguins(Integer.parseInt(editTextPinguins.getText().toString()));
                    }
                    listener.OnAnswer(result);
                }
            }
        });

        return view;
    }


    public void setGoedEnFout(int goed, int fout){
        editTextGoed.setText(String.valueOf(goed));
        editTextFout.setText(String.valueOf(fout));

    }

    public void setDiceLevelListener(DiceLevelListener listener){
        this.listener = listener;
    }


    interface DiceLevelListener{

        void OnAnswer(Result result);

    }

}
