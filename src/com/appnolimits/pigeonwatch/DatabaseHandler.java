package com.appnolimits.pigeonwatch;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "databasePGNw";

	// Contacts table name
	private static final String TABLE_SIGNS = "segnalazioni";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_TYPE = "tipo";
	private static final String KEY_LATITUDE = "latitude";
	private static final String KEY_LONGITUDE = "longitude";
	private static final String KEY_IMAGE = "image";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SIGNS + " ("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_TYPE + " TEXT,"
				+ KEY_LATITUDE + " TEXT," + KEY_LONGITUDE + " TEXT,"
				+ KEY_IMAGE + " BLOB)";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIGNS);
		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	public void addSegnalazione(Segnalatore segnalatore) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_TYPE, segnalatore.getTipo());
		values.put(KEY_LATITUDE, segnalatore.getLatitude());
		values.put(KEY_LATITUDE, segnalatore.getLongitude());
		values.put(KEY_IMAGE, segnalatore.getImage());
		// Inserting Row
		db.insert(TABLE_SIGNS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	public Segnalatore getSegnalazione(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_SIGNS, new String[] { KEY_ID, KEY_TYPE,
				KEY_LATITUDE, KEY_IMAGE }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		Segnalatore segnalatore = new Segnalatore(Integer.parseInt(cursor
				.getString(0)), cursor.getString(1), cursor.getString(2),
				cursor.getString(3), cursor.getBlob(4));
		cursor.close();
		db.close();
		return segnalatore;
	}

	// Getting All Contacts
	public ArrayList<Segnalatore> getAllContacts() {
		ArrayList<Segnalatore> segnalazioniList = new ArrayList<Segnalatore>();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_SIGNS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Segnalatore segnalatore = new Segnalatore();
				segnalatore.set_id(Integer.parseInt(cursor.getString(0)));
				segnalatore.setTipo(cursor.getString(1));
				segnalatore.setLongitude(cursor.getString(2));
				segnalatore.setLongitude(cursor.getString(3));
				segnalatore.setImage(cursor.getBlob(4));
				// Adding contact to list
				segnalazioniList.add(segnalatore);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		// return contact list
		return segnalazioniList;
	}

	// Updating single contact
	public int updateContact(Segnalatore segnalatore) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_TYPE, segnalatore.getTipo());
		values.put(KEY_LATITUDE, segnalatore.getLatitude());
		values.put(KEY_LONGITUDE, segnalatore.getLongitude());
		values.put(KEY_IMAGE, segnalatore.getImage());
		// updating row
		int i = db.update(TABLE_SIGNS, values, KEY_ID + " = ?",
				new String[] { String.valueOf(segnalatore.get_id()) });
		db.close();
		return i;
	}

	// Deleting single contact
	public void deleteContact(Segnalatore segnalatore) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_SIGNS, KEY_ID + " = ?",
				new String[] { String.valueOf(segnalatore.get_id()) });
		db.close();
	}

	// Getting contacts Count
	public int getSegnalazioniCount() {
		String countQuery = "SELECT * FROM " + TABLE_SIGNS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int i = cursor.getCount();
		cursor.close();
		db.close();
		// return count
		return i;
	}

}