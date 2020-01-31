package com.test.honeywell.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HoneyWellTest {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
		int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> matrix = new ArrayList<>();

		for (int i = 0; i < matrixRows; i++) {
			String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> matrixRowItems = new ArrayList<>();

			for (int j = 0; j < matrixColumns; j++) {
				int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
				matrixRowItems.add(matrixItem);
			}

			matrix.add(matrixRowItems);
		}

		List<List<Integer>> res = fillShape(matrix);

		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				bufferedWriter.write(String.valueOf(res.get(i).get(j)));

				if (j != res.get(i).size() - 1) {
					bufferedWriter.write(" ");
				}
			}

			if (i != res.size() - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}


	public static List<List<Integer>> fillShape(List<List<Integer>> matrix) {
		//i need to put values in the array
		Integer[][] intArr = new Integer[matrix.size()][];
		for (int i = 0; i < matrix.size(); i++) {
			intArr[i] = matrix.get(i).toArray(new Integer[matrix.get(i).size()]);
		}

		Integer[][] newArr = new Integer[intArr.length][];
		for (int p =0; p < intArr.length ; p++){
			for(int x =0 ; x < intArr[p].length; x++){
				if (intArr[p][x] == 1){
					newArr[p][x + 1] = 1;
				}
			}
		}

		List<List<Integer>> myList = new ArrayList<>();
		for (int i = 0; i < newArr.length; i++){
			List newList = new ArrayList();
			for(int z = 0; z < newArr[i].length; z++){

				newList.add(z);

			}
			myList.add(i, newList);
		}

		return myList;

	}

}