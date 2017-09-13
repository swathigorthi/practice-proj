package test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Displayer extends Thread {
    private Queue<Long> userQueue = new PriorityQueue<>();
    private boolean allInputRead = false;
    
    public void adduser(Long userId){
    	synchronized(userQueue){
    		userQueue.add(userId);
    		userQueue.notify();
    	}
    }
    
    public void finish(){
    	allInputRead = true;
    	synchronized(userQueue){
    		userQueue.notify();
    	}
    }
    
    @Override
    public void run(){
    	while(true){
    	    synchronized(userQueue){
    	    	while(userQueue.isEmpty() && !allInputRead){
    	    		try {
						userQueue.wait();
					} catch (InterruptedException e) {}
    	    	}
    	    	while(!userQueue.isEmpty()){
    	    		System.out.println(userQueue.poll());
    	    	}
    	    	if(allInputRead){
    	    		break;
    	    	}
    	    }
    	}
    }
}
