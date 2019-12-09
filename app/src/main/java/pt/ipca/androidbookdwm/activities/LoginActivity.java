package pt.ipca.androidbookdwm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.dialogs.AlertConfig;
import pt.ipca.androidbookdwm.dialogs.Dialogs;
import pt.ipca.androidbookdwm.interfaces.DialogsResult;
import pt.ipca.androidbookdwm.utils.Constants;

public class LoginActivity extends AppCompatActivity {

    private static final String DUMMY_EMAIL = "user@user.pt";
    private static final String DUMMY_PASSWORD = "12345";

    private EditText etEmail;
    private EditText etPassword;
    private CheckBox cbRemember;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        cbRemember = findViewById(R.id.remember);
        mainLayout = findViewById(R.id.mainLayout);
        getMyPreferences();
    }

    public void onLoginClick(View view) {
        if(!etEmail.getText().toString().equals(DUMMY_EMAIL)){
            etEmail.setError(getString(R.string.invalid_email));
            etEmail.requestFocus();
            return;
        }

        if(!etPassword.getText().toString().equals(DUMMY_PASSWORD)){
            etPassword.setError(getString(R.string.invalid_password));
            etPassword.requestFocus();
            return;
        }

        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
        //Snackbar.make(mainLayout, "Success", Snackbar.LENGTH_SHORT).show();

        //Shared preferences
        SharedPreferences prefs =
                getSharedPreferences(Constants.MyPREFERENCES,
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        if(cbRemember.isChecked()){
            editor.putString(Constants.EMAIL,
                    etEmail.getText().toString());

            editor.putString(Constants.PASSWORD,
                    etPassword.getText().toString());
        } else {
            editor.remove(Constants.EMAIL);
            editor.remove(Constants.PASSWORD);
        }

        editor.putBoolean(Constants.REMEMBER,
                cbRemember.isChecked());
        editor.apply();

        //Go to main activity
    }

    public void onForgotPassword(View view){
        AlertConfig alertConfig = new AlertConfig(
                getString(R.string.forgot_password_title),
                getString(R.string.forgot_password_message),
                getString(R.string.ok));

        Dialogs.showAlertDialog(this, alertConfig, new DialogsResult() {
            @Override
            public void onResult(boolean ok) {
                Toast.makeText(getApplicationContext(),
                        "Carreguei no ok", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCreateNewUser(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateUserActivity.class);
        startActivity(intent);
    }

    public void getMyPreferences(){
        SharedPreferences prefs =
                getSharedPreferences(Constants.MyPREFERENCES,
                        Context.MODE_PRIVATE);

        String email = prefs.
                getString(Constants.EMAIL, null);

        String password = prefs.
                getString(Constants.PASSWORD, null);

        boolean remember = prefs.
                getBoolean(Constants.REMEMBER, false);

        if(email != null && password != null){
            etEmail.setText(email);
            etPassword.setText(password);
        }

        cbRemember.setChecked(remember);
    }
}
