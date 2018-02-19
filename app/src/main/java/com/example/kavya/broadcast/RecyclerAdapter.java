package com.example.kavya.broadcast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kavya.broadcast.R;
import com.example.kavya.broadcast.incomingNumber;

import java.util.ArrayList;

/**
 * Created by kavya on 2/5/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myviewholder> {
    private ArrayList<incomingNumber>arrayList=new ArrayList <>();
    public RecyclerAdapter(ArrayList<incomingNumber>arrayList)
    {
        this.arrayList=arrayList;
    }



    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        holder.ID.setText(Integer.toString(arrayList.get(position).getId()));
        holder.Number.setText(arrayList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class Myviewholder extends RecyclerView.ViewHolder {


        TextView ID,Number;
        public Myviewholder(View itemView) {
            super(itemView);
            ID=(TextView)itemView.findViewById(R.id.text);
            Number=(TextView)itemView.findViewById(R.id.textnumber);

        }
    }
}
