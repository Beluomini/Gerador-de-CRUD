/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeradorTools;

import java.util.ArrayList;
import java.util.List;
import myTools.Ferramentas;

public class GerarFilteredJList {

    String projetoDestino;
    String nomeClasse;

    public GerarFilteredJList(String projetoDestino, String nomeClasse) {
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
"import java.awt.Container;\n" +
"import java.util.ArrayList;\n" +
"import java.util.Locale;\n" +
"import javax.swing.AbstractListModel;\n" +
"import javax.swing.JList;\n" +
"import javax.swing.JTextField;\n" +
"import javax.swing.ListModel;\n" +
"import javax.swing.event.DocumentEvent;\n" +
"import javax.swing.event.DocumentListener;\n" +
"\n" +
"public class FilteredJList extends JList {\n" +
"\n" +
"    private FilterField filterField;\n" +
"    private int DEFAULT_FIELD_WIDTH = 30;\n" +
"\n" +
"    public FilteredJList(Container container) {\n" +
"        super();\n" +
"        \n" +
"        setModel(new FilterModel());\n" +
"        filterField = new FilterField(DEFAULT_FIELD_WIDTH);\n" +
"        setLocale(new Locale(\"pt\",\"Br\"));\n" +
"    }\n" +
"\n" +
"    public void setModel(ListModel m) {\n" +
"        if (!(m instanceof FilterModel)) {\n" +
"            throw new IllegalArgumentException();\n" +
"        }\n" +
"        super.setModel(m);\n" +
"    }\n" +
"\n" +
"    public void addItem(Object o) {\n" +
"        ((FilterModel) getModel()).addElement(o);\n" +
"    }\n" +
"\n" +
"    public JTextField getFilterField() {\n" +
"        return filterField;\n" +
"    }\n" +
"\n" +
"   \n" +
"\n" +
"    // inner class to provide filtered model\n" +
"    class FilterModel extends AbstractListModel {\n" +
"\n" +
"        ArrayList items;\n" +
"        ArrayList filterItems;\n" +
"\n" +
"        public FilterModel() {\n" +
"            super();\n" +
"            items = new ArrayList();\n" +
"            filterItems = new ArrayList();\n" +
"        }\n" +
"\n" +
"        @Override\n" +
"        public Object getElementAt(int index) {\n" +
"            if (index < filterItems.size()) {\n" +
"                return filterItems.get(index);\n" +
"            } else {\n" +
"                return null;\n" +
"            }\n" +
"        }\n" +
"\n" +
"        @Override\n" +
"        public int getSize() {\n" +
"            return filterItems.size();\n" +
"        }\n" +
"\n" +
"        public void addElement(Object o) {\n" +
"            items.add(o);\n" +
"            refilter();\n" +
"        }\n" +
"\n" +
"        private void refilter() {\n" +
"            filterItems.clear();\n" +
"            String term = getFilterField().getText();\n" +
"            for (int i = 0; i < items.size(); i++) {\n" +
"                if (items.get(i).toString().indexOf(term, 0) != -1) {\n" +
"                    filterItems.add(items.get(i));\n" +
"                }\n" +
"            }\n" +
"            fireContentsChanged(this, 0, getSize());\n" +
"        }\n" +
"    }\n" +
"\n" +
"    // inner class provides filter-by-keystroke field\n" +
"    class FilterField extends JTextField implements DocumentListener {\n" +
"\n" +
"        public FilterField(int width) {\n" +
"            super(width);\n" +
"            getDocument().addDocumentListener(this);\n" +
"        }\n" +
"\n" +
"        public void changedUpdate(DocumentEvent e) {\n" +
"            ((FilterModel) getModel()).refilter();\n" +
"        }\n" +
"\n" +
"        public void insertUpdate(DocumentEvent e) {\n" +
"            ((FilterModel) getModel()).refilter();\n" +
"        }\n" +
"\n" +
"        public void removeUpdate(DocumentEvent e) {\n" +
"            ((FilterModel) getModel()).refilter();\n" +
"        }\n" +
"    }\n" +
"}");

        String cc = projetoDestino + "/src/tools/";
        System.out.println("Vai criar a classe nesse caminho=> " + cc);
        ferramentas.salvarArquivo(cc + "FilteredJList.java", codigoGerado);
    }
}
