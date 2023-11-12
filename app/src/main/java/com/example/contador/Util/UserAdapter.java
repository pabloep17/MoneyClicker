package com.example.contador.Util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contador.R;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<UserModel> userModelList;

    public UserAdapter(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(position + 1 + "º " + userModelList.get(position).getName());
        holder.monedas.setText(userModelList.get(position).getMonedas().toString());
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView monedas;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.textUserName);
            monedas = (TextView) v.findViewById(R.id.textUserMonedas);
        }
    }

}