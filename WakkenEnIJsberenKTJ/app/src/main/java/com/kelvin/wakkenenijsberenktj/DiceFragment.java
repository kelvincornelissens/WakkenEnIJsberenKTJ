package com.kelvin.wakkenenijsberenktj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Tim on 5-12-2016.
 */
public class DiceFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dice,null);




        this.view = view;

        return view;
    }


    public void setDice(int[] dice){

        ListView diceList = (ListView)view.findViewById(R.id.listViewDice);
        DiceListAdapter adapter = new DiceListAdapter(getActivity(),R.layout.dice_adapter_item,dice);
        diceList.setAdapter(adapter);

    }

}
