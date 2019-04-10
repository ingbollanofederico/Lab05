package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.db.AnagrammaDAO;

public class Model {
	
	public Map<String,Boolean> anagrammi(String parola){
		CercaAnagramma a = new CercaAnagramma();
		List<Anagramma> list = a.generaAnagramma(parola);
		List<Anagramma> listClean = new ArrayList<Anagramma>();
		
		Map<String,Boolean> mappa = new HashMap<String,Boolean>();
		AnagrammaDAO dao = new AnagrammaDAO();
		
		
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size();j++) {
				if(i!=j && list.get(i).getAnagramma().compareTo(list.get(j).getAnagramma())==0){
				}else {
					listClean.add(list.get(i));
				}
			}
		}
		
		for(Anagramma aa: listClean) {
			mappa.put(aa.getAnagramma(), dao.isCorrect(aa));
		}
		
		
		return mappa;
	}

}
