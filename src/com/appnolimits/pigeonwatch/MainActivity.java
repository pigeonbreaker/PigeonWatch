/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appnolimits.pigeonwatch;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements LocationListener,
		OnClickListener {

	public final static String PIGEONWATCH = "PIGEONWATCH -";
	public static LatLng coordMie = new LatLng(40.8, 8.5);

	GoogleMap map;

	public SegnalatoreDAO segnDAO;

	public static List<Segnalatore> segnalazioni;
	ArrayList<String> testosegnalazione;
	static boolean primaVolta = true;
	Coordinatami coordinator;
	TextView tvLocation;
	Button btn1, btn2, btn3,archivio;
	Intent mailIntent;
	String dovesono = "";
	int contaTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		segnDAO = new SegnalatoreDAO(this);
		setContentView(R.layout.activity_main);
		coordinator = new Coordinatami();
		segnalazioni = new ArrayList<Segnalatore>();
		testosegnalazione = new ArrayList<String>();
		tvLocation = (TextView) findViewById(R.id.a_type);
		tvLocation.setOnClickListener(this);
		btn1 = (Button) findViewById(R.id.btnbuca);
		btn1.setOnClickListener(this);
		btn2 = (Button) findViewById(R.id.btnluce);
		btn2.setOnClickListener(this);
		btn3 = (Button) findViewById(R.id.btndecoro);
		btn3.setOnClickListener(this);
		archivio = (Button) findViewById(R.id.accedi_archivio);
		archivio.setOnClickListener(this);
		contaTV=0;
	}

	@Override
	protected void onPause() {
		super.onPause();
		segnDAO.close();
	}

	@Override
	protected void onResume() {
		super.onResume();
		segnDAO.open();
		if (primaVolta) {
			primaVolta = false;
			Intent benvenuto = new Intent(this, BenvenutoActivity.class);
			startActivity(benvenuto);
		}
		if (segnDAO.getAllSegnalazioni() != null)
			segnalazioni = segnDAO.getAllSegnalazioni();
		setUpMapIfNeeded();
		//disegnaSegnalazioni();
	}

	private void disegnaSegnalazioni() {
		if (segnalazioni.isEmpty())
			return;
		map.clear();
		for (int i = 0; i < segnalazioni.size(); i++) {
			double lat = Double.parseDouble(segnalazioni.get(i).getLatitude());
			double lng = Double.parseDouble(segnalazioni.get(i).getLongitude());
			LatLng tcoord = new LatLng(lat, lng);
			Bitmap icona = ImageHelper
					.getBitmap(segnalazioni.get(i).getImage());
			map.addMarker(new MarkerOptions().position(tcoord)
					.title(segnalazioni.get(i).getTipo())
					.icon(BitmapDescriptorFactory.fromBitmap(icona)));
		}
	}

	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the
		// map.
		if (map == null) {
			// Try to obtain the map from the SupportMapFragment.
			map = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			// Check if we were successful in obtaining the map.
			if (map != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {
		// Getting Google Play availability status
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());
		// Showing status
		if (status != ConnectionResult.SUCCESS) {
			// Google Play Services are
			// not available
			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this,
					requestCode);
			dialog.show();
		} else { // Google Play Services are available

			// Getting reference to the SupportMapFragment of activity_main.xml
			SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map);
			// Getting GoogleMap object from the fragment
			map = fm.getMap();
			// Enabling MyLocation Layer of Google Map
			map.setMyLocationEnabled(true);
			// Getting LocationManager object from System Service
			// LOCATION_SERVICE
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
			// Creating a criteria object to retrieve provider
			Criteria criteria = new Criteria();
			// Getting the name of the best provider
			String provider = locationManager.getBestProvider(criteria, true);
			// Getting Current Location
			Location location = locationManager.getLastKnownLocation(provider);
			if (location != null) {
				onLocationChanged(location);
			}
			locationManager.requestLocationUpdates(provider, 20000, 0, this);
		}

	}

	@Override
	public void onClick(View v) {
		// Getting Google Play availability status
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());
		// Showing status
//		if (status != ConnectionResult.SUCCESS) {
			// Google Play Services are
			// not available
//			Toast.makeText(this, "non sono in grado di calcolare la posizione", Toast.LENGTH_SHORT).show();
//		} else { // Google Play Services are available
			switch (v.getId()) {
			case R.id.accedi_archivio:
				mailIntent = new Intent(this.getApplicationContext(),ArchivioActivity.class);
				startActivity(mailIntent);
				break;			
			case R.id.btnbuca:
				testosegnalazione.clear();
				preparaSegnalazione("buca");
				mailIntent = new Intent(this.getApplicationContext(),
						MailCreatorActivity.class);
				mailIntent.putStringArrayListExtra(PIGEONWATCH,
						testosegnalazione);
				startActivity(mailIntent);
				break;
			case R.id.btnluce:
				testosegnalazione.clear();
				preparaSegnalazione("illuminazione");
				mailIntent = new Intent(this.getApplicationContext(),
						MailCreatorActivity.class);
				mailIntent.putStringArrayListExtra(PIGEONWATCH,
						testosegnalazione);
				startActivity(mailIntent);
				break;
			case R.id.btndecoro:
				testosegnalazione.clear();
				preparaSegnalazione("pubblico_decoro");
				mailIntent = new Intent(this.getApplicationContext(),
						MailCreatorActivity.class);
				mailIntent.putStringArrayListExtra(PIGEONWATCH,
						testosegnalazione);
				startActivity(mailIntent);
				break;
			case R.id.a_type:
				contaTV++;
				cambiaLocationTextView(contaTV);
				break;
			}
//		}
	}

	private void cambiaLocationTextView(int i) {
		if (i % 2 == 0)
			tvLocation.setText("la provincia più vicina è "
					+ coordinator.dammiProvincia(coordMie).getNomeCitta());
		if (i % 2 == 1)
			tvLocation.setText(dovesono);
	}

	private void preparaSegnalazione(String tipo) {
		testosegnalazione.clear();
		testosegnalazione.add(tipo);
		testosegnalazione.add(String.valueOf(coordMie.latitude));
		testosegnalazione.add(String.valueOf(coordMie.longitude));
		if (tipo == "buca") {
			testosegnalazione.add(coordinator.dammiProvincia(coordMie)
					.getEmail());
			testosegnalazione.add(PIGEONWATCH + " BUCA!");
			testosegnalazione.add(" è la posizione della buca, vi invito "
					+ "a inserirla tra i lavori in corso. \n"
					+ "cordiali saluti.");
		}
		if (tipo == "illuminazione") {
			testosegnalazione.add(coordinator.dammiProvincia(coordMie)
					.getEmail());
			testosegnalazione.add(PIGEONWATCH + " ILLUMINAZIONE!");
			testosegnalazione
					.add(" è la posizione di un problema di illuminazione "
							+ "pubblica. , vi invito a inserirla tra i "
							+ "lavori in corso. \n" + "cordiali saluti.");
		}
		if (tipo == "pubblico_decoro") {
			testosegnalazione.add(coordinator.dammiProvincia(coordMie)
					.getEmail());
			testosegnalazione.add(PIGEONWATCH + " PUBBLICO DECORO!");
			testosegnalazione.add(" è la posizione, vi invito "
					+ "a inserirla tra i luoghi pubblici da risanare. \n"
					+ "cordiali saluti.");
		}

	}

	@Override
	public void onLocationChanged(Location location) {
		// Getting latitude of the current location
		double latitude = location.getLatitude();
		// Getting longitude of the current location
		double longitude = location.getLongitude();
		// Creating a LatLng object for the current location
		LatLng latLng = new LatLng(latitude, longitude);
		coordMie = latLng;
		// Showing the current location in Google Map
		map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		// Zoom in the Google Map
		map.animateCamera(CameraUpdateFactory.zoomTo(17));
		dovesono = "Lat: " + latitude + "Lon: " + longitude;
		// Setting latitude and longitude in the TextView tv_location
		tvLocation.setText(dovesono);
	}


	@Override
	public void onProviderDisabled(String provider) {
		tvLocation.setText("non è disponibile una localizzazione");
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	public static List<Segnalatore> getSegnalazioni() {
		return segnalazioni;
	}

	public static void setSegnalazioni(List<Segnalatore> segnalazioni) {
		MainActivity.segnalazioni = segnalazioni;
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

}