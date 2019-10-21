package triangleArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWorker {
	
	public File createFile(String fileName) {
		File file = new File(fileName);
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return file;
	}
	
	
	public void checkFileSize(File file) throws FileSizeException {
		try (FileInputStream fileInputStream = new FileInputStream(file);){
			if (fileInputStream.available() > 50) throw new FileSizeException("размер файла слишком большой");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	
	public Triangle calcTriangleMaxAreaFromFile(File file) {
		Triangle triangleMaxArea = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			checkFileSize(file);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			int lineNumber = 1;
			String[] coordinates = new String[6];
			Triangle triangle = new Triangle();
			while ((line = bufferedReader.readLine()) != null) {
				try {
					coordinates = line.split(" ");
					triangle.setX1(Integer.parseInt(coordinates[0]));
					triangle.setY1(Integer.parseInt(coordinates[1]));
					triangle.setX2(Integer.parseInt(coordinates[2]));
					triangle.setY2(Integer.parseInt(coordinates[3]));
					triangle.setY3(Integer.parseInt(coordinates[4]));
					triangle.setX3(Integer.parseInt(coordinates[5]));
					if (triangleMaxArea == null || 
							triangleMaxArea.getArea() < triangle.calcArea())
						triangleMaxArea = triangle;
				}catch (Exception e) {
					System.out.println("строка " + lineNumber + " содержит неверные координаты. Этот треугольник не будет учтен.");
				}
				lineNumber++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (FileSizeException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(fileReader != null) fileReader.close();
				if(bufferedReader != null) bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return triangleMaxArea;
	}
	
	
	public void write(String fileName, Triangle triangle) {
		
		try (FileWriter fileWriter = new FileWriter(createFile(fileName))) {
			if (triangle != null) fileWriter.write(triangle.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





















