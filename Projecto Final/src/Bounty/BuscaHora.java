package Bounty;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BuscaHora {

	static BuscaHora tempo = new BuscaHora();

	public static void main(String[] args) {
		
	}

	public String getRelogio(){
		int hora,minuto,segundo;
		hora = tempo.obtemHora();
		minuto = tempo.obtemMinuto();
		segundo = tempo.obtemSegundo();
		String relogio = String.format("%02d:%02d:%02d",hora,minuto,segundo);
		//String relogio = hora+":"+minuto+":"+segundo;

		//log
		//System.out.printf("%02d:%02d:%02d",hora,minuto,segundo);
		//System.out.println(relogio);
		return relogio;
	}

	public int getHoraFuso(Object cidade, ArrayList<FusosHorarios> fusosHorarios){
		int diferenca = 0;

		//diferenca = fusosHorarios.get(fusosHorarios.indexOf(cidade)).diferencaHoraria;

		for (int i = 0; i<fusosHorarios.size();i++){
			if(cidade.equals(fusosHorarios.get(i).cidade)){
				diferenca = fusosHorarios.get(i).diferencaHoraria;
				break;
			}
		}
		int hora = obtemHora() + diferenca;
		if (hora >= 24){
			hora-=24;
		}
		if (hora<0){
			hora = 24 + diferenca;
		}
		return hora;
	}

	public String getRelogioFuso(Object cidade, ArrayList<FusosHorarios> fusosHorarios){

		int hora = tempo.getHoraFuso(cidade,fusosHorarios);
		int minuto = tempo.obtemMinuto();
		int segundo = tempo.obtemSegundo();

		String relogio = String.format("%02d:%02d:%02d",hora,minuto,segundo);
		return relogio;
	}

	public int obtemHora(){
		int hora;
		Date data = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(data); 
		hora = calendar.get(Calendar.HOUR_OF_DAY);
		return hora;
	}
	public int obtemMinuto(){
		int min;
		Date data = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(data); 
		min = calendar.get(Calendar.MINUTE);
		return min;
	}
	public int obtemSegundo(){
		int sec;
		Date data = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(data);
		sec = calendar.get(Calendar.SECOND);
		return sec;
	}



}
