/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geradores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import myTools.Ferramentas;

/**
 *
 * @author radames
 */
public class GerarGUIAdmin {

    String projetoDestino;
    String nomeClasse;

    public GerarGUIAdmin(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        GerarGUIAdmin();
    }

    private void GerarGUIAdmin() {
        Ferramentas ferramentas = new Ferramentas();

        List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + nomeClasse + ".txt");

        List<String> codigoGerado = new ArrayList<>();

        //fazer a classe de controle de lista
        codigoGerado.clear();
        codigoGerado.add(
                "package Main;\n"
                + "\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import tools.Ferramentas;\n"
                + "import tools.DateTextField;\n"
                + "import java.awt.BorderLayout;\n"
                + "import java.awt.CardLayout;\n"
                + "import java.awt.Color;\n"
                + "import java.awt.Container;\n"
                + "import java.awt.FlowLayout;\n"
                + "import java.awt.GridLayout;\n"
                + "import java.awt.event.ActionEvent;\n"
                + "import java.awt.event.ActionListener;\n"
                + "import java.awt.event.WindowAdapter;\n"
                + "import java.awt.event.WindowEvent;\n"
                + "import java.awt.event.WindowListener;\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import javax.swing.JButton;\n"
                + "import javax.swing.JFrame;\n"
                + "import javax.swing.JLabel;\n"
                + "import javax.swing.JOptionPane;\n"
                + "import javax.swing.JPanel;\n"
                + "import javax.swing.JScrollPane;\n"
                + "import javax.swing.JTable;\n"
                + "import javax.swing.JTextArea;\n"
                + "import javax.swing.JTextField;\n"
                + "import javax.swing.table.DefaultTableModel;\n"
                + "import java.text.ParseException;\n"
                + "import javax.swing.text.DefaultCaret;\n"
                + "import tools.UsarGridBagLayout;\n"
                + "import java.awt.LayoutManager;\n"
                + "import java.util.Date;\n"
                + "import java.text.DateFormat;\n"
                + "import java.text.SimpleDateFormat;\n"
                + "import java.util.logging.Level;\n"
                + "import java.util.logging.Logger;\n"
                + "import javax.swing.JComboBox;\n\n");
        //import java.util.Date;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].equals("Date")) {
                codigoGerado.add("import java.util.Date;\n");
            }
        }

        codigoGerado.add("public class GUI extends JFrame{\n"
                + "private boolean inserindo;"
                + "private Ferramentas ferramentas = new Ferramentas();\n"
                + "private CardLayout cardLayout = new CardLayout();\n"
                + "\n\n");

        codigoGerado.add("private Container cp;\n");

        codigoGerado.add("private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));\n"
                + "private JPanel pnPrincipal = new JPanel();\n"
                + "private JPanel pnCentro = new JPanel(new GridLayout(1,3));\n"
                + "\n\n");

        codigoGerado.add("//COLOQUE AQUI A IMAGEM DOS CRUDS\n"
                + "    private JButton btCrud1 = new JButton(\"Objeto\");\n"
                + "    private JButton btCrud2 = new JButton(\"SubClasse\");\n"
                + "\n\n");
        
        codigoGerado.add("public GUI() throws ParseException{");

        codigoGerado.add("setDefaultCloseOperation(DISPOSE_ON_CLOSE);");

        codigoGerado.add("cp = getContentPane();\n"
                + "        cp.setLayout(new BorderLayout());\n"
                + "        pnPrincipal.setLayout(new GridLayout(3, 1));;\n"
                + "        cp.add(pnPrincipal);\n"
                + "        pnPrincipal.add(pnCentro);\n"
                + "        pnCentro.add(btCrud1);\n"
                + "        pnCentro.add(btCrud2);\n\n");
        codigoGerado.add("// ------------------------BOTAO CRUD1-----------------------------------------\n"
                + "        btCrud1.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                try {\n" +
"                    PessoaGUI pessoaGUI = new PessoaGUI();\n" +
"                } catch (ParseException ex) {\n" +
"                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);\n" +
"                }\n" 
                + "                dispose();"
                + "            }\n"
                + "        });");
        
        codigoGerado.add("// ------------------------BOTAO CRUD2-----------------------------------------\n"
                + "        btCrud2.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                try {\n" +
"                    GeneroGUI generoGUI = new GeneroGUI();\n" +
"                } catch (ParseException ex) {\n" +
"                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);\n" +
"                }\n" 
                + "                dispose();"
                + "            }\n"
                + "        });");        

        codigoGerado.add("// parâmetros para janela inicial\n"
                + "        setSize(900, 400);\n"
                + "        setTitle(\"CRUD\");\n"
                + "        setLocationRelativeTo(null);\n"
                + "        setVisible(true);");
        codigoGerado.add("  }\n}");

        String cc = projetoDestino + "/src/Main/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "GUI.java", codigoGerado);
    }
}
