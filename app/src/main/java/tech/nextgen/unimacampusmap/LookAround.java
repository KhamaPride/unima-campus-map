package tech.nextgen.unimacampusmap;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.arcgisruntime.layers.ArcGISSceneLayer;
import com.esri.arcgisruntime.mapping.ArcGISScene;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Camera;
import com.esri.arcgisruntime.mapping.view.SceneView;

public class LookAround extends AppCompatActivity {

    private SceneView mSceneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_around);

        // create a scene and add a basemap to it
        ArcGISScene scene = new ArcGISScene();
        scene.setBasemap(Basemap.createImageryWithLabelsVector());

        mSceneView = findViewById(R.id.sceneView);
        mSceneView.setScene(scene);

        // add a scene service to the scene for viewing buildings
        ArcGISSceneLayer sceneLayer = new ArcGISSceneLayer(getResources().getString(R.string.unima_buildings));
        scene.getOperationalLayers().add(sceneLayer);

        // add a camera and initial camera position
        Camera camera = new Camera(-15.39389, 35.3375, 150, 345, 65, 0);
        mSceneView.setViewpointCamera(camera);
    }

    @Override
    protected void onPause() {
        mSceneView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSceneView.resume();
    }

    @Override
    protected void onDestroy() {
        mSceneView.dispose();
        super.onDestroy();
    }
}