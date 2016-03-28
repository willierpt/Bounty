package Bounty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TarefasConcluidas {
	String tarefaConcluida;
	static ArrayList<TarefasConcluidas> tarefasConcluidas = new ArrayList<TarefasConcluidas>();
	
	public static void main(String[] args) {
		try {
			loadTarefas();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listaTarefasConcluidas(){
		
		/*tarefasConcluidas.add(new TarefasConcluidas("Concluido"));
		tarefasConcluidas.add(new TarefasConcluidas("Concluido1"));
		tarefasConcluidas.add(new TarefasConcluidas("Concluido2"));*/
		
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
		a = tarefasConcluidas.get(indice).toString();
		return a;
	}

	public static void gravarTarefas() throws FileNotFoundException, IOException{
		String filename = "tarefasDone.bin";
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
		outputStream.writeObject(tarefasConcluidas);
		outputStream.close();
	}
	
	public static void loadTarefas() throws IOException, ClassNotFoundException{
		String filename = "tarefasDone.bin";
		ObjectInputStream inputStream;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(filename));
			ArrayList<TarefasConcluidas> x = (ArrayList<TarefasConcluidas>)inputStream.readObject();
			inputStream.close();
			tarefasConcluidas = x;
		} catch (FileNotFoundException e) {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
			outputStream.writeObject(tarefasConcluidas);
			outputStream.close();
		}

	}
	
}