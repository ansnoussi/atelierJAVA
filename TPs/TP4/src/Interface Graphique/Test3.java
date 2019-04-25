import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Test3{
        


	public static void main(String[] args) {
    MyFrame f = new MyFrame(10,10,400,500,Color.red,true,"Mohamed Lamine Barghouda");
                MenuBar mb = new MenuBar();
                Menu mb1 = new Menu("file");
                MenuItem mi1 = new MenuItem("open");
                MenuItem mi2 = new MenuItem("save");
                MenuItem mi3 = new MenuItem("quit");
                mb1.add(mi1);
                mb1.add(mi2);
                mb1.add(mi3);
    mi3.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				System.exit(0); }
			}
				);
    mi2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
				System.out.println("Ce bouton Permet de sauvegarder le fichier courant dans le répertoire");}
        }
				);
    mi1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
				try
			{
				MyFileDialog mfd = new MyFileDialog(f);
				mfd.setVisible(true);
				String nomFichier = mfd.getFile();
				String repFichier = mfd.getDirectory();
				String nomComplet = nomFichier + repFichier;
				System.out.println("nomFichier : "+nomFichier);
				System.out.println("repFichier : "+repFichier);
				System.out.println("nomComplet : "+nomComplet);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	} );


        mb.add(mb1);
		f.setMenuBar(mb);
	}
}