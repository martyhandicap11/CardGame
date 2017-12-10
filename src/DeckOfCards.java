import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

public class DeckOfCards {
    private Card[] deck;
    private int currentCard;

    public DeckOfCards() throws IOException {
        String[] faces = {"2", "3", "4", "3", "5", "6", "7", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};

        deck = new Card[52];
        currentCard = 0;

        /*
        Information to extract individual cards from
        one image holding all the cards
         */
        final int width = 20;
        final int height = 20;
        final int rows = 4;
        final int cols = 13;

        BufferedImage bigImage = ImageIO.read(new File("carddeck.jpg"));
        BufferedImage tempCardImage;

        for (int suit = 0; suit < 4; suit++) {
            for (int faceNum = 0; faceNum < 13; faceNum++) {
                //Extract the image
                tempCardImage = bigImage.getSubimage(
                        faceNum * width + (faceNum * 9), //starting x-coordinate
                        suit * height + (suit + 14),     //starting y-coordinate
                        width,                             //width of the image
                        height                             //height of the image
                );//end of Extract the image

                /**
                 * Create new card Object
                 */
                deck[(faceNum + (suit * 13))] = new Card(
                        suits[suit],                      //calls the suit array to get
                        faces[faceNum],                 //calls the faces array to get the face name
                        faceNum + 2,              //value of the card
                        tempCardImage                    //image of the card

                );// end of deck

            }//end of faceNum

        }//end for suit

    }//end of DeckOfCards constructor

    /**
     * This method will print the deck of cards to the screen
     */

    public void displayDeck() {
        for (Card card : deck)
            System.out.println(card);
    }

    /**
     * This method will shuffle the Card objects in the deck
     */
    public void shoffle() {
        currentCard = 0;

        SecureRandom randomNumber = new SecureRandom();
        //for each card in the deck , pick and swap them
        for (int first = 0; first < deck.length; first++) {
            //select random card
            int second = randomNumber.nextInt(52);

            //swap the cards
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    } //end of method shuffle

    /**
     * This will deal a card, advancing the currentCard instance
     * variable
     * @return  The top card on the deck
     */

    public Card dealCard()
    {
        if (currentCard < deck.length)
            return  deck[currentCard++];
        else
            return null;
    }//end of dealCard

    public static void main(String[] args) throws IOException
    {
        DeckOfCards theDeck = new DeckOfCards();
        theDeck.displayDeck();

        theDeck.shoffle();
        System.out.println("\nAfter shuffling the deck looks like this");
        theDeck.displayDeck();


    }//end of main

}//end of class DeckOfCards
