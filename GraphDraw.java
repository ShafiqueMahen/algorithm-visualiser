import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//This class extends the graph and mainly contains the bars that represent the data being sorted
public class GraphDraw extends JPanel{
    ArrayList<GraphPoint> array;
    int largestNumber = 0;

    //Constructor that initializes the array that holds the values
    public GraphDraw(ArrayList<GraphPoint> tempArray){
        array = tempArray;
        if (array.size() == 0){
                array.add(new GraphPoint(0));
        }
        int RecWidth = getWidth() - getWidth()/9;
        setBackground(new Color(60,60, 100));
    }
    
    //drawing the bar chart
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        ArrayList temp = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            temp.add(array.get(i).value);
        }
        //White background rectangle
        g.setColor(new Color(80,80,130));
        int RecWidth = getWidth() - getWidth()/9; // width of white rectangle == 813px

        g.fillRect(getWidth()/18,getHeight()/18,RecWidth, getHeight() - (5 * getHeight())/(getHeight()/20));

        //Drawing the rest of the bars
        g.setColor(new Color(0,0,0));

        //Temp is a placeholder for the width of the bar
        int barWidth = (RecWidth/array.size());
        int textSize;
        int textXpos;
        //For loop manages many GUI factors for size of graph
        for (int i = 0; i < array.size(); i++) {
            g.setColor(array.get(i).color);

            g.fillRect((int)Math.floor
                (
                    getXBarPos(i, RecWidth, barWidth)),  //Gets X position
                    getHeight()/18 + getHeight() - (5 * getHeight())/(getHeight()/20) + getBarHeight(array.get(i).value), //Gets height
                    barWidth,
                    -getBarHeight(array.get(i).value) //Height has to be negative]
                );
            if(array.size() > 1 && array.size() <= 40)
            {
                textSize = 14;
                if(array.size() < 10){textSize+=5;}
                if(array.size() > 30){textSize-=5;}
                if(array.size() >= 20){
                    textXpos = (int) (getXBarPos(i, RecWidth, barWidth) + 0.1 * (barWidth));
                }else{
                    textXpos = (int) (getXBarPos(i, RecWidth, barWidth) + 0.35 * (barWidth));
                }
                    g.setColor(new Color(0, 255, 0));
                    g.setFont(new Font("Arial", Font.BOLD, textSize));
                    g.drawString(String.valueOf(array.get(i).value),
                            textXpos,
                            (int) (getHeight() / 18 + getHeight() - (5 * getHeight()) / (getHeight() / 20) + 0.4 * (getBarHeight(array.get(i).value))));
            }
        }
        //Sets colours for graph labels and numbers
        g.setColor(new Color(220,220,220));
        g.setFont(new Font("Arial", Font.BOLD,16));
        g.drawString("Index",(getWidth()/18) + (RecWidth/2), (getHeight()/18 + getHeight() - (5 * getHeight())/(getHeight()/20))+20);
        g.drawString("Graph",(getWidth()/18) + (RecWidth/2), (getHeight()/18) - 10 );
        g.drawString("Size",((RecWidth/2))*2 + 83, (getHeight() - (5 * getHeight())/(getHeight()/20))/2 );
    }

    //This function gets the X position of a bar
    private double getXBarPos (int i, int Recwidth, int BarWidth) {
        double x = ( (BarWidth * i)) ;
        x += getWidth()/18; //Starting at the edge of the white rectangle.
        return x;
    }

    //Gets the X coordinate of a specific bar from the array of values. Used for a future implementation of lineGraph
    private int getXCoordinate (ArrayList<Integer> array) {
        int x = (getWidth()/array.size())/2;
        return x;
    }

    //Gets the height of a bar from the array and value from it
    private int getBarHeight(int i){
        largestNumber = array.get(0).value;
        for (int j = 1; j < array.size(); j++) {
            if (largestNumber < array.get(j).value){
                largestNumber = array.get(j).value;
            }
        }
        float y = (float)i / (float)largestNumber; // gets the fraction of i from the largest value in the array.
        // scale the bar up to the graph using the percentage above.
        y *= getHeight() - (5 * (float)getHeight())/((float)getHeight()/20);
        return (int)-y;
    }

    //Setter to set the array
    public void setarray(ArrayList<GraphPoint> array) {
        this.array = array;
    }
}

