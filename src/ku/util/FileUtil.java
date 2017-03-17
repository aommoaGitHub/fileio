package ku.util;

import java.io.*;

/**
 * This class define copy methods with using InputSteam, OutputSteam,
 * BufferedReader, and PrintWriter Concept is read a file and copy to output
 * file.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class FileUtil {
	/**
	 * Copy the InputSteam to the OutputSteam one byte at a time
	 * 
	 * @param in
	 *            is InputSteam of the reading file
	 * @param out
	 *            is OutputSteam of the file to be written
	 */
	static void copy(InputStream in, OutputStream out) {
		copy(in, out, 1);
	}

	/**
	 * Copy the InputSteam to the OutputSteam using byte array of size
	 * blocksize.
	 * 
	 * @param in
	 *            is InputSteam of the reading file
	 * @param out
	 *            is OutputSteam of the file to be written
	 * @param blocksize
	 *            is amount of byte to copy at a time
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		byte[] buffer = new byte[blocksize];
		try {
			while (in.read(buffer) != -1) {
				out.write(buffer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {

			}
		}
	}

	/**
	 * Copy the InputSteam to the OutputSteam using BufferedReader to read the
	 * InputSteam and PrintWriter to write the OutputSteam and read one line at
	 * a time.
	 * 
	 * @param in
	 *            is InputSteam that be used with BufferedReader to read file.
	 * @param out
	 *            is OutputSteam that be used with PrintWriter to write output
	 *            file.
	 */
	static void scopy(InputStream in, OutputStream out) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out);
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				writer.write(line + "\n");
			}
		} catch (Exception re) {
			throw new RuntimeException(re.getMessage(),re);
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {

			}
		}
	}

	/**
	 * Copy the InputSteam to the OutputSteam using BufferedReader to read the
	 * InputSteam and PrintWriter to write the OutputSteam and read with an
	 * array of char.
	 * 
	 * @param in
	 *            is InputSteam that be used with BufferedReader to read file.
	 * @param out
	 *            is OutputSteam that be used with PrintWriter to write output
	 *            file.
	 */
	static void ccopy(InputStream in, OutputStream out) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out);
		char[] line = new char[10000];
		int len;
		try {
			while ((len = reader.read(line)) != -1) {
				writer.write(line + "\n");
			}
		} catch (Exception re) {
			throw new RuntimeException(re.getMessage(),re);
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {

			}
		}
	}
}
