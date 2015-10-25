package main;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class WAVPlayer extends Thread{

    private final int BUFFER_SIZE = 1280;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;

    boolean isPlay = true;
    public void stopSound(){
    		isPlay = false;
    }
    /**
     * @param filename the name of the file that is going to be played
     */
    public void playSound(String filename){

        String strFilename = filename;

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
            
            if(!isPlay){
            		System.out.println("Stopped");
            		break;
            }
        }

        sourceLine.drain();
        sourceLine.close();
        
    }
    
    public static void main(String[] argv){
    		WAVPlayer t = new WAVPlayer();
    		t.start();
    		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		t.stopSound();
    		//ms.stopSound();
    }
    
	@Override
	public void run() {
		URL filePath = MP3Player.class.getResource("data/timetolove.wav");
		//System.out.println(filePath.getFile());
		String filename = filePath.getFile();
		playSound(filename);
	}
}