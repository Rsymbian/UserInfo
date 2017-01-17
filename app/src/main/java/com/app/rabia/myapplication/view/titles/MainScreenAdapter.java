package com.app.rabia.myapplication.view.titles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.datasource.UserInfo;
import com.app.rabia.myapplication.domain.UserDataModel;
import com.app.rabia.myapplication.main.MyApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.app.rabia.myapplication.R.id.imageView;
import static com.app.rabia.myapplication.utils.Constants.IMAGE_BASE_URL;


public class MainScreenAdapter extends RecyclerView.Adapter<MainScreenAdapter.MyViewHolder> {


    private UserDataModel mData;
    private List<MainScreenItem> mList = new ArrayList<>();
    private NotifyListItemClicked listener;
    private Context mContext;

    public MainScreenAdapter(UserDataModel data, NotifyListItemClicked listener, Context context) {
        mData = data;
        this.listener = listener;
        prepareList();
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        MyApplication.getInstance().getPicasso(mContext)
                .load(IMAGE_BASE_URL + mList.get(position).getEmail() + ".png")
                .placeholder(R.drawable.image_placeholder)
                .into(holder.image);
        holder.title.setText(mList.get(position).getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.notifyListItemClicked(mList.get(position).getId());

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(imageView);
        }
    }

    private void prepareList() {
        Iterator it = mData.getAllUserInfo().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            MainScreenItem item = new MainScreenItem((Integer) pair.getKey(), ((UserInfo) pair.getValue()).getTitle(), ((UserInfo) pair.getValue()).getEmailAddress());
            mList.add(item);
            //  it.remove();
        }
    }

}
