import java.awt.*;
//This class holds and defines the object that the arrays use to plot graphs
//Stuff such as colour data, values, etc, are all defined in this and to be implemented into an array to be displayed
public class GraphPoint {
    int value;
    //Defines the colour variables
    public Color color;
    private Color originalColor;
    private Color sortedColor;
    private Color checkingColor;
    private Color searchValueColor;
    private Color searchBlue;
    private Color searchGreen;
    public boolean isSorted;

    //Constructor for the function
    public GraphPoint(int value){
        this.value = value;
        setColor(value);
        this.originalColor  = color;
        this.isSorted = false;
    }

    //This function allows the program to set the colour of the current value point
    public void setColor (int value) {
        this.color = new Color((int)((value+1)/10),0,(int)((value+1)/15));
        this.sortedColor = new Color( 0, (int)((value+1)/10),(int)((value+1)/15) );
        this.checkingColor = new Color( 0, (int)((value+1)/15),(int)((value+1)/10) );
        this.searchValueColor = new Color(255,255,0);
        this.searchBlue = new Color(0,150,255);
        this.searchGreen = new Color(100,255,100);
    }

    //Setters
    //Sets the color to Yellow
    public void setColorSearch () {
        this.color = searchValueColor;
    }

    //set search green color
    public void setSearchGreen () {
        this.color = searchGreen;
    }

    //set search blue color
    public void setSearchBlue () {
        this.color = searchBlue;
    }

    //Sets the colour to Green
    public void setColorGreen () {
        this.color = sortedColor;
    }

    //Sets the colour to Blue
    public void setColorBlue () {
        this.color = checkingColor;
    }

    //Resets the colour of the point
    public void resetColor(){
        color = originalColor;
    }

    //Gets the sorted colour
    public Color getSortedColor() {
        return sortedColor;
    }

    //Getter
    //get the search green color
    public  Color getSearchGreen(){
        return searchGreen;
    }

    //get search blue colo
    public Color getSearchBlue(){
        return searchBlue;
    }
    //Gets the check colour
    public Color getCheckingColor() {
        return checkingColor;
    }

    //Gets the search colour
    public Color getSearchingColor() {
        return searchValueColor;
    }
}
