package com.hfad.workout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//public class WorkoutListFragment extends ListFragment {
public class WorkoutListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_workout_list, container, false);
        String[] pizzaNames = new String[Workout.workouts.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = getContext().getResources().getString(Workout.workouts[i].getName());
        }
        int[] pizzaImages = new int[Workout.workouts.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Workout.workouts[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter =
                new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        pizzaRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return pizzaRecycler;
    }
}

//        static interface Listener {
//        void itemClicked(long id);
//    };
//    private Listener listener;
//    private String test;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        String[] names = new String[Workout.workouts.length];
//        for (int i = 0; i < names.length; i++) {
//            names[i] = getContext().getResources().getString(Workout.workouts[i].getName());
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                inflater.getContext(), android.R.layout.simple_list_item_1,
//                names);
//        setListAdapter(adapter);
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//    @Override
//    //attachs fragment to activity
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        this.listener = (Listener)context;
//    }
//    @Override
//    //tells listener when an item in the list view is clicked
//    public void onListItemClick(ListView listView, View itemView, int position, long id) {
//        if (listener != null) {
//            listener.itemClicked(id);
//        }
//    }
