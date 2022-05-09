package com.example.auth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessegeViewHolder> {
    List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    public MessageAdapter() {
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MessegeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_message,parent,false);
        return new MessegeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MessegeViewHolder holder, int position) {
        holder.textViewAuthor.setText(messageList.get(position).getAuthor());
        holder.textViewMessage.setText(messageList.get(position).getMessage());



    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    class MessegeViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewAuthor;
        private TextView textViewMessage;

        public MessegeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor=itemView.findViewById(R.id.textViewAthor);
            textViewMessage=itemView.findViewById(R.id.textViewmassege);
        }
    }
}
