import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.TextArea;
import java.awt.FileDialog;
import java.io.*;
import java.lang.String;
import java.io.FileWriter;

public class ButtonNSOQ implements ActionListener
{
	MyFrame fr;
	

	public void setFr (MyFrame fra)
	{
		this.fr=fra;
	}

	public void actionPerformed (ActionEvent x)
	{
		String name = x.getActionCommand();
		if (name.equals("Open"))
    		{
      			MyFileDialog mfd = new MyFileDialog(fr);
				mfd.setVisible(true);
				String nomFichier = mfd.getFile();
				String repFichier = mfd.getDirectory();
				String nomComplet = nomFichier + repFichier;
				System.out.println("nomFichier : "+nomFichier);
				System.out.println("repFichier : "+repFichier);
				System.out.println("nomComplet : "+nomComplet);
				File file = new File (mfd.getDirectory()+mfd.getFile());
				try
				{
					InputStream i = new FileInputStream (file);
					BufferedReader b = new BufferedReader(i);
					String ligne ;
					while ( ( ligne=b.readLine())!= null )
					{
						fr.ta.setText(fr.ta.getText()+"\n"+ligne);
					}
					i.close();
				}

				catch (FileNotFoundException e2){System.out.println(e2.toString());}
				catch(IOException e3 ){System.out.println(e3.toString());}
    		}
		else if(name.equals("New"))
		{
			fr.ta.setText(" ");
		}
		else if(name.equals("Quit"))
		{
			System.exit(0);
		}
		else if (name.equals("Save"))
    	{
      		MyFileDialog mfd = new MyFileDialog(fr);
			mfd.setMode(mfd.getMS());
			mfd.setVisible(true);
			String nomFichier = mfd.getFile();
			String repFichier = mfd.getDirectory();
			String nomComplet = nomFichier + repFichier;
			File file = new File (mfd.getDirectory()+mfd.getFile());
			try
			{
				OutputStream out = new OutputStream(file);
				BufferedWriter bw = new BufferedWriter(out);
				bw.println(fr.ta.getText());
				out.flush();
				out.close();
			}
			catch (FileNotFoundException e2){System.out.println(e2.toString());}
			catch(IOException e3 ){System.out.println(e3.toString());}
    	}
	}
}