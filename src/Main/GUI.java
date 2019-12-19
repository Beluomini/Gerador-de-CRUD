package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import Geradores.GerarClasseDeControle;
import Geradores.GerarClasseDeEntidade;
import Geradores.GerarClasseDeGUI;
import GeradorTools.GerarFerramentas;
import GeradorTools.GerarGridBagLayout;
import GeradorTools.GerarDate;
import GeradorTools.GerarCentroDoMonitorMaior;
import GeradorTools.GerarCopiarImagem;
import GeradorTools.GerarFilteredJList;
import GeradorTools.GerarJanelaPesquisar;
import GeradorTools.GerarManipulaArquivo;
import GeradorTools.GerarMinhaJOpitionPane;
import Geradores.GerarGUIAdmin;
import Geradores.GerarMain;
import GeradorTools.GerarTxtDados;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import myTools.Ferramentas;

public class GUI extends JFrame {

    private Container cp;
    private JLabel labelNomeProjetoDestino = new JLabel("Projeto Destino");//onde serão gerados os códigos
    private JTextField textFieldProjetoDestino = new JTextField(50);
    private JPanel painelNorte = new JPanel(new GridLayout(3, 1));
    private JPanel painelNorteLinha2 = new JPanel();
    private JPanel painelNorteLinha1 = new JPanel();
    private JPanel painelNorteLinha3 = new JPanel();
    private JPanel painelSul = new JPanel();

    private JButton botaoEscolherProjetoDestino = new JButton("Escolher projeto destino");
    private JButton botaoGerarClasseEntidade = new JButton("Gerar Entidade");
    private JButton botaoGerarClasseControle = new JButton("Gerar Controle");
    private JButton botaoGerarClasseGUI = new JButton("Gerar GUI");
    private JButton botaoGerarAuxiliares = new JButton("Gerar auxiliares");
    private JButton botaoGerarGUIPrincipal = new JButton("Gerar Main e GUI principal");
    
    private JCheckBox cbFk1 = new JCheckBox();
    private JCheckBox cbFk2 = new JCheckBox();
    private JLabel lbFk = new JLabel("Escolha em qual será colocado a chave estrangeira");

    private JLabel labelArqTexto = new JLabel("Nome do arquivo da entidade");
    private JTextField textFieldArquivoTexto = new JTextField(25);
    private JLabel labelArqTexto1 = new JLabel("Nome do arquivo do genero");
    private JTextField textFieldArquivoTexto1 = new JTextField(25);

    private JFileChooser caixaDeDialogo = new JFileChooser();
    private String caminho = "/home";
    private List<String> arqUltimaExecucao = new ArrayList<>();
    Ferramentas ferramentas = new Ferramentas();

    public GUI() {

        //carregar arquivo da última execução
        arqUltimaExecucao = ferramentas.abrirArquivo("UltimaExecucao.dat");// 
        if (arqUltimaExecucao != null) {
            caminho = arqUltimaExecucao.get(0);
            //   System.out.println("caminho last " + caminho);
            textFieldProjetoDestino.setText(caminho);
        }

        setSize(1000, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gerador de código 2018");
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(painelNorte, BorderLayout.NORTH);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelNorte.add(painelNorteLinha1);
        painelNorte.add(painelNorteLinha2);
        painelNorte.add(painelNorteLinha3);

        painelNorteLinha1.add(labelNomeProjetoDestino);
        painelNorteLinha1.add(textFieldProjetoDestino);
        painelNorteLinha1.add(botaoEscolherProjetoDestino);

        painelNorteLinha2.add(labelArqTexto);
        painelNorteLinha2.add(textFieldArquivoTexto);
        painelNorteLinha2.add(labelArqTexto1);
        painelNorteLinha2.add(textFieldArquivoTexto1);
        
        painelNorteLinha3.add(cbFk1);
        painelNorteLinha3.add(lbFk);
        painelNorteLinha3.add(cbFk2);

        textFieldArquivoTexto.setText("Pessoa");
        textFieldArquivoTexto1.setText("Genero");

        painelSul.add(botaoGerarClasseEntidade);
        painelSul.add(botaoGerarClasseControle);
        painelSul.add(botaoGerarClasseGUI);
        painelSul.add(botaoGerarAuxiliares);
        painelSul.add(botaoGerarGUIPrincipal);

        botaoEscolherProjetoDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("DIRETÓRIO", "..", "..");
                caixaDeDialogo.setFileFilter(filter);
                caixaDeDialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                File file = new File(caminho);
                if (file.exists()) {
                    caixaDeDialogo.setCurrentDirectory(file);
                } else {
                    file = new File("/home");
                    if (file.exists()) {
                        caixaDeDialogo.setCurrentDirectory(file);
                    } else {
                        caixaDeDialogo.setCurrentDirectory(null);
                    }

                }
                if (caixaDeDialogo.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                    caminho = caixaDeDialogo.getSelectedFile().getAbsolutePath();
                    textFieldProjetoDestino.setText(caminho);
                    arqUltimaExecucao = new ArrayList<>();
                    arqUltimaExecucao.add(caminho);
                    int arq = ferramentas.salvarArquivo("UltimaExecucao.dat", arqUltimaExecucao);

                    if (arqUltimaExecucao != null) {
                        caminho = arqUltimaExecucao.get(0);
                        textFieldProjetoDestino.setText(caminho);
                        // listaAtributo = new ArrayList();
                        textFieldProjetoDestino.setBackground(Color.green);
                    }
                }

            }
        });

        botaoGerarClasseEntidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    
                    List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + textFieldArquivoTexto.getText() + ".txt");
                    
                    for (String s : arquivoBase) {
                        String aux[] = s.split(";");
                        if (s.indexOf(";") < 0) {
                            JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                            System.exit(0);
                        }else if(aux.length < 2) {
                                JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                                System.exit(0);
                        }
                         
                    GerarClasseDeEntidade gerarClasseDeEntidade
                            = new GerarClasseDeEntidade(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    GerarClasseDeEntidade gerarClasseDeEntidade1
                            = new GerarClasseDeEntidade(textFieldProjetoDestino.getText(), textFieldArquivoTexto1.getText());
                }
            }
        }});

        botaoGerarClasseControle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + textFieldArquivoTexto.getText() + ".txt");
                    for (String s : arquivoBase) {
                        String aux[] = s.split(";");
                        if (s.indexOf(";") < 0) {
                            JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                            System.exit(0);
                        }else if (aux.length < 2) {
                                JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                                System.exit(0);
                            }
                    }
                    Geradores.GerarClasseDeControle gcc
                            = new GerarClasseDeControle(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    Geradores.GerarClasseDeControle gcc1
                            = new GerarClasseDeControle(textFieldProjetoDestino.getText(), textFieldArquivoTexto1.getText());
                }
            }
        });

        botaoGerarClasseGUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + textFieldArquivoTexto.getText() + ".txt");
                    for (String s : arquivoBase) {
                        String aux[] = s.split(";");
                        if (s.indexOf(";") < 0) {
                            JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                            System.exit(0);
                        }else if (aux.length < 2) {
                            JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                            System.exit(0);
                            }
                    }
                    Geradores.GerarClasseDeGUI gcc
                            = new GerarClasseDeGUI(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    Geradores.GerarClasseDeGUI gcc1
                            = new GerarClasseDeGUI(textFieldProjetoDestino.getText(), textFieldArquivoTexto1.getText());
                }
            }
        });

        botaoGerarAuxiliares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + textFieldArquivoTexto.getText() + ".txt");
                    for (String s : arquivoBase) {
                        String aux[] = s.split(";");
                        if (s.indexOf(";") < 0) {
                            JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                            System.exit(0);
                        }else if (aux.length < 2) {
                                JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                                System.exit(0);
                            }
                        
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarFerramentas gcc
                                = new GerarFerramentas(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarGridBagLayout gcc
                                = new GerarGridBagLayout(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarDate gcc
                                = new GerarDate(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarTxtDados gcc
                                = new GerarTxtDados(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarCentroDoMonitorMaior gcc
                                = new GerarCentroDoMonitorMaior(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarCopiarImagem gcc
                                = new GerarCopiarImagem(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarFilteredJList gcc
                                = new GerarFilteredJList(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarJanelaPesquisar gcc
                                = new GerarJanelaPesquisar(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarManipulaArquivo gcc
                                = new GerarManipulaArquivo(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        GeradorTools.GerarMinhaJOpitionPane gcc
                                = new GerarMinhaJOpitionPane(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                }
            }
        });
        
        botaoGerarGUIPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldArquivoTexto.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                } else {
                    List<String> arquivoBase = ferramentas.abrirArquivo("src/Main/" + textFieldArquivoTexto.getText() + ".txt");
                    for (String s : arquivoBase) {
                        String aux[] = s.split(";");
                        if (s.indexOf(";") < 0) {
                            JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                            System.exit(0);
                        }else if (aux.length < 2) {
                                JOptionPane.showMessageDialog(cp, "Algo na descrição da entidade está errada. \nO programa sera encerrado");
                                System.exit(0);
                            }
                        
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        Geradores.GerarMain gcc
                                = new GerarMain(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                    }
                    if (textFieldArquivoTexto.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(cp, "Deve ser informado um nome de entidade");
                    } else {
                        Geradores.GerarGUIAdmin gcc
                                = new GerarGUIAdmin(textFieldProjetoDestino.getText(), textFieldArquivoTexto.getText());
                        Geradores.GerarGUIAdmin gcc1
                                = new GerarGUIAdmin(textFieldProjetoDestino.getText(), textFieldArquivoTexto1.getText());
                    }
                }
            }
        });

        setLocationRelativeTo(null);//centraliza no monitor
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
