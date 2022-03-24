package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {
	
	private ArrayList<Country> cy;
	private ArrayList<Country> cyCopy;
	private File file= new File(".//files//Countries.txt");
	
	public Sorting() {
		cy= new ArrayList<>();
	}
	
	public void addCountry(String co)  {
		String[] ln=co.split(";");
		String name= ln[0];
		int goldM=Integer.parseInt(ln[1]);
		int silverM= Integer.parseInt(ln[2]);
		int bronceM= Integer.parseInt(ln[3]);
		int goldF= Integer.parseInt(ln[4]);
		int silverF= Integer.parseInt(ln[5]);
		int bronceF= Integer.parseInt(ln[6]);
		
		cy.add(new Country(name,goldM,silverM,bronceM,goldF,silverF,bronceF));
		cyCopy=cy;
	}

	public void chargeFiles() throws IOException {
		
		FileReader fr = new FileReader(file);

		BufferedReader input = new BufferedReader(fr);
		
		while (input.ready()) {
			String line=input.readLine();
			addCountry(line);
		}
		input.close();
		fr.close();
	}
	
	public void firstSort() {
		Collections.sort(cy, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				int result=o1.getGoldM()-o2.getGoldM();
				if(result==0)
					result=o1.getSilverM()-o2.getSilverM();
				if(result==0)
					result=o1.getBronzeM()-o2.getBronzeM();
				if(result==0)
					result=o1.getNameC().compareTo(o2.getNameC());
				return result;
			}
		});
		for(int i=0;i<cy.size();i++) {
			System.out.println(cy.get(i).toStringM());
		}
		System.out.println("----------");
		cy=cyCopy;
	}
	
	public void secondSort() {
		Collections.sort(cy);
		for(int i=0;i<cy.size();i++) {
			System.out.println(cy.get(i).toStringF());
		}
		System.out.println("----------");
		cy=cyCopy;
	}
	
	public void thirdSort() {
		int n = cy.size();
		boolean inversion = true;
		
		for (int i = 0; i < n && inversion; i++) {
			inversion = false;
	    	for (int j = 1; j < n - i; j++) {
	    		if (cy.get(j).compareByTeam(cy.get(j-1)) > 0) {
	    			Country temp = cy.get(j);
	    			cy.set(j, cy.get(j-1));
	    			cy.set(j-1, temp);
	    			inversion = true;
	    		}
	    	}
	    }
		for(int i=0;i<cy.size();i++) {
			System.out.println(cy.get(i).toStringA());
		}
		cy=cyCopy;
	}

	public void showList() {
		firstSort();
		secondSort();
		thirdSort();
	}
}
