
/*************************************************************************
 * @author Kevin Wayne
 *
 * Description: A term and its weight.
 * 
 *************************************************************************/

import java.util.Comparator;

public class Term implements Comparable<Term> {

	private final String myWord;
	private final double myWeight;

	/**
	 * The constructor for the Term class. Should set the values of word and
	 * weight to the inputs, and throw the exceptions listed below
	 * 
	 * @param word
	 *            The word this term consists of
	 * @param weight
	 *            The weight of this word in the Autocomplete algorithm
	 * @throws NullPointerException
	 *             if word is null
	 * @throws IllegalArgumentException
	 *             if weight is negative
	 */
	public Term(String word, double weight) {
		// TODO: Complete Term constructor
		if(weight < 0)
			throw new IllegalArgumentException("negative weight "+weight);
		
		if(word == null) //|| word.isEmpty())
			throw new NullPointerException("name is null or empty");
		
		myWord = word;
		myWeight = weight;
	}
	
	/**
	 * The default sorting of Terms is lexicographical ordering.
	 */
	public int compareTo(Term that) {
		return myWord.compareTo(that.myWord);
	}

	/**
	 * Getter methods, use these in other classes which use Term
	 */
	public String getWord() {
		return myWord;
	}

	public double getWeight() {
		return myWeight;
	}

	public String toString() {
		return String.format("(%2.1f,%s)", myWeight, myWord);
	}
	
	@Override
	public boolean equals(Object o) {
		Term other = (Term) o;
		return this.compareTo(other) == 0;
	}

	/**
	 * A Comparator for comparing Terms using a set number of the letters they
	 * start with. This Comparator may be useful in writing your implementations
	 * of Autocompletors.
	 *
	 */
	public static class PrefixOrder implements Comparator<Term> {
		private final int myPrefixSize;

		public PrefixOrder(int r) {
			this.myPrefixSize = r;
		}

		/**
		 * Compares v and w lexicographically using only their first r letters.
		 * If the first r letters are the same, then v and w should be
		 * considered equal. This method should take O(r) to run, and be
		 * independent of the length of v and w's length. You can access the
		 * Strings to compare using v.word and w.word.
		 * 
		 * @param v/w
		 *            - Two Terms whose words are being compared
		 */
		public int compare(Term v, Term w) {
			// TODO: Implement compare
			
            int value = 0;
            if (v == null && w == null) {
                value = 0;
            } else if (v == null) {
                value = -1;
            } else if (w == null) {
                value = 1;
            }
            if (value == 0) {
                               
                int len1 = v.getWord().length();
                int len2 = w.getWord().length();
                //int lim = Math.min(Math.min(len1, len2), myPrefixSize);
                
                int lim = 0;
                if(len1<len2)
                	lim = len1;
                else
                	lim = len2;
                
                if(lim>myPrefixSize)
                	lim = myPrefixSize;
                char v1[] = v.getWord().toCharArray();
                char v2[] = w.getWord().toCharArray();

                int i = 0;
                while (i < lim) {
                    char c1 = v1[i];
                    char c2 = v2[i];
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                    i++;
                }
                return len1 - len2;
            }
            return value;

		}
	
	}

	/**
	 * A Comparator for comparing Terms using only their weights, in descending
	 * order. This Comparator may be useful in writing your implementations of
	 * Autocompletor
	 *
	 */
	public static class ReverseWeightOrder implements Comparator<Term> {
		public int compare(Term v, Term w) {
			// TODO: implement compare
			
            int value = 0;
            if (v == null && w == null) {
                value = 0;
            } else if (v == null) {
                value = 1;
            } else if (w == null) {
                value = -1;
            }
            if (value == 0) {

            	if(v.getWeight() < w.getWeight())
            		value = 1;
            	if(v.getWeight() == w.getWeight())
            		value = 0;
            	if(v.getWeight() > w.getWeight())
            		value = -1;
            	
            }
            return value;
			
		}
	}

	/**
	 * A Comparator for comparing Terms using only their weights, in ascending
	 * order. This Comparator may be useful in writing your implementations of
	 * Autocompletor
	 *
	 */
	public static class WeightOrder implements Comparator<Term> {
		public int compare(Term v, Term w) {
			// TODO: implement compare
            int value = 0;
            if (v == null && w == null) {
                value = 0;
            } else if (v == null) {
                value = -1;
            } else if (w == null) {
                value = 1;
            }
            if (value == 0) {
                
            	if(v.getWeight() < w.getWeight())
            		value = -1;
            	if(v.getWeight() == w.getWeight())
            		value = 0;
            	if(v.getWeight() > w.getWeight())
            		value = 1;
            }
            
            return value;
		}
	}
}