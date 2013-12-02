package com.easylink.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import com.easylink.android.utils.EasyLinkConstants;
import com.easylink.android.utils.EasyLinkUtils;

public class EasyLinkSplashScreen extends Activity 
{
	/**
	 * Called initially and loading of views are done here
	 * Orientation is restricted for mobile phones to protrait only and both orientations for tablet  
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		//Called initially to set the orientation to protrait only for mobiles and both for tablets
		EasyLinkUtils.setProtraitOrientationEnabled(EasyLinkSplashScreen.this);
		
		//Setting the Splashscren view to Activity
		setContentView(R.layout.easylink_xsplash_screen);
		
		//Timer to start ConfigActivity 
		startTimer();

	}

	/**
	 * Starts the next activity with a little delay
	 */
	private void startTimer()
	{
		Handler splashTimer=new Handler();
		splashTimer.postDelayed(new Runnable()
		{
			public void run()
			{
				Intent configIntent=new Intent(EasyLinkSplashScreen.this,EasyLinkConfigActivity.class);
				startActivity(configIntent);
				finish();
			}
		}, EasyLinkConstants.SPLASH_DELAY);
	}

	
	/**
	 *gets called in activity when a device is rotated  in any side..
	 *so we set the orientation based on screen size.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) 
	{
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);


		if(!(EasyLinkUtils.isScreenXLarge(getApplicationContext())))
		{
			return;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
	return true;
	}
	
	/**
	 * Ovveriding back press function to ignore the back key event when user press back while processing the Splashscreen wait thread
	 */
	@Override
	public void onBackPressed()
	{
		return;
		
	}
}
