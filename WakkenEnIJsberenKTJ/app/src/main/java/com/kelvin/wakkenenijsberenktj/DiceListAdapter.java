package com.kelvin.wakkenenijsberenktj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by Tim on 5-12-2016.
 */
public class DiceListAdapter extends ArrayAdapter<Integer> {

    private int[] dices;

    public DiceListAdapter(Context context, int resource,int[] dices) {
        super(context, resource);

        this.dices = dices;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(R.layout.dice_adapter_item,null);

        }


       ImageView imageView = (ImageView) view.findViewById(R.id.imageViewDice);


        imageView.setImageResource(R.drawable.dice1);

        return view;
    }
}
