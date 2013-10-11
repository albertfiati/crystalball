package com.albertfiati.mestlessons;

import java.util.Random;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void enlightenMe(View v) {
		String[] answers = getResources().getStringArray(R.array.answers);
		Random rand = new Random();
		TextView txtAnswer = (TextView) findViewById(R.id.answer);
		txtAnswer.setText(answers[rand.nextInt(answers.length)]);
		animate();
		animateAnswer(txtAnswer);
	}
	
	private void animate(){
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.ballLayout);
		rl.setBackgroundResource(R.drawable.ball_animation);
		AnimationDrawable ballAnimation = (AnimationDrawable) rl.getBackground();
		
		if(ballAnimation.isRunning()){
			ballAnimation.stop();
		}
		
		ballAnimation.start();
	}
	
	private void animateAnswer(TextView tv){
		AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
		fadeInAnimation.setDuration(1500);
		fadeInAnimation.setFillAfter(true);
		tv.setAnimation(fadeInAnimation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
