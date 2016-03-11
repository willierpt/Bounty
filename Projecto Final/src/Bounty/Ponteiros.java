package Bounty;

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
	}

	public static int getCoordXfromGraus(double graus, double raio,double centroX){
		return (int)(raio*(Math.cos(graus * (Math.PI / 180))) + centroX);
	}
	
	public static int getCoordYfromGraus(double graus, double raio,double centroY){
		return (int)(Math.abs(raio*(Math.sin(graus * (Math.PI / 180))) + centroY));
	}
	
	/*public static int[] getCoordPonteiro(double graus, double raio, double centroX, double centroY){
		int[] coordXY = new int[2];
		
		coordXY[0] = (int)(raio*(Math.cos(graus * (Math.PI / 180))) + centroX);
		coordXY[1] = (int)(Math.abs(raio*(Math.sin(graus * (Math.PI / 180))) + centroY));

		return coordXY;
	}*/
	
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
	
	/*public static int[] getGrausfromHoraMinutoSegundo(){
		int[] grausHMS = new int[3];
		int hora = BuscaHora.obtemHora();
		if (hora > 12){
			hora -= 12;
		}
		int minuto = BuscaHora.obtemMinuto();
		int segundo = BuscaHora.obtemSegundo();
		grausHMS[1] = (-1*(6*minuto))+90;
		grausHMS[0] = (int) ((-1*(30*hora+0.5*minuto))+90);
		grausHMS[2] = (-1*(6*segundo))+90;
		
		return grausHMS;
	}*/

}
