package com.appnolimits.pigeonwatch;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SegnalatoreDAO {

	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_TYPE, MySQLiteHelper.COLUMN_LATITUDE,
			MySQLiteHelper.COLUMN_LONGITUDE, MySQLiteHelper.COLUMN_IMAGE };

	public SegnalatoreDAO(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }

	  public void close() {
	    dbHelper.close();
	  }

	  public long addSegnalazione(Segnalatore segn){
		  ContentValues values = new ContentValues();
		  values.put(MySQLiteHelper.COLUMN_TYPE, segn.getTipo());
		  values.put(MySQLiteHelper.COLUMN_LATITUDE, segn.getLatitude());
		  values.put(MySQLiteHelper.COLUMN_LONGITUDE, segn.getLongitude());
		  values.put(MySQLiteHelper.COLUMN_IMAGE, segn.getImage());
		  
		  long l = database.insert(MySQLiteHelper.TABLE_SEGNALAZIONI, null, values);
		  return l;
	  }
	  
	  public void deleteSegnalazioni (Segnalatore segn){
		  long id = segn.get_id();
		  database.delete(MySQLiteHelper.TABLE_SEGNALAZIONI, MySQLiteHelper.COLUMN_ID
				  + " = " + id,null);
	  }
	  
	  public List<Segnalatore> getAllSegnalazioni(){
		  List<Segnalatore> segnalazioni = new ArrayList<Segnalatore>();
		  Cursor cursor = database.query(MySQLiteHelper.TABLE_SEGNALAZIONI,
				  allColumns, null, null, null, null, null);
		  cursor.moveToFirst();
		  while (!cursor.isAfterLast()){
			  Segnalatore segn = cursorToSegn(cursor);
			  segnalazioni.add(segn);
			  cursor.moveToNext();
		  }
		  cursor.close();
		  return segnalazioni;
	  }

	private Segnalatore cursorToSegn(Cursor cursor) {
		Segnalatore segn = new Segnalatore();
		segn.set_id(cursor.getLong(0));
		segn.setTipo(cursor.getString(1));
		segn.setLatitude(cursor.getString(2));
		segn.setLongitude(cursor.getString(3));
		segn.setImage(cursor.getBlob(4));
		return segn;
	}
	  
}
