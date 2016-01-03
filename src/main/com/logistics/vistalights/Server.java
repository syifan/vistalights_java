package com.logistics.vistalights;

import com.logistics.pvis.application.Application;
import com.logistics.pvis.frame.DelegatedPAppletFactory;
import com.logistics.pvis.frame.JFrameFactory;
import com.logistics.pvis.frame.ProcessingFrame;
import com.logistics.pvis.frame.ProcessingFrameFactory;
import com.logistics.vistalights.application.VistaLights;

public class Server {

	public static void main(String[] args) {
		ProcessingFrameFactory frameFactory = new ProcessingFrameFactory(
				new JFrameFactory(), new DelegatedPAppletFactory());
		ProcessingFrame frame = frameFactory.produceProcessingFrame(960, 480);
		
		Application vistaLights = new VistaLights(frame);
		frame.setApplication(vistaLights);
		
		frame.show();
	}

}
