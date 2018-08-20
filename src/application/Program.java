/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import arquivo.ManipulacaoArquivo;
import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o caminho do arquivo: ");
        String caminhoDoArquivo = sc.nextLine();
        
        ManipulacaoArquivo ma = new ManipulacaoArquivo();
        
        ma.metodoDeManipulacaoDeArquivo(caminhoDoArquivo);
        
    }
    
}
