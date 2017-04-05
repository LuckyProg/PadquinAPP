package mx.ipn.padaquinproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Menu extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu);
		
	}

}
