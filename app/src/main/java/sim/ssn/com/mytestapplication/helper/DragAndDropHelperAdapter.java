package sim.ssn.com.mytestapplication.helper;

/**
 * Created by Simon.wuensch on 23.08.2016.
 */
public interface DragAndDropHelperAdapter {

    boolean onItemMove (int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
