import java.util.ArrayList;

//Class that runs the Selection Sort Algorithm; extends the algorithm abstract class to inherit functions
public class SelectionSort extends Algorithms{
    //Defining variables
    public ArrayList<GraphPoint> array;
    public boolean isSorted = false;
    public boolean foundblue = false;
    public GraphPoint CurrentSmallest;
    public int smallestInd;
    public int firstUnsortedInd;
    public int blueInd;
    //Constructor
    public SelectionSort(ArrayList<GraphPoint> array){
        super(array);
        this.array = array;
    }
    //Function that acts out a single iteration of the sort
    public boolean sortStep(ArrayList<GraphPoint> tempArray){
        firstUnsortedInd = -1;
        //finding first unsorted number
        for(int i=0; i<tempArray.size();i++){
            if(!tempArray.get(i).isSorted){
                firstUnsortedInd = i;
                break;
            }
        }
        if(firstUnsortedInd == -1 || firstUnsortedInd == tempArray.size() - 1){
            this.array = tempArray;
            if (sortCheck(array)){
                for(int j=0; j<tempArray.size(); j++){
                    tempArray.get(j).resetColor();
                }
                isSorted = true;
                // System.out.println("is sorted " + array);
            }else{
                //System.out.println("Somethin went wrong in selection sort");
            }

            return isSorted;
        }

        //Looking for first blue value
        blueInd = -1;
        foundblue = false;
        for(int i=firstUnsortedInd; i<tempArray.size(); i++){
            if(tempArray.get(i).color == tempArray.get(i).getCheckingColor()){
                foundblue = true;
                blueInd = i;
                CurrentSmallest = tempArray.get(i);
                smallestInd = i;
                break;
            }
        }
        //if we haven't found a blue, then just set the first unsorted thing as our new blue
        if(!foundblue){
            CurrentSmallest = tempArray.get(firstUnsortedInd);
            smallestInd = firstUnsortedInd;
            tempArray.get(firstUnsortedInd).setColorBlue();
            //System.out.println("no blues found, setting " + firstUnsortedInd + " to blue");
            return false;
        }

        //finding smallest value, not including sorted ones.
        for(int i = firstUnsortedInd; i<tempArray.size(); i++ ){
            if(CurrentSmallest.value > tempArray.get(i).value){
                CurrentSmallest = tempArray.get(i);
                smallestInd = i;
            }
        }
        //if our current blue is the smallest value, swap it
        if(smallestInd == blueInd) {
            //swapping
            tempArray.get(smallestInd).isSorted = true;
            tempArray.get(smallestInd).setColorGreen();
            GraphPoint tempVal = tempArray.get(firstUnsortedInd);
            tempArray.set(firstUnsortedInd, CurrentSmallest);
            tempArray.set(smallestInd, tempVal);

        this.array = tempArray;
        if (sortCheck(array)){
            for(int j=0; j<tempArray.size(); j++){
                tempArray.get(j).resetColor();
            }
            isSorted = true;
            // System.out.println("is sorted " + array);
        }

        return isSorted;
        }

        //Setting the next index to be blue.
        //if(blueInd < tempArray.size()){
        tempArray.get(blueInd + 1).setColorBlue();
        tempArray.get(blueInd).resetColor();
        //}
        //alternate version of selection sort that only changed next blue if it was smaller, kept for making faster
        // if not, loook ahead to see if there's a smaller blue, and if there is, then make that the new blue.
        //for(int i = blueInd; i < tempArray.size(); i++){
          //  if(tempArray.get(i).value < tempArray.get(blueInd).value){
            //    tempArray.get(i).setColorBlue();
              //  tempArray.get(blueInd).resetColor();
                //break;
          //  }
        //}


        this.array = tempArray;
        if (sortCheck(array)){
            for(int j=0; j<tempArray.size(); j++){
                tempArray.get(j).resetColor();
            }
            isSorted = true;
            // System.out.println("is sorted " + array);
        }

        return isSorted;
    }
}