package test.design.pattern.structural;
/*
 * We use the adapter in real life a lot. 
 * For example, we use a memory card adapter to connect a memory card 
 * and a computer since the computer only support one type of memory card 
 * and our card is not compatible with the computer.
   Adapter is a converter between two incompatible entities
 */
interface Player {
	public void play(String type, String fileName);
}

interface AudioPlayer {  
	public void playAudio(String fileName);
}

interface VideoPlayer {  
	public void playVideo(String fileName);
}

class MyAudioPlayer implements AudioPlayer {
	@Override
	public void playAudio(String fileName) {
		System.out.println("Playing. Name: "+ fileName);    
	}
}

class MyVideoPlayer implements VideoPlayer {
	@Override
	public void playVideo(String fileName) {
		System.out.println("Playing. Name: "+ fileName);    
	}
}

class MyPlayer implements Player {

	AudioPlayer audioPlayer = new MyAudioPlayer();
	VideoPlayer videoPlayer = new MyVideoPlayer();

	public MyPlayer(){      
	}
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("avi")){
			videoPlayer.playVideo(fileName);
		}else if(audioType.equalsIgnoreCase("mp3")){
			audioPlayer.playAudio(fileName);
		}
	}
}

public class AdaptorTest {
	public static void main(String[] args) {
		MyPlayer myPlayer = new MyPlayer();

		myPlayer.play("mp3", "h.mp3");
		myPlayer.play("avi", "me.avi");
	}
}
