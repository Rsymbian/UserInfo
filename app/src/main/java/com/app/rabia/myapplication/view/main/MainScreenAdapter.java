package com.app.rabia.myapplication.view.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.rabia.myapplication.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MainScreenAdapter extends RecyclerView.Adapter<MainScreenAdapter.MyViewHolder> {

    private Map<Integer, String> mData;
    private List<String> mList = new ArrayList<>();
    private ItemClickedHandler listener;

    public MainScreenAdapter(Map<Integer, String> titleList, ItemClickedHandler listener) {
        mData = titleList;
        this.listener = listener;
        prepareList();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mList.get(position));
        holder.title.setId(getIdFromMap(mList.get(position)));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(title.getId());
                }
            });
        }
    }

    private int getIdFromMap(String value) {
        Iterator it = mData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getValue().toString().equals(value)) {
                return (int) pair.getKey();

            }
        }
        return -1;
    }

    private void prepareList() {
        Iterator it = mData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            mList.add(pair.getValue().toString());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

}
