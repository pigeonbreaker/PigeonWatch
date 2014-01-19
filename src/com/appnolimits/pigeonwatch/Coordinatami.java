package com.appnolimits.pigeonwatch;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

public class Coordinatami {
	public class CoordProvincia {
		public String nomeCitta;
		public String email;
		public LatLng coordinate;
		
		public CoordProvincia(String nome, String mail, LatLng coord){
			this.nomeCitta=nome;
			this.email = mail;
			this.coordinate=coord;
		}

		public String getNomeCitta() {
			return nomeCitta;
		}

		public void setNomeCitta(String nomeCitta) {
			this.nomeCitta = nomeCitta;
		}

		public String getEmail() {
			return email;
		}

		public void setTarga(String mail) {
			this.email = mail;
		}

		public LatLng getCoordinate() {
			return coordinate;
		}

		public void setCoordinate(LatLng coordinate) {
			this.coordinate = coordinate;
		}
	}
	
	public static ArrayList<CoordProvincia> tutteCoord = new ArrayList<CoordProvincia>();
	
	
	public Coordinatami(){

		CoordProvincia agrigento = new CoordProvincia("Agrigento", " urp@comune.agrigento.it", new LatLng(37.3,13.6));
		CoordProvincia alessandria = new CoordProvincia("Alessandria", "urp@comune.alessandria.it", new LatLng(44.916,8.616));
		CoordProvincia ancona = new CoordProvincia("Ancona", "info@comune.ancona.it", new LatLng(43.616,13.516));
		CoordProvincia aosta = new CoordProvincia("Aosta", "protocollo@comune.aosta.it", new LatLng(45.733,7.316));
		CoordProvincia arezzo = new CoordProvincia("Arezzo", "protocollo@comune.arezzo.it", new LatLng(43.466,11.883));
		CoordProvincia ascolipiceno = new CoordProvincia("Ascoli Piceno", "protocollo@comune.ascolipiceno.it", new LatLng(42.85,13.566));
		CoordProvincia asti = new CoordProvincia("Asti", " protocollo@cert.comune.asti.it", new LatLng(44.883,8.2));
		CoordProvincia avellino = new CoordProvincia("Avellino", "ufficioprotocollo@cert.comune.avellino.it", new LatLng(40.916,14.783));
		CoordProvincia bari = new CoordProvincia("Bari", "urp@comune.bari.it", new LatLng(41.116,16.883));
		CoordProvincia belluno = new CoordProvincia("Belluno", "belluno.bl@cert.ip-veneto.net", new LatLng(46.133,12.216));
		CoordProvincia benevento = new CoordProvincia("Benevento", "lavoripubblici@pec.comunebn.it", new LatLng(41.133,14.766));
		CoordProvincia bergamo = new CoordProvincia("Bergamo", "protocollo@comune.bg.it", new LatLng(45.566,9.666));
		CoordProvincia biella = new CoordProvincia("Biella", "protocollo.comunebiella@pec.it", new LatLng(45.566,8.05));
		CoordProvincia bologna = new CoordProvincia("Bologna", "urp@comune.bologna.it", new LatLng(44.5,11.35));
		CoordProvincia bolzano = new CoordProvincia("Bolzano", "urp@comune.bolzano.it", new LatLng(46.5,11.333));
		CoordProvincia brescia = new CoordProvincia("Brescia", " protocollogenerale@pec.comune.brescia.it", new LatLng(44.533,10.2));
		CoordProvincia brindisi = new CoordProvincia("Brindisi", "ufficioprotocollo@pec.comune.brindisi.it", new LatLng(40.65,17.933));
		CoordProvincia cagliari = new CoordProvincia("Cagliari", "protocollogenerale@comune.cagliari.legalmail.it", new LatLng(39.216,9.166));
		CoordProvincia caltanisetta = new CoordProvincia("Caltanisetta", "protocollo@pec.comune.caltanissetta.it", new LatLng(37.483,14.066));
		CoordProvincia campobasso = new CoordProvincia("Campobasso", "comune.campobasso.protocollo@pec.it", new LatLng(41.566,14.316));
		CoordProvincia caserta = new CoordProvincia("Caserta", "postacertificata@pec.comune.caserta.it", new LatLng(41.066,14.316));
		CoordProvincia catania = new CoordProvincia("Catania", "etnaonline@comune.catania.it", new LatLng(37.5,15.083));
		CoordProvincia catanzaro = new CoordProvincia("Catanzaro", "uff.manutenzione.immobili@certificata.comune.catanzaro.it", new LatLng(38.9,16.583));
		CoordProvincia chieti = new CoordProvincia("Chieti", "info@comune.chieti.it", new LatLng(42.35,14.166));
		CoordProvincia como = new CoordProvincia("Como", "urp@comune.como.it", new LatLng(45.8,9.083));
		CoordProvincia cosenza = new CoordProvincia("Cosenza", "comunedicosenza@superpec.eu", new LatLng(39.283,16.25));
		CoordProvincia cremona = new CoordProvincia("Cremona", "servizi@comune.cremona.it", new LatLng(45.133,10.033));
		CoordProvincia crotone = new CoordProvincia("Crotone", "protocollocomune@pec.comune.crotone.it", new LatLng(39.083,17.133));
		CoordProvincia cuneo = new CoordProvincia("Cuneo", "ufficio.protocollo@comune.cuneo.it", new LatLng(44.4,7.55));
		CoordProvincia enna = new CoordProvincia("Enna", "protocollo@pec.comune.enna.it", new LatLng(37.566,14.266));
		CoordProvincia ferrara = new CoordProvincia("Ferrara", "urp@comune.fe.it", new LatLng(44.833,11.633));
		CoordProvincia firenze = new CoordProvincia("Firenze", "comunefirenze@comune.fi.it", new LatLng(43.766,11.25));
		CoordProvincia foggia = new CoordProvincia("Foggia", "lavori.pubblici@comune.foggia.it", new LatLng(41.466,15.55));
		CoordProvincia forli = new CoordProvincia("Forlì", "redazione.civica@comune.forli.fc.it", new LatLng(44.216,12.05));
		CoordProvincia frosinone = new CoordProvincia("Frosinone", "pec@pec.comune.frosinone.it", new LatLng(41.63,13.366));
		CoordProvincia genova = new CoordProvincia("Genova", "comunegenova@postemailcertificata.it", new LatLng(44.416,8.916));
		CoordProvincia gorizia = new CoordProvincia("Gorizia", "urp@comune.gorizia.it", new LatLng(45.95,13.633));
		CoordProvincia grosseto = new CoordProvincia("Grosseto", "comune.grosseto@postacert.toscana.it", new LatLng(42.766,11.116));
		CoordProvincia imperia = new CoordProvincia("Imperia", "protocollo@pec.comune.imperia.it", new LatLng(43.883,8.016));
		CoordProvincia isernia = new CoordProvincia("Isernia", "segreteriagenerale@comune.isernia.it", new LatLng(41.6,14.233));
		CoordProvincia laquila = new CoordProvincia("L'Aquila", "protocollo@comune.laquila.postecert.it", new LatLng(42.35,13.4));
		CoordProvincia laspezia = new CoordProvincia("La Spezia", "urp@comune.sp.it", new LatLng(44.116,9.833));
		CoordProvincia latina = new CoordProvincia("Latina", "segreteria.generale@pec.comune.latina.it", new LatLng(41.466,12.883));
		CoordProvincia lecce = new CoordProvincia("Lecce", "protocollo@pec.comune.lecce.it", new LatLng(40.35,18.183));
		CoordProvincia lecco = new CoordProvincia("Lecco", "comune@pec.comunedilecco.it", new LatLng(45.85,9.383));
		CoordProvincia livorno = new CoordProvincia("Livorno", "comune.livorno@postacert.toscana.it", new LatLng(43.55,10.316));
		CoordProvincia lodi = new CoordProvincia("Lodi", "urp@comune.lodi.it", new LatLng(45.316,9.5));
		CoordProvincia lucca = new CoordProvincia("Lucca", "urp@comune.lucca.it", new LatLng(43.85,10.516));
		CoordProvincia macerata = new CoordProvincia("Macerata", "comune.macerata@legalmail.it", new LatLng(43.3,13.45));
		CoordProvincia mantova = new CoordProvincia("Mantova", "comune.mantova.aoo@legalmail.it", new LatLng(45.15,10.783));
		CoordProvincia massa = new CoordProvincia("Massa", "comune.massa@postacert.toscana.it", new LatLng(44.333,10.083));
		CoordProvincia matera = new CoordProvincia("Matera", "comune.matera@cert.ruparbasilicata.it", new LatLng(40.683,16.6));
		CoordProvincia messina = new CoordProvincia("Messina", "protocollo@pec.comune.messina.it", new LatLng(38.183,15.566));
		CoordProvincia milano = new CoordProvincia("Milano", "protocollo@postacert.comune.milano.it", new LatLng(45.466,9.183));
		CoordProvincia modena = new CoordProvincia("Modena", "comune.modena@cert.comune.modena.it", new LatLng(44.65,10.916));
		CoordProvincia napoli = new CoordProvincia("Napoli", "urp@comune.napoli.it", new LatLng(40.35,14.25));
		CoordProvincia novara = new CoordProvincia("Novara", "urp@comune.novara.it", new LatLng(45.45,8.633));
		CoordProvincia nuoro = new CoordProvincia("Nuoro", "protocollo@pec.comune.nuoro.it", new LatLng(40.316,9.266));
		CoordProvincia oristano = new CoordProvincia("Oristano", "info@comune.oristano.it", new LatLng(39.9,8.6));
		CoordProvincia padova = new CoordProvincia("Padova", "urp@comune.padova.it", new LatLng(45.4,8.6));
		CoordProvincia palermo = new CoordProvincia("Palermo", "settoremanutenzione@cert.comune.palermo.it", new LatLng(38.116,13.35));
		CoordProvincia parma = new CoordProvincia("Parma", "comunediparma@postemailcertificata.it", new LatLng(44.8,10.35));
		CoordProvincia pavia = new CoordProvincia("Pavia", "protocollo@pec.comune.pavia.it", new LatLng(45.183,9.166));
		CoordProvincia perugia = new CoordProvincia("Perugia", "urp@comune.perugia.it", new LatLng(43.116,12.4));
		CoordProvincia pesaro = new CoordProvincia("Pesaro", "comune.pesaro@emarche.it", new LatLng(43.9,12.916));
		CoordProvincia pescara = new CoordProvincia("Pescara", "info@comune.pescara.it", new LatLng(42.45,14.216));
		CoordProvincia piacenza = new CoordProvincia("Piacenza", "urp@comune.piacenza.it", new LatLng(45.05,9.683));
		CoordProvincia pisa = new CoordProvincia("Pisa", "info@comune.pisa.it", new LatLng(43.716,10.4));
		CoordProvincia pistoia = new CoordProvincia("Pistoia", "info@comune.pistoia.it", new LatLng(43.933,10.916));
		CoordProvincia pordenone = new CoordProvincia("Pordenone", "comune.pordenone@certgov.fvg.it", new LatLng(45.95,12.65));
		CoordProvincia potenza = new CoordProvincia("Potenza", "protocollo@pec.comune.potenza.it", new LatLng(40.633,15.816));
		CoordProvincia prato = new CoordProvincia("Prato", "urpmultiente@po-net.prato.it", new LatLng(43.883,11.1));
		CoordProvincia ragusa = new CoordProvincia("Ragusa", "info@comune.ragusa.gov.it", new LatLng(36.933,14.733));
		CoordProvincia ravenna = new CoordProvincia("Ravenna", "urp@comune.ra.it", new LatLng(44.416,12.2));
		CoordProvincia reggiocalabria = new CoordProvincia("Reggio Calabria", "staffrete@comune.reggio-calabria.it", new LatLng(38.1,15.65));
		CoordProvincia reggioemilia = new CoordProvincia("Reggio Emilia", "comune.informa@municipio.re.it", new LatLng(44.7,10.633));
		CoordProvincia rieti = new CoordProvincia("Rieti", "urp@comune.rieti.it", new LatLng(42.366,12.866));
		CoordProvincia rimini = new CoordProvincia("Rimini", "urp.comune.rimini.it", new LatLng(44.066,12.566));
		CoordProvincia roma = new CoordProvincia("Roma", "ld.urbanistica@comune.roma.it", new LatLng(41.9,12.566));
		CoordProvincia rovigo = new CoordProvincia("Rovigo", "urp@comune.rovigo.it", new LatLng(45.066,11.8));
		CoordProvincia salerno = new CoordProvincia("Salerno", "protocollo@pec.comune.salerno.it ", new LatLng(40.683,14.766));
		CoordProvincia sassari = new CoordProvincia("Sassari", "info@comune.sassari.it", new LatLng(40.716,8.566));
		CoordProvincia savona = new CoordProvincia("Savona", "informa@comune.savona.it", new LatLng(44.316,8.466));
		CoordProvincia siena = new CoordProvincia("Siena", "comune.siena@postacert.toscana.it", new LatLng(43.316,11.3));
		CoordProvincia siracusa = new CoordProvincia("Siracusa", "manutenzione@comune.siracusa.it", new LatLng(37.066,15.283));
		CoordProvincia sondrio = new CoordProvincia("Sondrio", "info@comune.sondrio.it", new LatLng(46.183,9.883));
		CoordProvincia taranto = new CoordProvincia("Taranto", "comunicazione.urp@comune.taranto.it", new LatLng(40.466,17.233));
		CoordProvincia teramo = new CoordProvincia("Teramo", "urp@comune.teramo.it", new LatLng(42.666,13.716));
		CoordProvincia terni = new CoordProvincia("Terni", "sportello.cittadino@comune.terni.it", new LatLng(42.566,12.666));
		CoordProvincia torino = new CoordProvincia("Torino", "urp@comune.torino.it", new LatLng(45.066,7.7));
		CoordProvincia trapani = new CoordProvincia("Trapani", "urp@comune.trapani.it", new LatLng(38.016,12.533));
		CoordProvincia trento = new CoordProvincia("Trento", "comurp@comune.trento.it", new LatLng(46.066,11.133));
		CoordProvincia treviso = new CoordProvincia("Treviso", "urp@comune.treviso.it", new LatLng(45.666,12.25));
		CoordProvincia trieste = new CoordProvincia("Trieste", "urp@comune.trieste.it", new LatLng(45.65,13.766));
		CoordProvincia udine = new CoordProvincia("Udine", "urp@comune.udine.it", new LatLng(46.066,13.233));
		CoordProvincia varese = new CoordProvincia("Varese", "urp@comune.varese.it", new LatLng(45.833,8.816));
		CoordProvincia venezia = new CoordProvincia("Venezia", "protocollo@pec.comune.venezia.it", new LatLng(45.433,12.35));
		CoordProvincia verbania = new CoordProvincia("Verbania", "urpalessandria@regione.piemonte.it", new LatLng(45.933,8.55));
		CoordProvincia vercelli = new CoordProvincia("Vercelli", "urp@comune.vercelli.it", new LatLng(45.333,8.416));
		CoordProvincia verona = new CoordProvincia("Verona", " urp@comune.verona.it", new LatLng(45.45,11.0));
		CoordProvincia vibovalentia = new CoordProvincia("Vibo Valentia", "urp@comune.vibovalentia.vv.it", new LatLng(38.66,16.01));
		CoordProvincia vicenza = new CoordProvincia("Vicenza", "urp@comune.vicenza.it", new LatLng(45.55,11.55));
		CoordProvincia viterbo = new CoordProvincia("Viterbo", "urp@comune.viterbo.it", new LatLng(42.55,12.116));
		tutteCoord.clear();
		tutteCoord.add(agrigento);
		tutteCoord.add(alessandria);
		tutteCoord.add(ancona);
		tutteCoord.add(aosta);
		tutteCoord.add(arezzo);
		tutteCoord.add(ascolipiceno);
		tutteCoord.add(asti);
		tutteCoord.add(avellino);
		tutteCoord.add(bari);
		tutteCoord.add(belluno);
		tutteCoord.add(benevento);
		tutteCoord.add(bergamo);
		tutteCoord.add(biella);
		tutteCoord.add(bologna);
		tutteCoord.add(bolzano);
		tutteCoord.add(brescia);
		tutteCoord.add(brindisi);
		tutteCoord.add(cagliari);
		tutteCoord.add(caltanisetta);
		tutteCoord.add(campobasso);
		tutteCoord.add(caserta);
		tutteCoord.add(catania);
		tutteCoord.add(catanzaro);
		tutteCoord.add(chieti);
		tutteCoord.add(como);
		tutteCoord.add(cosenza);
		tutteCoord.add(cremona);
		tutteCoord.add(crotone);
		tutteCoord.add(cuneo);
		tutteCoord.add(enna);
		tutteCoord.add(ferrara);
		tutteCoord.add(firenze);
		tutteCoord.add(foggia);
		tutteCoord.add(forli);
		tutteCoord.add(frosinone);
		tutteCoord.add(genova);
		tutteCoord.add(gorizia);
		tutteCoord.add(grosseto);
		tutteCoord.add(imperia);
		tutteCoord.add(isernia);
		tutteCoord.add(laquila);
		tutteCoord.add(laspezia);
		tutteCoord.add(latina);
		tutteCoord.add(lecce);
		tutteCoord.add(lecco);
		tutteCoord.add(livorno);
		tutteCoord.add(lodi);
		tutteCoord.add(lucca);
		tutteCoord.add(macerata);
		tutteCoord.add(mantova);
		tutteCoord.add(massa);
		tutteCoord.add(matera);
		tutteCoord.add(messina);
		tutteCoord.add(milano);
		tutteCoord.add(modena);
		tutteCoord.add(napoli);
		tutteCoord.add(novara);
		tutteCoord.add(nuoro);
		tutteCoord.add(oristano);
		tutteCoord.add(padova);
		tutteCoord.add(palermo);
		tutteCoord.add(parma);
		tutteCoord.add(pavia);
		tutteCoord.add(perugia);
		tutteCoord.add(pesaro);
		tutteCoord.add(pescara);
		tutteCoord.add(piacenza);
		tutteCoord.add(pisa);
		tutteCoord.add(pistoia);
		tutteCoord.add(pordenone);
		tutteCoord.add(potenza);
		tutteCoord.add(prato);
		tutteCoord.add(ragusa);
		tutteCoord.add(ravenna);
		tutteCoord.add(reggiocalabria);
		tutteCoord.add(reggioemilia);
		tutteCoord.add(rieti);
		tutteCoord.add(rimini);
		tutteCoord.add(roma);
		tutteCoord.add(rovigo);
		tutteCoord.add(salerno);
		tutteCoord.add(sassari);
		tutteCoord.add(savona);
		tutteCoord.add(siena);
		tutteCoord.add(siracusa);
		tutteCoord.add(sondrio);
		tutteCoord.add(taranto);
		tutteCoord.add(teramo);
		tutteCoord.add(terni);
		tutteCoord.add(torino);
		tutteCoord.add(trapani);
		tutteCoord.add(trento);
		tutteCoord.add(treviso);
		tutteCoord.add(trieste);
		tutteCoord.add(udine);
		tutteCoord.add(varese);
		tutteCoord.add(venezia);
		tutteCoord.add(verbania);
		tutteCoord.add(vercelli);
		tutteCoord.add(verona);
		tutteCoord.add(vibovalentia);
		tutteCoord.add(vicenza);
		tutteCoord.add(viterbo);	
		
	}
	
	public ArrayList<String> tuttinomi(){
		ArrayList<String> lista = new ArrayList<String>();
		for (int i =0; i<tutteCoord.size();i++){
			lista.add(tutteCoord.get(i).getNomeCitta());
		}
		return lista;
	}
	
	public CoordProvincia dammiProvincia(LatLng mCoord){
		CoordProvincia temp = null;
		double deltaLat=100,deltaLng=100,deltatmp=100,delta=100;
		for (int i=0;i<tutteCoord.size();i++){
			deltaLat=Math.abs(mCoord.latitude-tutteCoord.get(i).getCoordinate().latitude);
			deltaLng=Math.abs(mCoord.longitude-tutteCoord.get(i).getCoordinate().longitude);
			deltatmp = deltaLat+deltaLng;
			if(deltatmp<delta){
				delta=deltatmp;
				temp=tutteCoord.get(i);
			}
		}
		
		return temp;
	}
	

	
}

