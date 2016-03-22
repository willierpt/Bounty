package Bounty;

import java.util.ArrayList;

public class Tarefas {
	String tarefa;
	private static ArrayList<String> tarefas = new ArrayList<String>();

	public static void main(String[] args) {
		preencheLista();
		for (int i=0;i<getSize();i++){
			System.out.println(getTarefaIndex(i)+" localizado no indice ["+i+"]");
		}
		tarefas.remove(1);
		System.out.println("--------------------------------------");
		for (int i=0;i<getSize();i++){
			System.out.println(getTarefaIndex(i)+" localizado no indice ["+i+"]");
		}
	}


	public Tarefas(String tarefa) {
		this.tarefa = tarefa;

	}

	public static void preencheLista(){
		tarefas.add("tarefa 1");
		tarefas.add("tarefa 2");
		tarefas.add("tarefa 3");
		tarefas.add("tarefa 4");
		tarefas.add("tarefa 5");
	}

	public static void adicionaTarefa(String e){
		tarefas.add(e);
	}

	public static String getTarefaIndex(int e){
		return tarefas.get(e);
	}

	public static String getLastTarefa(){
		tarefas.trimToSize();
		return tarefas.get(getSize()-1);
	}

	public static int getSize(){
		return tarefas.size();
	}

	public static int getIndexTarefa(String e){
		int index= -1;
		for (int i = 0; i<getSize();i++){
			if(e.equalsIgnoreCase(getTarefaIndex(i))){
				index = i;
				break;
			}
		}

		return index;
	}

	public static void apagaTarefaPorIndex(int e){
		tarefas.remove(e);
	}
	public static void apagaTarefaPorConteudo(String e){
		try {
			tarefas.remove(getIndexTarefa(e));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}