package com.example.mytask;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        EditText editName = findViewById(R.id.editName);
        EditText editEmail = findViewById(R.id.editEmail);
        EditText editNumber = findViewById(R.id.editNumber);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();
            String number = editNumber.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra(MainActivity.EXTRA_NAME, name);
            resultIntent.putExtra(MainActivity.EXTRA_EMAIL, email);
            resultIntent.putExtra(MainActivity.EXTRA_NUMBER, number);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}

