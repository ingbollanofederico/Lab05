package it.polito.tdp.model;

public class Anagramma {
	
	private String anagramma;

	
	public Anagramma() {
		this.anagramma="";
	}


	public String getAnagramma() {
		return anagramma;
	}


	public void setAnagramma(String anagramma) {
		this.anagramma = anagramma;
	}
	
	public void add(Character c) {
		this.anagramma+=c;
	}

	
	
	@Override
	public String toString() {
		return anagramma;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anagramma == null) ? 0 : anagramma.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagramma other = (Anagramma) obj;
		if (anagramma == null) {
			if (other.anagramma != null)
				return false;
		} else if (!anagramma.equals(other.anagramma))
			return false;
		return true;
	}


	
	protected Anagramma clone() {
		Anagramma a = new Anagramma();
		a.setAnagramma(anagramma);
		return a;
	}


	public boolean controllaLettere(String parola, Character c) {
		int nParola=0;
		int nAnagramma=0;
		
		for(int i=0; i<parola.length(); i++) {
			if(parola.toLowerCase().charAt(i)==c) {
				nParola++;
			}
		}
		
		for(int i=0; i<anagramma.length(); i++) {
			if(anagramma.toLowerCase().charAt(i)==c) {
				nAnagramma++;
			}
		}
		
		
		if(nAnagramma<nParola) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	

}
