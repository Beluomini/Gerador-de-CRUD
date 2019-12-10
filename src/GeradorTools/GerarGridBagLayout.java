/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

public class GerarGridBagLayout {

    String projetoDestino;
    String nomeClasse;

    public GerarGridBagLayout(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        GerarGridBagLayout();
    }

    private void GerarGridBagLayout() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        //fazer a classe de controle de lista
        codigoGerado.clear();
        codigoGerado.add("package tools;\n"
                + "\n"
                + "import java.awt.GridBagConstraints;\n"
                + "import java.awt.GridBagLayout;\n"
                + "import java.awt.Insets;\n"
                + "import javax.swing.JComponent;\n"
                + "import javax.swing.JLabel;\n"
                + "import javax.swing.JPanel;\n"
                + "import javax.swing.JScrollPane;");

        //import java.util.Date;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].equals("Date")) {
                codigoGerado.add("import java.util.Date;\n");
            }
        }

        codigoGerado.add("public class UsarGridBagLayout {\n"
                + "\n"
                + "    JPanel painelAlvo = new JPanel();\n"
                + "\n"
                + "    public UsarGridBagLayout(JPanel painel) {\n"
                + "        painelAlvo = painel;\n"
                + "        painelAlvo.setLayout(new GridBagLayout());\n"
                + "    }\n"
                + "\n"
                + "    public void add(JLabel label, JComponent componente) {\n"
                + "\n"
                + "        /**\n"
                + "         * Adiciona um label e um componente horizontalmente\n"
                + "         *\n"
                + "         * @param label que irá aparecer à esquerda\n"
                + "         * @param componente Componente de edição\n"
                + "         *\n"
                + "         * o painel que irá receber os componentes deve ter o layout setado para\n"
                + "         * GridBagLayout\n"
                + "         *\n"
                + "         * Por exemplo, painelCentro.setLayout(new GridBagLayout());\n"
                + "         *\n"
                + "         */\n"
                + "        GridBagConstraints cons = new GridBagConstraints();\n"
                + "        cons.fill = GridBagConstraints.NONE;  //não \"esticar\"\n"
                + "        cons.anchor = GridBagConstraints.NORTHWEST; //canto superior esquerdo \n"
                + "        cons.insets = new Insets(4, 4, 4, 4);  //distancia entre os componentes\n"
                + "\n"
                + "        cons.weightx = 0;\n"
                + "        cons.gridwidth = 1;\n"
                + "        painelAlvo.add(label, cons);\n"
                + "\n"
                + "        cons.fill = GridBagConstraints.BOTH;\n"
                + "        cons.weightx = 1;\n"
                + "        cons.gridwidth = GridBagConstraints.REMAINDER;\n"
                + "        painelAlvo.add(componente, cons);\n"
                + "    }\n"
                + "\n"
                + "    /**\n"
                + "     * Adiciona um label, um componente de edição, mais um label e outro\n"
                + "     * componente de edição. Todos na mesma linha\n"
                + "     *\n"
                + "     * @param label1 Label 1\n"
                + "     * @param componente Componente de edição\n"
                + "     * @param label2 Label 2\n"
                + "     * @param componente2 Componente de edição 2\n"
                + "     */\n"
                + "    public void add(JLabel label1, JComponent componente, JLabel label2, JComponent componente2) {\n"
                + "        GridBagConstraints cons = new GridBagConstraints();\n"
                + "        cons.fill = GridBagConstraints.BOTH;\n"
                + "        cons.insets = new Insets(4, 4, 4, 4);\n"
                + "\n"
                + "        cons.fill = GridBagConstraints.NONE;\n"
                + "        cons.anchor = GridBagConstraints.NORTHWEST;\n"
                + "        cons.weightx = 0;\n"
                + "        cons.gridwidth = 1;\n"
                + "        painelAlvo.add(label1, cons);\n"
                + "\n"
                + "        cons.weightx = 1;\n"
                + "        cons.gridwidth = 1;\n"
                + "        cons.fill = GridBagConstraints.BOTH;\n"
                + "        painelAlvo.add(componente, cons);\n"
                + "\n"
                + "        cons.fill = GridBagConstraints.NONE;\n"
                + "        cons.weightx = 0;\n"
                + "        cons.gridwidth = 1;\n"
                + "        painelAlvo.add(label2, cons);\n"
                + "\n"
                + "        cons.weightx = 1;\n"
                + "        cons.fill = GridBagConstraints.BOTH;\n"
                + "        cons.gridwidth = GridBagConstraints.REMAINDER;\n"
                + "        painelAlvo.add(componente2, cons);\n"
                + "    }\n"
                + "\n"
                + "    /**\n"
                + "     * Adiciona um label e um componente horizontalmente. O componente ocupará\n"
                + "     * todo o resto da tela\n"
                + "     *\n"
                + "     * @param label String que irá aparecer no label\n"
                + "     * @param componente Componente de edição\n"
                + "     */\n"
                + "    public void add(JLabel label, JScrollPane componente) {\n"
                + "        GridBagConstraints cons = new GridBagConstraints();\n"
                + "        cons.fill = GridBagConstraints.NONE;\n"
                + "        cons.anchor = GridBagConstraints.NORTHWEST;\n"
                + "        cons.insets = new Insets(4, 4, 4, 4);\n"
                + "        cons.weighty = 1;\n"
                + "        cons.gridheight = GridBagConstraints.REMAINDER;\n"
                + "\n"
                + "        cons.weightx = 0;\n"
                + "        cons.gridwidth = 1;\n"
                + "        painelAlvo.add(label, cons);\n"
                + "\n"
                + "        cons.fill = GridBagConstraints.BOTH;\n"
                + "        cons.weightx = 1;\n"
                + "        cons.gridwidth = GridBagConstraints.REMAINDER;\n"
                + "        painelAlvo.add(componente, cons);\n"
                + "    }\n"
                + "}"
        );

        String cc = projetoDestino + "/src/tools/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "UsarGridBagLayout.java", codigoGerado);
    }
}
