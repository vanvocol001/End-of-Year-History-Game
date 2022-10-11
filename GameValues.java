/*
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
*/
public class GameValues
{
  private int reputation;
  private int money;
  private String allegiance; 

  public GameValues()
  {
    reputation = 10;
    money = 70;
  }

  public void changeRep(int amount)
  {
    System.out.println(amount);
    if (reputation + amount <= 0)
      reputation = 0;
    else
      reputation += amount;
  }

  public int getRep(){
    return reputation;
  }

  public void changeMoney(int amount)
  {
    if (money + amount <= 0)
      money = 0;
    else
      money += amount;
  }
  
  public int getMoney(){
    return money;
  }

  public void setAllegiance(String alg)
  {
    allegiance = alg;
  }
  
  public String getAllegiance()
  {
    return allegiance;
  }

  public String toString()
  {
    return "";
  }
}