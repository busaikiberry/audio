package jp.ishida.audio;

import jp.ishida.audio.play.Player;
import jp.ishida.audio.record.Recorder;

public class RecorderExecutor {
	public static void main(String[] args) {
		Recorder m_CRec = new Recorder();
		m_CRec.start();
		Player player = new Player();
		player.start();
		
		int count = 0;
		
		while(true){
//			System.out.println(m_CRec.getVoice());
			player.setVoice(m_CRec.getVoice());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			if(count > (10*10)){
				m_CRec.end();
			}
			
			if(!m_CRec.g_bRecorder){
				break;
			}
		}
		System.exit(0);
	}
}
