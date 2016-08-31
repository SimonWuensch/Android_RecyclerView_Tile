package sim.ssn.com.mytestapplication.fragment.tile;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import sim.ssn.com.mytestapplication.R;
import sim.ssn.com.mytestapplication.model.Widget;

/**
 * Created by Simon.wuensch on 23.08.2016.
 */
public class TileFragmentViewHolder extends RecyclerView.ViewHolder {

    private static String TAG = TileFragmentViewHolder.class.getSimpleName();

    private Activity activity;
    private View itemView;

    private ImageView ivWidgetImage;
    private TextView tvWidgetName;
    private RelativeLayout rlWidgetLayout;

    public TileFragmentViewHolder(Activity activity, View itemView) {
        super(itemView);

        this.itemView = itemView;
        this.activity = activity;

        ivWidgetImage = ((ImageView)itemView.findViewById(R.id.cardview_fragment_test_image));
        tvWidgetName = ((TextView) itemView.findViewById(R.id.cardview_fragment_test_tvName));
    }

    protected void assignData(Widget widget){
        ivWidgetImage.setImageDrawable(activity.getResources().getDrawable(widget.getSvg(), null));
        ivWidgetImage.getDrawable().setTint(Color.BLACK);

        tvWidgetName.setText(widget.getName());



    }
}
