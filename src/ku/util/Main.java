package ku.util;

import stopwatch.Stopwatch;
import stopwatch.TaskTimer;

/**
 * Running the tasks.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class Main {
	/**
	 * It uses FileCopyTask class to create anonymous classes for each task.<br>
	 * It uses Stopwatch and TaskTimer to execute the tasks.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final String inputFilename = "Big-Alice-in_Wonderland.txt";

		TaskTimer timer = new TaskTimer();
		// task copy file one byte at a time
		FileCopyTask oneByteTask = new FileCopyTask(inputFilename, "OneByteAtTime.txt") {
			@Override
			public void run() {
				FileUtil.copy(in, out);
			}

			@Override
			public String toString() {
				return "Copy file one byte at a time.";
			}
		};
		timer.measureAndPrint(oneByteTask);

		// task copy file with byte array at a time
		int[] sizes = { 1024, 4 * 1024, 16 * 1024, 32 * 1024, 64 * 1024 };
		for (int size : sizes) {
			FileCopyTask byteArrayTask = new FileCopyTask(inputFilename, "ByteArray" + (size / 1024) + "KB.txt") {
				@Override
				public void run() {
					FileUtil.copy(in, out, size);
				}

				@Override
				public String toString() {
					return "Copy file using a byte of size " + (size / 1024) + "KB.";
				}
			};
			timer.measureAndPrint(byteArrayTask);
		}

		//task copy file using BufferedReader and PrintWriter and read one line at a time.
		FileCopyTask readerAndWriterS = new FileCopyTask(inputFilename, "ReaderAndWriterString.txt") {
			@Override
			public void run() {
				FileUtil.scopy(in, out);
			}

			@Override
			public String toString() {
				return "Copy file using BufferedReader and PrintWriter to copy lines of text";
			}
		};
		timer.measureAndPrint(readerAndWriterS);

		//task copy file using BufferedReader and PrintWriter with an array of char
		FileCopyTask readerAndWriterC = new FileCopyTask(inputFilename, "ReaderAndWriterCharArray.txt") {
			@Override
			public void run() {
				FileUtil.ccopy(in, out);
			}

			@Override
			public String toString() {
				return "Copy file using BufferedReader and PrintWriter to copy lines of text Character";
			}
		};
		timer.measureAndPrint(readerAndWriterC);

	}
}
