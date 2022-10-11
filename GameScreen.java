import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;



public class GameScreen extends UI 
{ 
  static boolean playing; 
  static boolean choosing = false;

  String leftChoiceString, rightChoiceString;

  BufferedImage bkgImg; 
  
  Sprites leftCharacter, rightCharacter, player, loyalist, patriot;

  UIComponent leftChoice, rightChoice;
  
  Counter monCount, repCount;

  AnimatedText t;

  ScriptReader s;

  GameValues v;
   public GameScreen(Graphics g, Rectangle b, int c,ScriptReader script,GameValues value)
   {
      
      super(g,b,c);

      v = value;
      s = script;

      leftChoiceString = "";
      rightChoiceString = "";

      try{
      bkgImg = ImageIO.read(new File("bkgd1.jpg"));
      } catch(Exception e){}

      player = new Sprites("boy");

      leftCharacter = player;

      components.add(new UIComponent("text border",100,400,600,500,3,true,false,b,"",Color.WHITE,Color.WHITE));

      components.add(leftChoice = new UIComponent("leftChoice",100,200,200,100,2,false,true,b,leftChoiceString,new Color(3, 0, 196),Color.WHITE));
      
      components.add(rightChoice = new UIComponent("rightChoice",500,200,200,100,2,false,true,b,rightChoiceString,new Color(237, 19, 19),Color.WHITE));

      monCount = new Counter(495,40,150,30,3,"Money: " + v.getMoney(),new Color(158,136,229),Color.BLACK,Color.BLACK);

      repCount = new Counter(650,40,150,30,3,"Rep: " + v.getRep(),new Color(158,136,229),Color.BLACK,Color.BLACK);

      t = new AnimatedText(s.getNextParagraph(),120,410,0,Color.WHITE);

      

      
      
     
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
         g.setColor(Color.BLACK);
         g.drawImage(bkgImg,0,0,null);
         leftCharacter.drawFrame(g, 50,150,0);

         g.fillRect(100,400,600,500);
         for(UIComponent c : components)
         {
            c.draw(g);
         
         }

         monCount.draw(g);
         repCount.draw(g);


         t.drawAnimatedText(g);

         if(choosing)
        {
          leftChoice.setVisible(true);
          rightChoice.setVisible(true);
          
          rightChoice.setText(s.getChoiceString(2));
          leftChoice.setText(s.getChoiceString(1));
          choosing = false;
          createChoices(g);
        }

   }

   public void setColor(int number)
   {
     super.setColor(number);
     
   }

   public static void turnOnChoosing(){
     choosing = true;
   }
   

   public void createChoices(Graphics g){
      g.setColor(Color.BLUE);
      g.fillRect(100, 200, 200, 100);
      
      g.setColor(Color.RED);
      g.fillRect(500, 200, 200, 100);
      
      leftChoice.draw(g);
      rightChoice.draw(g);
   }

   
}