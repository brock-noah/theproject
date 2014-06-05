package com.cs185.theproject;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MenuPage extends ActionBarActivity implements ActionBar.TabListener{

	private DialogFragment settingsFrag = new SettingsFragment();
	private DialogFragment helpFrag = new HelpFragment();
	public static int position = 0;
	public static int sectionNumber = 0;

	
	
	
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		 // get the listview
       
	
	// Set up the action bar.
			final ActionBar actionBar = getSupportActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

			// Create the adapter that will return a fragment for each of the three
			// primary sections of the activity.
			mSectionsPagerAdapter = new SectionsPagerAdapter(
					getSupportFragmentManager());

			// Set up the ViewPager with the sections adapter.
			mViewPager = (ViewPager) findViewById(R.id.pager);
			mViewPager.setAdapter(mSectionsPagerAdapter);

			// When swiping between different sections, select the corresponding
			// tab. We can also use ActionBar.Tab#select() to do this if we have
			// a reference to the Tab.
			mViewPager
					.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
						@Override
						public void onPageSelected(int position) {
							actionBar.setSelectedNavigationItem(position);
						}
					});

			// For each of the sections in the app, add a tab to the action bar.
			for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
				// Create a tab with text corresponding to the page title defined by
				// the adapter. Also specify this Activity object, which implements
				// the TabListener interface, as the callback (listener) for when
				// this tab is selected.
				actionBar.addTab(actionBar.newTab()
						.setText(mSectionsPagerAdapter.getPageTitle(i))
						.setTabListener(this));
			}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			System.out.println("Before newInst called:position "+position);
			return PlaceholderFragment.newInstance(position + 1);
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_food).toUpperCase(l);
			case 1:
				return getString(R.string.title_drinks).toUpperCase(l);
			}
			return null;
		}
	}
	
	public void displayCart(View view) {
		return;
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static  class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		View rootView;
	    ExpandableListAdapter mAdapter;

	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;
	    Context con;
		

		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static  PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			
			System.out.println("Section Number "+ sectionNumber);
			
			
			
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public  View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			 rootView = inflater.inflate(R.layout.fragment_menu, container,
					false);
				

			//TextView textView = (TextView) rootView.findViewById(R.id.section_label);
			//textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			return rootView;
		}
		
		@Override
	    public void onActivityCreated(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub

	        super.onActivityCreated(savedInstanceState);
	         ExpandableListView lv = (ExpandableListView) rootView.findViewById(R.id.elv);

	         //here setting all the values to Parent and child classes
	         System.out.println("sectionNum "+sectionNumber);
	         if(sectionNumber == 0)
	         { 
		      prepareListData(1);//here get the
		      sectionNumber++;
		      con=getActivity();
		         mAdapter=new ExpandableListAdapter(con,listDataHeader, listDataChild) ; //here i didnt set list values to this adoptor

		         lv.setAdapter(mAdapter);
	         }
	         else if(sectionNumber == 1)
	         {
			  prepareListData(2);//here get the
			  con=getActivity();
		         mAdapter=new ExpandableListAdapter(con,listDataHeader, listDataChild) ; //here i didnt set list values to this adoptor

		         lv.setAdapter(mAdapter);
			  
	         }
	         

		}
		private void prepareListData(int page_num) {
		
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	        
	        System.out.println("Food  "+page_num);
			if(page_num == 1)
			{
			System.out.println("Food ");
		
	        listDataHeader.add("Meals");
	        listDataHeader.add("Snacks");
	        listDataHeader.add("Candy");

	        // Adding child data
	        List<String> Meals = new ArrayList<String>();
	        Meals.add("Cheese Pizza");
	        Meals.add("Pepperoni Pizza");
	        Meals.add("Bean & Cheese Burrito");
	        Meals.add("Chick Filet");
	        Meals.add("Nachos");
	        Meals.add("Hot Dog");

	        List<String> Snacks = new ArrayList<String>();
	        Snacks.add("Chips");
	        Snacks.add("Cookie");
	        Snacks.add("Popcorn");
	        Snacks.add("Peanuts");
	        Snacks.add("Kracker Jacks");

	        List<String> Candy = new ArrayList<String>();
	        Candy.add("Twizzler");
	        Candy.add("Butterfinger");
	        Candy.add("Reeses");
	        Candy.add("Hot Tamales");
	        Candy.add("Twix");

	        listDataChild.put(listDataHeader.get(0), Meals); // Header, Child data
	        listDataChild.put(listDataHeader.get(1), Snacks);
	        listDataChild.put(listDataHeader.get(2), Candy);
			}
	        
	        if(page_num == 2)
			{
				System.out.println("Drinks ");
				
				listDataHeader.add("Beer");
		        listDataHeader.add("Soda");
		        listDataHeader.add("Other Beverages");

		        // Adding child data
		        List<String> Beer = new ArrayList<String>();
		        Beer.add("Budweiser");
		        Beer.add("Heineken");
		        Beer.add("805");
		        Beer.add("Coors Light");
		        Beer.add("Dog Fish Head");
		        Beer.add("Delirium");
		        
		        List<String> Soda = new ArrayList<String>();
		        Soda.add("Root Beer");
		        Soda.add("Coke");
		        Soda.add("Sprite");
		        Soda.add("Dr. Pepper");
		        Soda.add("Mountain Dew");
		        Soda.add("Pepsi");

		        List<String> OtherBeverages = new ArrayList<String>();
		        OtherBeverages.add("Water");
		        OtherBeverages.add("Coffee");
		        OtherBeverages.add("Milk");
		        OtherBeverages.add("Frozen Lemonade");

		        
		        listDataChild.put(listDataHeader.get(0), Beer); // Header, Child data
		        listDataChild.put(listDataHeader.get(1), Soda); // Header, Child data
		        listDataChild.put(listDataHeader.get(2), OtherBeverages);
				
			}
	    }
		
		
	}



			
}
