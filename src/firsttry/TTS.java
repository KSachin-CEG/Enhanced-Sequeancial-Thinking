package firsttry;

import javax.sound.midi.Synthesizer;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;




public class TTS {
	Voice voice;
	TTS()
	{
		voice = VoiceManager.getInstance().getVoice("kevin");
		if (voice != null) {
            voice.allocate();//Allocating Voice
        }
       
	}
	void sound(String str)
	{
		try {
            voice.setRate(120);//Setting the rate of the voice
            voice.setPitch(80);//Setting the Pitch of the voice
            voice.setVolume(4);//Setting the volume of the voice
            voice.speak(str);//Calling speak() method
  			
			
        }
        catch(Exception e)
        {
       e.printStackTrace();
        }
	}
	

}
