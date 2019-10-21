package triangleArea;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		String inputFileName = args[0];
		String outputFileName = args[1];
		
		FileWorker fileWorker = new FileWorker();
		File inputFile = fileWorker.createFile(inputFileName);
		Triangle triangle = fileWorker.calcTriangleMaxAreaFromFile(inputFile);
		fileWorker.write(outputFileName, triangle);
		
	}
}





















