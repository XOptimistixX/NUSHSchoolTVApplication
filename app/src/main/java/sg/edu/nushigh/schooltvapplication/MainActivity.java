package sg.edu.nushigh.schooltvapplication;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import sg.edu.nushigh.schooltvapplication.model.Bus;
import sg.edu.nushigh.schooltvapplication.model.BusStop;

public class MainActivity extends AppCompatActivity {
	private View rootView;
	public static List<BusStop> busStops;
	public static MainActivity sReference;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sReference = this;
		setContentView(R.layout.activity_main);
		rootView = findViewById(R.id.activity_main);
		busStops = new ArrayList<>();
		Bus b188 = new Bus("188", ContextCompat.getColor(this, R.color.colorGreen));
		b188.setTimings(new String[]{"1","2","3"});
		Bus b189 = new Bus("189", ContextCompat.getColor(this, R.color.colorGreen));
		b189.setTimings(new String[]{"6","10","13"});
		Bus b196 = new Bus("196", ContextCompat.getColor(this, R.color.colorPurple));
		b196.setTimings(new String[]{"2","5","7"});
		busStops.add(new BusStop("Back gate", Arrays.asList(b188, b189, b196)));
		getSupportFragmentManager().beginTransaction().replace(R.id.replace, new BusOverviewFragment()).commit();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			rootView.setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_STABLE
							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
							| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_FULLSCREEN
							| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
	}
}
