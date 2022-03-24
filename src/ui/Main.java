package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Sorting;

public class Main {
	
	public static InputStreamReader isr= new InputStreamReader(System.in);
	public static BufferedReader br= new BufferedReader(isr);
	public static Sorting st= new Sorting();
	
	public static void main(String[]args) {
		boolean r=true;
		try {
			while(r) {
				System.out.println("Bienvenido\n1:Digitar países\n2:Cargar países\n3:Mostrar listas\n4:Salir");
				String op=br.readLine();
				
				
				switch(Integer.parseInt(op)) {
				
				case 1:
					input();
					System.out.println();
				break;
				
				case 2:
					st.chargeFiles();
					System.out.println();
				break;
				
				case 3:
					st.showList();
					System.out.println();
				break;
				
				case 4:
					r=false;
					System.out.println("El programa ha finalizado");
				break;
				
				default:
					System.out.println("Esta opción no existe");
				}
			}
			
			br.close();
			isr.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public static void input() throws IOException {
		System.out.println("Digite el número de paises entrantes");
		String num=br.readLine();
		int num2=Integer.parseInt(num);
		int cont=0;
		while(cont<num2) {
			System.out.println("Digite los paises con sus medallas:\nNombre del país;Oro hombre;Plata hombre;Bronce hombre;Oro mujer;Plata mujer;Bronce mujer");
			String co=br.readLine();
			st.addCountry(co);
			cont++;
		}
	}
}
