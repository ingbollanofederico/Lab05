package it.polito.tdp.model;

import java.util.*;

public class CercaAnagramma {
	
	private List<Anagramma> anagrammi;

	public CercaAnagramma() {
	}
	
	public List<Anagramma> generaAnagramma(String parola){
		anagrammi = new LinkedList<Anagramma>();
		
		Anagramma parziale = new Anagramma();
		cerca(parziale,0,parola);
				
				
		return anagrammi;
		
	}

	private void cerca(Anagramma parziale, int livello, String parola) {
		
		if(livello==parola.length()) {
			System.out.println(parziale);
			anagrammi.add(parziale.clone());
			return;
		}
		
		
		
		for(int i=0; i<parola.length();i++) {
			
			if(parziale.controllaLettere(parola,parola.toLowerCase().charAt(i))) {
			
				parziale.add(parola.charAt(i));
				
				cerca(parziale,livello+1,parola);
				
				parziale.setAnagramma(parziale.getAnagramma().substring(0,parziale.getAnagramma().length()-1));
			
			}

		}
		
	}
	
	
	

}
