package Bounty;

public class Tarefas {
	String tarefa;
	boolean done;

	public String getTarefa() {
		return tarefa;
	}

	public boolean getDone() {
		return done;
	}

	public Tarefas(String tarefa, boolean done) {
		this.tarefa = tarefa;
		this.done = done;
	}
}