import java.awt.*;
import java.awt.event.*;

public class MyFileDialog extends FileDialog 
{
public MyFileDialog(Frame f)
{
super(f);
}


public int getMS ()
{ 
return(FileDialog.SAVE); 
}
}