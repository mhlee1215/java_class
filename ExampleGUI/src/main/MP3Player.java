package main;

/*************************************************************************
 *  Compilation:  javac -classpath .:jl1.0.jar MP3.java         (OS X)
 *                javac -classpath .;jl1.0.jar MP3.java         (Windows)
 *  Execution:    java -classpath .:jl1.0.jar MP3 filename.mp3  (OS X / Linux)
 *                java -classpath .;jl1.0.jar MP3 filename.mp3  (Windows)
 *  
 *  Plays an MP3 file using the JLayer MP3 library.
 *
 *  Reference:  http://www.javazoom.net/javalayer/sources.html
 *
 *
 *  To execute, get the file jl1.0.jar from the website above or from
 *
 *      http://www.cs.princeton.edu/introcs/24inout/jl1.0.jar
 *
 *  and put it in your working directory with this file MP3.java.
 *
 *************************************************************************/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;

import javazoom.jl.player.Player;


public class MP3Player {
    private String filename;
    private Player player; 
    private Thread playThread;

    // constructor that takes the name of an MP3 file
    public MP3Player(String filename) {
        this.filename = filename;
    }

    public void close() { if (player != null) player.close(); }

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        playThread = new Thread() {
            public void run() {
                try {
                
                	player.play(); 
                
                }
                catch (Exception e) { System.out.println(e); }
            }
        };
        playThread.start();
    }
    
    public synchronized void pause(){ 
    	synchronized(playThread){
    		playThread.suspend();
    	}
    }
    
    public synchronized void resume(){
    	synchronized(playThread){
    		playThread.resume();
    	}
    }


    // test client
    public static void main(String[] args) {
    		URL filePath = MP3Player.class.getResource("data/ratherbe.mp3");
    		//System.out.println(filePath.getFile());
        String filename = filePath.getFile();
        MP3Player mp3 = new MP3Player(filename);
        mp3.play();

        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // when the computation is done, stop playing it
        System.out.println("pause!");
        mp3.pause();
        
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("resume");
        mp3.resume();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("pause!");
        mp3.pause();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("resume");
        mp3.resume();
        

    }

}
