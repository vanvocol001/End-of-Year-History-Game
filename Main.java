import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class Main
{
  
   public static void main(String args[])
   {
   
      GameWindow tester = new GameWindow();
      tester.addWindowListener(
            new WindowAdapter()
            {
               public void windowClosing(WindowEvent e)
               {System.exit(0);}});
      tester.setSize(800,600); 
      tester.setResizable(false);   
      tester.setVisible(true);

  
   }
}
   
   
class GameWindow extends JFrame implements MouseListener, KeyListener
{

   static int minX, minY, width, height;
   int colorChoice; 
   boolean isTitle, isSub, isGame;
   TitleScreen t; 
   GameScreen game; 
   ScriptReader s;
   GameValues v;
   Decision d1, d2;
   boolean left, right = false;
   
   public GameWindow()
   {
      super("WINDOW");
      
      addMouseListener(this);
      addKeyListener(this);
      isTitle = true;
      isGame = false;
      
      s = new ScriptReader();
      v = new GameValues();
      d1 = new Decision("");
      d2 = new Decision("");

      


   }

   public void paint (Graphics g)
   {
      
      //boundaries
      Insets insets = getInsets();
      minX = insets.left;
      minY = insets.top;
      width = getWidth() - insets.left - insets.right - 1;
      height = getHeight() - insets.top - insets.bottom - 1;

      
      Rectangle bounds = new Rectangle (minX,minY,width,height);

      //System.out.println(bounds);
      t = new TitleScreen(g,bounds,1);
      game = new GameScreen(g,bounds,1,s,v);
      
      
  
      if(isTitle)
      {
         t.drawUI(g);
         
      }

      if(isGame)
      {
        game.drawUI(g);
        

      }
            
     
   }
  //mouse listeners
   public void mouseClicked(MouseEvent e)
   {
      int xPos = e.getX();
      int yPos = e.getY();

      if(isTitle)
      {
         for (UIComponent u : t.getUIComponentArray())
         {
            if (u.getBounds().contains(xPos,yPos) && u.isClickable())
            {
               update(u.getName());
               System.out.println("You clicked on play");
               repaint(); 
            }
              
         }
      }
      if(isGame)
      {
        for (UIComponent u : game.getUIComponentArray())
         {
            if (u.getBounds().contains(xPos,yPos) && u.isClickable())
            {
               System.out.println(u.getName());
               update(u.getName());

               System.out.println("You clicked on a choice");
               repaint(); 
            }
            
         }
         
      }
          
         


        
   }

   public void mouseEntered(MouseEvent e) 	{ }
   public void mouseExited(MouseEvent e) 	{ }
   public void mousePressed(MouseEvent e) 	{ }
   public void mouseReleased(MouseEvent e) 	{ }

   public void keyTyped(KeyEvent e){}
   public void keyPressed(KeyEvent e){
      if(e.getKeyCode() == KeyEvent.VK_SPACE){
        if(v.getRep() <= 0)
        {
          if(s.isPat())
            s.setScript("PatRepBad");
          else
            s.setScript("LoyRepBad");
        }

        if(v.getMoney() <= 0)
        {  
          s.setScript("MoneyEnd");
        }  
          repaint();
        } 

      
   }
   public void keyReleased(KeyEvent e) {}
   
   public void update( String name )
   {
      switch (name)
      {
         case "play" :
         {
            isTitle = false;
            isGame = true;
            break;
         }
         case "leftChoice" :
         {
            String choice = s.getDecision(1);
            switch(choice){
            case "L": 
              v.setAllegiance("Loyalist");
              s.setScript("Loyalist");
              break;
            case "P":
              v.setAllegiance("Patriot");
              s.setScript("Patriot");
              break;
            case "none":
              break;
            case "mi10r10":
              v.changeMoney(-10);
              v.changeRep(10);
              break;
            case "ri5":
              v.changeRep(-5);
              break;
            case "mi20r10":
              v.changeMoney(-20);
              v.changeRep(10);
              break;
            case "ri10A":
              //v.changeMoney(-10);
              v.changeRep(-10);
              break;
            case "ri10B":
              v.changeRep(-10); 
              break;
            case "mi20r30":
              v.changeMoney(-20);
              v.changeRep(30);
              break;    
            /*case "mi20r20":
              v.changeMoney(-20);
              v.changeRep(20);
              break;*/
            case "m20ri20":
              v.changeMoney(20);
              v.changeRep(-20);
              break;
            case "mi10r30":
              v.changeMoney(-10);
              v.changeRep(30);
              break;
            case "ri30":
              //v.changeMoney(-10);
              v.changeRep(-30);
              break;
            case "mi40r40":
              v.changeMoney(-40);
              v.changeRep(40);
              break;
            case "r20":
              v.changeRep(20);
              break;
            case "mi10l10":
              v.changeRep(10);
              v.changeMoney(-10);
              break;
            case "l20":
              v.changeRep(20);
              break;
            case "mi20l20A":
              v.changeRep(20);
              v.changeMoney(-20);
              break;
            case "mi20l20B":
              v.changeRep(20);
              v.changeMoney(-20);
              break;
            case "li20A":
              v.changeRep(-20);
              break;
            case "li20B":
              v.changeRep(-20);
              break;
            case "li20C":
              v.changeRep(-20);
              break;
            case "li20D":
              v.changeRep(-20);
              break;
            case "l30":
              v.changeRep(30);
              break;
            case "mi20l30":
              v.changeRep(30);
              v.changeMoney(-20);
              break;
            case "l30A":
              v.changeRep(30);
              break;
            case "l30B":
              v.changeRep(30);
              break;
            }  
            break;
         }

         case "rightChoice":
         {
           System.out.println("RIGHT");
           String choice = s.getDecision(2);
            switch(choice){
              case "L": 
              v.setAllegiance("Loyalist");
              s.setScript("Loyalist");
              break;
            case "P":
              v.setAllegiance("Patriot");
              s.setScript("Patriot");
              break;
            case "none":
              break; 
            case "mi10r10":
              v.changeMoney(-10);
              v.changeRep(10);
              break;
            case "mi20r10":
              v.changeMoney(-20);
              v.changeRep(10);
              break;
            case "ri10":
              //v.changeMoney(-10);
              v.changeRep(-10);
              break;
            case "mi20r30":
              v.changeMoney(-20);
              v.changeRep(30);
              break;
            case "mi20r20":
              v.changeMoney(-20);
              v.changeRep(20);
              break;
            case "m20ri20":
              v.changeMoney(-20);
              v.changeRep(-20);
              break;
            case "mi10r30":
              v.changeMoney(-10);
              v.changeRep(30);
              break;
            case "ri30":
              //v.changeMoney(-10);
              v.changeRep(-30);
              break;
            case "mi40r40":
              v.changeMoney(-40);
              v.changeRep(40);
              break;
            case "r20":
              v.changeRep(20);
              break;
            case "mi10l10":
              v.changeRep(10);
              v.changeMoney(-10);
              break;
            case "l20":
              v.changeRep(20);
              break;
            case "mi20l20A":
              v.changeRep(20);
              v.changeMoney(-20);
              break;
            case "mi20l20B":
              v.changeRep(20);
              v.changeMoney(-20);
              break;
            case "li20A":
              v.changeRep(-20);
              break;
            case "li20B":
              v.changeRep(-20);
              break;
            case "li20C":
              v.changeRep(-20);
              break;
            case "li20D":
              v.changeRep(-20);
              break;
            case "l30":
              v.changeRep(30);
              break;
            case "mi20l30":
              v.changeRep(30);
              v.changeMoney(-20);
              break;
            case "l30A":
              v.changeRep(30);
              break;
            case "l30B":
              v.changeRep(30);
              break;
            case "ri10A":
              v.changeRep(-10);
              break;
            case "ri10B":
              v.changeRep(-10);
              break;
         }
         break;
      }
   }
}
}

      