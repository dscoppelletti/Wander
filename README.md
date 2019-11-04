Wander
======

In this practical you create the `Wander` app, which is a styled Google Map. The
`Wander` app allows you to drop markers onto locations, see your location in
real time, and look at Street View panoramas.

Content: http://codelabs.developers.google.com/codelabs/advanced-android-training-google-maps/index.html

Lab path
--------

### 3. Task 1. Set up the project an get an API Key

1. [google_maps_api.xml](http://github.com/dscoppelletti/Wander/blob/master/app/src/debug/res/values/google_maps_api.xml)
1. [activity_maps.xml](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/res/layout/activity_maps.xml)
1. [MapsActivity.java](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/java/com/example/android/wander/MapsActivity.java)

### 4. Task 2. Add map types and markers

1. [map_options.xml](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/res/menu/map_options.xml)
1. [strings.xml](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/res/values/strings.xml)
1. [MapsActivity.java](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/java/com/example/android/wander/MapsActivity.java)

### 5. Task 3. Style your map

1. [activity_maps.xml](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/res/layout/activity_maps.xml)
1. [map_style.json](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/res/raw/map_style.json)

    Created using [Maps Platform Styling Wizard](http://mapstyle.withgoogle.com)
    
1. [MapsActivity.java](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/java/com/example/android/wander/MapsActivity.java)
1. [android.png](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/res/drawable/android.png)

### 6. Task 4. Enable location tracking and Street View

1. [AndroidManifest.xml](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/AndroidManifest,xml)
1. [MapsActivity.java](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/java/com/example/android/wander/MapsActivity.java)
1. [activity_maps.xml](http://github.com/dscoppelletti/Wander/blob/master/app/src/main/res/layout/activity_maps.xml)

> The Google Maps Android API Street View service requires to link a billing
> account to the project on Google Cloud.

References
----------

* [API key guide](http://developers.google.com/maps/documentation/android-api/signup)
* [Info windows](http://developers.google.com/maps/documentation/android-api/infowindows)
* [Styling Wizard](http://developers.google.com/maps/documentation/javascript/styling#styled_map_wizard)
* [Location Services API](http://developer.android.com/training/location/index.html)
* [Location-data layer](http://developers.google.com/maps/documentation/android-api/location)
* [Street View coverage](http://www.google.com/streetview/understand)

* [Getting Started with the Google Maps Android API](http://developers.google.com/maps/documentation/android-api/start)
* [Adding a Map with a Marker](http://developers.google.com/maps/documentation/android-api/map-with-marker)
* [Map Objects](http://developers.google.com/maps/documentation/android-api/map)
* [Adding a Styled Map](http://developers.google.com/maps/documentation/android-api/styling)
* [Street View](http://developers.google.com/maps/documentation/android-api/streetview)
* [Ground Overlays](http://developers.google.com/maps/documentation/android-api/groundoverlay)

License
-------

Copyright 2017 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
