package Bounty;


import java.io.Serializable;
import java.util.ArrayList;

public class FusosHorarios implements Serializable {
	String cidade;
	int diferencaHoraria;
	static ArrayList<FusosHorarios> fusosHorarios = new ArrayList<FusosHorarios>();

	public static void listaFusos(){
		//for comit
		fusosHorarios.add(new FusosHorarios("GMT  0 - Lisboa, Londres",0));
		fusosHorarios.add(new FusosHorarios("GMT -1 - Ponta Delgada",-1));
		fusosHorarios.add(new FusosHorarios("New York",-5));
		fusosHorarios.add(new FusosHorarios("Açores",-1));
		fusosHorarios.add(new FusosHorarios("Madrid",1));
		fusosHorarios.add(new FusosHorarios("Sydney",10));
		fusosHorarios.add(new FusosHorarios("Paris",1));
		fusosHorarios.add(new FusosHorarios("Lima", -5));



	}



	public FusosHorarios(String cidade, int diferencaHoraria){
		this.cidade = cidade;
		this.diferencaHoraria = diferencaHoraria;
	}


	public ArrayList<FusosHorarios> getListaFusos(){
		return fusosHorarios;
	}


}
