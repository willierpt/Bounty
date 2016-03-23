package Bounty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Tarefas {
	String tarefa;
	private static String[] tarefas = new String[6];

	public static void main(String[] args) {
		
		try {
			tarefas = loadTarefas();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getTarefaIndex(0));
	}

	public Tarefas(String tarefa) {
		this.tarefa = tarefa;

	}

	public static void preencheListaTeste(){
		for(int i=0;i<tarefas.length;i++){
			tarefas[i] = "Texto " + (i+1);
		}
	}

	public static void adicionaTarefa(String e,int indice){
		tarefas[indice] = e;
	}

	public static String getTarefaIndex(int indice){
		return tarefas[indice];
	}


	public static int getSize(){
		return tarefas.length;
	}

	public static int getIndexTarefa(String e){
		try {
			tarefas = loadTarefas();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int index= -1;
		for (int i = 0; i<getSize();i++){
			if(e.equalsIgnoreCase(getTarefaIndex(i))){
				index = i;
				break;

			}
		}

		return index;
	}

	public static void apagaTarefa(int indice){
		tarefas[indice] = "";
	}

	public static void gravarTarefas() throws FileNotFoundException, IOException{
		String filename = "tarefas.bin";
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
		outputStream.writeObject(tarefas);
		outputStream.close();
	}

	public static String[] loadTarefas() throws FileNotFoundException, IOException, ClassNotFoundException{
		String filename = "tarefas.bin";
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename)); 
		String[] x = (String[])inputStream.readObject();
		inputStream.close();
		return x;

	}
}