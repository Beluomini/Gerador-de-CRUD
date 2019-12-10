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
public class GerarClasseDeControle {

    String projetoDestino;
    String nomeClasse;

    public GerarClasseDeControle(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        gerarClasseControle();
    }

    private void gerarClasseControle() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        int unidadeLinha = 0;
        int unidadeObj = 0;

        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            unidadeObj += 1;
            unidadeLinha += aux.length;
        }
        String vetCoisas[] = new String[unidadeLinha];
        int couttt = 0;

        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            vetCoisas[couttt] = aux[1];
            couttt++;
        }
        //fazer a classe de controle de lista
        codigoGerado.clear();
        codigoGerado.add("package Main;\n"
                + "\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import java.text.SimpleDateFormat;\n"
                + "import java.util.Date;");


        codigoGerado.add("public class " + nomeClasse + "Controle {\n");
        codigoGerado.add("  List<" + nomeClasse + "> lista = new ArrayList<>();\n\n");
        codigoGerado.add("SimpleDateFormat simpleDateFormat = new SimpleDateFormat();\n");
        
        couttt=0;
        
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if(couttt==0){
                if(aux[0].trim().toLowerCase().equals("int") || aux[0].trim().toLowerCase().equals("long")){
                    codigoGerado.add("public " + nomeClasse + " buscar(int chave){\n"
                + "        for (int i = 0; i < lista.size(); i++) {\n"
                + "            if (chave == lista.get(i).get" + ferramentas.plMaius(vetCoisas[0]) + "()) {\n"
                + "                return lista.get(i);\n"
                + "            }\n"
                + "        }\n"
                + "        return null;\n"
                + "    }\n");
                }else{
                    codigoGerado.add("public " + nomeClasse + " buscar(String chave){\n"
                + "        for (int i = 0; i < lista.size(); i++) {\n"
                + "            if (lista.get(i).get" + ferramentas.plMaius(vetCoisas[0]) + "().equals(chave)) {\n"
                + "                return lista.get(i);\n"
                + "            }\n"
                + "        }\n"
                + "        return null;\n"
                + "    }\n");
                }
            }
            couttt++;
        }

        

        codigoGerado.add("public void inserir(" + nomeClasse + " " + nomeClasse.toLowerCase() + "){\n"
                + "    lista.add(" + nomeClasse.toLowerCase() + ");\n"
                + "    }\n");

        codigoGerado.add("public String converteDeDateParaString(Date data) {\n"
                + "       try {\n"
                + "           return simpleDateFormat.format(data); //converte a data para string\n"
                + "       } catch (Exception e) {\n"
                + "           return null;//se algo estiver errado na data, retorne null\n"
                + "           //tem que tratar o erro na classe que chamou\n"
                + "       }\n"
                + "   }\n\n"
                + "public Date converteDeStringParaDate(String s) {\n"
                + "       try {\n"
                + "           return simpleDateFormat.parse(s);//converte\n"
                + "       } catch (Exception e) {\n"
                + "           return null;// se algo estiver errado, retorne null\n"
                + "       }\n"
                + "   }");

        codigoGerado.add("void alterar(" + nomeClasse + " " + nomeClasse.toLowerCase() + "Original, " + nomeClasse + " " + nomeClasse.toLowerCase() + "Alterado){\n"
                + "    lista.set(lista.indexOf(" + nomeClasse.toLowerCase() + "Original), " + nomeClasse.toLowerCase() + "Alterado);\n"
                + "    }\n");

        codigoGerado.add("void excluir(" + nomeClasse + " " + nomeClasse.toLowerCase() + "){\n"
                + "    lista.remove(" + nomeClasse.toLowerCase() + ");"
                + "    }\n");

        codigoGerado.add("public List<String> listar() {\n"
                + "        List<String> ls = new ArrayList<>();\n"
                + "        for (int i = 0; i < lista.size(); i++) {\n"
                + "            ls.add(\"\"\n");
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].toLowerCase().equals("date")) {
                codigoGerado.add("                    + converteDeDateParaString(lista.get(i).get" + ferramentas.plMaius(aux[1]) + "()) + \";\"\n");
            } else {
                codigoGerado.add("                    + lista.get(i).get" + ferramentas.plMaius(aux[1]) + "() + \";\"\n");
            }
        }
        codigoGerado.add("            );\n"
                + "        }\n"
                + "        return ls;\n"
                + "    }");

        codigoGerado.add("}");

        String cc = projetoDestino + "/src/Main/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + nomeClasse + "Controle.java", codigoGerado);
    }
}
