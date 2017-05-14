package sg.edu.nushigh.schooltvapplication.model;

import android.graphics.Color;

/**
 * Created by Jeff on 14/5/2017.
 */

public class Bus {
	private String name;
	private String[] timings = new String[3];
	private int color;

	public Bus(String name, int color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getTimings() {
		return timings;
	}

	public void setTimings(String[] timings) {
		this.timings = timings;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
