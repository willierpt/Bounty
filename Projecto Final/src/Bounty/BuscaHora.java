package Bounty;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BuscaHora {



	public static void main(String[] args) {
		//System.out.print(getRelogio());
		ArrayList<FusosHorarios> fusosHorarios = new ArrayList<FusosHorarios>();
		fusosHorarios.add(new FusosHorarios("Lisboa",0));
		fusosHorarios.add(new FusosHorarios("Tokio",10));
		fusosHorarios.add(new FusosHorarios("New York",-5));
		fusosHorarios.add(new FusosHorarios("Açores",-1));
		getRelogioFuso("Tokio",fusosHorarios);
	}

	public static String getRelogio(){
		int hora,minuto,segundo;
		hora = obtemHora();
		minuto = obtemMinuto();
		segundo = obtemSegundo();
		String relogio = String.format("%02d:%02d:%02d",hora,minuto,segundo);
		//String relogio = hora+":"+minuto+":"+segundo;

		//log
		//System.out.printf("%02d:%02d:%02d",hora,minuto,segundo);
		//System.out.println(relogio);
		return relogio;
	}



	public static String getRelogioFuso(Object cidade, ArrayList<FusosHorarios> fusosHorarios){
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
		int minuto = obtemMinuto();
		int segundo = obtemSegundo();

		String relogio = String.format("%02d:%02d:%02d",hora,minuto,segundo);
		return relogio;
	}

	public static int obtemHora(){
		int hora;
		Date data = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(data); 
		hora = calendar.get(Calendar.HOUR_OF_DAY);
		return hora;
	}
	public static int obtemMinuto(){
		int min;
		Date data = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(data); 
		min = calendar.get(Calendar.MINUTE);
		return min;
	}
	public static int obtemSegundo(){
		int sec;
		Date data = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(data);
		sec = calendar.get(Calendar.SECOND);
		return sec;
	}



}
