package tech.nextgen.unimacampusmap;

import static android.os.Build.VERSION_CODES.S;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Spinner;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.BasemapStyle;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.LocationDisplay;
import com.esri.arcgisruntime.mapping.view.MapView;

public class MainActivity extends AppCompatActivity {

    private MapView mMapView;
    private LocationDisplay mLocationDisplay;
    private Spinner mSpinner;

    private final int requestCode = 2;
    private final String[] reqPermissions = {Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);

        /*
        authentication with API key required to access basemap services
        and other location services
        */
        ArcGISRuntimeEnvironment.setApiKey("AAPKae2e0e4cb2814af49d6346db0343b8f9NyzRssRkbMgKM_Oc-amCwMPW__5G4lDx9CTq4dP3T7vXSpLv1uM22fr7t50GNn-a");

        //inflate map view from layout
        mMapView = findViewById(R.id.mapView);

        //create a map with topographic basemap
        ArcGISMap map = new ArcGISMap(BasemapStyle.ARCGIS_STREETS);

        //set the map to be displayed in this view
        mMapView.setMap(map);
        mMapView.setViewpoint(new Viewpoint( -15.3897, 35.3370,7000));
    }
    @Override
    protected void onPause(){
        mMapView.pause();
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mMapView.resume();
    }

    @Override
    protected void onDestroy() {
        mMapView.dispose();
        super.onDestroy();
    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.i1:
                //perform any action;
                return true;
            case R.id.mapMenu:
                //perform any action;
                return true;
            case R.id.myPlacesMenu:
                //perform any action;
                return true;
            case R.id.lookAroundMenu:
                //perform any action;
                return true;
            case R.id.arNavMenu:
                //perform any action;
                return true;
            case R.id.settingsMenu:
                //perform any action;
                return true;
            case R.id.helpMenu:
                //perform any action;
                return true;
            case R.id.sendFdbkMenu:
                //perform any action;
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}