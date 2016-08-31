package sim.ssn.com.mytestapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import sim.ssn.com.mytestapplication.fragment.tile.TileFragment;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTestFragment();
    }

    public void showTestFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_fragment_container,
                        new TileFragment(),
                        TileFragment.TAG)
                .commit();
        Log.i(TAG, "Switched to Fragment " + TileFragment.TAG);
    }
}
