package com.kelvin.wakkenenijsberenktj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Tim on 5-12-2016.
 */
public class DiceListAdapter extends ArrayAdapter<Integer> {

    private int[] dices;

    public DiceListAdapter(Context context, int resource,ArrayList<Integer> dices) {
        super(context, resource,dices);



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.dice_adapter_item,null);

        }


       ImageView imageView = (ImageView) view.findViewById(R.id.imageViewDice);


       // imageView.setImageResource(R.drawable.dice1);


        int diceNumber = getItem(position);

        switch (getItem(position)){
            case 1:

                imageView.setImageResource(R.drawable.dice1);
                break;

            case 2:

                imageView.setImageResource(R.drawable.dice2);
                break;

            case 3:

                imageView.setImageResource(R.drawable.dice3);
                break;

            case 4:

                imageView.setImageResource(R.drawable.dice4);
                break;

            case 5:

                imageView.setImageResource(R.drawable.dice5);
                break;

            case 6:

                imageView.setImageResource(R.drawable.dice6);
                break;
        }

        return view;
    }
}
