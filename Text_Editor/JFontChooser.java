/*
 * Developpe par Lev-Arcady Sellem
 * Contact : <lev.arcady.sellem@gmail.com>
 * Merci de donner un objet a votre mail
 * Publie sous licence Creative Commons
 *
 */
package com.zeusolym.utils;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;

/**
 * Classe permettant de proposer un choix de police de caracteres a l'utilisateur. 
 * Attention, la boîte de dialogue creee N'EST PAS detruite en fin de dialogue !
 * @author Lev-Arcady Sellem
 * @version 2.0
 */
@SuppressWarnings("serial")
class JFontChooser extends JDialog{
	/**
	 * Constructeur de la classe JFontChooser
	 * @param f La police de caracteres par defaut
	 */
	public JFontChooser(final Font f){
		//Creer la boite
		super((JFrame)null, "Choix de la fonte", true);
		choice_panel = new ChoicePanel(f, this);
		global_scroll = new JScrollPane(choice_panel);
		add(global_scroll);
		choice_panel.setter(f);

		//Modifier le comportement pour que la fermeture de la boite aie le meme resultat
		//qu'un clic sur 'Annuler'
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				choice_panel.setter(f);
			}
		});
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Renvoie la police de caracteres choisie par l'utilisateur
	 * @return L'objet Font representant la police de caracteres choisie par l'utilisateur
	 */
	public Font getFont(){
		return choice_panel.getter();
	}
	private JScrollPane global_scroll; private ChoicePanel choice_panel;
}

/**
 * Panneau permettant le choix d'une police de caracteres
 * @author Lev-Arcady Sellem
 * @version 2.0
 */
@SuppressWarnings("serial")
class ChoicePanel extends JPanel implements ActionListener{
	/**
	 * Constructeur de la classe ChoicePanel
	 * @param f La police par defaut
	 * @param parent_dialog La boite de dialogue appelante
	 */
	public ChoicePanel(Font f, JDialog parent_dialog){
		this.f = f;
		this.parent_dialog = parent_dialog;

		//Creation du champ exemple et de tableaux contenant le choix propose
		example = new JTextField("Voix ambigu\u00eb d'un coeur qui, au z\u00e9phyr, pr\u00e9f\u00e8re les jattes de kiwis", 24);
		example.setEditable(false);

		sizes = new String[]{"6","8","10","11","12","14","16","18","20","22","24","26","28","30","32","34","36","40","44","48"};
		styles = new String[]{"Normal", "Gras", "Italique", "Gras et Italique"};
		fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		//Creation des box JTextField + JList permettant de choisir
		font_choice = new VerticalBox(fonts, false, this);
		style_choice = new VerticalBox(styles, false, this);
		size_choice = new VerticalBox(sizes, true, this);

		//Creation des boutons de fin de dialogue
		cancel = new JButton("Annuler");
		cancel.addActionListener(this);
		ok = new JButton("OK");
		ok.addActionListener(this);

		//Box contenant les boutons
		prov_valid = Box.createHorizontalBox();
		prov_valid.add(cancel);
		prov_valid.add(Box.createHorizontalStrut(5));
		prov_valid.add(ok);

		global = Box.createVerticalBox();

		//Box gerant la mise en page des boutons
		valid = Box.createHorizontalBox();
		valid.add(Box.createGlue());
		valid.add(prov_valid);

		//Box gerant la mise en page des listes de choix
		settings = Box.createHorizontalBox();
		settings.add(font_choice);
		settings.add(Box.createHorizontalStrut(5));
		settings.add(style_choice);
		settings.add(Box.createHorizontalStrut(5));
		settings.add(size_choice);

		//Box contenant l'integralite des composants
		global.add(settings);
		global.add(Box.createVerticalStrut(5));
		global.add(example);
		global.add(Box.createVerticalStrut(5));
		global.add(valid);

		//Remplissage des valeurs par defauts et affichage de l'exemple
		setter(f);
		example();

		//Ecouter le champ de texte de saisie de la taille afin que les modifications
		//soient repercutees lorsque l'utilisateur change son contenu
		size_choice.result.addActionListener(this);

		//Ajout du resultat au panneau
		add(global);
	}

	/**
	 * Met a jour les champs de texte avec la police de caracteres choisie
	 * @param f La police de caracteres choisie
	 */
	public void setter(Font f){
		font_choice.result.setText(f.getName());
		size_choice.result.setText(String.valueOf(f.getSize()));
		int prov = f.getStyle();
		String prov2 = "";
		if(prov==Font.PLAIN){prov2 = "Normal";}
		else if(prov==Font.BOLD){prov2 = "Gras";}
		else if(prov==Font.ITALIC){prov2 = "Italique";}
		else if(prov==Font.BOLD+Font.ITALIC){prov2 = "Gras et Italique";}
		style_choice.result.setText(prov2);
	}

	/**
	 * Retourne la police de caracteres choisie par l'utilisateur
	 * @return L'objet Font contenant les choix de l'utilisateur
	 */
	public Font getter(){
		String prov = style_choice.result.getText();
		if(prov.equals("Normal")){
			styl = Font.PLAIN;
		}
		else if(prov.equals("Gras")){
			styl = Font.BOLD;
		}
		else if(prov.equals("Italique")){
			styl = Font.ITALIC;
		}
		else if(prov.equals("Gras et Italique")){
			styl = Font.BOLD+Font.ITALIC;
		}
		if(size_choice.result.getText().equals("")==false){
			font = new Font(font_choice.result.getText(), styl, Integer.parseInt(size_choice.result.getText()));
			return font;
		}
		else{
			JOptionPane.showMessageDialog(null, "Vous n'avez pas sp\u00e9cifi\u00e9 de taille !", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	/**
	 * Formatte la phrase d'exemple avec la police de caracteres selectionnee
	 */
	public void example(){
		Font prov_font = getter();
		if(prov_font != null){
			example.setFont(prov_font);
		}
		else{System.out.println("Erreur : Impossible d'afficher l'exemple, l'appel de getter() a retourn\u00e9 une valeur nulle");}
	}

	/**
	 * Gere les clics sur les boutons "Valider" et "Annuler" ainsi que le changement de taille de la police de caracteres
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==ok){
			//Faire disparaitre la boite de dialogue sans la detruire
			//pour pouvoir continuer a utiliser getter() de l'exterieur
			parent_dialog.setVisible(false);
		}
		else if(e.getSource()==cancel){
			//Remettre les valeurs de depart puis
			//faire disparaitre la boite de dialogue sans la detruire
			//pour pouvoir continuer a utiliser getter() de l'exterieur
			setter(f);
			parent_dialog.setVisible(false);
		}
		else if(e.getSource()==size_choice.result){
			example();
		}
	}

	private String [] sizes, fonts, styles; private Box settings, global, valid, prov_valid; private VerticalBox font_choice, style_choice, size_choice;
	private Font font, f; private int styl; private JTextField example; private JButton ok, cancel;
	private JDialog parent_dialog;
}

/**
 * Ensemble champ de texte et liste permettant la selection
 * @author Lev-Arcady Sellem
 * @version 2.0
 */
@SuppressWarnings("serial")
class VerticalBox extends Box implements ListSelectionListener{
	/**
	 * Constructeur de la classe VerticalBox
	 * @param content La liste de choix disponibles
	 * @param is_editable Le caractere editable de la liste
	 * @param parent Le panneau appelant
	 */
	public VerticalBox(String[] content, boolean is_editable, ChoicePanel parent){
		super(1);
		this.parent = parent;
		result = new JTextField();
		result.setEditable(is_editable);
		choix = new JList<String>(content);
		choix.setSelectionMode(0);
		choix.setVisibleRowCount(10);
		choix.addListSelectionListener(this);
		defil = new JScrollPane(choix);

		add(result);
		add(Box.createVerticalStrut(3));
		add(defil);
	}

	/**
	 * L'ecouteur associe a la liste capturant la selection de ses elements
	 */
	public void valueChanged(ListSelectionEvent e){
		if(!e.getValueIsAdjusting()){
			result.setText((String)choix.getSelectedValue());
			parent.example();
		}
	}
	JTextField result; private JList<String> choix; private JScrollPane defil; private ChoicePanel parent;
}
