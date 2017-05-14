package sg.edu.nushigh.schooltvapplication.model;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nushigh.schooltvapplication.R;

/**
 * Created by Jeff on 14/5/2017.
 */

public class BusStopRecyclerViewAdapter extends RecyclerView.Adapter<BusStopRecyclerViewAdapter.BusStopViewHolder> {
	private List<Bus> buses;
	private List<BusTimingAdapter> busTimingAdapters = new ArrayList<>();

	public BusStopRecyclerViewAdapter(List<Bus> buses) {
		this.buses = buses;
		for (int i = 0; i < buses.size(); i++) {
			busTimingAdapters.add(new BusTimingAdapter(buses.get(i)));
		}
		System.out.print(busTimingAdapters.size());
	}

	@Override
	public BusStopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		BusStopViewHolder vh =  new BusStopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bus, parent, false));
		vh.busTimingsView.setLayoutManager(new LinearLayoutManager(parent.getContext(), LinearLayoutManager.HORIZONTAL, false) {
			@Override
			public boolean canScrollHorizontally() {
				return false;
			}
		});
		return vh;
	}

	@Override
	public void onBindViewHolder(BusStopViewHolder holder, int position) {
		holder.busNameView.setText(buses.get(position).getName());
		holder.busTimingsView.setAdapter(busTimingAdapters.get(position));
	}

	@Override
	public int getItemCount() {
		return buses.size();
	}

	protected class BusStopViewHolder extends RecyclerView.ViewHolder {
		protected TextView busNameView;
		protected RecyclerView busTimingsView;

		protected BusStopViewHolder(View v) {
			super(v);
			busNameView = (TextView) v.findViewById(R.id.bus_name);
			busTimingsView = (RecyclerView) v.findViewById(R.id.bus_timings);
		}
	}

	protected class BusTimingAdapter extends RecyclerView.Adapter<BusTimingAdapter.BusTimingViewHolder> {
		private Bus bus;
		protected BusTimingAdapter(Bus bus) {
			this.bus = bus;
			System.out.println(bus);
		}
		@Override
		public BusTimingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			BusTimingViewHolder vh =  new BusTimingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_bus, parent, false));

			return vh;
		}

		@Override
		public void onBindViewHolder(BusTimingViewHolder holder, int position) {
			holder.busTimingView.setText(bus.getTimings()[position]);
		}

		@Override
		public int getItemCount() {
			return bus.getTimings().length;
		}

		protected class BusTimingViewHolder extends RecyclerView.ViewHolder {
			protected TextView busTimingView;
			protected BusTimingViewHolder(View v) {
				super(v);
				busTimingView = (TextView) v.findViewById(R.id.bus_timing);
				View timingCircle = v.findViewById(R.id.timing_circle);
				timingCircle.setClipToOutline(true);
			}
		}
	}
}
