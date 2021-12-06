/**
 * Filename - MatchProducer.java
 *
 * Produces unlimited Match objects over time
 *
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 */

import java.util.concurrent.BlockingQueue;

public class MatchProducer implements Runnable{
    BlockingQueue<Match> matchStorage;

    public MatchProducer(BlockingQueue<Match> matchStorage){
        this.matchStorage = matchStorage;
    }

    public void produce() throws InterruptedException {
        this.matchStorage.put(new Match());
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.produce();
            } catch (InterruptedException e) {
            }
        }
    }
}
