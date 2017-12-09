
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Card
{
   /*
   Make Card Instance Variables private
   Because any thing outside this class
   should not be able to modify them
    */
    private String faceName, suit;
    private int faceValue;
    private BufferedImage cardImage; /*
                                     Allows the storing of an image
                                     within a class*/

    /**
     * This Constructor for the Card class
     * @param suit "spades", "clubs", "diamonds", "hearts"
     * @param face = 2,3,4,5......,9,10,Jack,Queen,King,Ace
     * @param value= 2,3,4,....12,13,14
     * @param card a BufferedImage representing the card
     */

    public  Card(String suit, String face, int value, BufferedImage card)
    {
        this.suit = suit;
        this.faceName = face;
        this.faceValue = value;
        this.cardImage = card;

    }//end of constructor

    /**
     * This returns a string representation of a card object
     * @return
     */
    @Override
    public String toString()
    {
        return faceName + "of" + suit;

    }// end of toString

    /**
     * This returns the faceValue of the card
     * as an Integer
     * @return
     */
    public int getFaceValue()
    {
       return  faceValue;

    }//end of getFaceValue

    public static void main(String[] args) throws IOException
    {
        Card aceOfSpades = new Card("Spades", "Ace",
                14, ImageIO.read(new File("Ace_of_ spades.png")));

        Card queenOfHearts = new Card("Hearts", "Queen",
                12, ImageIO.read(new File("QueenOfHearts.jpg")));

        System.out.println(aceOfSpades.toString());
        System.out.println("The Ace of Spades has a value of\t" + aceOfSpades.getFaceValue());

        System.out.println(queenOfHearts.toString());
        System.out.println("The Queen of Hearts has a value of\t" + queenOfHearts.getFaceValue());

        // Create a JFrame to display our card
        JFrame window = new JFrame("Playing Card");
        window.setSize(400,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a JPanel - this is similar to glass in a window
        JPanel contentPane = new JPanel(new BorderLayout());

        //Create a JLabel
        JLabel cardLabel = new JLabel(new ImageIcon(aceOfSpades.cardImage));
        cardLabel.setSize(300,400);

        JLabel cardLabel01 = new JLabel(new ImageIcon(queenOfHearts.cardImage));
        cardLabel01.setSize(300,400);
        contentPane.add(cardLabel01);


        window.setVisible(true);
        window.add(contentPane);
    }//end of main



}//End of Card class
