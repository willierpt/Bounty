package Bounty;

import java.util.ArrayList;

public class Tarefas {
	String tarefa;
	boolean done;
	static ArrayList<Tarefas> tarefas = new ArrayList<Tarefas>();
	
	public static void listaTarefas(){
		
		tarefas.add(new Tarefas("Teste",false));
		tarefas.add(new Tarefas("Teste1",false));
		tarefas.add(new Tarefas("Teste2",false));
		tarefas.add(new Tarefas("Teste3",false));
		tarefas.add(new Tarefas("Teste4",false));
		tarefas.add(new Tarefas("Teste5",false));
		
	}	

	public Tarefas(String tarefa, boolean done) {
		this.tarefa = tarefa;
		this.done = done;
	}
	
	public ArrayList<Tarefas> getListaTarefas(){
		return tarefas;
	}
}