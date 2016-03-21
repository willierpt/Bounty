package Bounty;

import java.util.ArrayList;

public class Tarefas {
	String tarefa;
	static ArrayList<Tarefas> tarefas = new ArrayList<Tarefas>();
	
	public static void listaTarefas(){
		
		tarefas.add(new Tarefas("Teste"));
		tarefas.add(new Tarefas("Teste1"));
		tarefas.add(new Tarefas("Teste2"));
		tarefas.add(new Tarefas("Teste3"));
		tarefas.add(new Tarefas("Teste4"));
		tarefas.add(new Tarefas("Teste5"));
		
	}	

	public Tarefas(String tarefa) {
		this.tarefa = tarefa;

	}
	
	public ArrayList<Tarefas> getListaTarefas(){
		return tarefas;
	}
}