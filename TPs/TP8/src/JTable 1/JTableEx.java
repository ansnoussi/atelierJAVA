import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*; 
import java.awt.Dimension;
class JTableEx extends JFrame
{
    public JTableEx(){
        final Object[][]lignes = {
            {new Integer(1), "Mohamed", "BARGHOUDA", "Tunis"},
            {new Integer(2), "Tarek", "JARRAR", "Tunis"},
            {new Integer(3), "Anis", "SNOUSSI", "Sfax"},
            {new Integer(4), "Thameur", "BACCOUCHE", "Sousse"}
        };

        final Object[] colonnesNom={"Numero", "Prenom", "Nom", "Adresse"};

        TableModel dataModel = new AbstractTableModel(){
            public int getColumnCount(){
            return colonnesNom.length;
            }
            public int getRowCount(){
            return lignes.length;
            }
            public Object getValueAt(int l, int c){
            return lignes[l][c];
            }
            public String getColumnName(int col){
            return (String)colonnesNom[col];
            }
            public Class getColumnClass(int cl){
            return getValueAt(0,cl).getClass();
            }
        };

        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(500, 300));
        this.getContentPane().add(scrollpane);
        this.pack();
        this.setVisible(true);
    }
    
}