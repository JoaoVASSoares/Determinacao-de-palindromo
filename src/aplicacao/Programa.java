package aplicacao;

import java.text.Normalizer;
import java.util.Scanner;

public class Programa {
	public static void main(String[]args) {
		
		Scanner sc = new Scanner(System.in);
		
		String normal = ""; //Entrada normal
		String invertida = ""; //Entrada Invertida
		String normalSemEspaco = "";
		String invertidaSemEspaco = "";
		String normalSemPontuacao = "";
		String invertidaSemPontuacao = "";
		String normalSemAcento = "";
		String invertidaSemAcento = "";
		
		System.out.print("Digite uma palvrava, frase ou valor numérico: ");
		normal = sc.nextLine();
		
		for(int i = normal.length() - 1; i >=0; i--) {
			invertida += normal.charAt(i);
		}

		//Retira o espaços das frases e a pontuacao
		normalSemEspaco = normal.replaceAll("\\s+","");
		invertidaSemEspaco = invertida.replaceAll("\\s+","");
		normalSemPontuacao = normalSemEspaco.replaceAll("\\p{Punct}","");
		invertidaSemPontuacao = invertidaSemEspaco.replaceAll("\\p{Punct}","");
		//Retira os acentos.
		//O primeiro faz a troca dos caracteres acentuados pelos correspondentes nao acentuados.
		//O segundo remove "sujeiras" deixadas no processo
		normalSemAcento = Normalizer.normalize(normalSemPontuacao, Normalizer.Form.NFD);
		normalSemAcento = normalSemAcento.replaceAll("[^\\p{ASCII}]", "");
		invertidaSemAcento = Normalizer.normalize(invertidaSemPontuacao, Normalizer.Form.NFD);
		invertidaSemAcento = invertidaSemAcento.replaceAll("[^\\p{ASCII}]", "");

		System.out.println();
		System.out.println("Escrita normalmente: " + normal);
		System.out.println("Escrita invertida: " + invertida);
		System.out.println();
		
		//compara a entrada normal e invertida, ignorando letras maiúsculas ou minúsculas 
		if(normalSemAcento.equalsIgnoreCase(invertidaSemAcento)) {
			System.out.println("É um palindromo");
		}
		else {
			System.out.println("Não é um palindromo");
		}
		
		sc.close();
		
	}
}
