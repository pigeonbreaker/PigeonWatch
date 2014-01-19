package com.appnolimits.pigeonwatch;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SegnalatoreAdapter extends ArrayAdapter<Segnalatore> {

	public SegnalatoreAdapter(Context context, int textViewResourceId,
			List<Segnalatore> objects) {
		super(context, textViewResourceId, objects);

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.segnalatiny, null);
		LinearLayout rigaArchivio = (LinearLayout) convertView
				.findViewById(R.id.riga_archivio);
		TextView tipo = (TextView) convertView.findViewById(R.id.a_type);
		TextView lat = (TextView) convertView.findViewById(R.id.a_latitude);
		TextView lon = (TextView) convertView.findViewById(R.id.a_longitude);
		ImageView imag = (ImageView) convertView
				.findViewById(R.id.a_immsegnalaz);
		Segnalatore s = getItem(position);
		tipo.setText(s.getTipo());
		lat.setText(s.getLatitude());
		lon.setText(s.getLongitude());
		if (s.getImage()!=null) 
		imag.setImageBitmap(ImageHelper.getBitmap(s.getImage()));

		mettiSfondo(s.getTipo(), rigaArchivio);

		return convertView;
	}

	private void mettiSfondo(String tipo, LinearLayout riga) {
		if (tipo == "buca")
			riga.setBackgroundResource(R.drawable.buca);
		if (tipo == "illuminazione")
			riga.setBackgroundResource(R.drawable.illuminazione);
		if (tipo == "pubblico decoro")
			riga.setBackgroundResource(R.drawable.decoropubbl);
	}

}
