package examenExemple.additionChiffres;

import java.util.Arrays;

import org.junit.internal.matchers.StacktracePrintingMatcher;

public class MainThreadedConcatener {

    public static void main(String[] args) {
        String[] entree = new String[400];

        // Fill the 'entree' array with string representations of integers followed by a dash
        for (int i = 0; i < 400; i++)
            entree[i] = Integer.toString(i) + "--";

        int numThreads = 4; // Number of threads to use
        ConcatenerThread[] threads = new ConcatenerThread[numThreads];
        Concatener2 c = new Concatener2(numThreads);
        // Calculate the number of elements each thread should handle
        int elementsPerThread = entree.length / numThreads;
        int remainingElements = entree.length % numThreads;

        // Create and start threads
        int startIndex = 0;
        for (int i = 0; i < numThreads; i++) {
            int threadElements = elementsPerThread + (i < remainingElements ? 1 : 0);
            threads[i] = new ConcatenerThread(c, i, entree, startIndex, startIndex + threadElements);
            threads[i].start();
            startIndex += threadElements;
        }

        // Wait for all threads to complete
        try {
            for (ConcatenerThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the concatenated string
        System.out.println("Valeur : " + c.getValeur());
    }
}

class ConcatenerThread extends Thread {
    private Concatener2 concatener;
    private String[] strings;
    private int startIndex;
    private int endIndex;
    private int id;

    public ConcatenerThread(Concatener2 concatener, int id, String[] strings, int startIndex, int endIndex) {
        this.concatener = concatener;
        this.strings = strings;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.id = id;
    }

    @Override
    public void run() {
    	System.out.println(Thread.currentThread().getName());
        for (int i = startIndex; i < endIndex; i++) {
            concatener.plus(strings[i], id);
        }
    }
}

class Concatener2 {
    private String[] valeur;
    
    public Concatener2(int numThreads) {
    	valeur = new String[numThreads];
    	for(int i = 0; i < numThreads; i++) {
    		valeur[i] = "";
    	}
    }

    public synchronized void plus(String s, int thread) {
        valeur[thread] += s;
    }

    public synchronized String getValeur() {
    	String result = "";
    	for(int i = 0; i < valeur.length; i++) {
    		result += valeur[i];
    	}
    	return result;
    }
}
