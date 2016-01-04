/**
 * Logistics server side
 */
package com.logistics.visualizer;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * @author Yifan Sun
 *
 */
@SuppressWarnings("serial")
public class VisualizerWindow extends JFrame {
	
	private Visualizer visualizer;
	
	public VisualizerWindow(){
		this.getContentPane().setPreferredSize(new Dimension(960, 540));
		//this.setResizable(false);
		pack();
		visualizer = new Visualizer();
		add(visualizer);
		visualizer.init();
		setVisible(true);
		
		
		// Add the listen to exit the program when the visualizer is closed
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
	}
	
}
