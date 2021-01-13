package com.beatandroid.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beatandroid.recyclerviewdemo.users_generator.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    interface OnClickUser {
        void onClickUser(User user);
    }

    interface OnClickLongUser {
        void onClickLongUser(User user);
    }

    private OnClickUser onClickUser;
    private OnClickLongUser onClickLongUser;
    private List<User> users;

    public UserAdapter(List<User> users, OnClickUser onClickUser,OnClickLongUser onClickLongUser) {
        this.users = users;
        this.onClickUser = onClickUser;
        this.onClickLongUser = onClickLongUser;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent
                , false), onClickUser,onClickLongUser);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView countryTextView;
        private TextView languageTextView;
        private ImageView genderImageView;
        private ImageView workImageView;
        //
        private User user;

        public UserViewHolder(@NonNull View itemView, final OnClickUser onClickUser, final OnClickLongUser onClickLongUser) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            countryTextView = itemView.findViewById(R.id.country_text_view);
            languageTextView = itemView.findViewById(R.id.language_text_view);
            genderImageView = itemView.findViewById(R.id.gender_image_view);
            workImageView = itemView.findViewById(R.id.work_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickUser.onClickUser(user);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onClickLongUser.onClickLongUser(user);
                    return false;
                }
            });
        }

        private void bind(User user) {
            this.user = user;
            nameTextView.setText(user.getName());
            countryTextView.setText(user.getCountry());
            languageTextView.setText(user.getLanguage());
            if (user.isMale()) genderImageView.setImageResource(R.drawable.boy);
            else genderImageView.setImageResource(R.drawable.girl);
            if (user.isWorking()) workImageView.setImageResource(R.drawable.ic_baseline_work);
            else workImageView.setImageResource(R.drawable.ic_baseline_work_off);
        }
    }
}
