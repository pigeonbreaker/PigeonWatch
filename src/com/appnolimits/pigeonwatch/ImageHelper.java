package com.appnolimits.pigeonwatch;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;

public class ImageHelper {
	private static String getTempDirectoryPath(Context ctx) {
		File cache;

		// SD Card Mounted
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			cache = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath()
					+ "/Android/data/"
					+ ctx.getPackageName() + "/cache/");
		}
		// Use internal storage
		else {
			cache = ctx.getCacheDir();
		}

		// Create the cache directory if it doesn't exist
		if (!cache.exists()) {
			cache.mkdirs();
		}

		return cache.getAbsolutePath();
	}

	public static Uri getOutputImageFileUri(Context ctx) {
		// TODO: check the presence of SDCard

		String tstamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
		File file = new File(getTempDirectoryPath(ctx), "PGNw" + tstamp
				+ ".jpg");

		return Uri.fromFile(file);

	}

	public static byte[] getByteArray(Bitmap bmp) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
		byte[] byteArray = stream.toByteArray();
		return byteArray;
	}

	public static Bitmap getBitmap(byte[] bitmapData) {
		Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapData, 0,
				bitmapData.length);
		return bitmap;
	}
}
