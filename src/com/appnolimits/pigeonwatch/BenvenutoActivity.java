package com.appnolimits.pigeonwatch;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BenvenutoActivity extends FragmentActivity {
	TextView benvenuto;
	Button btninizia;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.benvenuto);
		benvenuto = (TextView) findViewById(R.id.testobenvenuto);
		benvenuto
				.setText("Benvenuti in PIGEONWATCH il nostro paese sta affrontando"
						+ " un periodo difficile, è vero. ma dobbiamo a tutti i costi fare"
						+ " qualcosa a riguardo, anche se in piccolo il messaggio che ne "
						+ "uscirà sarà forte e chiaro. Grazie a PIGEONWATCH hai una "
						+ "linea diretta verso l\'Ufficio Relazioni con il Pubblico "
						+ "provinciale più vicino a te. L'applicazione ti permette in "
						+ "maniera facile e rapida di comporre una mail di segnalazione "
						+ "verso il tuo URP di qualsiasi genere, dalle buche ai problemi "
						+ "di illuminazione. Ogni segnalazione quindi contribuirà a "
						+ "costruire una mappa dettagliata dei luoghi dove urge la "
						+ "manutenzione pubblica. Sarà inoltre possibile aumentare l'urgenza"
						+ " con la funzione +1 delle segnalazioni già effettuate, "
						+ "e quindi visibili sulla mappa, per cui se ne potrà "
						+ "aumentare l'importanza. Cosa aspetti? crea la tua "
						+ "segnalazione e vedi se gli altri sono d'accordo con te!"
						+ " non curandoci del nostro ambiente, "
						+ "lo lasceremo morire lentamente.");
		btninizia = (Button) findViewById(R.id.conferma_benevenuto);
		btninizia.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});
	}
	

	@Override
	public void onBackPressed() {
	}
}
