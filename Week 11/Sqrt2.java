package com.rit.assignment11.A;

import java.math.BigDecimal;

class Sqrt2 implements Runnable{
    static BigDecimal OneByRootTwo = BigDecimal.valueOf(1);
    private final int start;
    private final int end;

    public Sqrt2(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = this.start; i < this.end; i++) {
            OneByRootTwo = OneByRootTwo.
            		multiply(BigDecimal.valueOf(1 -
            				(1 / Math.pow((4 * i) + 2, 2))));
        }
    }
}
