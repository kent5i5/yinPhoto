package com.example.yinphoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    TextView changeSignUpModeTextView;
    boolean signUpModeActive = true;
    EditText usernameEditText;
    EditText passwordEditText;

    public void signUp(View view){


        if (usernameEditText.getText().toString().matches("") && passwordEditText.getText().toString().matches("")){
            Toast.makeText(this,"Email and password is empty", Toast.LENGTH_LONG).show();
        } else {
            //set up username and password variable for the server
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        changeSignUpModeTextView = (TextView)findViewById(R.id.changeSignUpModeTextView);
        changeSignUpModeTextView.setOnClickListener(this);


        usernameEditText = (EditText)findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = (EditText) findViewById(R.id.editTextTextPassword);
        ConstraintLayout backgroundLayout = (ConstraintLayout) findViewById(R.id.backgroundLayout);

        passwordEditText.setOnKeyListener(this);
        backgroundLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.changeSignUpModeTextView){
            Button signUpButton = (Button)findViewById(R.id.signUpButton);
            if (signUpModeActive){
                signUpModeActive = false;
                signUpButton.setText("Login");
                changeSignUpModeTextView.setText("or Sign Up");
            } else {
                signUpModeActive = true;
                signUpButton.setText("Sign Up");
                changeSignUpModeTextView.setText("or Login");
            }
            Toast.makeText(this,"change mode!", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.backgroundLayout) {
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER &&  event.getAction() == KeyEvent.ACTION_DOWN ){
            signUp(v);
        }

        return false;
    }
}