package com.example.android.wander;

import java.util.Locale;
import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

/* DOC STEP 1.1 - Create the Wander project with the Maps template
The MapsActivity.java file instantiates the SupportMapFragment class and uses
the class's getMapAsync() method to prepare the Google Map. The activity that
contains the SupportMapFragment must implement the OnMapReadyCallback interface
and that interface's onMapReady() method. The getMapAsync() method returns a
GoogleMap object, signifying that the map is loaded.
DOC END STEP 1.1 */

/* DOC STEP 2.1.5 - Add map types
Using AppCompatActivity will show the app bar, and therefore it will show the
menu.
DOC END STEP 2.1.5 */
// TODO STEP 2.1.5 - Add map types
//public class MapsActivity extends FragmentActivity implements
//        OnMapReadyCallback {
public class MapsActivity extends AppCompatActivity implements
        OnMapReadyCallback {
// TODO END STEP 2.1.5

    /* DOC STEP 3.1 - Add a style to your map
    To create a customized style for your map, you generate a JSON file that
    specifies how features in the map are displayed.You don't have to create
    this JSON file manually: Google provides the Styling Wizard, which generates
    the JSON for you after you visually style your map.

    Note: Styling only applies to maps that use the normal map type. */
    private static final String TAG = "MapsActivity";
    /* DOC END STEP 3.1 */

    /* DOC STEP 3.3 - Add an overlay
    One way you can customize the Google Map is by drawing on top of it. This
    technique is useful if you want to highlight a particular type of location,
    such as popular fishing spots. Three types of overlays are supported:

    . Shapes: You can add polylines, polygons, and circles to the map.

    . TileOverlay objects: A tile overlay defines a set of images that are added
    on top of the base map tiles. Tile overlays are useful when you want to add
    extensive imagery to the map. A typical tile overlay covers a large
    geographical area.

    . GroundOverlay objects: A ground overlay is an image that is fixed to a
    map. Unlike markers, ground overlays are oriented to the Earth's surface
    rather than to the screen. Rotating, tilting, or zooming the map changes the
    orientation of the image. Ground overlays are useful when you wish to fix a
    single image at one area on the map
    DOC END STEP 3.3 */

    /* DOC STEP 4 - Enable location tracking and Street View
    Users often use Google Maps to see their current location, and you can
    obtain device location using the Location Services API. To display the
    device location on your map without further use of Location data, you can
    use the location-data layer.

    The location-data layer adds a My Location button to the top-right side of
    the map. When the user taps the button, the map centers on the device's
    location. The location is shown as a blue dot if the device is stationary,
    and as a blue chevron if the device is moving.

    You can provide additional information about a location using Google Street
    View, which is a navigable panorama photo of a given location.
    DOC END STEP 4 */

    /* DOC STEP 4.1 - Enable location tracking
    Enabling location tracking in Google Maps requires a single line of code.
    However, you must make sure that the user has granted location permissions
    (using the runtime-permission model).

    Note: When you run the app on an emulator, the location may not be
    available. If you haven't used the emulator settings to set a location, the
    location button will be unavailable. */
    private static final int REQUEST_LOCATION_PERMISSION = 101;
    /* DOC END STEP 4.1 */

    /* DOC STEP 4.2 - Enable Street View
    Google Maps provides Street View, which is a panoramic view of a location
    with controls for navigating along a designated path.

    To enable a Street View panorama that is activated when the user taps a
    POI's info window. You need to do two things:

    1) Distinguish POI markers from other markers, because you want your app's
    functionality to work only on POI markers. This way, you can start Street
    View when the user taps a POI info window, but not when the user taps any
    other type of marker.

    2) When the user taps a tagged info window in an OnInfoWindowClickListener,
    replace the MapFragment with a StreetViewPanoramaFragment. (The code below
    uses SupportMapFragment and SupportStreetViewPanoramaFragment to support
    Android versions below API 12.)
    DOC END STEP 4.2 */

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready
        // to be used.
        // TODO STEP 4.2.B2 - Replace the static SupportMapFragment with a
        //  runtime instance
//        SupportMapFragment mapFragment =
//                (SupportMapFragment) getSupportFragmentManager()
//                        .findFragmentById(R.id.map);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        // TODO END STEP 4.2.B2
        // TODO STEP 4.2.B3 - Replace the static SupportMapFragment with a
        //  runtime instance
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mapFragment).commit();
        // TODO END STEP 4.2.B3
        // TODO STEP 4.2.B4 - Replace the static SupportMapFragment with a
        // runtime instance
        mapFragment.getMapAsync(this);
        // TODO END STEP 4.2.B4
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the
     * camera. In this case, we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be
     * prompted to install it inside the SupportMapFragment. This method will
     * only be triggered once the user has installed Google Play services and
     * returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // TODO STEP 2.2.1 - Move the default map location
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney)
//                .title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        // TODO END STEP 2.2.1

        // TODO STEP 2.2.4 - Move the default map location
        LatLng home = new LatLng(45.081329, 7.566367);
        // TODO END STEP 2.2.4

        /* DOC STEP 2.2.5 - Move the default map location
        The following list gives you an idea of what level of detail each level
        of zoom shows:

        1: World
        5: Landmass/continent
        10: City
        15: Streets
        20: Buildings

        DOC END STEP 2.2.5 */

        // TODO STEP 2.2.5 - Move the default map location
        float zoom = 15;
        // TODO END STEP 2.2.5

        // TODO STEP 2.2.6 - Move the default map location
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, zoom));
        // TODO END STEP 2.2.6

        // TODO STEP 3.3.2 - Add an overlay
        GroundOverlayOptions homeOverlay = new GroundOverlayOptions()
                // TODO STEP 3.3.3 - Add an overlay
                .image(BitmapDescriptorFactory.fromResource(R.drawable.android))
                // TODO END STEP 3.3.3
                // TODO STEP 3.3.4 - ADD an overlay
                .position(home, 100);
                // 100 = width in meters of the desired overlay
                // TODO END STEP 3.3.4
        // TODO END STEP 3.3.2

        // TODO STEP 3.3.5 - ADD an overlay
        mMap.addGroundOverlay(homeOverlay);
        // TODO END STEP 3.3.5

        // TODO STEP 2.3.4 - Add map markers
        setMapLongClick(mMap);
        // TODO END STEP 2.3.4

        // TODO STEP 2.4.5 - Add POI listeners
        setPoiClick(mMap);
        // TODO END STEP 2.4.5

        // TODO STEP 4.2.D4
        setInfoWindowClickToPanorama(mMap);
        // TODO END STEP 4.2.D4

        // TODO STEP 3.1.9 - Add a style to your map
        try {
            // Customize the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
        // TODO END STEP 3.1.9

        // TODO STEP 4.1.4 - Enable location tracking
        enableMyLocation();
        // TODO END STEP 4.1.4
    }

    /* DOC STEP 2.1 - Add map types
    The type of map that your user wants depends on the kind of information they
    need. When using maps for navigation in your car, it's helpful to see street
    names clearly. When you are hiking, you probably care more about how much
    you have to climb to get to the top of the mountain.
    END DOC STEP 2.1 */

    // TODO STEP 2.1.6 - Add map types
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options, menu);
        return true;
    }
    // TODO END 2.1.6

    // TODO 2.1.7 - Add map types
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Change the map type based on the user's selection.
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    // TODO END STEP 2.1.7

    /* DOC STEP 2.3 - Add map markers
    Google Maps can single out a location using a marker, which you create using
    the Marker class. The default marker uses the standard Google Maps icon.

    You can extend markers to show contextual information in info windows.
    DOC END STEP 2.3 */

    /* DOC STEP 2.3.5 - Add map markers
    Touch and hold on the map to place a marker at a location.
    DOC END STEP 2.3.5 */
    // TODO STEP 2.3.1 - Add map markers
    private void setMapLongClick(final GoogleMap map) {
        // TODO STEP 2.3.2 - Add map markers
        map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                // TODO STEP 2.3.3 - Add map markers
                // Replaced by 2.3.7
                // map.addMarker(new MarkerOptions().position(latLng));
                // TODO END STEP 2.3.3
                // TODO STEP 2.3.7 - Add an info window for the marker
                String snippet = String.format(Locale.getDefault(),
                        "Lat: %1$.5f, Long: %2$.5f",
                        latLng.latitude,
                        latLng.longitude);

                map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(getString(R.string.dropped_pin))
                        .snippet(snippet)
                        // TODO STEP 3.2.1 - Style your marker
                        .icon(BitmapDescriptorFactory.defaultMarker
                                (BitmapDescriptorFactory.HUE_BLUE))
                        // TODO END STEP 3.2.1
                );
                // TODO END STEP 2.3.7
            }
        });
        // TODO END STEP 2.3.2
    }
    // TODO END STEP 2.3.1

    /* DOC STEP 2.3.6 - Add map markers
    Tap the marker, which centers it on the screen.
    Navigation buttons appear at the bottom-left side of the screen, allowing
    the user to use the Google Maps app to navigate to the marked position.
    DOC END STEP 2.3.6 */

    /* DOC STEP 2.4 - Add POI listener
    By default, points of interest (POIs) appear on the map along with their
    corresponding icons. POIs include parks, schools, government buildings, and
    more. When the map type is set to normal, business POIs also appear on the
    map. Business POIs represent businesses such as shops, restaurants, and
    hotels.
    DOC END STEP 2.4 */

    // TODO STEP 2.4.1 - Add POI listener
    private void setPoiClick(final GoogleMap map) {
        // TODO STEP 2.4.2 - Add POI listener
        map.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
            @Override
            public void onPoiClick(PointOfInterest poi) {
                // TODO STEP 2.4.3 - Add POI listener
                Marker poiMarker = mMap.addMarker(new MarkerOptions()
                        .position(poi.latLng)
                        .title(poi.name));
                // TODO END STEP 2.4.3
                // TODO STEP 4.2.A1 - Tag the POI marker
                poiMarker.setTag("poi");
                // TODO END STEP 4.2.A1
                // TODO STEP 2.4.4 - Add POI listener
                poiMarker.showInfoWindow();
                // TODO END STEP 2.4.4
            }
        });
        // TODO END STEP 2.4.2
    }
    // TODO END STEP 2.4.1

    // TODO STEP 4.1.2 - Enable location tracking
    private void enableMyLocation() {
        // TODO STEP 4.1.3 - Enable location tracking
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                            { Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
        // TODO END STEP 4.1.3
    }
    // TODO END STEP 4.1.2

    // TODO STEP 4.1.5 - Enable location tracking
    @Override
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    public void onRequestPermissionsResult(int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        // Check if location permissions are granted and if so enable the
        // location data layer.
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocation();
                    break;
                }
        }
    }
    // TODO END STEP 4.1.5

    // TODO STEP 4.2.C1 - Set an OnInfoWindowClickListener and check the marker
    // tag
    private void setInfoWindowClickToPanorama(GoogleMap map) {
        // TODO STEP 4.2.C2 - Set an OnInfoWindowClickListener and check the
        // marker tag
        map.setOnInfoWindowClickListener(
                new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        // TODO STEP 4.2.C3 - Set an OnInfoWindowClickListener
                        // and check the marker tag
                        if (marker.getTag() == "poi") {
                            // TODO STEP 4.2.D1 - Replace the SupportMapFragment
                            // with a SupportStreetViewPanoramaFragment
                            StreetViewPanoramaOptions options =
                                    new StreetViewPanoramaOptions().position(
                                            marker.getPosition());
                            // TODO END STEP 4.2.D1
                            // TODO STEP 4.2.D2 - Replace the SupportMapFragment
                            // with a SupportStreetViewPanoramaFragment
                            SupportStreetViewPanoramaFragment streetViewFragment
                                    = SupportStreetViewPanoramaFragment
                                    .newInstance(options);
                            // TODO END STEP 4.2.D2
                            // TODO STEP 4.2.D3
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container,
                                            streetViewFragment)
                                    .addToBackStack(null).commit();
                            // TODO END STEP 4.2.D3
                        }
                        // TODO END STEP 4.2.C3
                    }
                });
        // TODO END STEP 4.2.C2
    }
    // TODO END STEP 4.2.C1
}
