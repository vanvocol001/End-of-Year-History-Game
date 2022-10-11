import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class UIComponent
{
   int xPos, yPos, width, height,sides, thick;
   double size;
   boolean visible, filled, clickable, SHAPE, IMAGE, BOX;
   String name,direction,text;
   BufferedImage image;
   Polygon shape;
   Rectangle bounds, buttonBounds;
   
   Color color, txtColor;
   
   public UIComponent (String n, int y, double sz, boolean v, boolean click, String d, BufferedImage i, Rectangle b)
   {
      IMAGE = true;
      name = n;
      direction = d;
      
      bounds = b;
      setImage(i,sz);
      
      yPos = y;  
      
      visible = v;
      clickable = click;

      buttonBounds = new Rectangle(xPos, yPos, width, height);
      
      
   }
   
   public UIComponent (String n, int y, int w, int h, int s, double sz, boolean v, boolean f, boolean click, String d, Rectangle b, Color c)
   {
      SHAPE = true;
      name = n;
      
      bounds = b;
      
      yPos = y;
      
      setShape(s,sz);
      
      visible = v;
      filled = f;
      clickable = click;

      color = c;
      
      
      
      
      
      
   }
   
   public UIComponent (String n, int x, int y, int w, int h, int t, boolean v, boolean click, Rectangle b,String txt,Color c, Color tC)
   {
      BOX = true;
      name = n;
      
      bounds = b;
      
      xPos = x;
      yPos = y;
      width = w;
      height = h;
      thick = t;
    
      buttonBounds = new Rectangle(xPos,yPos,width,height);
      
      visible = v;
      clickable = click;


      text = txt;
      color = c;
      txtColor = tC;
      
      
      
   }

   
//    public void setXPos (String direction)
//    {
//       int x;
//       if(direction.equals("left"))
//          x = (int)(bounds.getMinX())+50;
//       else if (direction.equals("right"))
//          x = bounds.width - (width) - 50;
//       else if (direction.equals("centered"))
//          if(IMAGE)
//             x = (bounds.width/2)-width/2;
//          if(SHAPE)
//             x = (bounds.width/2);
//       else
//          x = 0;
// 
//       xPos = x;
//       System.out.println(xPos);
//    
//    }
   
   public void setYPos (int y)
   {
      yPos = y;
   }
   
   public void setWidth (int w)
   {
      width = w;
   }
   
   public void setHeight (int h)
   {
      height = h;
   }
   
   public void setVisible (boolean v)
   {
      visible = v;
   }
   
   public void setClickable (boolean c)
   {
      clickable = c;
   }
   
   public void setImage (BufferedImage i, double size)
   {
      image = i;
      
      width = (int)((double)image.getWidth()*size);
      height = (int)((double)image.getHeight()*size);
      
      System.out.println(width);
      
      BufferedImage output = new BufferedImage(width,height,i.getType()==0?5:i.getType());
      Graphics2D g2d = output.createGraphics();
      
      
      if(direction.equals("left"))
         xPos = (int)(bounds.getMinX())+250;
      else if (direction.equals("right"))
         xPos = bounds.width - 250;
      else if (direction.equals("centered"))
         xPos = (bounds.width/2)-(width/2);
      else
         xPos = 0;


   }
   
   public void setShape (int sides, double size)
   {
      xPos = bounds.width/2;
      double twoPI = 2 * Math.PI;
		int xCoord[] = new int[sides];
		int yCoord[] = new int[sides];

		for (int k = 0; k < sides; k++)
		{
			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/sides) * size/2) + xPos;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/sides) * size/2) + yPos;
		}
      
      
      
		shape = new Polygon(xCoord,yCoord,sides);
    buttonBounds = shape.getBounds();
    width = (int)buttonBounds.getWidth();
    height = (int)buttonBounds.getHeight();
   }

   public void setText(String s)
   {
      text = s;
   }
   
   public void setColor(Color c)
   {
      color = c;
   }
   public int getXPos ()
   {
      return xPos;
   }
   
   public int getYPos ()
   {
      return yPos;
   }
   
   public int getWidth ()
   {
      return width;
   }
   
   public int getHeight ()
   {
      return height;
   }
   
   public String getName ()
   {
      return name;
   }
   
   public BufferedImage getImage ()
   {
      if (image != null)
         return image;
      else 
         System.out.println("ERROR: NO IMAGE");
      return null;
   }
   
   public Polygon getShape ()
   {
      if (shape != null)
         return shape;
      else 
         System.out.println("ERROR: NO SHAPE");
      return null;
   }
   
   public boolean isVisible ()
   {
      return visible;
   }
   
   public boolean isClickable ()
   {
      return clickable;
   }
   
   public void drawImage(Graphics g)
   {

      g.drawImage(image, xPos, yPos, width, height, null);
      
      
   }

   public void drawCenteredText (Graphics g, String s, int h, int size)
   {
      g.setColor(txtColor);      
      if(!(s.contains("\n")))
      {
        Font font = new Font("Times New Roman",1, size);
        FontMetrics metrics = g.getFontMetrics(font);
        int x = buttonBounds.x + (buttonBounds.width - metrics.stringWidth(s)) / 2;
        g.setFont(font);
        g.drawString(s, x, h);
      }
      else
      {
        Font font = new Font("Times New Roman",1, size-5);
        FontMetrics metrics = g.getFontMetrics(font);
        h = h -  65;
        for (String line : s.split("\n"))
        {
            int x = buttonBounds.x + (buttonBounds.width - metrics.stringWidth(line)) / 2;
            g.setFont(font);
            g.drawString(line, x, h += metrics.getHeight()+10);
        }
      }
   }
   
   public void drawCenteredShape (Graphics g)
   {  
      g.setColor(color);
      if(filled)
         g.fillPolygon(shape);
      else
         g.drawPolygon(shape);

     
   }
   
   public void drawBorder(Graphics g, int x, int y, int width, int height, int thickness)
   {
        g.setColor(color);
        g.drawRect(x, y, width, height);
        if (thickness > 1) 
            drawBorder(g, x + 1, y + 1, width - 2, height - 2, thickness - 1);

        drawCenteredText(g, text, 265, 25);
   }
   
   
   
  
   
   
   public void draw(Graphics g)
   {
      if(visible)   
      {
         if(IMAGE)
            drawImage(g);
         else if(SHAPE)
         {
            drawCenteredShape(g);
         }
         else if(BOX)
         {
            drawBorder(g,xPos,yPos,width,height,thick);
         }
         else 
            System.out.println("ERROR: NO IMAGE or SHAPE or BOX");
      }
      else
      System.out.println("Not visible");
   }
   public Rectangle getBounds ()
   {
      return buttonBounds;
   }
   
   
}   