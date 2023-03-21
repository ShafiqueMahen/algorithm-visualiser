import java.util.ArrayList;
//Bubblesort algorithm which extends the abstract Algorithms
public class BubbleSort extends Algorithms{
    //Creates array for the graph points to be stored in
    public ArrayList<GraphPoint> array;
    //Defines variables for the algorithm to run
    public boolean isSorted = false;
    public boolean foundblue = false;
    public int SortingFrom;
    public int largestVal;
    //Constructor
    public BubbleSort(ArrayList<GraphPoint> array){
        super(array);
        this.array = array;
        this.SortingFrom = 0;
    }

    //Sort Step used to sort the array; either via a single click or by using the instant sort button to repeatedly run it
    public boolean sortStep(ArrayList<GraphPoint> tempArray){
        
        foundblue = false;
        for(int i=0; i<tempArray.size() - 1; i++){
        //Checking if value is blue
	    if(tempArray.get(i).color == tempArray.get(i).getCheckingColor()){
		    foundblue = true;
		    //The algorithm checks if the current value is larger than the next in the array, and if so, creates a temp value and swaps the values
            if(tempArray.get(i).value > tempArray.get(i+1).value){
                    GraphPoint tempVal = tempArray.get(i);
                    tempArray.set(i, tempArray.get(i+1));
                    tempArray.set(i + 1, tempVal);
                    break;
                }
            else{
                //Resets colour to show user it is no longer working on it, and moves the colour to the next value
    		    tempArray.get(i).resetColor();
		        tempArray.get(i+1).setColorBlue();
		        }
	        }
        }
        if(!foundblue){
	        for(int k=0; k<tempArray.size() - 1; k++){
	            //Sets all values to blue 
		        if(tempArray.get(k).value > tempArray.get(k+1).value){
			        tempArray.get(k).setColorBlue();
	                GraphPoint tempVal = tempArray.get(k);
                	tempArray.set(k, tempArray.get(k+1));
                    tempArray.set(k + 1, tempVal);
			        break;
		        }
	        }
        }

        //finding stuff to set to green
        largestVal = 0;
        for(int l=0; l<tempArray.size();l++){
            if(tempArray.get(l).color == tempArray.get(l).getSortedColor()){
            break;
            }
            if(tempArray.get(l).value >= tempArray.get(largestVal).value){
                largestVal = l;
            }
        }
        if(largestVal == tempArray.size() -1){
            tempArray.get(largestVal).setColorGreen();
        }else if(tempArray.get(largestVal+1).color == tempArray.get(largestVal + 1 ).getSortedColor()){
            tempArray.get(largestVal).setColorGreen();
        }


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