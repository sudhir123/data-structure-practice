package com.prac.home.tests.old;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


class WrietFile implements Runnable{

    File f;
    WrietFile(File f){
        this.f=f;
    }

    @Override
    public void run() {
        for(int i=1; i<1000; i++){
            // write to file
        }
    }
}


public class ThreadsImpl {

    public static void main(String[] args) {

        File f = new File("");

        WrietFile w = new WrietFile(f);

        Thread t1= new Thread(w);
        t1.start();
        Thread t2 = new Thread(w);
        t2.start();

        Executor e = Executors.newFixedThreadPool(10);
        e.execute(
                ()-> {
                    for(int i=1; i<1000; i++){
                        // write to file
                    }
                }
        );
    }
}
