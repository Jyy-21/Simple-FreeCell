import java.util.*;

class ColumnRotation {
  public static void main (String[] args) {
    ArrayList<String> column = new ArrayList<>();
    column.add ("cA");
    column.add ("d2");
    column.add ("h3");
    column.add ("s4");

    Scanner input = new Scanner (System.in);
    String cmd;
    do {
      System.out.println ("Column 1: " + column);
      System.out.print   ("Command > ");
      // Get first letter.
      cmd = input.next().substring(0,1);
      // If a column name is entered, rotate
      // the column by moving last element to front.
      if (cmd.equals("1"))
        column.add(0, column.remove(column.size()-1));
    } while (cmd.equals("1"));
    System.out.println ("Column 1: " + column);
  }
}
