package com.kelvin.wakkenenijsberenktj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import GameClasses.Result;

/**
 * Created by Tim on 9-12-2016.
 */

public class DiceLevelFragment extends Fragment {


    DiceLevelListener listener;

    EditText editTextWakken,editTextIjsberen,editTextPinguins,editTextGoed,editTextFout;
    Button buttonAnswer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dicelevel,null);

        editTextWakken   = (EditText)view.findViewById(R.id.editTextWakken);
        editTextIjsberen = (EditText)view.findViewById(R.id.editTextIjsberen);
        editTextPinguins = (EditText)view.findViewById(R.id.editTextPinguins);
        editTextFout     = (EditText)view.findViewById(R.id.editTextFout);
        editTextGoed     = (EditText)view.findViewById(R.id.editTextGoed);

        buttonAnswer = (Button)view.findViewById(R.id.buttonAnswer);
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){

                    Result result = new Result();
                    result.setIjsberen(Integer.parseInt(editTextIjsberen.getText().toString()));
                    result.setWakken(Integer.parseInt(editTextWakken.getText().toString()));
                    result.setPinguins(Integer.parseInt(editTextPinguins.getText().toString()));

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
