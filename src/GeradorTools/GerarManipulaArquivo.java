/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

public class GerarManipulaArquivo {

    String projetoDestino;
    String nomeClasse;

    public GerarManipulaArquivo(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        GerarDate();
    }

    private void GerarDate() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        //fazer a classe de controle de lista
        codigoGerado.clear();
        codigoGerado.add("package tools;\n" +
"\n" +
"// @author Radames\n" +
"import java.io.BufferedReader;\n" +
"import java.io.BufferedWriter;\n" +
"import java.io.File;\n" +
"import java.io.FileReader;\n" +
"import java.io.FileWriter;\n" +
"import java.util.ArrayList;\n" +
"import java.util.List;\n" +
"\n" +
"public class ManipulaArquivo {\n" +
"\n" +
"    public ManipulaArquivo() {\n" +
"    }\n" +
"\n" +
"    public List<String> abrirArquivo(String caminho) {\n" +
"        List<String> texto = new ArrayList<>();\n" +
"        File arq = new File(caminho);\n" +
"        if (arq.exists()) {\n" +
"            try {\n" +
"                //OpenFile\n" +
"                FileReader arquivo = new FileReader(caminho);\n" +
"                BufferedReader conteudoDoArquivo = new BufferedReader(arquivo);\n" +
"                String linha = conteudoDoArquivo.readLine();\n" +
"                while (linha != null) {\n" +
"                    texto.add(linha);\n" +
"                    linha = conteudoDoArquivo.readLine();\n" +
"                }\n" +
"                conteudoDoArquivo.close();\n" +
"                System.out.println(texto);\n" +
"            } catch (Exception e) {//Catch exception if any\n" +
"                System.err.println(\"Error: \" + e.getMessage());\n" +
"            }\n" +
"        } else {\n" +
"            texto.add(\"\");\n" +
"        }\n" +
"        return texto;\n" +
"    }\n" +
"\n" +
"    public int salvarArquivo(String caminho, List<String> texto) {\n" +
"        try {\n" +
"            // Create file \n" +
"            FileWriter arquivo = new FileWriter(caminho);\n" +
"            BufferedWriter conteudoDoArquivo = new BufferedWriter(arquivo);\n" +
"            for (int i = 0; i < texto.size(); i++) {\n" +
"                conteudoDoArquivo.write(texto.get(i) + \"\\n\");//+ System.getProperty(\"line.separator\")); // \n" +
"            }\n" +
"            conteudoDoArquivo.close();\n" +
"        } catch (Exception e) {//Catch exception if any\n" +
"            System.err.println(\"Error: \" + e.getMessage());\n" +
"            return 1; //houve erro\n" +
"        }\n" +
"        return 0;\n" +
"    }\n" +
"}\n");

        String cc = projetoDestino + "/src/tools/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "ManipulaArquivo.java", codigoGerado);
    }
}
