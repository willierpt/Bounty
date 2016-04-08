package Bounty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;




public class TarefasConcluidas implements Serializable{
	String tarefaConcluida;
	static ArrayList<TarefasConcluidas> tarefasConcluidas = new ArrayList<TarefasConcluidas>();

	public static void main(String[] args) {
		//listaTarefasConcluidas();

		try {
			loadTarefas();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(getTarefa(0));
	}

	public static void listaTarefasConcluidas(){

		tarefasConcluidas.add(new TarefasConcluidas("Concluido"));
		tarefasConcluidas.add(new TarefasConcluidas("Concluido1"));
		tarefasConcluidas.add(new TarefasConcluidas("Concluido2"));

	}	

	public TarefasConcluidas(String tarefaConcluida) {
		this.tarefaConcluida = tarefaConcluida;
	}
	//for comit
	public static void adicionaTarefa(String a){
		tarefasConcluidas.add(new TarefasConcluidas(a));
	}

	public static String getTarefa(int indice){
		String a;
		//a = tarefasConcluidas.get(indice).toString();
		a = tarefasConcluidas.get(indice).tarefaConcluida;
		return a;
	}

	public static void gravarTarefas() throws FileNotFoundException, IOException{
		FileOutputStream fos = new FileOutputStream("tarefasDone.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(tarefasConcluidas);
		oos.close();

	}

	public static void loadTarefas() throws IOException, ClassNotFoundException{
		try {
			FileInputStream fis = new FileInputStream("tarefasDone.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			tarefasConcluidas = (ArrayList<TarefasConcluidas>) ois.readObject();
			ois.close();
		}
		catch (FileNotFoundException e) {
			gravarTarefas();


		}


	}



}