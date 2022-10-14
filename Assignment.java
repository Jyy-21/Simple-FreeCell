import java.util.*;


public class Assignment // main function class

{
      /**
       *
       * @param args an array of strings which stores arguments passed by command line while starting a program
       * @throws IndexOutOfBoundsException check for first input is 1 to 9 column and other function for exit/restart/rotate, 2nd input for cards exist, 3rd input for column list and pile
       * @throws InputMismatchException to catch error for user that wrong input for 3rd input
       * @throws NumberFormatException check for the correct input type
    */
        public static void main (String[] args)
    {

        deck object = new deck(); // create new deck class as object
        System.out.println(object);
        Scanner input = new Scanner(System.in);
        do
        {
            try
            {   //to let user know the first for x to exit game and 0 to choose column that need to rotate
                System.out.println("Insert comment (exp : 1 cA 2 ) || enter x at first input to exit || press 0 at first input to rotate || press r to restart game");
                System.out.print("Comment > ");
                String column1 = input.next();

                if(column1.equals("0"))// function to rotate
                {
                    do
                    {
                        System.out.print("Please insert the number column to rotate, available for column (1 to 8) :");
                        int columnRow = input.nextInt();
                        object.columnRotate(columnRow);
                        System.out.println(object);
                        System.out.print("Comment > ");
                        column1 = input.next();

                    }while(column1.equals("0"));
                }

                if(column1.equals("r") || column1.equals("R"))// function to restart game
                {

                        System.out.println();
                        object.clearAll();
                        object.addAll();
                        object.print();
                        object.addCard();
                        System.out.println(object);
                        continue;// Continue will restart the loop so other code down there it wont care


                }

                if(column1.equals("x")) // function to exit game
                        break;

                String getcards = input.next();
                getcards = getcards.substring(0,1) + getcards.substring(1,2).toUpperCase();// let user can input lowerCase
                String column2 = input.next();

                object.move(column1,getcards,column2); //function to move card(s)
                System.out.println(object);

            }
            catch(IndexOutOfBoundsException ex) // check for first input is 1 to 9 column and other function for exit/restart/rotate, 2nd input for cards exist, 3rd input for column list and pile
            {
                System.out.println();
                System.out.println("CheckError: First Input didn't match the list column(1 to 9), and input for exit/restart/rotate");
                System.out.println("CheckError: While for the second input user only can insert the the provide");
                System.out.println("CheckError: Third input user can input 1 to 9 and the 4 type of pile which is c,d,h,s");
                System.out.println();
            }

            catch(InputMismatchException ex)// check for the correct input type
            {
                System.out.println("CheckError: Input type didn't match the 3 input");
                System.out.println();
            }

            catch(NumberFormatException ex) // to catch error for user that wrong input for 3rd input
            {
                System.out.println("CheckError: First Input didn't match the list column(1 to 9), and input for exit/restart/rotate");
                System.out.println("CheckError: The third user can input 1 to 9 and the 4 type of pile which is c,d,h,s");
                System.out.println();
            }

            if (object.c.size() == 13 && object.d.size() == 13 && object.h.size() == 13  && object.s.size() == 13) // function to check did user finish the game
            {
                System.out.println("You won the game !!!");
                break;
            }

        }while(true);
    }
}
