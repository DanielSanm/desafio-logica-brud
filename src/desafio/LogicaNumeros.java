package desafio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que resolve o desafio/teste de conhecimentos proposto pela Brud
 * @author Daniel Elias
 * @since 1.0
 */

public class LogicaNumeros {

	// variáveis globais
	static ArrayList<Integer> listaNum = new ArrayList<>(); // lista aonde vai ser inserido cada número da seqûencia digitada
	static int numAnterior = 0;		// variável que guarda o número anterior
	static int numConcat = 0;		// variável que recebe os números concatenados
	static int posiLista = 0;		// váriável que indica aonde o número concatenado deve ser inserido na lista

	// método principal
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int numMaior = 0;					// variável que guarda o número maior
		int numMaiorAnte = 0;				// variável que guarda o número maior anterior
		boolean numMaiorAnteDef = false;	// váriável que indica se o número maior anterior já foi definido

		System.out.print("Digite uma sequência aleatória de números: ");
		String num = scan.next(); 	// variável que guarda o número digitado
		
		// loop que vefica se algum número da sequência é consecutivo ao outro
		for (int i = 0; i < num.length(); i++) {
			// adicionando o primeiro número da sequência
			if (listaNum.isEmpty()) {
				listaNum.add((int) num.charAt(i) - 48);
				numAnterior = listaNum.get(i);		
			} else {
				// adicionando cada número digitado a uma posição da lista
				listaNum.add((int) num.charAt(i) - 48);
				
				// tornando 9 e 0 consecutivos
				if (numAnterior == 9 && listaNum.get(i) == 0) {
					concatenarNumeros(i);
				// verificando se os números são consecutivos
				} else if (numAnterior == listaNum.get(i) - 1) {
					concatenarNumeros(i);
				} else {
					posiLista = i;
					numAnterior = listaNum.get(i);
				}
			}
		}

		// removendo todas as posições da lista que são nulas
		listaNum.removeIf(n -> (n == null));
		
		// loop que verifica quais dos números consecutivos é o maior 
		for (int i = 0; i < listaNum.size(); i++) {

			for (int l = 0; l < listaNum.size(); l++) {
				if (listaNum.get(i) >= listaNum.get(l)) {
					numMaior = listaNum.get(i);
				}
			}

			if (numMaiorAnteDef == false) {
				numMaiorAnte = numMaior;
				numMaiorAnteDef = true;
			} else if (numMaiorAnte < numMaior) {
				numMaiorAnte = numMaior;
			} else {
				numMaior = numMaiorAnte;
			}

		}
		
		// resultado
		System.out.println("O maior número em sequência numérica é: " + numMaior);

		scan.close();
	}
	
	// método de concatenar números a lista
	static void concatenarNumeros(int num) {
		
		//concatenando os números
		numConcat = Integer.parseInt(listaNum.get(posiLista).toString() 
				+ listaNum.get(num).toString());
		
		// inserindo a lista
		listaNum.set(posiLista, numConcat);
		
		// definindo o número anterior para a próxima verificação
		numAnterior = listaNum.get(num);
		
		// definindo a antiga posição do número concatenado como nula
		if (posiLista != num) {
			listaNum.set(num, null);
		}
		
	}
}
