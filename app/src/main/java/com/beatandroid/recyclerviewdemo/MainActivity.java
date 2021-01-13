package com.beatandroid.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.beatandroid.recyclerviewdemo.users_generator.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, UserAdapter.OnClickUser, UserAdapter.OnClickLongUser {
    //
    private RecyclerView recyclerView;
    //
    private List<User> users =new User().getUsers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        ((SwitchCompat) findViewById(R.id.linear_layout_switch)).setOnCheckedChangeListener(this);
        setAdapter();
    }
    private void setAdapter(){
        UserAdapter userAdapter = new UserAdapter(users,this ,this);
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (recyclerView.getAdapter() == null)return;
        if (isChecked) recyclerView.setLayoutManager(new LinearLayoutManager(this));
            else recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    public void onClickUser(User user) {
        Toast.makeText(this,String.valueOf(user.getAge()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickLongUser(User user) {
        Toast.makeText(this,user.getName(), Toast.LENGTH_SHORT).show();
    }
}