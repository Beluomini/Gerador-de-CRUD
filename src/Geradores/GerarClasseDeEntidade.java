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
public class GerarClasseDeEntidade {

    String projetoDestino;
    String nomeClasse;

    public GerarClasseDeEntidade(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        gerarClasseEntidade();
    }

    private void gerarClasseEntidade() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        codigoGerado.add("package Main;\n");
        codigoGerado.add("import java.text.SimpleDateFormat;"
                + "import java.util.Date;");



        codigoGerado.add("public class " + nomeClasse + " {");
        int cont = 0;
        //atributos
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add("private " + aux[0] + " " + aux[1] + ";");
            cont++;
        }

//        for (int i = 0; i < codigoGerado.size(); i++) {
//            System.out.println(codigoGerado.get(i));
//        }
        codigoGerado.add("\npublic " + nomeClasse + "(){\n}\n\n");

        codigoGerado.add("public " + nomeClasse + "(");
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add(aux[0] + " " + aux[1]);
            if (cont > 1) {
                codigoGerado.add(",");
            }
            cont -= 1;
        }
        codigoGerado.add("){");
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add("this." + aux[1] + " = " + aux[1] + ";");
        }
        codigoGerado.add("}");
        
        codigoGerado.add("SimpleDateFormat simpleDateFormat = new SimpleDateFormat();\n");
        codigoGerado.add("public String converteDeDateParaString(Date data) {\n"
                + "       try {\n"
                + "           return simpleDateFormat.format(data); //converte a data para string\n"
                + "       } catch (Exception e) {\n"
                + "           return null;//se algo estiver errado na data, retorne null\n"
                + "           //tem que tratar o erro na classe que chamou\n"
                + "       }\n"
                + "   }\n");


        //métodos get
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add(""
                        + "public " + aux[0] + " get" + ferramentas.plMaius(aux[1]) + "() {\n"
                        + "        return " + aux[1] + ";\n"
                        + "    }\n");
        }
        codigoGerado.add("");

        //métodos set
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add(" public void set" + ferramentas.plMaius(aux[1])
                        + "(" + aux[0] + " " + aux[1] + ") {\n"
                        + "        this. " + aux[1] + " =  " + aux[1] + ";\n"
                        + "    }");
        }

        //Método toString
        String ss = "";
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if(aux[0].toLowerCase().equals("date")){
                ss += "converteDeDateParaString("+aux[1] + ")+ \";\"+";
            }else{
                ss += aux[1] + "+ \";\"+";
            }
        }
        ss = ss.substring(0, ss.length() - 1);

        codigoGerado.add(" @Override\n"
                + "    public String toString() {\n"
                + "        return " + ss + " ;\n"
                + "    }");

        codigoGerado.add("");
        codigoGerado.add("}");

        String cc = projetoDestino + "/src/Main/" + nomeClasse + ".java";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc, codigoGerado);

        //terminou a classe de entidade
    }

}
