package Bounty;

public class Tarefas {

	int index;
	String tarefa;
	boolean done;

	public String getTarefa() {
		return tarefa;
	}

	public boolean getDone() {
		return done;
	}

	/*public int getIndex() {
		return index;
	}*/

	public Tarefas(String tarefa, boolean done) {
		//this.index = index;
		this.tarefa = tarefa;
		this.done = done;
	}
}