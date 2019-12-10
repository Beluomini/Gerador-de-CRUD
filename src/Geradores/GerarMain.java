/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geradores;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

/**
 *
 * @author radames
 */
public class GerarMain {

    String projetoDestino;
    String nomeClasse;

    public GerarMain(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        gerarMain();
    }

    private void gerarMain() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        //fazer a classe de controle de lista
        codigoGerado.clear();

        codigoGerado.add("/*\n"
                + " * To change this license header, choose License Headers in Project Properties.\n"
                + " * To change this template file, choose Tools | Templates\n"
                + " * and open the template in the editor.\n"
                + " */\n"
                + "package Main;\n"
                + "\n"
                + "import java.text.ParseException;"
                + "/**\n"
                + " *\n"
                + " * @author Lucas\n"
                + " */\n"
                + "public class Main {\n"
                + "\n"
                + "    /**\n"
                + "     * @param args the command line arguments\n"
                + "     */\n"
                + "    public static void main(String[] args) throws ParseException {\n"
                + "       GUI gui = new GUI();\n"
                + "//É NESCESSARIO COLOCAR O NOME DOS CRUDS NO GUI\n"
                + "    }\n"
                + "    \n"
                + "}");

        String cc = projetoDestino + "/src/Main/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "Main.java", codigoGerado);
    }
}
