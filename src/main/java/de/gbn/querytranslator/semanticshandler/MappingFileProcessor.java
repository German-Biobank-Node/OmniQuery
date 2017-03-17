package de.gbn.querytranslator.semanticshandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MappingFileProcessor {

	private List<MappingEntry> mappingEntries = new ArrayList<MappingEntry>();

	public MappingEntry addUniqueMappingEntry(MappingEntry mapping) {
		for (int a = 0; a < mappingEntries.size(); a++) {
			if (mapping.isMappable(mappingEntries.get(a)))
				return mappingEntries.get(a);
		}

		mapping.removeWildcards();
		mappingEntries.add(mapping);
		return mapping;
	}

	public void writeCsvFile() {
		File file = new File("MappingFile.csv");
		System.out.println("Writing mapping file: " + file.getAbsolutePath());

		try {
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);
			MappingEntry attr = new MappingEntry();
			bw.write(attr.getHeadline() + "\n");

			for (int a = 0; a < mappingEntries.size(); a++) {
				bw.write(mappingEntries.get(a).getCsvLine() + "\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		File file = new File("MappingFile.csv");
		System.out.println("Reading mapping file: " + file.getAbsolutePath());

		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine();

				int linepos = 0;
				while ((line = br.readLine()) != null) {
					MappingEntry newAttributes = new MappingEntry();
					linepos++;
					try {
						newAttributes.initFromLine(line);
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Could not process line " + linepos + " in MappingFile.csv!");
						e.printStackTrace();
					}

					// addUniqueMappingEntry(newAttributes);
					mappingEntries.add(newAttributes);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
