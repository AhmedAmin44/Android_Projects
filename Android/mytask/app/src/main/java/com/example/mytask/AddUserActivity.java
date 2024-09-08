package com.example.mytask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

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

            if (!isValidEmail(email)) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isValidPhoneNumber(number)) {
                Toast.makeText(this, "Invalid phone number format", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra(MainActivity.EXTRA_NAME, name);
            resultIntent.putExtra(MainActivity.EXTRA_EMAIL, email);
            resultIntent.putExtra(MainActivity.EXTRA_NUMBER, number);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return Pattern.matches(emailPattern, email);
    }

    private boolean isValidPhoneNumber(String number) {
        return number.length() == 10 && number.matches("[0-9]+");
    }
}