package sg.edu.nushigh.schooltvapplication.model;

import java.util.List;

/**
 * Created by Jeff on 14/5/2017.
 */

public class BusStop {
	private String name;
	private List<Bus> buses;

	public BusStop(String name, List<Bus> buses) {
		this.name = name;
		this.buses = buses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}
}
