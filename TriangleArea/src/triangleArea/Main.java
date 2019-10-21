package triangleArea;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String inputFileName = "";
		String outputFileName = "";
		try {
			inputFileName = args[0];
			outputFileName = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Не введены названия входного и выходного файлов");
			inputFileName = "in.txt";
			outputFileName = "out.txt";
		}
		FileWorker fileWorker = new FileWorker();
		File inputFile = fileWorker.createFile(inputFileName);
		Triangle triangle = fileWorker.calcTriangleMaxAreaFromFile(inputFile);
		fileWorker.write(outputFileName, triangle);
		
	}
}





















