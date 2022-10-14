import java.util.*;

/**
 * this class is control all the game function
 *
 * @author Chan Jun Yang , Chan Jun Ting
 */
public class deck
{
    /**
     * this are the ArrayList for all the list pile for clubs .
	 */
    ArrayList<String> c = new ArrayList<>(); // list pile for clubs

    /**
     * this are the ArrayList for all the list pile for diamond.
	 */
    ArrayList<String> d = new ArrayList<>(); // list pile for diamond

    /**
     * this are the ArrayList for all the list pile for hearts.
	 */
    ArrayList<String> h = new ArrayList<>(); // list pile for hearts

    /**
     * this are the ArrayList for all the list pile for spades.
	 */
    ArrayList<String> s = new ArrayList<>(); // list pile for spades

    /**
     * this are the ArrayList for all the cards.
	 */
    ArrayList<String> cards = new ArrayList<>();

    /**
     * this are the ArrayList for all the list for 9 columns .
	 */
    ArrayList<String>[] list = new ArrayList[10]; // lists for 9 columns

    /**
     *constructor
     */
    public deck() // constructor
    {
        for (int i = 1; i <= 9; i++)
            {
                list[i] = new ArrayList<>();
            }
        addAll();
        print();
        addCard();

    }

    /**
     * @param column1 list number cards transfer from
     * @param getcards card input that user want to transfer to
     * @param column2 list number cards need transfer to
     */
    public void move(String column1,String getcards,String column2) // function to move the cards
    {

        checkValue(getcards);
        if(column2.equals("c") || column2.equals("d") || column2.equals("h") || column2.equals("s"))
            MoveCardToPile(column1,getcards,column2);

        else
            compareValue(column1,getcards,column2);
    }

    /**
     * function to print the all list
     */
    public String toString() //function to print the all list
    {
        return
        "\n" + "\n"+
        "Card can only be entered into pile one at a time !!!!!" + "\n" +
        "Pile    c: " + c + "\n" +
        "Pile    d: " + d + "\n" +
        "Pile    h: " + h + "\n" +
        "Pile    s: " + s + "\n" +
        "Column 1 :" + list[1] + "\n" +
        "Column 2 :" + list[2] + "\n" +
        "Column 3 :" + list[3] + "\n" +
        "Column 4 :" + list[4] + "\n" +
        "Column 5 :" + list[5] + "\n" +
        "Column 6 :" + list[6] + "\n" +
        "Column 7 :" + list[7] + "\n" +
        "Column 8 :" + list[8] + "\n" +
        "Column 9 :" + list[9];
    }

    /**
     * function of deck of cards with shuffle
     */
    public void addAll() // function of deck of cards with shuffle
    {
        Collections.addAll(cards,"cA","c2","c3", "c4", "c5", "c6", "c7", "c8", "c9", "cX", "cJ", "cQ", "cK",
                                 "dA", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "dX", "dJ", "dQ", "dK",
                                 "hA", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "hX", "hJ", "hQ", "hK",
                                 "sA", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "sX", "sJ", "sQ", "sK");
        Collections.shuffle(cards);
    }

    /**
     * function to deck that after shuffle
     */
    public void print() // function to deck that after shuffle
    {
        System.out.println("Shuffled cards : ");
        System.out.print(cards);
    }

    /**
     * function to add all the cards to 9 columns
     */
    public void addCard() //function to add all the cards to 9 columns
    {
        for (int i = 0; i<7; i++)
            list[1].add(cards.get(i));

        for (int i = 7; i<14; i++)
            list[2].add(cards.get(i));

        for (int i = 14; i<21; i++)
            list[3].add(cards.get(i));

        for (int i = 21; i<28; i++)
            list[4].add(cards.get(i));

        for (int i =28; i<34; i++)
            list[5].add(cards.get(i));

        for (int i = 34; i<40; i++)
            list[6].add(cards.get(i));

        for (int i = 40; i<46; i++)
            list[7].add(cards.get(i));

        for (int i =46; i<52; i++)
            list[8].add(cards.get(i));
    }

    /**
     * to get the cards value to check
     * @param getcards card input that user want to transfer to
     * @return to get card value for checking ordering method
     */
    public int checkValue(String getcards) // to get the cards value to check
    {
        if(getcards.substring(1,2).equals("A"))
            return 1;

        else if(getcards.substring(1,2).equals("2"))
            return 2;

        else if(getcards.substring(1,2).equals("3"))
            return 3;

        else if(getcards.substring(1,2).equals("4"))
            return 4;

        else if(getcards.substring(1,2).equals("5"))
            return 5;

        else if(getcards.substring(1,2).equals("6"))
            return 6;

        else if(getcards.substring(1,2).equals("7"))
            return 7;

        else if(getcards.substring(1,2).equals("8"))
            return 8;

        else if(getcards.substring(1,2).equals("9"))
            return 9;

        else if(getcards.substring(1,2).equals("X"))
            return 10;

        else if(getcards.substring(1,2).equals("J"))
            return 11;

        else if(getcards.substring(1,2).equals("Q"))
            return 12;

        else if (getcards.substring(1,2).equals("K"))
            return 13;

        else
            return -1;
    }

    /**
     * function to compare the value when the cards need transfer to
     * @param column1 list number cards from
     * @param getcards card input that user want to transfer to
     * @param column2 list number cards need transfer to
     */
    public void compareValue(String column1,String getcards,String column2) // function to compare the value when the cards need transfer to
    {

            int columnFrom = Integer.parseInt(column1); // list number cards from
            int columnTo = Integer.parseInt(column2); // list number cards need transfer to


            if(columnFrom == 9) // move card(s) from column 9 function
            {
                int number1 = checkValue(getcards);
                int number2 = checkValue(list[columnTo].get(list[columnTo].size() - 1)  );
                if(list[9].isEmpty())
                    System.out.println("Column 9 did not have card to move");

                else
                {
                    if (number2 == number1 + 1) //check cards transfer from and transfer to is in order from
                    {
                        list[columnTo].add(getcards);
                        list[columnFrom].remove(getcards);
                    }

                    else
                    System.out.println("Error = card not place in the ascending way, please try again");

                }

            }

            else if(columnTo == 9) // move card(s) to column 9 function
            {

                if(list[9].size() < 4) // to check column 9 size is less than 4
                {
                    if(list[columnFrom].indexOf(getcards) == list[columnFrom].size()-1)
                    {
                        list[9].add(getcards);
                        list[columnFrom].remove(getcards);
                    }
                    else
                        System.out.println("Error = Column 9 can only insert the last card from each column");
                }
                else
                    System.out.println("Error = Column 9 only can insert 4 cards");


            }

            else if (list[columnFrom].indexOf(getcards) != list[columnFrom].size()-1) // move more than one card function
            {
                boolean sorting = true ;
                int indexCards = list[columnFrom].indexOf(getcards); // the index of the cards that user input
                int lastIndex = list[columnFrom].size() - 1; // the last index of the list for column's from


                for(int i = indexCards; i < lastIndex; i++ )
                {
                    sorting = checkCardOrder(columnFrom , i , i+1,sorting); // to check cards that need to transfer all in order
                }

                if(list[columnTo].isEmpty() && sorting == true) // transfer cards to and empty column
                {
                    for(int i = indexCards   ; i <= lastIndex  ; i++ )
                    {
                        list[columnTo].add(list[columnFrom].get(i));
                    }

                    for(int i = lastIndex; i >= indexCards  ; i--)
                    {
                        list[columnFrom].remove(list[columnFrom].get(i));
                    }
                }
                else // transfer cards to other column that not empty
                {
                    int number1 = checkValue(getcards);
                    int number2 = checkValue(list[columnTo].get(list[columnTo].size() - 1) );
                    if (number2 == number1 + 1)
                    {

                        if(sorting)
                        {
                            for(int i = indexCards   ; i <= lastIndex  ; i++ )
                            {
                                list[columnTo].add(list[columnFrom].get(i));
                            }
                            for(int i = lastIndex; i >= indexCards  ; i--)
                            {
                                list[columnFrom].remove(list[columnFrom].get(i));
                            }
                        }
                        else
                            System.out.println("Error = card choose not in the ordering with other");
                    }
                    else
                        System.out.println("Error = card(s) that transfer not in ascending order, please try again");
                }

            }

            else // move one cards function
            {
                if(list[columnTo].isEmpty())
                {
                    list[columnTo].add(getcards);
                    list[columnFrom].remove(getcards);
                }
                else
                {
                    int number1 = checkValue(getcards);
                    int number2 = checkValue(list[columnTo].get(list[columnTo].size() - 1) );

                    if (number2 == number1 + 1)
                    {
                            list[columnTo].add(getcards);
                            list[columnFrom].remove(getcards);
                    }

                    else
                        System.out.println("Error = card not place in the ascending way, please try again");
                }
            }

    }

    /**
     * function check the all cards that need transfer is in order if move more than one cards
     * @param numColumn card user input
     * @param index card index that user input
     * @param index2 next card that user input
     * @param sorting to check all card that need to transfer is in order form .If true all card are in order , if false all card are not in order
     * @return sorting whether the sorting is true
     */
    public boolean checkCardOrder(int numColumn ,int index, int index2,boolean sorting) // function check the all cards that need transfer is in order if move more than one cards
    {

        int compare1 = checkValue(list[numColumn].get(index)); //card user input
        int compare2 = checkValue(list[numColumn].get(index2)); // next card that user input
        if(compare1 == compare2 + 1) // check both compare 1 and 2 cards is in order form
        {
            sorting = true;
        }
        else
        {
            sorting = false;
        }
        return sorting;

    }

    /**
     * function to move card to pile
     * @param column1  list number cards from
     * @param getcards  card input that user want to transfer to
     * @param column2 list number cards need transfer to
     */
    public void MoveCardToPile(String column1,String getcards,String column2) // function to move card to pile
    {
        int columnFrom = Integer.parseInt(column1);
        if(column2.equals("c") && getcards.substring(0, 1).equals("c") && list[columnFrom].indexOf(getcards) == list[columnFrom].size()-1) // move card to pile c
        {
            if(c.isEmpty() && checkValue(getcards) == 1)  // if pile is empty, check the the card insert is A
            {
                c.add(getcards);
                list[columnFrom].remove(getcards);
            }
            else // if pile not empty
            {
                int number1 = checkValue(getcards);
                int number2 = checkValue(c.get(c.size() - 1));

                if (number1 == number2 + 1) // check pile last card and card need to insert is in order form
                {
                    c.add(getcards);
                    list[columnFrom].remove(getcards);
                }
                else // card didn't follow the order form
                {
                    System.out.println("Error = card not place in the ascending way, please try again");
                }

            }
        }

        else if(column2.equals("d") && getcards.substring(0, 1).equals("d") && list[columnFrom].indexOf(getcards) == list[columnFrom].size()-1) // move card to pile d
        {
            if(d.isEmpty() && checkValue(getcards)== 1)
            {
                d.add(getcards);
                list[columnFrom].remove(getcards);
            }

            else
            {
                int number1 = checkValue(getcards);
                int number2 = checkValue(d.get(d.size() - 1));

                if (number1 == number2 + 1)
                {
                    d.add(getcards);
                    list[columnFrom].remove(getcards);
                }
                else
                {
                    System.out.println("Error = card not place in the ascending way, please try again");
                }

            }
        }

        else if(column2.equals("h") && getcards.substring(0, 1).equals("h") && list[columnFrom].indexOf(getcards) == list[columnFrom].size()-1) // move card to pile h
        {
            if(h.isEmpty() && checkValue(getcards)== 1)
            {
                h.add(getcards);
                list[columnFrom].remove(getcards);
            }

            else
            {
                int number1 = checkValue(getcards);
                int number2 = checkValue(h.get(h.size() - 1));

                if (number1 == number2 + 1)
                {
                    h.add(getcards);
                    list[columnFrom].remove(getcards);
                }
                else
                {
                    System.out.println("Error = card not place in the ascending way, please try again");
                }

            }
        }

        else if(column2.equals("s") && getcards.substring(0, 1).equals("s") && list[columnFrom].indexOf(getcards) == list[columnFrom].size()-1) // move card to pile s
        {
            if(s.isEmpty() && checkValue(getcards)== 1)
            {
                s.add(getcards);
                list[columnFrom].remove(getcards);
            }

            else
            {
                int number1 = checkValue(getcards);
                int number2 = checkValue(s.get(s.size() - 1));

                if (number1 == number2 + 1)
                {
                    s.add(getcards);
                    list[columnFrom].remove(getcards);
                }
                else
                {
                    System.out.println("Error = card not place in the ascending way, please try again");
                }
            }
        }

        else // user didn't insert (c,d,h,s) which input list that no in the program
        {

            System.out.println("Error = Pile input did not match(c,d,h,s), make sure card insert into correct pile");
            System.out.println("Error = Pile input can only insert by the last card of each column");
        }

    }

    /**
     * function to push every last card in column to first
     * @param columnRow column from
     */
    public void columnRotate(int columnRow) // function to push every last card in column to first
    {

        list[columnRow].add(0, list[columnRow].get(list[columnRow].size()-1));
        list[columnRow].remove(list[columnRow].size()-1);
        System.out.println("The column " + columnRow + " has rotated");

    }

    /**
     * function clear all list to restart method
     */
    public void clearAll() // function clear all list to restart method
    {
        c.clear();
        d.clear();
        s.clear();
        h.clear();
        list[1].clear();
        list[2].clear();
        list[3].clear();
        list[4].clear();
        list[5].clear();
        list[6].clear();
        list[7].clear();
        list[8].clear();
        list[9].clear();
        cards.clear();
    }
}
