/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

public class GerarCopiarImagem {

    String projetoDestino;
    String nomeClasse;

    public GerarCopiarImagem(String projetoDestino, String nomeClasse) {
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
"import java.io.FileInputStream;\n" +
"import java.io.FileNotFoundException;\n" +
"import java.io.FileOutputStream;\n" +
"import java.io.IOException;\n" +
"import java.io.InputStream;\n" +
"import java.io.OutputStream;\n" +
"\n" +
"/**\n" +
" *\n" +
" * @author radames\n" +
" */\n" +
"public class CopiarImagem {\n" +
"\n" +
"    public static void copiar(String origem, String destino) {\n" +
"        //  System.out.println(\"Origem >\"+origem+ \" Destino >\"+destino);\n" +
"        try {\n" +
"            InputStream in;\n" +
"            in = new FileInputStream(origem);\n" +
"            OutputStream out;\n" +
"            byte[] buf = new byte[1024];\n" +
"            out = new FileOutputStream(destino);\n" +
"            int len;\n" +
"            try {\n" +
"                while ((len = in.read(buf)) > 0) {\n" +
"                    out.write(buf, 0, len);\n" +
"                }\n" +
"            } catch (IOException ex) {\n" +
"                System.out.println(\"Erro na cópia\");\n" +
"            }\n" +
"            try {\n" +
"                in.close();\n" +
"                out.close();\n" +
"            } catch (IOException ex) {\n" +
"                System.out.println(\"Erro na cópia\");\n" +
"            }\n" +
"        } catch (FileNotFoundException ex) {\n" +
"            System.out.println(\"Erro na cópia - arquivo não encontrado\");\n" +
"        }\n" +
"    }\n" +
"}\n" +
"");

        String cc = projetoDestino + "/src/tools/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "CopiarImagem.java", codigoGerado);
    }
}
