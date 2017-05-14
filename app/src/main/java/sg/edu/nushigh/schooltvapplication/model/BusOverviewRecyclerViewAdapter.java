package sg.edu.nushigh.schooltvapplication.model;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nushigh.schooltvapplication.BusStopFragment;
import sg.edu.nushigh.schooltvapplication.MainActivity;
import sg.edu.nushigh.schooltvapplication.R;

/**
 * Created by Jeff on 14/5/2017.
 */

public class BusOverviewRecyclerViewAdapter extends RecyclerView.Adapter<BusOverviewRecyclerViewAdapter.BusOverviewViewHolder> {
	private List<BusStop> busStops;
	private List<BusStopTimingAdapter> busStopTimingAdapters = new ArrayList<>();
	private RecyclerView recyclerView;

	public BusOverviewRecyclerViewAdapter(List<BusStop> busStops) {
		this.busStops = busStops;
		for (int i = 0; i < busStops.size(); i++) {
			busStopTimingAdapters.add(new BusStopTimingAdapter(busStops.get(i)));
		}
		System.out.println("wew" + busStops.size());
	}

	@Override
	public BusOverviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		BusOverviewViewHolder vh =  new BusOverviewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_overview, parent, false));
		vh.busTimingsView.setLayoutManager(new LinearLayoutManager(parent.getContext(), LinearLayoutManager.HORIZONTAL, false) {
			@Override
			public boolean canScrollHorizontally() {
				return false;
			}
		});
		return vh;
	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
		this.recyclerView = recyclerView;
	}

	@Override
	public void onBindViewHolder(BusOverviewViewHolder holder, final int position) {
		holder.busStopNameView.setText(busStops.get(position).getName());
		holder.busTimingsView.setAdapter(busStopTimingAdapters.get(position));
		holder.moreButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BusStopFragment fragment = new BusStopFragment();
				Bundle bundle = new Bundle();
				bundle.putInt("bsIndex", position);
				fragment.setArguments(bundle);
				MainActivity.sReference.getSupportFragmentManager().beginTransaction().addToBackStack("shitstain").replace(R.id.replace, fragment).commit();
			}
		});
	}

	@Override
	public int getItemCount() {
		return busStops.size();
	}

	protected class BusOverviewViewHolder extends RecyclerView.ViewHolder {
		protected TextView busStopNameView;
		protected RecyclerView busTimingsView;
		protected Button moreButton;

		protected BusOverviewViewHolder(View v) {
			super(v);
			busStopNameView = (TextView) v.findViewById(R.id.bus_stop_name);
			busTimingsView = (RecyclerView) v.findViewById(R.id.bus_overview);
			moreButton = (Button) v.findViewById(R.id.more);
		}
	}

	protected class BusStopTimingAdapter extends RecyclerView.Adapter<BusStopTimingAdapter.BusStopTimingViewHolder> {
		private BusStop busStop;
		protected BusStopTimingAdapter(BusStop busStop) {
			this.busStop = busStop;
		}
		@Override
		public BusStopTimingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			BusStopTimingViewHolder vh =  new BusStopTimingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_bus1, parent, false));

			return vh;
		}

		@Override
		public void onBindViewHolder(BusStopTimingViewHolder holder, int position) {
			Bus bus = busStop.getBuses().get(position);
			holder.busTimingView.setText(bus.getTimings()[0]);
			holder.busNameView.setText(bus.getName());
			holder.busCircleView.setColorFilter(bus.getColor());
		}

		@Override
		public int getItemCount() {
			return busStop.getBuses().size();
		}

		protected class BusStopTimingViewHolder extends RecyclerView.ViewHolder {
			protected TextView busTimingView;
			protected TextView busNameView;
			protected ImageView busCircleView;
			protected BusStopTimingViewHolder(View v) {
				super(v);
				busTimingView = (TextView) v.findViewById(R.id.bus_timing);
				busNameView = (TextView) v.findViewById(R.id.bus_name);
				busCircleView = (ImageView) v.findViewById(R.id.bus_name_circle);
				View timingCircle = v.findViewById(R.id.timing_circle);
				timingCircle.setClipToOutline(true);
			}
		}
	}
}
