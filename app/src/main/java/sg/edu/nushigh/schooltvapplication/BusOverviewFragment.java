package sg.edu.nushigh.schooltvapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sg.edu.nushigh.schooltvapplication.model.BusOverviewRecyclerViewAdapter;

/**
 * Created by Jeff on 14/5/2017.
 */

public class BusOverviewFragment extends Fragment {
	private RecyclerView busOverview;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_bus_stop, container, false);

		busOverview = (RecyclerView) view.findViewById(R.id.buses);
		busOverview.setLayoutManager(new LinearLayoutManager(getContext()));
		busOverview.setAdapter(new BusOverviewRecyclerViewAdapter(MainActivity.busStops));

		return view;
	}
}
