package pt.ipca.androidbookdwm.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.utils.Utils;

public class CreateUserActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText firstName, lastName, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        toolbar = findViewById(R.id.toolbar);
        setUpToolbar();
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
    }

    void setUpToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                //onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onCreateUserClick(View view){

        if(TextUtils.isEmpty(firstName.getText())){
            firstName.setError(getString(R.string.field_required));
            firstName.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(lastName.getText())){
            lastName.setError(getString(R.string.field_required));
            lastName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email.getText())) {
            email.setError(getString(R.string.field_required));
            email.requestFocus();
            return;
        }

        if (!Utils.isEmailValid(email.getText().toString())) {
            email.setError(getString(R.string.invalid_email));
            email.requestFocus();
            return;
        }

        if (!TextUtils.isEmpty(password.getText())
                && !Utils.isPasswordValid(password.getText().toString())) {
            password.setError(getString(R.string.invalid_password));
            password.requestFocus();
            return;
        }

        if (!TextUtils.isEmpty(confirmPassword.getText())
                && !Utils.isPasswordValid(confirmPassword.getText().toString())) {
            confirmPassword.setError(getString(R.string.invalid_password));
            confirmPassword.requestFocus();
            return;
        }

        if(!confirmPassword.getText().toString().equals(password.getText().toString())){
            confirmPassword.setError(getString(R.string.password_do_not_match));
            confirmPassword.requestFocus();
            return;
        }

        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
    }
}
