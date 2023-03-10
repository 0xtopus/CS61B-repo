import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/** @Source: https://github.com/Berkeley-CS61B/lectureCode-sp18/blob/master/exercises/DIY/inheritance4/DemoCollections.java */
public class PlayWithWords {

	/** Returns a lower case version of the string with
	  * all characters except letters removed. */
	public static String cleanString(String s) {
		return s.toLowerCase().replaceAll("[^a-z]", "");
	}

	/** Gets a list of all words in the file. */
	public static List<String> getWords(String inputFilename) {
		List<String> words = new ArrayList<String>();
        In in = new In(inputFilename);
        while (!in.isEmpty()) {
            String lowerCaseStr = PlayWithWords.cleanString(in.readString());
            words.add(lowerCaseStr);
        }
        return words;
	}

	/** Returns the count of the number of unique words in words. */
	public static int countUniqueWords(List<String> words) {
        Set<String> stringSet = new HashSet<String>();
        for (String word : words) {
            stringSet.add(word);
        }
		return stringSet.size();
	}

	/** Returns a map (a.k.a. dictionary) that tracks the count of all specified
	  * target words in words. */
	public static Map<String, Integer> collectWordCount(List<String> words, List<String> targets) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : targets) {
            wordMap.put(w, getWordFrequency(words, w));
        }
        return wordMap;
	}

    /** Tell how many times a word presents in the given list */
    private static Integer getWordFrequency(List<String> words, String word) {
        int wordFreq = 0;
        for (String w : words) {
            if (word.equals(w)) {
                wordFreq++;           
            }
        }
        return wordFreq;
    }

	public static void main(String[] args) {
		List<String> w = getWords("lotteryOfBabylon.txt");
		System.out.println(w);
		System.out.println(countUniqueWords(w));

		List<String> targets = new ArrayList<String>();
		targets.add("lottery");
		targets.add("the");
		targets.add("babylon");

		System.out.println(collectWordCount(w, targets));
	}
} 