package com.bluesprucegroup.njrealtors.csvtopdf.domain.security;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebServiceGzipUtil{
	private static final Logger log = LogManager.getLogger(WebServiceGzipUtil.class);

	public static byte[] compress(final String input) throws IOException{
		byte[] bytes = null;
		try {
			if ((input == null) || (input.length() == 0)) {
				throw new NullPointerException();
			}
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(byteArrayOutputStream);
			gzip.write(input.getBytes("UTF-8"));
			gzip.flush();
			gzip.close();
			bytes = byteArrayOutputStream.toByteArray();
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return bytes;
	}

	public static String decompress(final byte[] compressed) throws IOException {
		final StringBuilder stringBuilder = new StringBuilder();
		try {
			if ((compressed == null) || (compressed.length == 0)) {
				throw new NullPointerException();
			}
			if (isCompressed(compressed)) {
				final GZIPInputStream ungzip = new GZIPInputStream(new ByteArrayInputStream(compressed));
				final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ungzip, "UTF-8"));
	
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					stringBuilder.append(line);
				}
			} else {
				stringBuilder.append(compressed);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return stringBuilder.toString();
	}

	public static boolean isCompressed(final byte[] compressed) {
		return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
	}
}
