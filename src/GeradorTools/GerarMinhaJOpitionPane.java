/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

public class GerarMinhaJOpitionPane {

    String projetoDestino;
    String nomeClasse;

    public GerarMinhaJOpitionPane(String projetoDestino, String nomeClasse) {
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
"import java.awt.BorderLayout;\n" +
"import java.awt.Container;\n" +
"import java.awt.FlowLayout;\n" +
"import java.awt.Point;\n" +
"import java.awt.event.ActionEvent;\n" +
"import java.awt.event.ActionListener;\n" +
"import java.awt.event.WindowEvent;\n" +
"import java.awt.event.WindowListener;\n" +
"import javax.swing.JButton;\n" +
"import javax.swing.JDialog;\n" +
"import javax.swing.JLabel;\n" +
"import javax.swing.JPanel;\n" +
"\n" +
"/**\n" +
" *\n" +
" * @author radames\n" +
" */\n" +
"public class MinhaJOptionPane extends JDialog {\n" +
"\n" +
"    private boolean resp = false;\n" +
"    private final Container cp;\n" +
"    private final JPanel painelMsg = new JPanel();\n" +
"    private final JPanel painelBotoes = new JPanel();\n" +
"    private final JButton btnOk = new JButton(\"Ok\");\n" +
"    private final JButton btnCancel = new JButton(\"Cancelar\");\n" +
"    private final JLabel labelMsg = new JLabel();\n" +
"    private String msg;\n" +
"    private Point p;\n" +
"\n" +
"    public MinhaJOptionPane(Point pos, String msg) {\n" +
"        this.p = pos;\n" +
"        this.msg = msg;\n" +
"        cp = getContentPane();\n" +
"    }\n" +
"\n" +
"    public boolean getValorRetornado() {\n" +
"        inicialize();\n" +
"        setVisible(true);\n" +
"        return resp;\n" +
"    }\n" +
"\n" +
"    public void finalizeJanela() {\n" +
"        dispose();\n" +
"    }\n" +
"\n" +
"    public void inicialize() {\n" +
"        setSize(350, 80);\n" +
"\n" +
"        // setDefaultCloseOperation(DISPOSE_ON_CLOSE);\n" +
"        setModal(true);\n" +
"        cp.setLayout(new BorderLayout());\n" +
"        cp.add(painelMsg, BorderLayout.CENTER);\n" +
"        cp.add(painelBotoes, BorderLayout.SOUTH);\n" +
"\n" +
"        painelMsg.setLayout(new FlowLayout(FlowLayout.CENTER));\n" +
"        painelMsg.add(labelMsg);\n" +
"        painelBotoes.add(btnOk);\n" +
"        painelBotoes.add(btnCancel);\n" +
"\n" +
"        labelMsg.setText(msg);\n" +
"        pack();\n" +
"        setLocation(p.x + JDialog.WIDTH / 2, p.y);\n" +
"\n" +
"        btnOk.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                resp = true;\n" +
"                dispose();\n" +
"            }\n" +
"        });\n" +
"        btnCancel.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                resp = false;\n" +
"                dispose();\n" +
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
"                resp = false;\n" +
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
"\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void windowDeactivated(WindowEvent we) {\n" +
"            }\n" +
"        });\n" +
"\n" +
"    }\n" +
"}\n" +
"\n" +
"");

        String cc = projetoDestino + "/src/tools/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "MinhaJOptionPane.java", codigoGerado);
    }
}
