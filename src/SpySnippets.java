import java.util.ArrayList;

/**
 * Solution by : Amol Gade
 * <p>
 * Note: for education purpose only
 * <p>
 * Problem statement:
 * Spy snippets
 * ============
 * <p>
 * You've been recruited by the team building Spy4Rabbits, a highly advanced search engine used to help fellow agents discover files and intel needed to continue the operations against Dr. Boolean's evil experiments. The team is known for recruiting only the brightest rabbit engineers, so there's no surprise they brought you on board. While you're elbow deep in some important encryption algorithm, a high-ranking rabbit official requests a nice aesthetic feature for the tool called "Snippet Search." While you really wanted to tell him how such a feature is a waste of time in this intense, fast-paced spy organization, you also wouldn't mind getting kudos from a leader. How hard could it be, anyway?
 * <p>
 * When someone makes a search, Spy4Rabbits shows the title of the page. Your commander would also like it to show a short snippet of the page containing the terms that were searched for.
 * <p>
 * Write a function called answer(document, searchTerms) which returns the shortest snippet of the document, containing all of the given search terms. The search terms can appear in any order.
 * <p>
 * The length of a snippet is the number of words in the snippet. For example, the length of the snippet "round fluffy rabbit tails" is 4. (Hey, don't judge your colleagues for what they search in their spare time).
 * <p>
 * The document will be a string consisting only of lower-case letters [a-z] and spaces. Words in the string will be separated by a single space. A word could appear multiple times in the document.
 * searchTerms will be a list of words, each word comprised only of lower-case letters [a-z]. All the search terms will be distinct.
 * <p>
 * Search terms must match words exactly, so "hop" does not match "hopping".
 * <p>
 * Return the first sub-string if multiple sub-strings are shortest. For example, if the document is "world there hello hello where world" and the search terms are ["hello", "world"], you must return "world there hello".
 * <p>
 * The document will be guaranteed to contain all the search terms.
 * <p>
 * The number of words in the document will be at least one, will not exceed 500, and each word will be 1 to 10 letters long. Repeat words in the document are considered distinct for counting purposes.
 * The number of words in searchTerms will be at least one, will not exceed 100, and each word will not be more than 10 letters long.
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (string) document = "many google employees can program"
 * (string list) searchTerms = ["google", "program"]
 * Output:
 * (string) "google employees can program"
 * <p>
 * Inputs:
 * (string) document = "a b c d a"
 * (string list) searchTerms = ["a", "c", "d"]
 * Output:
 * (string) "c d a"
 */

public class SpySnippets {

    public static void main(String[] args) {
        //input
        String document = "many google employees can program";
        String[] searchTerms = {"google", "program"};

        String[] DocumentArray;
        boolean in = false;
        String word, total = "", total2 = "";
        int size = 0;
        ArrayList<String> DocumentList = new ArrayList<String>();
        ArrayList<String> searchTermsList = new ArrayList<String>();
        ArrayList<String> TempsearchTermsList = new ArrayList<String>();
        ArrayList<String> TempList = new ArrayList<String>();
        ArrayList<String> total1 = new ArrayList<String>();
        SpySnippets answer = new SpySnippets();

        DocumentArray = document.split(" ");
        for (int i = 0; i < DocumentArray.length; i++) {
            DocumentList.add(DocumentArray[i]);
        }
        for (int i = 0; i < searchTerms.length; i++) {
            searchTermsList.add(searchTerms[i]);
            TempsearchTermsList.add(searchTerms[i]);
        }


        for (int i = 0; i < DocumentArray.length; i++) {
            word = DocumentArray[i];
            //call answer.getTheFirstSniffet()
            in = answer.getTheFirstSniffet(TempsearchTermsList, word, in);

            if (!in && TempsearchTermsList.size() == 0) {

                for (int k = 0; k < searchTermsList.size(); k++) {
                    if (word.equals(searchTermsList.get(k))) {
                        TempList.clear();
                        for (int p = i; p > i - size; p--) {
                            TempList.add(DocumentArray[p]);
                        }
                        //call answer.getTheShortestSniffet()
                        total1 = answer.getTheShortestSniffet(searchTermsList, TempList, size);
                        break;
                    }
                }
            }

            if (in) {
                if (TempsearchTermsList.size() == 0) {
                    total += word;
                } else {
                    total += word + " ";
                }
                size++;
            }
            if (TempsearchTermsList.size() == 0) {
                in = false;
            }

            if (total1.size() != 0) {
                for (int q = 0; q < total1.size(); q++) {
                    if (q == total1.size() - 1) {
                        total2 += total1.get(q);
                    } else {
                        total2 += total1.get(q) + " ";
                    }
                }
                total = total2;
                size = total1.size();
                total2 = "";
            }
        }
        System.out.println("output String==>" + total + "\nsize\t" + size);
        // return total;
    }

    public boolean getTheFirstSniffet(ArrayList<String> TempsearchTermsList, String word, boolean in) {
        if (TempsearchTermsList.size() != 0) {
            int index1;
            for (int j = 0; j < TempsearchTermsList.size(); j++) {

                if (word.equals(TempsearchTermsList.get(j))) {
                    in = true;
                    index1 = TempsearchTermsList.indexOf(TempsearchTermsList.get(j));
                    TempsearchTermsList.remove(index1);
                    break;
                }
            }
        }
        return in;
    }

    public ArrayList<String> getTheShortestSniffet(ArrayList<String> searchTermsList, ArrayList<String> TempList, int size) {
        int hit = 0, index = 0;
        ArrayList<String> output1 = new ArrayList<String>();

        for (int i1 = 0; i1 < searchTermsList.size(); i1++) {
            for (int j = 0; j < TempList.size(); j++) {
                if (searchTermsList.get(i1).equals(TempList.get(j))) {
                    if (index < j) {
                        index = j;
                    }
                    hit++;
                    break;
                }
            }
        }

        if (hit == searchTermsList.size() && index + 1 < size) {
            for (int x = index; x >= 0; x--) {
                output1.add(TempList.get(x));
            }
        }
        return output1;
    }

}
