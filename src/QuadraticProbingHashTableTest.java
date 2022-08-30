import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class QuadraticProbingHashTableTest {
	// Size of this should preferably be a prime number 
	private static final int DEFAULT_TABLE_SIZE = 10001;
	
    public static void main(String[] args) throws FileNotFoundException, IOException {	   
    	try {
    	Instant start = Instant.now();	
    	BufferedReader read = new BufferedReader(new FileReader("patient_categories.txt"));
        read.readLine();
    	String thisLine = null;
    	
    	QuadraticProbingHashTable table = new QuadraticProbingHashTable(DEFAULT_TABLE_SIZE);
    	
    	int i = 0;
    	while((thisLine = read.readLine()) != null)
    		table.insert(Integer.toString(i++), thisLine);
    	
    	for(int j = 0; j < DEFAULT_TABLE_SIZE; j++)
    		System.out.println(table.get(Integer.toString(j)));
    	
    	table.printHashTable();
    	Instant end = Instant.now();
    	
    	System.out.println("Number of operations: " + table.getOperationCount());
    	Duration interval = Duration.between(start, end);
    	System.out.println("Execution time: " + interval.toMillis() + " milliseconds");
    
    	read.close();	
    	}
    	catch (Exception e) {
    		System.out.print("Your file cannot be found...");
    	}
    }
}