package com.example.mytask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserAdapter.OnUserDeleteListener {

    private static final int ADD_USER_REQUEST_CODE = 1;
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";
    public static final String EXTRA_NUMBER = "EXTRA_NUMBER";

    private List<User> users = new ArrayList<>();
    private UserAdapter adapter;
    private TextView noUsersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noUsersTextView = findViewById(R.id.noUsersTextView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        adapter = new UserAdapter(users, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivityForResult(intent, ADD_USER_REQUEST_CODE);
        });

        updateUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_USER_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String name = data.getStringExtra(EXTRA_NAME);
                String email = data.getStringExtra(EXTRA_EMAIL);
                String number = data.getStringExtra(EXTRA_NUMBER);
                User user = new User(name, email, number);
                users.add(user);
                adapter.notifyDataSetChanged();
                updateUI();
            }
        }
    }

    private void updateUI() {
        if (users.isEmpty()) {
            noUsersTextView.setVisibility(View.VISIBLE);
        } else {
            noUsersTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onUserDelete(int position) {
        users.remove(position);
        adapter.notifyItemRemoved(position);
        updateUI();
    }
}