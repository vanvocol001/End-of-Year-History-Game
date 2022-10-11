import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Counter{
  int xPos,yPos,width,height,thick,value;
  String txt;
  Color color,lineColor,txtColor;

  Rectangle bounds;

  public Counter (int x, int y, int w, int h, int t,String text,Color c, Color lC, Color tC)
   {
      xPos = x;
      yPos = y;
      width = w;
      height = h;
      thick = t;

      bounds = new Rectangle(xPos,yPos,width,height);

      txt = text;
      color = c;
      lineColor = lC;
      txtColor = tC;
      
      
      
   }

   public void drawBorder(Graphics g, int x, int y, int width, int height, int thickness)
   {
        g.setColor(lineColor);
        g.drawRect(x, y, width, height);
        if (thickness > 1) 
            drawBorder(g, x + 1, y + 1, width - 2, height - 2, thickness - 1);

        
   }

   public void drawCenteredText (Graphics g, String s, int h, int size)
   {
      g.setColor(txtColor);
      Font font = new Font("Times New Roman",1, size);
      
      FontMetrics metrics = g.getFontMetrics(font);
      int x = bounds.x + (bounds.width - metrics.stringWidth(s)) / 2;
      
      g.setFont(font);
      g.drawString(s, x, h);
     
   }
   public void draw(Graphics g)
   {
      g.setColor(color);
      g.fillRect(xPos,yPos,width,height);
      drawBorder(g,xPos,yPos,width,height,thick);
      drawCenteredText(g,txt,yPos+height/2+10,20);
   }

}

 