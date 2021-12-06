/**
 * Filename - ProducerConsumer.java
 *
 * Problem Statement - To simulate the producer-consumer pattern
 *
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Match> matchStorage = new ArrayBlockingQueue<>(90);
        BlockingQueue<MatchBox> boxStorage = new ArrayBlockingQueue<>(9);

        new Thread(new MatchProducer(matchStorage)).start();
        new Thread(new BoxProducer(boxStorage)).start();
        new Thread(new Consumer(matchStorage, boxStorage)).start();

        Thread.sleep(2000);
        System.exit(0);
    }
}
