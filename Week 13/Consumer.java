/**
 * Filename - Consumer.java
 *
 * Consumes 50 Match objects and 1 MatchBox object from storage to create
 * one final product
 *
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<Match> matchStorage;
    BlockingQueue<MatchBox> matchBoxStorage;
    int matches = 0;
    int totalProductsCreated = 0;

    public Consumer(BlockingQueue<Match> matchStorage, BlockingQueue<MatchBox> matchBoxStorage){
        this.matchStorage = matchStorage;
        this.matchBoxStorage = matchBoxStorage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.matchStorage.take();
                this.matches += 1;
            } catch (InterruptedException e) {
            }
            if (this.matches >= 50) {
                try {
                    this.matchBoxStorage.take();
                    System.out.println("Final product " + this.totalProductsCreated + " created with 50 matches and 1 matchbox.");
                    this.matches -= 50;
                    this.totalProductsCreated += 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
