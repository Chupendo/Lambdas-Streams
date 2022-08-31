package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import pjo.MemberTeams;

public class ProccesCSV {

	public ProccesCSV() {}
	
	
	public List<Object> readCSV(String doc) throws IOException {
		if(doc==null)
			return null;
		
		CSVReader csvReader = new CSVReader(new FileReader(doc));
		String[] row = null;
		List<MemberTeams> listMembersTeams = new ArrayList<MemberTeams>();
		csvReader.readNext(); //Saltamos la cabecera
		while((row = csvReader.readNext()) != null) {
			//System.out.println(row[0] + " | " + row[1]);
			 
			MemberTeams memberTeams = new MemberTeams();
			memberTeams.setName(row[0]);
			memberTeams.setEmail(row[1]);
			
			listMembersTeams.add(memberTeams);
		}

		csvReader.close();
		
		return (List)listMembersTeams;
	}
}
