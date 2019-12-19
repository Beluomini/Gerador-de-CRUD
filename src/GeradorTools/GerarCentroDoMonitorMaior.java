/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

public class GerarCentroDoMonitorMaior {

    String projetoDestino;
    String nomeClasse;

    public GerarCentroDoMonitorMaior(String projetoDestino, String nomeClasse) {
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
"import java.awt.Dimension;\n" +
"import java.awt.GraphicsConfiguration;\n" +
"import java.awt.GraphicsDevice;\n" +
"import java.awt.GraphicsEnvironment;\n" +
"import java.awt.Point;\n" +
"import java.awt.Rectangle;\n" +
"import java.awt.Toolkit;\n" +
"import javax.swing.JDialog;\n" +
"import javax.swing.JFrame;\n" +
"\n" +
"/**\n" +
" *\n" +
" * @author Beluomini\n" +
" */\n" +
"public class CentroDoMonitorMaior {\n" +
"\n" +
"    public Point getCentroMonitorMaior(JFrame f) {\n" +
"        Point posicaoDoFrameCentralizado;\n" +
"        {\n" +
"            GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();\n" +
"            GraphicsDevice[] devices = e.getScreenDevices();\n" +
"            int maior = 0;\n" +
"            int qualOMaiorMonitor = 0;\n" +
"            for (int i = 0; i < devices.length; i++) {\n" +
"\n" +
"                if (devices[i].getDisplayMode().getWidth() > maior) {\n" +
"                    maior = devices[i].getDisplayMode().getWidth();\n" +
"                    qualOMaiorMonitor = i;\n" +
"                }\n" +
"            }\n" +
"\n" +
"            GraphicsConfiguration[] configurations = devices[qualOMaiorMonitor].getConfigurations();\n" +
"            Rectangle retanguloDoMaiorMonitor = configurations[0].getBounds();\n" +
"            Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();\n" +
"            int larguraDoFrame = f.getWidth();\n" +
"            int alturaDoFrame = f.getHeight();\n" +
"            //Point meio = new Point(retanguloDoMaiorMonitor.width / 2, retanguloDoMaiorMonitor.height / 2);\n" +
"            posicaoDoFrameCentralizado = new Point(retanguloDoMaiorMonitor.x + (retanguloDoMaiorMonitor.width / 2) - (larguraDoFrame / 2),\n" +
"                    retanguloDoMaiorMonitor.y + (retanguloDoMaiorMonitor.height / 2) - (alturaDoFrame / 2));\n" +
"        }\n" +
"        return posicaoDoFrameCentralizado;\n" +
"        \n" +
"        /*\n" +
"        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();\n" +
"        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));\n" +
"        */\n" +
"    }\n" +
"    public Point getCentroMonitorMaior(JDialog f) {\n" +
"        Point posicaoDoFrameCentralizado;\n" +
"        {\n" +
"            GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();\n" +
"            GraphicsDevice[] devices = e.getScreenDevices();\n" +
"            int maior = 0;\n" +
"            int qualOMaiorMonitor = 0;\n" +
"            for (int i = 0; i < devices.length; i++) {\n" +
"\n" +
"                if (devices[i].getDisplayMode().getWidth() > maior) {\n" +
"                    maior = devices[i].getDisplayMode().getWidth();\n" +
"                    qualOMaiorMonitor = i;\n" +
"                }\n" +
"            }\n" +
"\n" +
"            GraphicsConfiguration[] configurations = devices[qualOMaiorMonitor].getConfigurations();\n" +
"            Rectangle retanguloDoMaiorMonitor = configurations[0].getBounds();\n" +
"            Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();\n" +
"            int larguraDoFrame = f.getWidth();\n" +
"            int alturaDoFrame = f.getHeight();\n" +
"            //Point meio = new Point(retanguloDoMaiorMonitor.width / 2, retanguloDoMaiorMonitor.height / 2);\n" +
"            posicaoDoFrameCentralizado = new Point(retanguloDoMaiorMonitor.x + (retanguloDoMaiorMonitor.width / 2) - (larguraDoFrame / 2),\n" +
"                    retanguloDoMaiorMonitor.y + (retanguloDoMaiorMonitor.height / 2) - (alturaDoFrame / 2));\n" +
"        }\n" +
"        return posicaoDoFrameCentralizado;\n" +
"        \n" +
"        /*\n" +
"        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();\n" +
"        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));\n" +
"        */\n" +
"    }\n" +
"}\n" +
"");

        String cc = projetoDestino + "/src/tools/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "CentroDoMonitorMaior.java", codigoGerado);
    }
}
