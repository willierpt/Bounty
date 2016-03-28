package Bounty;

import java.util.ArrayList;
import java.util.Scanner;

public class Ponteiros {

	public static void main(String[] args) {
		Scanner in	= new Scanner(System.in);
		System.out.println("--Circunferencia de raio 1--");
		System.out.print("Int. Graus:");
		double graus = in.nextDouble();
		System.out.print("Int. CentroX:");
		double centroX = in.nextDouble();
		System.out.print("Int. CentroY:");
		double centroY = in.nextDouble();
		System.out.print("Int. raio:");
		double raio = in.nextDouble();

		System.out.println("coord X = " + getCoordXfromGraus(graus,raio,centroX));
		System.out.println("coord Y = " + getCoordYfromGraus(graus,raio,centroY));
		in.close();
	}

	public static int getCoordXfromGraus(double graus, double raio,double centroX){
		return (int)(raio*(Math.cos(graus * (Math.PI / 180))) + centroX);
	}

	public static int getCoordYfromGraus(double graus, double raio,double centroY){
		return (int)(Math.abs(raio*(Math.sin(graus * (Math.PI / 180))) + centroY));
	}

	public static int getGrausFromHoraFuso(Object cidade, ArrayList<FusosHorarios> fusos){
		int hora = BuscaHora.getHoraFuso(cidade, fusos);
		int minuto = BuscaHora.obtemMinuto();
		if (hora > 12){
			hora -= 12;
		}
		return (int) ((-1*(30*hora+0.5*minuto))+90);
	}

	public static int getGrausFromHora(){
		int hora = BuscaHora.obtemHora();
		int minuto = BuscaHora.obtemMinuto();
		if (hora > 12){
			hora -= 12;
		}
		return (int) ((-1*(30*hora+0.5*minuto))+90);
	}

	public static int getGrausFromMinuto(){
		return (-1*(6*BuscaHora.obtemMinuto()))+90;
	}

	public static int getGrausFromSegundo(){
		return (-1*(6*BuscaHora.obtemSegundo()))+90;
	}



}
