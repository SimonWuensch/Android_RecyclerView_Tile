package sim.ssn.com.mytestapplication.fragment.tile;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sim.ssn.com.mytestapplication.R;
import sim.ssn.com.mytestapplication.helper.DragAndDropHelperAdapter;
import sim.ssn.com.mytestapplication.model.Widget;

/**
 * Created by Simon.wuensch on 23.08.2016.
 */
public class TileFragmentAdapter extends  RecyclerView.Adapter<TileFragmentViewHolder> implements DragAndDropHelperAdapter{

    private static String TAG = TileFragmentAdapter.class.getSimpleName();

    private final int layout;
    private final TileFragment fragment;
    private View inflatedView;

    private List<Widget> defaultInputs;
    private Activity activity;

    public TileFragmentAdapter(int layout, final TileFragment fragment){
        this.layout = layout;
        this.fragment = fragment;
        this.activity = fragment.getActivity();

        initDefaultInputs();
    }

    private void initDefaultInputs(){
        defaultInputs = new ArrayList<Widget>() {
            {
                add(Widget.create("Projekt", R.drawable.icon_project));
                add(Widget.create("System", R.drawable.icon_system));
                add(Widget.create("KPI", R.drawable.icon_kpi));
                add(Widget.create("Meldungen", R.drawable.icon_notification));
                add(Widget.create("Runtime", R.drawable.icon_runtime));
                add(Widget.create("Scada Komponente", R.drawable.icon_scada_components));
            }
        };

    }

    @Override
    public TileFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflatedView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        TileFragmentViewHolder viewHolder = new TileFragmentViewHolder(fragment.getActivity(), inflatedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TileFragmentViewHolder holder, int position) {
        holder.assignData(defaultInputs.get(position));
        //inflatedView.setOnClickListener(fragment).handleCardClick(defaultInputs.get(position)));
    }

    @Override
    public int getItemCount() {
        return defaultInputs.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    //Interface DragAndDropHelperAdapter
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(defaultInputs, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(defaultInputs, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        defaultInputs.remove(position);
        notifyItemRemoved(position);
    }
}
