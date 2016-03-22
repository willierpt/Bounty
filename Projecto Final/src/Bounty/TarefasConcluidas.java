package Bounty;

import java.util.ArrayList;

public class TarefasConcluidas {
	String tarefaConcluida;
	static ArrayList<TarefasConcluidas> tarefasConcluidas = new ArrayList<TarefasConcluidas>();
	
	public static void listaTarefasConcluidas(){
		
		tarefasConcluidas.add(new TarefasConcluidas("Concluido"));
		tarefasConcluidas.add(new TarefasConcluidas("Concluido1"));
		tarefasConcluidas.add(new TarefasConcluidas("Concluido2"));
		
	}	

	public TarefasConcluidas(String tarefaConcluida) {
		this.tarefaConcluida = tarefaConcluida;
	}
	
	public ArrayList<TarefasConcluidas> getListaTarefasConcluidas(){
		return tarefasConcluidas;
	}

}