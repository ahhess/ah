package bwbv.ersatzspielercheck;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class CSVLoader {

	void load(String filename, int skipRows) throws IOException {
		System.out.println("lade " + filename);
		int anz = 0;
		int j = skipRows - 1;
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = br.readLine();
		for (int i = 0; line != null; i++) {
			// Ueberschriftszeile(n) ueberspringen
			if (i > j) {
				processRow(line.split(";"));
				anz++;
				if (i == 100) {
					System.out.print(".");
					i = 0;
				}
			}
			line = br.readLine();
		}
		System.out.println("\n" + anz + " Zeilen geladen.");
	}

	abstract void processRow(String[] token);
}
