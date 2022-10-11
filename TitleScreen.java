import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;



public class TitleScreen extends UI
{ 

  BufferedImage titleImg; 
      
   public TitleScreen(Graphics g, Rectangle b, int c)
   {
      
      super(g,b,c);

      components.add(new UIComponent("play", 350, 200, 200, 3,100, true, true, true, "centered", b, super.fgColor));
      try{
      titleImg = ImageIO.read(new File("bkgd1.jpg"));
      } catch(Exception e){}
    
      
      
      
     
   }
   
   // public void setVisibility(boolean v)
//    {
//       super.setVisibility(v);
//       
//         
//  
//    }
//    
//    public boolean getVisibility()
//    {
//       return super.getVisibility();
//    }
   
   public ArrayList<UIComponent> getUIComponentArray()
   {
      return super.components;
   }
   
   public void setComponentArray( boolean v )
   {
      if(!v)
         {
            for(int x = 0; x < components.size(); x++)
            {
               components.get(x).setClickable(false);
            }
         }
   }
   
   
   public void drawUI(Graphics g)
   {
      //if(getVisibility())
      //{
         g.setColor(super.bgColor);
         //g.fillRect((int)super.bounds.getX(),(int)super.bounds.getY(),(int)super.bounds.getWidth(),(int)super.bounds.getHeight());
         g.drawImage(titleImg,0,0,null);
      
         g.setColor(super.fgColor);
         for(UIComponent c : components)
         {
            c.draw(g);
         
         }
        super.drawCenteredText(g, "EOY History Game", 200, 50);
        ;
         
      //}
      
   }
   
   public void setColor(int number)
   {
     super.setColor(number);
     
   }
         
     
      
   }
   
