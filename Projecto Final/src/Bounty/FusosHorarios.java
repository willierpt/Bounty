package Bounty;

import java.util.ArrayList;

public class FusosHorarios {
	String cidade;
	int diferencaHoraria;
	static ArrayList<FusosHorarios> fusosHorarios = new ArrayList<FusosHorarios>();

	public static void listaFusos(){

		fusosHorarios.add(new FusosHorarios("Lisboa",0));
		fusosHorarios.add(new FusosHorarios("Tokio",10));
		fusosHorarios.add(new FusosHorarios("New York",-5));
		fusosHorarios.add(new FusosHorarios("Açores",-1));
		fusosHorarios.add(new FusosHorarios("Madrid",1));

	}

	public FusosHorarios(String cidade, int diferencaHoraria){
		this.cidade = cidade;
		this.diferencaHoraria = diferencaHoraria;
	}

	public String getCidade(){
		return cidade;
	}
	public int getDiferencaHoraria(){
		return diferencaHoraria;
	}

	public ArrayList<FusosHorarios> getListaFusos(){
		return fusosHorarios;
	}


}
