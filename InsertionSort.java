import java.awt.*;
import java.util.ArrayList;

//Class that extends the algorithm abstract class that is used to perform insertion sort
public class InsertionSort extends Algorithms{
    //Declares the variables
    public ArrayList<GraphPoint> array;
    public boolean isSorted = false;
    //Constructor
    public InsertionSort(ArrayList<GraphPoint> array){
        super(array);
        this.array = array;
    }

    //Sort step which carries out a single step of the function to sort the array
    public boolean sortStep(ArrayList<GraphPoint> tempArray){
        //Sort temparray
        for(int i=1; i<tempArray.size(); i++){
            if (!(tempArray.get(i).color == new Color(4,190,26)) && !tempArray.get(i).isSorted){
                tempArray.get(i).resetColor();
            }
            //System.out.println(SortingFrom);
            if(tempArray.get(i).value < tempArray.get(i-1).value){
                //System.out.println("is changing");

                GraphPoint tempVal = tempArray.get(i-1);
                tempArray.set(i-1, tempArray.get(i));
                tempArray.set(i, tempVal);
                tempArray.get(i-1).setColorBlue();
                break;
            }else{
                //it is sorted!
                tempArray.get(i-1).setColorGreen();
                tempArray.get(i).setColorGreen();
                tempArray.get(i-1).isSorted = true;
                tempArray.get(i).isSorted = true;
            }
        }

        //Resets colour of the array
        this.array = tempArray;
        if (sortCheck(tempArray)){
            for(int j=0; j<tempArray.size(); j++){
            tempArray.get(j).resetColor();
            }
            isSorted = true;
        }

        return isSorted;
    }
}