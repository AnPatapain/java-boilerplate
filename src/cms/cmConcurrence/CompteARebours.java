package cms.cmConcurrence;

class CompteARebours extends Thread {
	public int processingCount = 0;

	CompteARebours(int processingCount) {
		this.processingCount = processingCount;
		System.out.println("Thread Créé");
	}

	@Override
	public void run() {
		System.out.println("*Thread " + this.getName() + " lancé");
		while (processingCount > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("*Thread " + this.getName() + " interrompu");
			}
			processingCount--;
			System.out.println("**Dans Thread " + this.getName() + ", compteur = " + processingCount);
		}
		System.out.println("*Thread " + this.getName() + " Terminé");
	}
}

