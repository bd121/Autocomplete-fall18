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
		
		// (low,high] contains target
		// TODO: complete method
		//return doFirstBS(low+1, high, list, target, comp);
		return bSearchFirst(list, target, comp);
	}
	
	public static <T> int bSearchFirst(List<T> list, 
           	T target, Comparator<T> comp) {
		
		int low = 0;
		int high = list.size()-1;
        int mid;
		
		while(low <= high)
		{
			mid = (low + high)/2;
			if(comp.compare(target, list.get(mid) )< 0)
					high = mid - 1;
			else
				if(comp.compare(target, list.get(mid) ) > 0)
					low = mid + 1;
				else {
					while(mid > 0 && comp.compare(target, list.get(mid-1)) == 0)
						mid--;
					return mid;
					
				}
		}
		return -1;
	}

	public static <T> int bSearchLast(List<T> list, 
           	T target, Comparator<T> comp) {
		
		int low = 0;
		int high = list.size()-1;
        int mid;
		
		while(low <= high)
		{
			mid = (low + high)/2;
			if(comp.compare(target, list.get(mid) )< 0)
					high = mid - 1;
			else
				if(comp.compare(target, list.get(mid) ) > 0)
					low = mid + 1;
				else {
					while(mid < high && comp.compare(target, list.get(mid+1)) == 0)
						mid++;
					return mid;
					
				}
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

		
		// target in [low,high)
		// TODO: complete method
		
		// (low,high] contains target
		// TODO: complete method
		//return doLastBS(low, high-1, list, target, comp);
		return bSearchLast(list, target, comp);
	}
	
}
