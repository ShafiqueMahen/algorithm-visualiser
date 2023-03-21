import java.util.ArrayList;
import java.util.Collections;

//Class extends the abstract class Algorithms as a foundation for it
public class BogoSort extends Algorithms{
    //Defines the array that stores the graph values
    public ArrayList<GraphPoint> array;
    //Sets sorted to false as an assumption to begin with
    public boolean isSorted = false;
    //Bogosort starts here
    //Constructor
    public BogoSort(ArrayList<GraphPoint> array){
        super(array);
        this.array = array;
    }
    //Sort step that is done to sort the array
    public boolean sortStep(ArrayList<GraphPoint> tempArray){
        //
        Collections.shuffle(tempArray);
        this.array = tempArray;
        if (sortCheck(array)){
            isSorted = true;
           // System.out.println("is sorted " + array);
        }
        return isSorted;
    }
}