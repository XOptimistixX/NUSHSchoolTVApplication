package sg.edu.nushigh.schooltvapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nushigh.schooltvapplication.model.Bus;
import sg.edu.nushigh.schooltvapplication.model.BusStop;
import sg.edu.nushigh.schooltvapplication.model.BusStopRecyclerViewAdapter;

/**
 * Created by Jeff on 14/5/2017.
 */

public class BusStopFragment extends Fragment {
	private RecyclerView busesView;
	private BusStop busStop;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_bus_stop, container, false);

		busStop = MainActivity.busStops.get(0);
		busesView = (RecyclerView) view.findViewById(R.id.buses);
		busesView.setLayoutManager(new LinearLayoutManager(getContext()));
		busesView.setAdapter(new BusStopRecyclerViewAdapter(busStop.getBuses()));

		return view;
	}
}
