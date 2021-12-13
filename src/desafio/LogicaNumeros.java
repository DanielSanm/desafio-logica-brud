package desafio;

import java.util.ArrayList;
import java.util.Scanner;

public class LogicaNumeros {
	
	static int numAnterior = 0;
	static int posiLista = 0;
	static int numConcat = 0;
	static ArrayList<Integer> listaNum = new ArrayList<>();
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		
		int numMaior = 0;
		int numMaiorAnte = 0;
		boolean numMaiorAnteDef = false;

		System.out.print("Digite uma sequência aleatória de números: ");
		String num = scan.next();

		

		for (int i = 0; i < num.length(); i++) {
			if (listaNum.isEmpty()) {
				listaNum.add((int) num.charAt(i) - 48);
				numAnterior = listaNum.get(i);
			} else {
				listaNum.add((int) num.charAt(i) - 48);

				if (numAnterior == 9 && listaNum.get(i) == 0) {
					concatenarNumeros(i);

				} else if (numAnterior == listaNum.get(i) - 1) {
					concatenarNumeros(i);
				} else {
					posiLista = i;
					numAnterior = listaNum.get(i);
				}
			}
		}

		listaNum.removeIf(n -> (n == null));

		for (int i = 0; i < listaNum.size(); i++) {
			
			for (int l = 0; l < listaNum.size(); l++) {
				if(listaNum.get(i) >= listaNum.get(l)) {
					numMaior = listaNum.get(i);
				}
			}
			
			if(numMaiorAnteDef == false) {
				numMaiorAnte = numMaior;
				numMaiorAnteDef = true;
			} else if (numMaiorAnte < numMaior) {
				numMaiorAnte = numMaior;
			} else {
				numMaior = numMaiorAnte;
			}
			
		}
		
		System.out.println("O maior número em sequência numérica é: " + numMaior);

		scan.close();
	}
	
	static void concatenarNumeros(int num) {
		numConcat = Integer.parseInt(listaNum.get(posiLista).toString() 
				+ listaNum.get(num).toString());
		listaNum.set(posiLista, numConcat);
		numAnterior = listaNum.get(num);
		
		if (posiLista != num) {
			listaNum.set(num, null);
		}
	}
}
