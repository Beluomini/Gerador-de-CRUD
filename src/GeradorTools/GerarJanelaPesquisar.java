/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

public class GerarJanelaPesquisar {

    String projetoDestino;
    String nomeClasse;

    public GerarJanelaPesquisar(String projetoDestino, String nomeClasse) {
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
"\n" +
"\n" +
"// @author Radames\n" +
"import java.awt.BorderLayout;\n" +
"import java.awt.Container;\n" +
"import java.awt.GridLayout;\n" +
"import java.awt.event.MouseAdapter;\n" +
"import java.awt.event.MouseEvent;\n" +
"import java.awt.event.WindowEvent;\n" +
"import java.awt.event.WindowListener;\n" +
"import java.util.List;\n" +
"import javax.swing.JDialog;\n" +
"import javax.swing.JLabel;\n" +
"import javax.swing.JPanel;\n" +
"import javax.swing.JScrollPane;\n" +
"import javax.swing.ScrollPaneConstants;\n" +
"\n" +
"public class JanelaPesquisar extends JDialog {\n" +
"\n" +
"    private String valorRetornado = \"\";\n" +
"    private List<String> lista;\n" +
"    private int x=0;\n" +
"    private int y=0;\n" +
"\n" +
"    public JanelaPesquisar(List<String> lista, int x,int y) {//esse construtor é importante para receber dados \n" +
"        this.lista = lista;\n" +
"        this.x = x;\n" +
"        this.y = y;\n" +
"    }\n" +
"\n" +
"    public String getValorRetornado() {\n" +
"        inicialize();\n" +
"\n" +
"        setVisible(true);\n" +
"        return valorRetornado;\n" +
"    }\n" +
"\n" +
"    public void finalizeJanela() {\n" +
"        dispose();\n" +
"    }\n" +
"\n" +
"    public void inicialize() {\n" +
"\n" +
"        setTitle(\"Pesquisar\");\n" +
"        setSize(350, 400);\n" +
"        setModal(true);\n" +
"        Container containerLista = new JPanel();\n" +
"        Container cp;\n" +
"        cp = getContentPane();\n" +
"        cp.setLayout(new BorderLayout());\n" +
"        // populate list\n" +
"        final FilteredJList list = new FilteredJList(containerLista);\n" +
"        for (int i = 0; i < lista.size(); i++) {\n" +
"            list.addItem(lista.get(i));\n" +
"        }\n" +
"        containerLista.setLayout(new GridLayout(1, 1));\n" +
"        containerLista.add(list);\n" +
"        // add to gui\n" +
"        JPanel painelDireita = new JPanel();\n" +
"        painelDireita.setLayout(new GridLayout(3, 1));\n" +
"\n" +
"        painelDireita.add(new JLabel());\n" +
"        JScrollPane pane = new JScrollPane(containerLista, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);\n" +
"        JPanel painelCentro = new JPanel();\n" +
"        painelCentro.setLayout(new BorderLayout());\n" +
"        painelCentro.add(list.getFilterField(), BorderLayout.NORTH);\n" +
"        painelCentro.add(pane, BorderLayout.CENTER);\n" +
"        cp.add(painelCentro, BorderLayout.CENTER);\n" +
"        cp.add(painelDireita, BorderLayout.EAST);\n" +
"        cp.add(new JLabel(\"<Clic duplo = seleciona>\"), BorderLayout.SOUTH);\n" +
"       \n" +
"        //setLocationRelativeTo(null);\n" +
"        setLocation(x- getWidth() / 2, y+50);\n" +
"        \n" +
"        list.addMouseListener(new MouseAdapter() {\n" +
"            public void mouseClicked(MouseEvent e) {\n" +
"                if (e.getClickCount() == 2) { //clic duplo\n" +
"                    valorRetornado = (String) list.getSelectedValue();\n" +
"                    dispose();\n" +
"                }\n" +
"            }\n" +
"        });\n" +
"        addWindowListener(new WindowListener() {\n" +
"            @Override\n" +
"            public void windowOpened(WindowEvent we) {\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void windowClosing(WindowEvent we) {\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void windowClosed(WindowEvent we) {\n" +
"                valorRetornado = null;\n" +
"                dispose();\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void windowIconified(WindowEvent we) {\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void windowDeiconified(WindowEvent we) {\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void windowActivated(WindowEvent we) {\n" +
"                \n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void windowDeactivated(WindowEvent we) {\n" +
"            }\n" +
"        });\n" +
"\n" +
"    }\n" +
"}\n" +
"");

        String cc = projetoDestino + "/src/tools/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "JanelaPesquisar.java", codigoGerado);
    }
}
