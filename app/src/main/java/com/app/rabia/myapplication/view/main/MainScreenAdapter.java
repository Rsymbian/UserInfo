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

    private Map<Integer, String> mTitleData;
    private List<MainScreenItem> mList = new ArrayList<>();
    private ItemClickedHandler listener;

    public MainScreenAdapter(Map<Integer, String> title, ItemClickedHandler listener) {
        mTitleData = title;
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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.title.setText(mList.get(position).getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(mList.get(position).getId());
            }
        });
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
        }
    }

    private void prepareList() {
        Iterator it = mTitleData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            MainScreenItem item = new MainScreenItem((Integer) pair.getKey(), pair.getValue().toString());
            mList.add(item);
          //  it.remove();
        }
    }

}
