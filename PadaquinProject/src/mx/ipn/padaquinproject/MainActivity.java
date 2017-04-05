package mx.ipn.padaquinproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText nameEditText;
    private EditText passEditText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // Address the email and password field
        nameEditText = (EditText) findViewById(R.id.username);
        passEditText = (EditText) findViewById(R.id.password);
    }

    public void checkLogin(View arg0) {

        final String name = nameEditText.getText().toString();
        if (!isValidName(name)) {
            //Set error message for email field
            nameEditText.setError("Username cannot be empty");
        }

        final String pass = passEditText.getText().toString();
        if (!isValidPassword(pass)) {
            //Set error message for password field
            passEditText.setError("Password cannot be empty");
        }

        if(isValidName(name) && isValidPassword(pass))
        {
        	
        	intent = new Intent(this, Inicio.class);
        	this.startActivity(intent);
        	finish();
        }

    }

    // validating email id
    private boolean isValidName(String name) {
    	if (name != null && name.length() >= 4) {
            return true;
        }
        return false;
    }

    // validating password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 4) {
            return true;
        }
        return false;
    }
}
