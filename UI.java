import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.image.BufferedImage;

public abstract class UI
{
   
   boolean visible;
   Font font;
   Color bgColor, fgColor;
   Rectangle bounds;
   ArrayList<UIComponent> components; 
   public UI(Graphics g,Rectangle b, int c)
   {
      bounds = b;

     try {
        //create the font to use. Specify the size!
        // font = Font.createFont(Font.TRUETYPE_FONT, new File("gyparody.ttf")).deriveFont(12f);
        // GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // //register the font
        // ge.registerFont(font);
      } catch (Exception e) { System.out.println("oops"); }

      components = new ArrayList<UIComponent>();
      //visible = v;
      
      setColor(c);

   }
   
   // public void setVisibility(boolean v)
//    {
//       visible = v;
//       if(!v)
//       {
//          for(int x = 0; x < components.size(); x++)
//          {
//             components.get(x).setClickable(false);
//          }
//       }
//    }
//    
//    public boolean getVisibility()
//    {
//       return visible;
//    }
//    
   abstract void drawUI(Graphics g);
 
   public void drawCenteredText (Graphics g, String s, int h, int size)
   {
      g.setColor(fgColor);
      Font font = new Font("Times New Roman",1, size);
      
      FontMetrics metrics = g.getFontMetrics(font);
      int x = bounds.x + (bounds.width - metrics.stringWidth(s)) / 2;
      
      g.setFont(font);
      g.drawString(s, x, h);
     
   }
   
     
   public void drawBorder(Graphics g, int x, int y, int width, int height, int thickness)
   {
        g.setColor(fgColor);
        g.drawRect(x, y, width, height);
        if (thickness > 1) 
            drawBorder(g, x + 1, y + 1, width - 2, height - 2, thickness - 1);
   }
   
   
   
   public void setColor(int number)
   {

      switch (number)
      {
         case 1 : bgColor = Color.BLACK; fgColor = new Color (51,153,255);
         
      }
 
      
   }
   
   
   
              
}
   