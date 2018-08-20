/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivo;

import Entidade.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathan
 */
public class ManipulacaoArquivo {

    private List<Produto> produtos = new ArrayList<>();
    
    public void metodoDeManipulacaoDeArquivo(String caminhoArquivo){
        leituraArquivo(caminhoArquivo);
        escreverNoArquivo(caminhoArquivo);
    }

    private void leituraArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] array = linha.split(";");
                produtos.add(new Produto(array[0], Double.parseDouble(array[1]), Integer.parseInt(array[2])));
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    
    private void escreverNoArquivo(String caminhoArquivo){
        
        File arquivo = new File(caminhoArquivo);
        
        String caminhoDiretorio = arquivo.getParent();
        
        new File(caminhoDiretorio + "\\out").mkdir();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDiretorio+"\\out\\sumario.csv"))) {
            
            for(Produto p : produtos){
                bw.write(p.getNome()+", "+(p.getPreco()*p.getQuantidade()));
                bw.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
