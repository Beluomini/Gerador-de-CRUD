/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import myTools.Ferramentas;

/**
 *
 * @author radames
 */
public class GerarClasseDeGUI {

    String projetoDestino;
    String nomeClasse;

    public GerarClasseDeGUI(String projetoDestino, String nomeClasse) {
        this.projetoDestino = projetoDestino;
        this.nomeClasse = nomeClasse;
        gerarClasseGUI();
    }

    private void gerarClasseGUI() {
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
                + "import javax.swing.JCheckBox;\n"
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
                + "import javax.swing.JComboBox;\n"
                + "import javax.swing.Icon;\n"
                + "import javax.swing.ImageIcon;\n"
                + "import tools.JanelaPesquisar;\n" 
                +"import tools.ManipulaArquivo;\n"
                + "import java.awt.event.MouseAdapter;\n" 
                +"import java.awt.event.MouseEvent;\n" 
                +"import java.io.File;\n"
                + "import javax.swing.JFileChooser;\n"
                + "import java.awt.Image;\n\n");
        
        //import java.util.Date;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].equals("Date")) {
                codigoGerado.add("import java.util.Date;\n");
            }
        }

        codigoGerado.add("public class " + nomeClasse + "GUI extends JFrame{\n"
                + "private boolean inserindo;"
                + "private Ferramentas ferramentas = new Ferramentas();\n"
                + "private CardLayout cardLayout = new CardLayout();\n"
                + "private " + nomeClasse + "Controle " + nomeClasse.toLowerCase() + "Controle = new " + nomeClasse + "Controle();\n"
                + "private " + nomeClasse + " " + nomeClasse.toLowerCase() + " = new " + nomeClasse + "();\n"
                + "private " + nomeClasse + "Controle " + nomeClasse.toLowerCase() + "controle = new " + nomeClasse + "Controle();"
                + "\n"
                + "SimpleDateFormat simpleDateFormat = new SimpleDateFormat(\"DD/MM/YY\");\n\n"
                + "public Date converteDeStringParaDate(String s) {\n"
                + "       try {\n"
                + "           return simpleDateFormat.parse(s);//converte\n"
                + "       } catch (Exception e) {\n"
                + "           return null;// se algo estiver errado, retorne null\n"
                + "       }\n"
                + "   }\n\n"
                + "public boolean converteStrParaBoolean(String s) {\n"
                + "       if(s.toLowerCase().trim().equals(\"true\")){\n"
                + "           return true;\n"
                + "       }else{\n"
                + "           return false;\n"
                + "       }\n"
                + "   }\n\n"
                        + "JLabel lbFoto = new JLabel(\"\");\n" +
"Image imagemAux;\n" +
"    String origem;\n" +
"    String destino = \"src/fotos/\";\n" +
"    String acao = \"\";//variavel para facilitar insert e update \n\n");

        codigoGerado.add("private Container cp;\n");

        codigoGerado.add("private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));\n"
                + "private JPanel pnPrincipal = new JPanel();\n"
                + "private JPanel pnCentro = new JPanel();\n"
                + "private JPanel pnOeste = new JPanel();\n"
                + "private JPanel pnLeste = new JPanel();"
                + "\n\n");

        codigoGerado.add("private JPanel pnSul = new JPanel(cardLayout);\n"
                + "private JPanel pnSulMsg = new JPanel();\n"
                + "private JPanel pnSulListagem = new JPanel(new GridLayout(1,1));"
                + "\n\n");

        codigoGerado.add("Icon voltarMenu = new ImageIcon(getClass().getResource(\"/Imagens/voltarMenu.png\"));\n"
                + "    private JButton btVoltar = new JButton(voltarMenu);\n"
                + "    Icon buscar = new ImageIcon(getClass().getResource(\"/Imagens/lupa.png\"));\n"
                + "    private JButton btBuscar = new JButton(buscar);\n"
                + "    private JButton btLimpar = new JButton(buscar);\n"
                + "    Icon inserir = new ImageIcon(getClass().getResource(\"/Imagens/adidionar.png\"));\n"
                + "    private JButton btInserir = new JButton(inserir);\n"
                + "    Icon alterar = new ImageIcon(getClass().getResource(\"/Imagens/listar.png\"));\n"
                + "    private JButton btAlterar = new JButton(alterar);\n"
                + "    Icon excluir = new ImageIcon(getClass().getResource(\"/Imagens/lixeira.png\"));\n"
                + "    private JButton btExcluir = new JButton(excluir);\n"
                + "    Icon listar = new ImageIcon(getClass().getResource(\"/Imagens/list.png\"));\n"
                + "    private JButton btListar = new JButton(listar);\n"
                + "    Icon salvar = new ImageIcon(getClass().getResource(\"/Imagens/salvar.png\"));\n"
                + "    private JButton btSalvar = new JButton(salvar);\n"
                + "   Icon cancelar = new ImageIcon(getClass().getResource(\"/Imagens/cancelar.png\"));\n"
                + "    private JButton btCancelar = new JButton(cancelar);\n"
                + "    private JButton btGravar = new JButton();\n\n");

        int unidadeLinha = 0;
        int unidadeObj = 0;
        int unidadeBool = 0;

        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].toLowerCase().trim().equals("boolean")) {
                unidadeBool += 1;
            } else {
                unidadeObj += 1;
                unidadeLinha += aux.length;
            }
            codigoGerado.add("    private JLabel lb" + aux[1] + " = new JLabel(\"" + aux[1] + ":\");");
        }

        String vetCoisas[] = new String[unidadeLinha];
        String vetBool[] = new String[unidadeBool];
        int couttt = 0;
        int countt = 0;

        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (aux[0].toLowerCase().equals("boolean")) {
                codigoGerado.add("    private JCheckBox cb" + aux[1] + " = new JCheckBox();");
                vetBool[countt] = aux[1];
                countt++;
            } else {
                if (aux[0].toLowerCase().equals("date")) {
                    codigoGerado.add("    private DateTextField tf" + aux[1] + " = new DateTextField();");
                } else {
                    codigoGerado.add("    private JTextField tf" + aux[1] + " = new JTextField(10);");
                }
                vetCoisas[couttt] = aux[1];
                couttt++;
            }
        }

        codigoGerado.add("\n\nString[] colunas = new String[]{");
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            codigoGerado.add("\"" + aux[1] + "\",");
        }
        codigoGerado.add("};\n" + "    String[][] dados = new String[0][1];\n"
                + "\n"
                + "    DefaultTableModel model = new DefaultTableModel(dados, colunas);\n"
                + "    JTable tabela = new JTable(model);\n"
                + "\n"
                + "    JScrollPane scrollList = new JScrollPane();\n"
                + "\n"
                + "    private JScrollPane scrollMensagem = new JScrollPane(); //barra de rolagem\n"
                + "\n"
                + "    JTextArea textAreaMsg = new JTextArea(5, 150); //campo para texto com várias linhas" + "DefaultCaret caret = (DefaultCaret) textAreaMsg.getCaret(); //para que haja rolagem automática do textArea\n"
                + "DefaultCaret caret = (DefaultCaret) textAreaMsg.getCaret(); //para que haja rolagem automática do textArea"
                + "\n"
                + "    Ferramentas fer = new Ferramentas();\n"
                + "\n"
                + "    //métodos auxiliares\n"
                + "    private void setLog(String msg) {\n"
                + "        textAreaMsg.append(msg + \"\\n\");\n"
                + "        textAreaMsg.setCaretPosition(textAreaMsg.getDocument().getLength());\n"
                + "    }\n\n"
                + "private void limparValoresDosAtributos() {\n");
        
        int conte=0;
        
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if(conte == 0){
                conte++;
            }else{
            if (aux[0].toLowerCase().equals("boolean")) {
                codigoGerado.add("        cb" + aux[1] + ".setSelected(false);\n");
            } else if (aux[0].toLowerCase().equals("date")){
                codigoGerado.add("        tf" + aux[1] + ".setText(\"DD/MM/YYYY\");\n");
            } else {
                codigoGerado.add("        tf" + aux[1] + ".setText(\"\");\n");
            }
                    }
            conte++;
        }
        
        
        codigoGerado.add("}");

        codigoGerado.add("public " + nomeClasse + "GUI() throws ParseException{");

        int contadorLeitor = 0;
        codigoGerado.add("List<String> listaAuxiliar = fer.abrirArquivo(\"" + nomeClasse + "Dados.txt\");\n"
                + "        if (listaAuxiliar != null) {\n"
                + "            for (int i = 0; i < listaAuxiliar.size(); i++) {\n"
                + "                String aux[] = listaAuxiliar.get(i).split(\";\");\n"
                + "                " + nomeClasse + " c = new " + nomeClasse + "(");

        int contador = 0;
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (String.valueOf(aux[0]).toLowerCase().trim().equals("int")) {
                if (contador < (unidadeBool + unidadeObj) - 1) {
                    codigoGerado.add("Integer.valueOf(aux[" + contador + "]),\n");
                } else {
                    codigoGerado.add("Integer.valueOf(aux[" + contador + "])\n");
                }
            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("double")) {
                if (contador < (unidadeBool + unidadeObj) - 1) {
                    codigoGerado.add("Double.parseDouble(aux[" + contador + "]),\n");
                } else {
                    codigoGerado.add("Double.parseDouble(aux[" + contador + "])\n");
                }
            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("long")) {
                if (contador < (unidadeBool + unidadeObj) - 1) {
                    codigoGerado.add("Long.valueOf(aux[" + contador + "]),\n");
                } else {
                    codigoGerado.add("Long.valueOf(aux[" + contador + "])\n");
                }
            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("boolean")) {
                if (contador < (unidadeBool + unidadeObj) - 1) {
                    codigoGerado.add("converteStrParaBoolean(aux[" + contador + "]),\n");
                } else {
                    codigoGerado.add("converteStrParaBoolean(aux[" + contador + "])\n");
                }

            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("date")) {
                if (contador < (unidadeBool + unidadeObj) - 1) {
                    codigoGerado.add("converteDeStringParaDate(aux[" + contador + "]),\n");
                } else {
                    codigoGerado.add("converteDeStringParaDate(aux[" + contador + "])\n");
                }
            } else {
                if (contador < (unidadeBool + unidadeObj) - 1) {
                    codigoGerado.add("aux[" + contador + "],\n");
                } else {
                    codigoGerado.add("aux[" + contador + "]\n");
                }
            }
            contador += 1;
        }

        codigoGerado.add(");\n" + "                " + nomeClasse.toLowerCase() + "controle.inserir(c);\n"
                + "            }\n"
                + "        }");

        codigoGerado.add("caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);\n"
                + "        scrollMensagem.setViewportView(textAreaMsg);\n"
                + "        scrollMensagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//esconde a barra horizontal\n"
                + "\n"
                + "        setDefaultCloseOperation(DISPOSE_ON_CLOSE);");

        codigoGerado.add("cp = getContentPane();\n"
                + "        cp.setLayout(new BorderLayout());"
                + "        pnPrincipal.setLayout(new GridLayout(3, 1));;"
                + "        cp.add(pnPrincipal);"
                + "        pnPrincipal.add(pnNorte);"
                + "        pnPrincipal.add(pnCentro);"
                + "        pnPrincipal.add(pnSul);");

        codigoGerado.add("pnCentro.add(pnOeste);"
                + "pnCentro.add(pnLeste);\n"
                + "UsarGridBagLayout usarGridBagLayoutSul = new UsarGridBagLayout(pnSulMsg);\n"
                + "        usarGridBagLayoutSul.add(new JLabel(\"Mensagem:\"), scrollMensagem);\n"
                + "        pnSul.add(pnSulMsg, \"pnMsg\");\n"
                + "        pnSul.add(pnSulListagem, \"pnLst\");\n"
                + "        pnSul.setBackground(Color.red);\n");

        codigoGerado.add(" pnNorte.add(btVoltar);\n"
                + "        pnNorte.add(lb" + vetCoisas[0] + ");\n"
                + "        pnNorte.add(tf" + vetCoisas[0] + ");\n"
                + "        pnNorte.add(btBuscar);\n"
                + "        pnNorte.add(btLimpar);\n"
                + "        pnNorte.add(btInserir);\n"
                + "        pnNorte.add(btAlterar);\n"
                + "        pnNorte.add(btExcluir);\n"
                + "        pnNorte.add(btSalvar);\n"
                + "        pnNorte.add(btCancelar);\n"
                + "        pnNorte.add(btListar);\n");

        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("pnCentro.add(lb" + vetCoisas[i] + ");\n"
                    + "        pnCentro.add(tf" + vetCoisas[i] + ");");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("pnCentro.add(lb" + vetBool[i] + ");\n"
                    + "        pnCentro.add(cb" + vetBool[i] + ");");
        }
        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("        tf" + vetCoisas[i] + ".setEditable(false);\n");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("        cb" + vetBool[i] + ".setEnabled(false);");
        }
        
        codigoGerado.add("pnCentro.add(lbFoto);");

        codigoGerado.add("btSalvar.setVisible(false);\n"
                + "        btCancelar.setVisible(false);\n"
                + "        btInserir.setVisible(false);\n"
                + "        btExcluir.setVisible(false);\n"
                + "        btAlterar.setVisible(false);\n"
                + "        btLimpar.setVisible(false);\n"
                + "        textAreaMsg.setEditable(false);");
        
        codigoGerado.add("try {\n" +
"            origem = \"/fotos/0a.png\";\n" +
"            ImageIcon icone = new ImageIcon(getClass().getResource(origem));\n" +
"            imagemAux = icone.getImage();\n" +
"            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));\n" +
"            lbFoto.setIcon(icone);\n" +
"\n" +
"        } catch (Exception e) {\n" +
"            System.out.println(\"erro ao carregar a imagem\");\n" +
"        }\n\n");
        
        codigoGerado.add("tf"+vetCoisas[(vetCoisas.length/2)-1]+".addActionListener(new ActionListener() {\n" +
"\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();\n" +
"                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo(\"GeneroDados.txt\");\n" +
"\n" +
"                if (listaAuxiliar.size() > 0) {\n" +
"                    String selectedItem = new JanelaPesquisar(listaAuxiliar, getBounds().x - getWidth() / 2 + getWidth() + 5, getBounds().y).getValorRetornado();\n" +
"                    if (!selectedItem.equals(\"\")) {\n" +
"                        String[] aux = selectedItem.split(\";\");\n" +
"                        tf"+vetCoisas[(vetCoisas.length/2)-1]+".setText(aux[1]);\n" +
"\n" +
"                    } else {\n" +
"                        tf"+vetCoisas[(vetCoisas.length/2)-1]+".requestFocus();\n" +
"                        tf"+vetCoisas[(vetCoisas.length/2)-1]+".selectAll();\n" +
"                    }\n" +
"                }\n" +
"            }\n" +
"        });");

        codigoGerado.add("// ------------------------BOTAO BUSCAR-----------------------------------------\n"
                + "btBuscar.addActionListener((ActionEvent e) -> {\n"
                + "            Date hoje = new Date();\n"
                + "            if (tf" + vetCoisas[0] + ".getText().trim().equals(\"\")) {\n"
                + "                JOptionPane.showMessageDialog(pnPrincipal, \"Pensei que você queria pesquisar algo... \");\n"
                + "            } else {\n"
                + "                try{\n"
                + "                    \n"
                + "                        try {\n"
                + "                            tf" + vetCoisas[0] + ".setBackground(Color.green);\n"
                + "                            cardLayout.show(pnSul, \"pnMsg\");\n");
        
        countt=0;
        
            for (String s : arquivoBase) {
                String aux[] = s.split(";");
                if(countt==0){
                    if (aux[0].toLowerCase().equals("int")||aux[0].toLowerCase().equals("long")) {
                        codigoGerado.add(nomeClasse.toLowerCase() + " = " + nomeClasse.toLowerCase()+"Controle.buscar(Integer.valueOf(tf" + vetCoisas[0] + ".getText()));\n");
                    } else if (aux[0].toLowerCase().equals("string")){
                    codigoGerado.add(nomeClasse.toLowerCase() + " = " + nomeClasse.toLowerCase()+"Controle.buscar(tf" + vetCoisas[0] + ".getText());\n");
                    }
                }
                countt++;
            }
                
                
                codigoGerado.add( "                            if (" + nomeClasse.toLowerCase() + " == null) { //nao achou\n"
                + "                                btInserir.setVisible(true);\n"
                + "                                btExcluir.setVisible(false);\n");
        
            codigoGerado.add("limparValoresDosAtributos();");
        
        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("tf" + vetCoisas[i] + ".setEditable(false);\n");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("cb" + vetBool[i] + ".setSelected(false);");
            codigoGerado.add("        cb" + vetBool[i] + ".setEnabled(false);");
        }
        codigoGerado.add("                                setLog(\"Não tem no album, pode colar se tiver...\");\n"
                + "try {\n" +
"                                String aux = String.valueOf("+nomeClasse.toLowerCase()+".get"+vetCoisas[0].substring(0, 1).toUpperCase().concat(vetCoisas[0].substring(1))+"()).trim();\n" +
"                                origem = \"/fotos/\" + aux + \".png\";\n" +
"                                ImageIcon icone = new ImageIcon("+nomeClasse+"GUI.this.getClass().getResource(origem));\n" +
"                                imagemAux = icone.getImage();\n" +
"                                icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));\n" +
"                                lbFoto.setIcon(icone);\n" +
"                            } catch (Exception i) {\n" +
"                                System.out.println(\"nao achou \" + origem);\n" +
"                                origem = \"/fotos/0a.png\";\n" +
"                                ImageIcon icone = new ImageIcon("+nomeClasse+"GUI.this.getClass().getResource(origem));\n" +
"                                imagemAux = icone.getImage();\n" +
"                                icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));\n" +
"                                lbFoto.setIcon(icone);\n" +
"                            }\n"
                + "                            } else { //achou\n"
                + "                                btExcluir.setVisible(true);\n"
                + "                                btInserir.setVisible(false);\n"
                + "                                btAlterar.setVisible(true);\n"
                + "                                tf" + vetCoisas[0] + ".setText(String.valueOf(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(vetCoisas[0]) + "()));\n");
        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("tf" + vetCoisas[i] + ".setEditable(false);\n");
            codigoGerado.add("tf" + vetCoisas[i] + ".setText(String.valueOf(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(vetCoisas[i]) + "()));\n");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("cb" + vetBool[i] + ".setEnabled(false);");
            codigoGerado.add("cb" + vetBool[i] + ".setSelected(" + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(vetBool[i]) + "());");
        }
        codigoGerado.add("                            }\n"
                + "                        } catch (Exception x) {\n"
                + "                            tf" + vetCoisas[0] + ".selectAll();\n"
                + "                            tf" + vetCoisas[0] + ".requestFocus();\n"
                + "                            tf" + vetCoisas[0] + ".setBackground(Color.red);\n"
                + "                            setLog(\"Erro no tipo de dados da chave. (\" + x.getMessage() + \")\");\n"
                + "                        }//else//else\n"
                + "                }catch (Exception x) {\n"
                + "                    JOptionPane.showMessageDialog(pnPrincipal, \"coloque um numero natural\");\n"
                + "                }\n"
                + "            }\n"
                + "            tf" + vetCoisas[0] + ".selectAll();\n"
                + "            tf" + vetCoisas[0] + ".requestFocus();\n"
                + "            tf" + vetCoisas[0] + ".setEditable(false);\n"
                + "            btLimpar.setVisible(true);\n"
                + "            btBuscar.setVisible(false);\n"
                + "        });");

        codigoGerado.add("addWindowListener(new WindowAdapter() {\n"
                + "            @Override\n"
                + "            public void windowClosing(WindowEvent e) {\n"
                + "                btGravar.doClick();\n"
                + "                // Sai   \n"
                + "                dispose();\n"
                + "            }\n"
                + "        });");
        
        codigoGerado.add("lbFoto.addMouseListener(new MouseAdapter() {\n" +
"            public void mouseReleased(MouseEvent e) {\n" +
"                if (acao.equals(\"insert\") || acao.equals(\"update\")) {\n" +
"                    JFileChooser fc = new JFileChooser();\n" +
"                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);\n" +
"                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {\n" +
"                        File img = fc.getSelectedFile();\n" +
"                        origem = fc.getSelectedFile().getAbsolutePath();\n" +
"                        try {\n" +
"                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());\n" +
"                            Image imagemAux;\n" +
"                            imagemAux = icone.getImage();\n" +
"                            icone.setImage(imagemAux.getScaledInstance(100, 100, Image.SCALE_FAST));\n" +
"                            lbFoto.setIcon(icone);\n" +
"\n" +
"                        } catch (Exception ex) {\n" +
"                            System.out.println(\"Erro: \" + ex.getMessage());\n" +
"                        }\n" +
"                    }\n" +
"\n" +
"                }\n" +
"\n" +
"            }\n" +
"        });\n\n");

        codigoGerado.add("btGravar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                Date hoje = new Date();\n"
                + "                //converter a lista<contato> em lista de string\n"
                + "                List<String> listaStr = " + nomeClasse.toLowerCase() + "controle.listar();\n"
                + "                ferramentas.salvarArquivo(\"" + nomeClasse + "Dados.txt\", listaStr);\n"
                + "            }\n"
                + "        });");

        codigoGerado.add("// ------------------------BOTAO LIMPAR-----------------------------------------\n"
                + "        btLimpar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                Date hoje = new Date();\n"
                + "                tf" + vetCoisas[0] + ".setEditable(true);\n"
                + "                tf" + vetCoisas[0] + ".setBackground(Color.white);\n"
                + "                btLimpar.setVisible(false);\n"
                + "                btBuscar.setVisible(true);\n"
                + "                btCancelar.setVisible(false);\n"
                + "                btInserir.setVisible(false);\n"
                + "                btExcluir.setVisible(false);\n"
                + "                btListar.setVisible(true);\n"
                + "                btSalvar.setVisible(false);\n"
                + "                btAlterar.setVisible(false);\n"
                + "            }\n"
                + "        });");

        codigoGerado.add("//*********************** BOTÃO SALVAR ****************************************        \n"
                + "        btSalvar.addActionListener((ActionEvent e) -> {\n"
                + "            Date hoje = new Date();\n"
                + "            try{\n"
                + "            " + nomeClasse + " contatoOriginal = " + nomeClasse.toLowerCase() + "; //para pesquisar na lista\n"
                + "            //precisamos do contato original (para depois modificar)\n"
                + "            if (inserindo) {\n"
                + "                " + nomeClasse.toLowerCase() + " = new " + nomeClasse + "(); //criar um novo contato\n"
                + "            }\n"
                + "            //transfere os valores da GUI para classe contato\n");
        for (String s : arquivoBase) {
            String aux[] = s.split(";");
            if (String.valueOf(aux[0]).toLowerCase().trim().equals("int")) {
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(aux[1]) + "(Integer.valueOf(tf" + aux[1] + ".getText()));\n");
            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("double")) {
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(aux[1]) + "(Double.parseDouble(tf" + aux[1] + ".getText()));\n");
            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("long")) {
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(aux[1]) + "(Long.valueOf(tf" + aux[1] + ".getText()));\n");
            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("boolean")) {
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(aux[1]) + "(cb" + aux[1] + ".isSelected());\n");
            } else if (String.valueOf(aux[0]).toLowerCase().trim().equals("date")) {
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(aux[1]) + "(converteDeStringParaDate(tf" + aux[1] + ".getText()));\n");
            } else {
                codigoGerado.add(nomeClasse.toLowerCase() + ".set" + ferramentas.plMaius(aux[1]) + "(tf" + aux[1] + ".getText());\n");
            }
        }
        codigoGerado.add("\n"
                + "            if (inserindo) { //a variavel inserindo é preenchida nos\n"
                + "                " + nomeClasse.toLowerCase() + "controle.inserir(" + nomeClasse.toLowerCase() + ");\n"
                + "                setLog(\"Inseriu: \" + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(vetCoisas[0]) + "());\n"
                + "            } else {\n"
                + "                " + nomeClasse.toLowerCase() + "controle.alterar(contatoOriginal, " + nomeClasse.toLowerCase() + ");\n"
                + "                cardLayout.show(pnSul, \"pnMsg\");\n"
                + "                setLog(\"Alterou (\" + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(vetCoisas[1]) + "());\n"
                + "            }\n"
                + "\n"
                + "            //voltar para tela inicial\n"
                + "            tf" + vetCoisas[0] + ".requestFocus();\n"
                + "            tf" + vetCoisas[0] + ".selectAll();\n"
                + "            tf" + vetCoisas[0] + ".setEditable(true);\n"
                + "            btSalvar.setVisible(false);\n"
                + "            btCancelar.setVisible(false);\n"
                + "            btBuscar.setVisible(true);\n"
                + "            btLimpar.setVisible(false);\n"
                + "            btListar.setVisible(true);\n");
        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("        tf" + vetCoisas[i] + ".setEditable(false);\n");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("        cb" + vetBool[i] + ".setEnabled(false);\n");
        }
        codigoGerado.add("}catch(Exception x){\n"
                + "                JOptionPane.showMessageDialog(pnPrincipal, \"Faltam valores a serem preenchidos ou foram preenchidos incorretamente\");\n"
                + "            }\n"
                + "        });");

        codigoGerado.add("//================================= BOTÃO CANCELAR ====================================\n"
                + "btCancelar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                Date hoje = new Date();\n"
                + "                tf" + vetCoisas[0] + ".requestFocus();\n"
                + "                tf" + vetCoisas[0] + ".selectAll();\n"
                + "                tf" + vetCoisas[0] + ".setEditable(true);\n"
                + "                btInserir.setVisible(false);\n"
                + "                btSalvar.setVisible(false);\n"
                + "                btCancelar.setVisible(false);\n"
                + "                btBuscar.setVisible(true);\n"
                + "                btLimpar.setVisible(false);\n"
                + "                btListar.setVisible(true);\n"
                + "                limparValoresDosAtributos();\n");
        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("        tf" + vetCoisas[i] + ".setEditable(false);\n");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("        cb" + vetBool[i] + ".setEnabled(false);\n");
        }
        codigoGerado.add("                setLog(\"Cancelou a edição\");\n"
                + "            }\n"
                + "        });");

        codigoGerado.add("//++++++++++++++++++++++++++++++++BOTÃO INSERIR ++++++++++++++++++++++++++++++++++++++++\n"
                + "btInserir.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                Date hoje = new Date();\n"
                + "                btInserir.setVisible(false);\n"
                + "                btSalvar.setVisible(true);\n"
                + "                btCancelar.setVisible(true);\n"
                + "                btBuscar.setVisible(false);\n"
                + "                btLimpar.setVisible(false);\n"
                + "                btListar.setVisible(false);\n");
        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("        tf" + vetCoisas[i] + ".setEditable(true);\n");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("        cb" + vetBool[i] + ".setEnabled(true);\n");
        }
        codigoGerado.add("                inserindo = true;\n"
                + "                setLog(\"Certeza que quer adicionar?\");\n"
                + "            }\n"
                + "        });\n\n");

        codigoGerado.add("acao=\"insert\";\n\n");

        codigoGerado.add("//-----------------------------------------------BOTÃO LISTAR -----------------------------------\n"
                + "btListar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                Date hoje = new Date();\n"
                + "                cardLayout.show(pnSul, \"pnLst\");\n"
                + "                scrollList.setPreferredSize(tabela.getPreferredSize());\n"
                + "                pnSulListagem.add(scrollList);\n"
                + "                scrollList.setViewportView(tabela);\n"
                + "                List<String> listaDeFigurinhas = " + nomeClasse.toLowerCase() + "controle.listar();//busca a lista de contatos\n"
                + "                String[] aux;\n"
                + "                colunas = new String[]{");
        contadorLeitor = 0;
        for (String s : arquivoBase) {
            String aux1[] = s.split(";");
            codigoGerado.add("\"" + aux1[1] + "\"");
            if ((contadorLeitor + 1) % (unidadeObj + unidadeBool) != 0) {
                codigoGerado.add(",");
            }
            contadorLeitor++;
        }
        codigoGerado.add("};\n"
                + "                dados = new String[0][" + (unidadeObj + unidadeBool) + "];\n"
                + "                model.setDataVector(dados, colunas);\n"
                + "                for (int i = 0; i < listaDeFigurinhas.size(); i++) {\n"
                + "                    aux = listaDeFigurinhas.get(i).split(\";\");\n"
                + "                    String[] linha = new String[]{");
        contadorLeitor = 0;
        for (int i = 0; i < (unidadeObj + unidadeBool); i++) {
            codigoGerado.add("aux[" + i + "]");
            if ((contadorLeitor + 1) % (unidadeObj + unidadeBool) != 0) {
                codigoGerado.add(",");
            }
            contadorLeitor++;
        }
        codigoGerado.add("};\n"
                + "                    model.addRow(linha);"
                + "                }\n"
                + "                limparValoresDosAtributos();\n"
                + "                btInserir.setVisible(false);\n"
                + "                btExcluir.setVisible(false);\n"
                + "            }\n"
                + "        });");
        codigoGerado.add("//***************************** EXCLUIR *************************************\n"
                + "        btExcluir.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                Date hoje = new Date();\n"
                + "                int dialogResult = JOptionPane.showConfirmDialog(pnPrincipal, \"Vai excluir: \"\n"
                + "                        + tf" + vetCoisas[0] + ".getText() + \"?\", \"Excluir do registro\", NORMAL);\n"
                + "                if (dialogResult == JOptionPane.YES_OPTION) {\n"
                + "                    " + nomeClasse.toLowerCase() + "controle.excluir(" + nomeClasse.toLowerCase() + ");\n"
                + "                    setLog(\"Excluiu: \" + " + nomeClasse.toLowerCase() + ".get" + ferramentas.plMaius(vetCoisas[0]) + "());\n"
                + "                    btExcluir.setVisible(false);\n");
        
            codigoGerado.add("limparValoresDosAtributos();\n");
        
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("        cb" + vetBool[i] + ".setSelected(false);\n");
        }
        codigoGerado.add("                }\n"
                + "            }\n"
                + "        });");

        codigoGerado.add("// ------------------------BOTAO VOLTAR MENU-----------------------------------------\n"
                + "        btVoltar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                try {\n"
                + "                    GUI gui = new GUI();\n"
                + "                } catch (ParseException ex) {\n"
                + "                    Logger.getLogger(" + nomeClasse + "GUI.class.getName()).log(Level.SEVERE, null, ex);\n"
                + "                }"
                + "                dispose();            }\n"
                + "        });");

        codigoGerado.add("// ------------------------BOTAO ALTERAR-----------------------------------------\n"
                + "        btAlterar.addActionListener(new ActionListener() {\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n");
        for (int i = 1; i < unidadeObj; i++) {
            codigoGerado.add("        tf" + vetCoisas[i] + ".setEditable(true);\n");
        }
        for (int i = 0; i < unidadeBool; i++) {
            codigoGerado.add("        cb" + vetBool[i] + ".setEnabled(true);\n");
        }
        codigoGerado.add("btInserir.setVisible(false);\n"
                + "                btSalvar.setVisible(true);\n"
                + "                btCancelar.setVisible(true);\n"
                + "                btBuscar.setVisible(false);\n"
                + "                btLimpar.setVisible(false);\n"
                + "                btAlterar.setVisible(false);\n"
                + "                btExcluir.setVisible(false);\n"
                + "                btListar.setVisible(false);\n");
        codigoGerado.add("        }\n});");
        
        codigoGerado.add("acao=\"update\";\n");

        codigoGerado.add("// parâmetros para janela inicial\n"
                + "        setSize(900, 400);\n"
                + "        setTitle(\"CRUD\");\n"
                + "        setLocationRelativeTo(null);\n"
                + "        setVisible(true);");
        codigoGerado.add("  }\n}");

        String cc = projetoDestino + "/src/Main/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + nomeClasse + "GUI.java", codigoGerado);
    }
}
