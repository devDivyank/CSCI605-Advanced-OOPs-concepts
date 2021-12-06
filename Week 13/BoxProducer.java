/**
 * Filename - BoxProducer.java
 *
 * Produces unlimited MatchBox objects over time
 *
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 *
 */

import java.util.concurrent.BlockingQueue;

public class BoxProducer implements Runnable{
    BlockingQueue<MatchBox> matchBoxStorage;

    public BoxProducer(BlockingQueue<MatchBox> matchBoxStorage){
        this.matchBoxStorage = matchBoxStorage;
    }

    public void produce() throws InterruptedException {
        this.matchBoxStorage.put(new MatchBox());
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
