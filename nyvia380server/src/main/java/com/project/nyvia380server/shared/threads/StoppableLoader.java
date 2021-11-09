package com.project.nyvia380server.shared.threads;

public class StoppableLoader implements Runnable{

    private String threadName = Thread.currentThread().getName();
    private boolean stopRequested = false;

    public void setThreadName(String threadName) {
        Thread.currentThread().setName(threadName);
        this.threadName = Thread.currentThread().getName();
    }

    private synchronized void requestStop(){
        this.stopRequested = true;
    }

    public synchronized boolean isStopRequested(){
        return this.stopRequested;
    }

    public void requestStopWizard() {
        System.out.println("Thread: " + this.threadName + "\trequesting stop!");
        requestStop();
        System.out.println("Thread: " + this.threadName + "\tstop requested!");
    }


    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread: " + threadName + "\tstarted!");
        while (!isStopRequested()) {
            sleep(1000);
        }
        System.out.println("Thread:" + threadName + "\tstopped!");
    }


}
