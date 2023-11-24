package tds.td7_swing_;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.SwingWorker;

import tds.td6_threads.MyRunnable;

public class CompteTask extends SwingWorker<Integer, Integer>{
	private Model model;
	private View view;
	public CompteTask(View view, Model model) {
		this.model = model;
		this.view = view;
	}
	@Override
	protected Integer doInBackground() throws Exception {
		Character character = view.getLetterInputField().getText().toCharArray()[0];
		
		int numThreads = Runtime.getRuntime().availableProcessors();
		System.out.println(numThreads);
        List<Thread> threads = new ArrayList<>();
        int chunkedSize = model.getContents().size() / numThreads;
        int remain = model.getContents().size() % numThreads;
        AtomicInteger count = new AtomicInteger(0);
        for(int i = 0; i < numThreads; i++) {
            int start = i* ( chunkedSize + ( (i < remain) ? 1:0) );
            int end = start + ( chunkedSize + ( (i < remain) ? 1:0) ) - 1;
            
            Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					count.addAndGet(countCharInFiles(character, start, end));
				}
			});
            
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to complete
        for(Thread thread : threads) {
            thread.join();
        }
        
        return count.get();
		
	}
	@Override
    protected void done() {
        try {
            // Get the result from doInBackground
            int count = get();
            
            // Update the view with the result
            view.setResult(String.valueOf(count));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception if needed
        }
    }
	
	private int countCharInFiles(Character character, int start, int end) {
		int count = 0;
		for(int i = start; i <= end; i++) {
			if(model.getContents().get(i) == character) {
				count++;
			}
		}
		return count;
	}
}
