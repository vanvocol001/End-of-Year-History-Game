import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


class AnimatedText
{
String text;
int x,y,delay;
Color color;
    public AnimatedText (String s, int xPos, int yPos, int d, Color c)
    {
      text = s;
      delay = d;
      x = xPos;
      y = yPos;
      
      if(c != null)
      {
        color = c;
      }
      else{
        color = Color.WHITE;

      }

    }

    public void setText(String s)
    {
      System.out.println(s);
      text = s;
    }

    public void drawAnimatedText(Graphics g)
    {
      clearText(g);
      g.setColor(Color.WHITE);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

      String textTransfer = "";
      for(int a = 0; a < text.length(); a++){
        textTransfer += text.charAt(a);
        try{
        Thread.sleep(delay);
        } catch(Exception e){}
        drawString(g,textTransfer,x,y);
      }


    }

    public void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight()+10);
    }

    public void clearText(Graphics g)
    {
      g.setColor(Color.BLACK);
      g.fillRect(120,410,550,250);
    }
}