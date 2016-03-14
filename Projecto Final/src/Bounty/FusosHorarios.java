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
	
		fusosHorarios.add(new FusosHorarios("Lisboa",0));
		fusosHorarios.add(new FusosHorarios("Tokio",10));
		fusosHorarios.add(new FusosHorarios("New York",-5));
		fusosHorarios.add(new FusosHorarios("Açores",-1));
		fusosHorarios.add(new FusosHorarios("Madrid",1));

		
		
	}

	/*@SuppressWarnings("unchecked")
	public static void listaFusos() throws IOException, ClassNotFoundException{
		FileInputStream fis;
		
		fis = new FileInputStream("src/Bounty/resources/fusohorarios.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		fusosHorarios = (ArrayList<FusosHorarios>) ois.readObject();
		ois.close();
	}*/
	
	
	public FusosHorarios(String cidade, int diferencaHoraria){
		this.cidade = cidade;
		this.diferencaHoraria = diferencaHoraria;
	}

	/*public String getCidade(){
		return cidade;
	}
	public int getDiferencaHoraria(){
		return diferencaHoraria;
	}*/

	public ArrayList<FusosHorarios> getListaFusos(){
		return fusosHorarios;
	}


}
