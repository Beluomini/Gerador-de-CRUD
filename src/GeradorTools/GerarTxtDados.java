/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

/**
 *
 * @author radames
 */
public class GerarTxtDados {

    String projetoDestino;
    String nomeClasse;

    public GerarTxtDados(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        gerarTxtDados();
    }

    private void gerarTxtDados() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        String cc = projetoDestino + "/" + nomeClasse + "Dados.txt";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc, codigoGerado);

        //terminou a classe de entidade
    }

}
