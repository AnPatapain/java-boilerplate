package cms.cmConcurrence;


public class ExempleProducerConsumer {

  public static void main(String[] args) {
    Queue q = new Queue();
    Producer producer = new Producer(q);
    Consumer consumer = new Consumer(q);

    consumer.start();
    producer.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    producer.interrupt();
    consumer.interrupt();
  }
}