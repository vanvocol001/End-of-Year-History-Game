import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class Sprites
{
   final static int FLIP_VERTICAL = 1;
   final static int FLIP_HORIZONTAL = -1;
   
   double size = 0.7;
   BufferedImage[] allSpriteFrames; 
   BufferedImage[] spriteFrames;  

   
   BufferedImage image;
   
   public Sprites(String name)
   {
      allSpriteFrames = new BufferedImage[5];
      spriteFrames = new BufferedImage[5];
      
      try{
      allSpriteFrames[0]  = ImageIO.read(new File("sprboy1.png"));
      allSpriteFrames[1]  = ImageIO.read(new File("sprboy2.png"));
      allSpriteFrames[2]  = ImageIO.read(new File("sprboy3.png"));
      allSpriteFrames[3]  = ImageIO.read(new File("sprboy4.png"));
      allSpriteFrames[4]  = ImageIO.read(new File("sprboy5.png"));
      
      System.out.println("Success");
      }
      catch (Exception e) {System.out.println("Cannot find Image");}
      
      if(name.equals("boy"))
         for (int x = 0; x < 4; x++)
            spriteFrames[x] = allSpriteFrames[x];
      
      

      
   }
   
   
   
   public void drawFrame(Graphics g, int xPos, int yPos, int x)
   {
      //scaling
      int scaledWidth = (int)(spriteFrames[x].getWidth()*size);
      int scaledHeight = (int)(spriteFrames[x].getHeight()*size);
      
      BufferedImage output = new BufferedImage(scaledWidth,scaledHeight,spriteFrames[x].getType()==0?5:spriteFrames[x].getType());
      Graphics2D g2d = output.createGraphics();
      
      g.drawImage(spriteFrames[x], xPos, yPos , scaledWidth, scaledHeight, null);
      
      //flipping
      // if(horizontalDirection.equals("right") && verticalDirection.equals("up"))
      // {
      //    g.drawImage(spriteFrames[x], xPos, yPos , scaledWidth, scaledHeight, null);
      // }
      

      // if(horizontalDirection.equals("right") && verticalDirection.equals("down"))
      // {
      //    g.drawImage(spriteFrames[x], xPos, yPos+scaledHeight , scaledWidth, -(scaledHeight), null);
      // }
      
      // if(horizontalDirection.equals("left") && verticalDirection.equals("up"))
      // {

      //    g.drawImage(spriteFrames[x], xPos+scaledWidth, yPos , -(scaledWidth), scaledHeight, null);
      // }
      
      // if(horizontalDirection.equals("left") && verticalDirection.equals("down"))
      // {

      //    g.drawImage(spriteFrames[x], xPos+scaledWidth, yPos+scaledHeight , -(scaledWidth), -(scaledHeight), null);
      // }
      
         
      
      
      
   }
   
  //  int a=0;
   
  //  public void animate(Graphics g, int xPos, int yPos,int time, boolean right, boolean left, boolean up, boolean down)
  //  {
      
  //     if(right)
  //     {
         
  //        if(up)
  //        {
  //           //facing right, facing up
  //           if(time%200 == 0)
  //           {
  //              a++;
  //              if(a > spriteFrames.length-1)
  //              {
  //                 a = 1;
           
  //              }
         
  //           }  
  //           drawFrame(g,xPos,yPos,a,"right", "up");
  //        } 
         
  //        if(down)
  //        {
  //           //facing right, facing down
  //           if(time%200 == 0)
  //           {
  //              a++;
  //              if(a > spriteFrames.length-1)
  //              {
  //                 a = 1;
           
  //              }
         
  //           }  
  //           drawFrame(g,xPos,yPos,a,"right", "down");   
  //        }    
               
         
  //     }
      
  //     if(left)
  //     {
  //        if(up)      
  //        {
  //           //facing left, facing up
  //           if(time%200 == 0)
  //           {
  //              a++;
  //              if(a > spriteFrames.length-1)
  //              {
  //                 a = 1;
           
  //              }
         
  //           }  
  //           drawFrame(g,xPos,yPos,a,"left", "up");
  //        }
         
  //        if(down)      
  //        {
  //           //facing left, facing down
  //           if(time%200 == 0)
  //           {
  //              a++;
  //              if(a > spriteFrames.length-1)
  //              {
  //                 a = 1;
           
  //              }
         
  //           }  
  //           drawFrame(g,xPos,yPos,a,"left", "down");
  //        }
         
  //     }   
  //  }
   
   // public void clear (Graphics g, int xPos, int yPos)
//    {
//       int scaledWidth = spriteFrames[x].getWidth()*size;
//       int scaledHeight = spriteFrames[x].getHeight()*size;
//       
//       g.setColor(Color.WHITE);
//       g.fillRect(xPos, yPos , scaledWidth, scaledHeight);
//    }   
   public void changeCharacter (String name){
     if(name.equals("boy"))
         for (int x = 0; x < 4; x++)
            spriteFrames[x] = allSpriteFrames[x];
   }
   
   public BufferedImage flip (BufferedImage i, int direction)
   {
      BufferedImage flip = new BufferedImage(i.getWidth(),i.getHeight(),BufferedImage.TYPE_INT_RGB);
      for(int y = 0; y < i.getHeight(); y++)
      {
         for( int x = 0; x < i.getWidth(); x++)
         {
            switch(direction)
            {
               case FLIP_HORIZONTAL:
                  flip.setRGB((i.getWidth()-1)- x,y,i.getRGB(x,y));
                  break;
               case FLIP_VERTICAL:
                  flip.setRGB(x,i.getHeight()-1,i.getRGB(x,y));
                  break;
            }
               
          }
             
      }
      
      return flip;
      
    }
                     
                     
   
   

}