package br.com.cod3r.cm.visao;

import java.util.Scanner;

import br.com.cod3r.cm.excecao.ExplosaoException;
import br.com.cod3r.cm.excecao.SairException;
import br.com.cod3r.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
		
	}
	
	private void executarJogo () {
		try {
			boolean continuar = true;
			cicloDoJogo();
			
			while(continuar) {
				System.out.println("Outra pardida? (S/n) ");
				String reposta = entrada.nextLine();
				
				
				if("n".equalsIgnoreCase(reposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
				
			}
			
			
		} catch (SairException e) {
			System.out.println("Tchau!!!");
		} finally {
			entrada.close();
		}
	}
	
	private void cicloDoJogo() {
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite (x, y): ");
			}
			
			System.out.println("Você ganhou!");
		} catch(ExplosaoException e) {
			System.out.println("Você perdeu!");
		}
	}
	
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		
		return digitado;
	}

}
