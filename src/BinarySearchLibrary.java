import java.util.*;

public class BinarySearchLibrary {
	
	public static <T>
	    int firstIndexSlow(List<T> list, 
	    		           T target, Comparator<T> comp) {
		int index = Collections.binarySearch(list, target,comp);
		
		if (index < 0) return index;
		
		while (0 <= index && comp.compare(list.get(index),target) == 0) {
			index -= 1;
		}
		return index+1;
	}
	
	private static <T> int lastIndexSlow(List<T> list, T target, Comparator<T> comp) {
		
		int index = Collections.binarySearch(list, target,comp);
	
		if (index < 0) return index;
	
		while (index < list.size() && comp.compare(list.get(index),target) == 0) {
			index += 1;
		}
		return index-1;
	}

	/**
	 * Uses binary search to find the index of the first object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index < i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	
	public static <T>
    	int firstIndex(List<T> list, 
	               	T target, Comparator<T> comp) {
		
		int low = -1;
		int high = list.size()-1;
		// (low,high] contains target				
		// TODO: complete method
		
        int mid;
		
		while(low < high)
		{
       
			mid = (high + low)/2;
	       
	        int cmp = comp.compare(list.get(mid), target);
	        
			if( cmp < 0) {
				low = mid;
			}
			else {

					high = mid;
					
					if(cmp == 0)
					{
						if(mid == low || mid == 0 || (mid-low) == 0 || (high-low)==1)
							  return mid;
					}
					
				}

			if((high - low == 1) && comp.compare(list.get(high), target) == 0)
				return high;
			else
				if(high - low == 1) 
				  return -1;
			
	        	
						
		}
		
		return -1;
		
	}
	

	/**
	 * Uses binary search to find the index of the last object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index > i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	public static <T>
	int lastIndex(List<T> list, 
               	  T target, Comparator<T> comp) {
		
		int low = 0;
		int high = list.size();
		
		// target in [low,high)
		// TODO: complete method

        int mid;
		
		while(low < high)
		{
       
			mid = (high + low)/2;
			int c = comp.compare(list.get(mid), target); 
			
			if(c > 0) {
				high = mid;
			}
			else {

					low = mid;
					
					if(c == 0)
					{
						if(mid == high || mid == 0 || (mid-high) == 0 || mid == list.size()-1)
							  return mid;
					
					}
					
				}
			
			if( (high - low == 1) && comp.compare(target, list.get(low) ) == 0)
        		return low;
			 else
		        	if ((high - low) == 1)
		        		return -1;
						
		}
		
		return -1;
	
	}
	
	
	
	
}
