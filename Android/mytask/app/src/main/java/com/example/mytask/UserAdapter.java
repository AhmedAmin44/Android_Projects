package com.example.mytask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> users;
    private OnUserDeleteListener onUserDeleteListener;

    public interface OnUserDeleteListener {
        void onUserDelete(int position);
    }

    public UserAdapter(List<User> users, OnUserDeleteListener onUserDeleteListener) {
        this.users = users;
        this.onUserDeleteListener = onUserDeleteListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.userName.setText(user.getName());
        holder.userEmail.setText(user.getEmail());
        holder.userNumber.setText(user.getNumber());

        holder.btnDelete.setOnClickListener(v -> {
            if (onUserDeleteListener != null) {
                onUserDeleteListener.onUserDelete(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userEmail, userNumber;
        Button btnDelete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userEmail = itemView.findViewById(R.id.userEmail);
            userNumber = itemView.findViewById(R.id.userNumber);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
