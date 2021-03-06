package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	
	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters
	private int mCreate;
	private int mRestart;
	private int mStart;
	private int mResume;
	
	
	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	private TextView mTvCreate;
	private TextView mTvStart;
	private TextView mTvResume;
	private TextView mTvRestart;


	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// TODO: Assign the appropriate TextViews to the TextView variables

//	 mCreate = 0;
//	 mRestart =0;
//     mCreate =0;
//	 mStart =0;
		
		
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvResume = (TextView) findViewById(R.id.resume);


		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method
				Context context = v.getContext();
				Intent intent = new Intent(context, ActivityTwo.class);
				startActivity(intent);
				// Create an intent stating which Activity you would like to start
				
				// Launch the Activity using the intent

			
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			
			 mCreate = savedInstanceState.getInt(CREATE_KEY);
			 mStart = savedInstanceState.getInt(START_KEY);
			 mResume = savedInstanceState.getInt(RESUME_KEY);
			 mRestart = savedInstanceState.getInt(RESTART_KEY);

		}
		
		mCreate++;
		Log.i(TAG, "Entered the onCreate method");
		displayCounts();

	}

	// Life cycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		mStart++;
		Log.i(TAG, "Entered the onStart method");
		  displayCounts();

		// TODO:
		// Update the appropriate count variable
		// Update the user interface


	}

	@Override
	public void onResume() {
		super.onResume();

      mResume++;
  	Log.i(TAG, "Entered the onResume method");
	  displayCounts();


	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
 		
		Log.i(TAG, "Entered the onPause method");


		
	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message\
		Log.i(TAG, "Entered the onStop method");

	}

	@Override
	public void onRestart() {
		super.onRestart();

		  mRestart++;
			Log.i(TAG, "Entered the onRestart method");
		  displayCounts();



	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the OnDestroy method");

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(RESTART_KEY , mRestart);

	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
	
//	public void onConfigurationChanged(Configuration newConfig)
//    {
//		super.onConfigurationChanged(newConfig);
//		setContentView(R.layout.activity_one);
//    }
	
}
