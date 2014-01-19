/**
 * 
 */
package com.appnolimits.pigeonwatch;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

/**
 * @author Carlo
 *
 */
public class ArchivioActivity extends FragmentActivity {
	private SegnalatoreDAO segnDAO;
	private SegnalatoreAdapter adapter;
	private ListView listView;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.archivio);
		listView = (ListView) findViewById(R.id.archivio_list);
		segnDAO = new SegnalatoreDAO(this);
		segnDAO.open();
		List<Segnalatore> segnalazioni = segnDAO.getAllSegnalazioni();
		adapter = new SegnalatoreAdapter(this, R.layout.segnalatiny, segnalazioni);
		listView.setAdapter(adapter);			
	}
	
	  @Override
	  protected void onResume() {
	    segnDAO.open();
	    super.onResume();
	  }
	@Override
	  protected void onPause() {
	    segnDAO.close();
	    super.onPause();
	  }

	public void onClick(View v) {
		Segnalatore segn = new Segnalatore();
		switch (v.getId()){
		case R.id.button_add:
			segn.setTipo("buca");
			segn.setLatitude("20.30555");
			segn.setLongitude("24.24242");
			segnDAO.addSegnalazione(segn);
			adapter.add(segn);
			break;
		case R.id.button_delete:
			if (adapter.getCount() > 0) {
				segn = (Segnalatore) adapter.getItem(0);
				segnDAO.deleteSegnalazioni(segn);
				adapter.remove(segn);
			}
			break;
		}
		adapter.notifyDataSetChanged();
	}

}
