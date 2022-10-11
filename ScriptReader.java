import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class ScriptReader
{
  String string, temp, leftChoice, rightChoice;
  boolean run, run2 = false;
  Scanner scan;
  File file;
  Decision d1, d2;
  public ScriptReader(){
    try{
    file = new File("Intro.txt");
    scan = new Scanner(file);
    }catch(Exception e){}
    string = "";
    d1 = new Decision("");
    d2 = new Decision("");
  }

  public boolean isPat()
  {
    return file.getName() == "PatScript.txt";
  }

  
   
  public String getNextParagraph(){
   string = "";
   for(int x = 0; x < 4; x++){
      if(scan.hasNextLine())
      {
        temp = scan.nextLine();
        if(temp.equals("//"))
        {
          break;
        }
        else if (temp.contains("DECISION"))
        {
          String[] array = temp.split("-");
          String c1 = array[1];
          String c2 = array[2];
          setChoiceString(1,c1);
          setChoiceString(2,c2);
          d1.setDecision(c1);
          d2.setDecision(c2);
          GameScreen.turnOnChoosing();
        }
        else if (temp.contains("ENDING1"))
        {
          try{
            file = new File("PatGood.txt");
            scan = new Scanner(file);
          }
          catch(Exception e){}
        }
        else if (temp.contains("ENDING2"))
        {
          try{
            file = new File("LoyGood.txt");
            scan = new Scanner(file);
          }
          catch(Exception e){}
        }
        else
          string += temp;
      }
      string += "\n";
      System.out.println(string); 
   }
   return string;
  }

 public String getDecision(int num){
   if(num == 1){
     return d1.getDecision();
   }
   else if (num == 2){
     return d2.getDecision();
   }

   return "";
   
 }

 public String getChoiceString(int num){
   if(num == 1){
     return leftChoice;
   }
   else if (num == 2){
     return rightChoice;
   }
   return "";
 }

 public void setChoiceString(int num, String s){
   if (num == 1)
   {
     switch (s)
     {
       case "L": 
        leftChoice = "Loyalist";
        break;
       case "P":
        leftChoice = "Patriot";
        break;
       case "mi10r10":
        leftChoice = "Pay" + "\n" + "(-10g,+10r)";
        break;
       case "mi20r10":
        leftChoice = "Pay" + "\n" + "(-20g,+10r)";
        break;
       case "ri10A":
        leftChoice = "Don't run "+ "\n" + "story(-10r)";
        break;
       case "mi20r30":
        leftChoice = "Join" + "\n" + "(-20g,+30r)";
        break;
       case "ri10B":
        leftChoice = "Don't" + "\n" + "join";
        break;
       case "noneA":
        leftChoice = "Bring" + "\n" + "nothing";
        break;
       case "mi20r20":
        leftChoice = "Pick critical" + "\n" + "(-20g, +20r)";
        break;
       case "m20ri20":
        leftChoice = "Pick neutral" + "\n" + "(+20g, -20r)";
        break;
       case "m10r30":
        leftChoice = "Push for" + "\n" + "change(-10g, +30r) ";
        break;
       case "ri20":
        leftChoice = "Encourage rule" + "\n" + "(-20r)";
        break;
       case "mi40r40":
        leftChoice = "Print speech" + "\n" +"(-40g, +40r)";
        break;
       case "ri30":
        leftChoice = "Don't print" +"\n" + "(-30r)";
        break;
       case "mi10l10":
        leftChoice = "Pay tax" +"\n" + "(-10g,+10r)";
        break;
       case "l30A":
        leftChoice = "Demand payment"  + "\n" +  "(+30g)";
        break;
       case "mi20l20A":
        leftChoice = "Arrest vendor"  + "\n" + "(-20g, +20r)";
        break;
       case "li20A":
        leftChoice = "Run story"  + "\n" +  "(-20r)";
        break;
       case "l30B":
        leftChoice = "Protect" + "\n" + "dock" + "(+30r)";
        break;
       case "li20B":
        leftChoice = "Regular" + "\n" + "patrol(-10r)";
        break;
       case "mi20l30":
        leftChoice = "Pick Neutral" + "\n" + "(-20g,+30r)";
        break;
       case "li20C":
        leftChoice = "Pick Objective" + "\n" + "(-20g)";
        break;
       case "mi20l20B":
        leftChoice = "Pull" + "\n" + "strings(-20m,+20r)";
        break;
       case "li20D":
        leftChoice = "Do nothing"  + "\n" + "(-20r)";
        break;
       
       
   
    }
   }
    else if (num == 2)
    {
      switch (s)
      {
       case "L": 
        rightChoice = "Loyalist";
        break;
       case "P":
        rightChoice = "Patriot";
        break;
       case "mi10r10":
        rightChoice = "Pay" + "\n" + "(-10g,+10r)";
        break;
       case "mi20r10":
        rightChoice = "Pay" + "\n" + "(-20g,+10r)";
        break;
       case "ri10A":
        rightChoice = "Don't run "+ "\n" + "story(-10r)";
        break;
       case "mi20r30":
        rightChoice = "Join" + "\n" + "(-20g,+30r)";
        break;
       case "ri10B":
        rightChoice = "Don't" + "\n" + "join(-10r)";
         break;
       case "noneA":
        rightChoice = "Bring" + "\n" + "nothing" + "\n" + "(No change)";
        break;
       case "mi20r20":
        rightChoice = "Pick critical " + "\n" + "article(-20g,+20r)";
        break;
       case "m20ri20":
        rightChoice = "Pick neutral " + "\n" + "article(+20g,-20r)";
        break;
       case "m10r30":
        rightChoice = "Push for" + "\n" + "change(+20g,+30r)";
        break;
       case "ri20":
        rightChoice = "Encourage rule" + "\n" + "(-20r)";
        break;
       case "mi40r40":
        rightChoice = "Print speech" + "\n" + "(-40g,+40r)";
        break;
       case "ri30":
        rightChoice = "Don't print" + "\n" + "(-30r)"; 
        break;
       case "mi10l10":
        rightChoice = "Pay tax" + "\n" + "(-10g,+10r)";
        break;
       case "l30A":
        rightChoice = "Demand" + "\n" + "payment(+30r)";
        break;
       case "mi20l20A":
        rightChoice = "Arrest" + "\n" + "vendor(-20g,+20r)";
        break;
       case "li20A":
        rightChoice = "Run story(-20r)";
        break;
       case "l30B":
        rightChoice = "Protect" + "\n" + "dock(+30r)";
        break;
       case "li20B":
        rightChoice = "Regular" + "\n" + "patrol(-20r)";
        break;
       case "mi20l30":
        rightChoice = "Neutral" + "\n" + "article(-20g,+30r)";
        break;
       case "li20C":
        rightChoice = "Objective" + "\n" + "article(-20r)";
        break;
       case "mi20l20B":
        rightChoice = "Pull" + "\n" + "strings(-20g,+20r)";
        break;
       case "li20D":
        rightChoice = "Do" + "\n" + "nothing(-20r)";
        break;
        
      }
    }
 }


public void setScript(String s){
  if(run == false){

    if(s.equals("Loyalist")){
      run = true;
      try{
      file = new File("LoyScript.txt");
      scan = new Scanner(file);
      }catch(Exception e){}
    }
    else if(s.equals("Patriot")) {
      run = true;
      try{
      file = new File("PatScript.txt");
      scan = new Scanner(file);
      }catch(Exception e){}
    }
    
  }
  if (run2 == false){
    if(s.equals("PatRepBad")) {
      run2 = true;
      try{
        file = new File("PatRepBad.txt");
        scan = new Scanner(file);
      }catch(Exception e){}
    }
    
    if(s.equals("LoyRepBad")) {
      run2 = true;
      try{
        file = new File("LoyRepBad.txt");
        scan = new Scanner(file);
      }catch(Exception e){}
    }
    else if(s.equals("MoneyEnd")) {
      run2 = true;
      try{
        file = new File("MoneyEnd.txt");
        scan = new Scanner(file);
        System.out.println("TEST");
      }catch(Exception e){System.out.println("FAILED");}
    }
  }
}


}





// try
// {
//   //random code
// }
// catch(Exception e){System.out.print(e.getErrorMessage())} 