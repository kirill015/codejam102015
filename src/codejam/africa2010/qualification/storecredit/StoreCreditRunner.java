package codejam.africa2010.qualification.storecredit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class StoreCreditRunner {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nTestCases = readIntLine(rdr).get(0);
		
		for(int testNum = 0; testNum < nTestCases; testNum++) {
			int credit = readIntLine(rdr).get(0);
			int nItems = readIntLine(rdr).get(0);
			List<Integer> prices = readIntLine(rdr);
			
			List<Integer> solution = getItemIndicesWithTotal(prices, credit);
			
			writer.write(String.format("Case #%d: %d %d\n", testNum, solution.get(0), solution.get(1)));
			writer.flush();
		}
		
	}
	
	private static List<Integer> getItemIndicesWithTotal(List<Integer> prices, int credit) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		result.add(2);
		result.add(5);
		return result;
	}

	private static List<Integer> readIntLine(BufferedReader rdr) throws IOException {
		String line = rdr.readLine();
		String[] tokens = line.split(" ");
		List<Integer> ints = new ArrayList<Integer>();
		
		for(int i = 0; i < tokens.length; i++) {
			String token = tokens[i].trim();
			if(token.isEmpty())
				continue;
			
			ints.add(Integer.parseInt(token));
		}
		
		return ints;
	}

}
