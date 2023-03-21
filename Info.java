import javax.swing.*;
import java.awt.*;

public class Info extends JPanel {
    String listValue = "BogoSort ";
    JLabel message;
    JLabel messageInfo; //thats fine, just separating these for the time being, just incase we want to style each thing separately.
    JLabel messageSteps;
    JLabel caseNotation;
    JPanel messageText;
    JPanel stepsPanel;

    Color textColor = new Color(220,220,220);
    public Info (){
        message = new JLabel(listValue);
        message.setForeground(textColor);
        //add(message);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //Info panel
        //c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        //height and width
        c.ipady = 260;
        c.ipadx = -157;
        messageText = new JPanel();
        messageText.setBackground(new Color(40,40,40));
        add(messageText,c);


        //Steps panel
        //c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        //height and width
        c.ipady = 200;
        c.ipadx = 400;
        stepsPanel = new JPanel();
        stepsPanel.setBackground(new Color(40,40,40));
        add(stepsPanel,c);

        messageInfo = new JLabel("Lorem ipsum");
        messageInfo.setForeground(textColor);
        messageInfo.setBackground(Color.BLUE);
        messageInfo.setFont(new Font("Arial", Font.BOLD, 14));
        caseNotation = new JLabel();
        caseNotation.setForeground(textColor);
        caseNotation.setFont(new Font("Arial", Font.BOLD, 14));
        messageText.add(messageInfo);
        messageText.add(caseNotation);

        messageSteps = new JLabel("");
        messageSteps.setForeground(textColor);
        messageSteps.setBackground(Color.GREEN);
        messageSteps.setFont(new Font("Arial", Font.BOLD, 14));
        stepsPanel.add(messageSteps);

        setBackground(new Color(80,80,130));

    }

    //Class and Switch statement that checks for which algorithm is selected, and displays the info based off of the selected algo
    public void setInformation() {
        switch (listValue) {
            //If Bogosort is selected, displays the relevant information
            case "BogoSort" -> {
                System.out.println("bogosort set text");
                message.setText("Current sorting algorithm being used is: " + listValue + ".");
                messageInfo.setText("<html><h1><u>Information:</u></h1><p style=\"width:425px\">Bogo Sort is a sorting algorithm that successively re-arranges the order of a data set until it finds an instance in which the data set is sorted. For instance, if we were to apply the Bogo Sort algorithm on a set of cards, it would consist of checking if the deck is in correct order; if not the deck would be shuffled at random and checked again. This process would continue until the deck is sorted.<br/></p></html>");
                caseNotation.setText("<html><h2><u>Notations:</u></h2><p style=\"width:425px\">Big O: O((n+1)!), as the array is randomised repeatedly there is a huge time complexity</p></html>");
                messageSteps.setText("<html><h2><u>Steps:</u></h2><p style=\"width:425px\">Step 1: Shuffle the data within the array randomly<br/>Step 2: Check if the shuffled array is sorted, using a boolean called isSorted (to determine if another shuffle is needed)<br/>Step 3: If sorted, set isSorted to true and return the array<br/>Step 4: Otherwise, repeat steps 1-3 until the shuffled array is sorted correctly.</p></html>");
                //System.out.println("Case 1 is currently being run"); testing purposes
            }

            //If Bogosort is selected, displays the relevant information
            case "BubbleSort" -> {
                message.setText("Current sorting algorithm being used is: " + listValue + ".");
                messageInfo.setText("<html><h1><u>Information:</u></h1><p style=\"width:425px\"> Bubble Sort is a sorting algorithm that starts at the beginning of a list, compares it to the next value in the list, and swaps if the previous value is larger. With this, the largest value will be sorted first, and then the 2nd largest will be sorted next, until the whole list is sorted. The appearance of the largest value floating up the list is like a bubble floating upwards, hence the name. While not the fastest algorithm, it is valid for small to medium sized data sets, and is extremely simple to understand! <br/></p></html>");
                caseNotation.setText("<html><h2><u>Notations:</u></h2><p style=\"width:425px\">Best Case Time Complexity: O(n), where the array is already sorted. <br> Worst Case and Average Case Time Complexity: O(n2), where the list is reverse sorted (ie Largest to Smallest), or shuffled into a random order <br> Space Complexity: O(1), the algorithm only needs a single temporary variable to store data for when a swap is made</p></html>");
                messageSteps.setText("<html><h2><u>Steps:</u></h2><p style=\"width:425px\">Step 1: Initialises loop to run for length of array, starts at position 0 <br/>Step 2: Compare the value at position 0 to value at position 1, if value 0 > value 1, the values are swapped. If value 0 < value 1, no swap is made <br/>Step 3: The loop iterates, the next values are considered (Value 1 and Value 2) <br/>Step 4: This is repeated until the final value n is reached in the list, which after one pass, should now be the largest value in the list <br/>Step 5: The list is checked to be sorted and if not, the loop is run again <br/>Step 6: Once all values are sorted, the sort check is run again, and if True is returned, the loop ends, and the sorted array is returned. </p></html>");
                //System.out.println("Case 2 is currently being run");
            }

            //If Insertion Sort is selected, displays the relevant information
            case "InsertionSort" -> {
                message.setText("Current sorting algorithm being used is: " + listValue + ".");
                messageInfo.setText("<html><h1><u>Information:</u></h1><p style=\"width:425px\"> Insertion Sort is a sorting algorithm that slowly builds up the sorted array, one entry at a time. It will compare the next value to the current one, and if smaller, swap it. However, it will build the array behind the pointer, so say if it has sorted 5 values, and the smallest value in the array is next to be checked, it will compare it to every value in the array, and move it down the list as it is the smallest; it will insert the next value into the in-progress array in the correct spot, iterating through the list until there are no more values to be inserted, hence its name! <br/></p></html>");
                caseNotation.setText("<html><h2><u>Notations:</u></h2><p style=\"width:425px\">Best Case Time Complexity: O(n), where the list is already sorted. <br> Worst Case and Average Case Time Complexity: O(n2), where the list is reverse sorted (ie Largest to Smallest), or shuffled into a random order, requiring much more comparisons to sort <br> Space Complexity: O(1), the algorithm only uses a single temporary variable to store data as it checks it against the sorted array <br> On average, it is more efficient than Bubble Sort!</p></html>");
                messageSteps.setText("<html><h2><u>Steps:</u></h2><p style=\"width:425px\"> Step 1: Initialises loop at the start of the list; checks 2nd value against the first, and if the 2nd value is smaller than the first, inserts it before it<br/>Step 2: The algorithm iterates, comparing the following numbers against those before it; if it is smaller than the number before it, it inserts it one place before it in the list<br/>Step 3: This reverse insertion is continued until the value before its current place is smaller than it, stopping the insertion<br/>Step 4: The algorithm will repeat this for every value in the list, iterating through it, until it reaches the last value<br/>Step 5: The algorithm will then do a check to see if no more swaps need to be done, and if none need to be done, the list is sorted and returned</p></html>");
                //System.out.println("Case 3 is currently being run");
            }

            //If Merge Sort is selected, displays the relevant information, not implemented, used in future
            case "MergeSort" -> {
                message.setText("Current sorting algorithm being used is: " + listValue + ".");
                messageInfo.setText("<html><h1><u>Information:</u></h1><p style=\"width:425px\"> This is a test for Merge Sort <br/></p></html>");
                caseNotation.setText("<html><h2><u>Notations:</u></h2><p style=\"width:425px\">Big O:  <br> Omega: <br> Theta: </p></html>");
                messageSteps.setText("<html><h2><u>Steps:</u></h2><p style=\"width:425px\"></p></html>");
                //System.out.println("Case 4 is currently being run");
            }

            //If Selection Sort is selected, displays the relevant information
            case "SelectionSort" -> {
                message.setText("Current sorting algorithm being used is: " + listValue + ".");
                messageInfo.setText("<html><h1><u>Information:</u></h1><p style=\"width:425px\"> Selection Sort is a sorting algorithm that will compare the current value pointed at in the list, and swap it for the smallest value in the whole list. It effectively splits the list into 2 sublists, a sorted and unsorted list, and as it iterates, the sorted list gets larger, and the unsorted list smaller. It compares the current value it has highlighted, iterates through the list, selecting the smallest value present in the unsorted sublist, and swaps it with the current value. It appears similar to Insertion Sort, however instead of Inserting and comparing, it simply selects and swaps values to sort. <br/></p></html>");
                caseNotation.setText("<html><h2><u>Notations:</u></h2><p style=\"width:425px\">Best and Worst Time Complexity: This is always O(n2) as the algorithm is made from 2 nested for loops, as such it is consistent, but for very large data sets, sorts such as Merge and Quicksort are more recommended <br> Space Complexity: O(1) as once again only a single temporary variable is needed to perform comparisons and swaps\n</p></html>");
                messageSteps.setText("<html><h2><u>Steps:</u></h2><p style=\"width:425px\">Step 1: Initialize the sorted list as empty, the unsorted list as the whole list <br/>Step 2: Begins at the first value, iterates to find the smallest value in the list, and swaps it with the first value in the list <br/>Step 3: The sorted list size is increased by 1, the unsorted list decreased by 1 <br/>Step 4: Repeats this process with Value 1, checking the unsorted list for the smallest value, swaps the 2, and then iterates <br/>Step 5: Iterates to the end of the list where the unsorted sublist has a size of 0 and the sorted sublist is now the whole list <br/>Step 6: By swapping, the whole list should be sorted <br/></p></html>");
                //System.out.println("Case 5 is currently being run");
            }

            //If Binary Search is selected, displays the relevant information, to be implemented in the future
            case "Binary Search" -> {
                message.setText("Current sorting algorithm being used is: " + listValue + ".");
                messageInfo.setText("<html><h1><u>Information:</u></h1><p style=\"width:425px\"> This is a test for Binary Search <br/></p></html>");
                caseNotation.setText("<html><h2><u>Notations:</u></h2><p style=\"width:425px\">Big O:  <br> Omega: <br> Theta: </p></html>");
                messageSteps.setText("<html><h2><u>Steps:</u></h2><p style=\"width:425px\">Step 1: <br/>Step 2: <br/>Step 3: <br/>Step 4: </p></html>");
                //System.out.println("Case 6 is currently being run");
            }

            //If Linear Search is selected, displays the relevant information
            case "LinearSearch" -> {
                message.setText("Current sorting algorithm being used is: " + listValue + ".");
                messageInfo.setText("<html><h1><u>Information:</u></h1><p style=\"width:425px\"> Linear Search is a Searching Algorithm that proceeds through the list one value at a time, comparing it to a reference/search value, and if it is found, returns True. This is the simplest form of searching that can be implemented, and as such it is simply implemented via a loop to iterate through the list to find the value that is being searched for <br/></p></html>");
                caseNotation.setText("<html><h2><u>Notations:</u></h2><p style=\"width:425px\">Worst Case Time Complexity: O(n), as there is a single loop, which means that it iterates once through the list. Worst case occurs if the value is not in the list or if it is the last value in the list, as the loop will traverse n values, hence O(n) </p></html>");
                messageSteps.setText("<html><h2><u>Steps:</u></h2><p style=\"width:425px\">Step 1: Have isFound be set to false, start at the beginning of the list <br/>Step 2: Iterate through the list, comparing the current iterated value to the reference or search value you aim to find <br/>Step 3: If the value is found, set isFound to true, return it <br/>Step 4: Else if the value is not found, return isFound as false <br/></p></html>");
                //System.out.println("Case 7 is currently being run");
            }

            //If nothing is selected, shows that something has gone wrong
            case "null" -> {
                message.setText("There is currently no algorithm being run");
                //System.out.println("Case 8 is currently being run");
            }

        }
    }

    public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }

    public void setListValue(String listValue) {
        this.listValue = listValue;
        System.out.println("info list value is "+listValue);
        setInformation();
    }
}
