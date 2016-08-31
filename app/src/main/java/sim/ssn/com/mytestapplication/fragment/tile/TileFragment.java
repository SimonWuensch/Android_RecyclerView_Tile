package sim.ssn.com.mytestapplication.fragment.tile;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sim.ssn.com.mytestapplication.R;
import sim.ssn.com.mytestapplication.helper.DragAndDropHelper;
import sim.ssn.com.mytestapplication.helper.DragAndDropHelperAdapter;

public class TileFragment extends Fragment {
    public static String TAG = TileFragment.class.getSimpleName();

    private static int LAYOUT = R.layout.fragment_tile;
    private static int RECYCLERVIEW = R.id.fragment_test_recycler_view;
    private static int CARDVIEW = R.layout.fragment_tile_cardview;

    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView == null) {
            rootView = inflater.inflate(LAYOUT, container, false);
            Log.d(TAG, "CardView - Layout: " + TAG + " inflated...");

            RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(RECYCLERVIEW);
            mRecyclerView.setHasFixedSize(true);
            //mRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            mRecyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));

            RecyclerView.Adapter mAdapter = new TileFragmentAdapter(CARDVIEW, this);
            Log.d(TAG, mAdapter.getClass().getSimpleName() + " created...");
            mRecyclerView.setAdapter(mAdapter);

            ItemTouchHelper.Callback callback =
                    new DragAndDropHelper((DragAndDropHelperAdapter) mAdapter);
            ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
            touchHelper.attachToRecyclerView(mRecyclerView);
        }
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
