import java.io.IOException;
import java.io.Writer;
import javax.swing.text.AbstractWriter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

public class TPWriter extends AbstractWriter {
	
	

	protected TPWriter(Writer arg0, Element arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void write() throws IOException, BadLocationException {
		System.out.println("Hello World\n");
		
	}

}