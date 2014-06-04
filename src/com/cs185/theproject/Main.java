package com.cs185.theproject;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Main extends ActionBarActivity {

	private DialogFragment settingsFrag = new SettingsFragment();
	private DialogFragment helpFrag = new HelpFragment();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
		Spinner spinner = (Spinner) findViewById(R.id.spinner_location);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.location_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//determine which menu was clicked
		int id = item.getItemId();
		if (id == R.id.action_settings) {
        	settingsFrag.show(getSupportFragmentManager(), "settingsFragment");
		} else if (id == R.id.action_help) {
        	helpFrag.show(getSupportFragmentManager(), "helpFragment");
		} else if (id == R.id.action_account) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void myMethod(View view){
		//MenuPage menuFrag = new MenuPage();
		Intent intent = new Intent(this, MenuPage.class);
		startActivity(intent);
	}
	
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
