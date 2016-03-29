package Bounty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class FusosHorarios implements Serializable {
	String cidade;
	int diferencaHoraria;
	static ArrayList<FusosHorarios> fusosHorarios = new ArrayList<FusosHorarios>();

	public static void listaFusos(){
		//for comit
		fusosHorarios.add(new FusosHorarios("Lisboa",0));
		fusosHorarios.add(new FusosHorarios("Tokio",10));
		fusosHorarios.add(new FusosHorarios("New York",-5));
		fusosHorarios.add(new FusosHorarios("A�ores",-1));
		fusosHorarios.add(new FusosHorarios("Madrid",1));
		fusosHorarios.add(new FusosHorarios("Sydney",10));
		fusosHorarios.add(new FusosHorarios("Paris",1));

		
		
	}

	
	
	public FusosHorarios(String cidade, int diferencaHoraria){
		this.cidade = cidade;
		this.diferencaHoraria = diferencaHoraria;
	}


	public ArrayList<FusosHorarios> getListaFusos(){
		return fusosHorarios;
	}


}
