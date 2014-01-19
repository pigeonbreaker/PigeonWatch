package com.appnolimits.pigeonwatch;

import java.util.ArrayList;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MailCreatorActivity extends FragmentActivity {

	private static final int CAMERA_REQUEST = 1337;
	private SegnalatoreDAO segnDAO;
	private ScrollView scrollView;
	private String tipoSegnalazione;
	private Uri immagineUri = null;
	private boolean immagineinserita = false;
	private ImageView immagine;
	private EditText dest;
	private EditText oggetto;
	private EditText testo;
	private Button conferma;
	private Bitmap datiFoto;
	private ArrayList<String> datimail;
	private Intent intento;
	private Segnalatore segnalatore;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		getWindow().setSoftInputMode(
			      WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		setContentView(R.layout.mail);
		scrollView = (ScrollView) findViewById(R.id.scrollViewSegn);
		segnDAO = new SegnalatoreDAO(this);
		segnalatore = new Segnalatore();
		datimail = new ArrayList<String>();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		intento = this.getIntent();
		datimail = intento.getStringArrayListExtra(MainActivity.PIGEONWATCH);		
		this.dest = (EditText) findViewById(R.id.destinAutotxt);
		this.dest.setSingleLine(true);
		this.oggetto = (EditText) findViewById(R.id.Oggettoedit);
		this.oggetto.setSingleLine(true);
		this.testo = (EditText) findViewById(R.id.TestoMessaggio);
		if (!datimail.isEmpty()) {
			setTipoSegnalazione(datimail.get(0));
			this.dest.setText(datimail.get(3));
			this.oggetto.setText(datimail.get(4));
			this.testo.setText("lat:" + datimail.get(1) + "-long:"
					+ datimail.get(2) + " " + datimail.get(5));
			segnalatore.setTipo(tipoSegnalazione);
			segnalatore.setLatitude(datimail.get(1));
			segnalatore.setLongitude(datimail.get(2));
		}
		else {
			Toast.makeText(this, "dati mancanti", Toast.LENGTH_SHORT).show();
			finish();
		}
		mettiSfondo(tipoSegnalazione);
		this.immagine = (ImageView) findViewById(R.id.fotoSegn);
		this.immagine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				launchCamera();
			}
		});
		this.conferma = (Button) findViewById(R.id.confermaMail);
		this.conferma.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (completa()) {
					segnalatore.setImage(ImageHelper.getByteArray(datiFoto));
					Intent imail = new Intent(Intent.ACTION_SEND);
					imail.setType("plain/text");
					imail.putExtra(Intent.EXTRA_EMAIL, new String[] { dest
							.getText().toString() });
					imail.putExtra(Intent.EXTRA_SUBJECT, oggetto.getText()
							.toString());
					imail.putExtra(Intent.EXTRA_TEXT, testo.getText()
							.toString());
					imail.setType("image/jpeg");
					imail.putExtra(Intent.EXTRA_STREAM, immagineUri);
					startActivity(Intent.createChooser(imail, "Email"));
					segnDAO.addSegnalazione(segnalatore);
					finish();
				} else {
					Toast.makeText(getApplicationContext(),
							"completare " + "correttamente i campi",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		segnDAO.close();
	}

	private void mettiSfondo(String tipo) {
		if (tipo == "buca")
			scrollView.setBackgroundResource(R.drawable.buca);
		if (tipo == "illuminazione")
			scrollView.setBackgroundResource(R.drawable.illuminazione);
		if (tipo == "pubblico_decoro")
			scrollView.setBackgroundResource(R.drawable.decoropubbl);
	}

	private boolean completa() {
		return (dest.getText() != null && oggetto.getText() != null && immagineinserita);
	}

	private void launchCamera() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		immagineUri = ImageHelper.getOutputImageFileUri(this);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, immagineUri);
		startActivityForResult(intent, CAMERA_REQUEST);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAMERA_REQUEST) {
			try {
				datiFoto = android.provider.MediaStore.Images.Media.getBitmap(
						this.getContentResolver(), immagineUri);
				immagine.setImageBitmap(this.resizeBitmap(datiFoto,
						immagine.getWidth(), immagine.getHeight()));
				this.immagineinserita = true;				
			} catch (Exception e) {
				Toast t = Toast.makeText(this,
						"Si è verificato un errore durante l'acquisizione dell'immagine:\n"
								+ e.toString(), Toast.LENGTH_LONG);
				t.show();
			}
		}
	}

	public Bitmap resizeBitmap(Bitmap bitmap, int newWidth, int newHeight) {
		/* Ridimensiono la bitmap */
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		// CREATE A MATRIX FOR THE MANIPULATION
		Matrix matrix = new Matrix();

		// RESIZE THE BIT MAP
		matrix.postScale(scaleWidth, scaleHeight);

		// RECREATE THE NEW BITMAP
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
	}

	public ArrayList<String> getDatimail() {
		return datimail;
	}

	public void setDatimail(ArrayList<String> strings) {
		this.datimail = strings;
	}

	public Uri getImmagineUri() {
		return immagineUri;
	}

	public void setImmagineUri(Uri immagineUri) {
		this.immagineUri = immagineUri;
	}

	public String getTipoSegnalazione() {
		return tipoSegnalazione;
	}

	public void setTipoSegnalazione(String tipo) {
		this.tipoSegnalazione = tipo;
	}

}