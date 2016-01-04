/**
 * Logistics server side
 */
package com.logistics.visualizer.scene.playscene;

import com.logistics.simulator.scheduler.Scheduler;
import com.logistics.visualizer.Visualizer;
import com.logistics.visualizerbasic.gui.GuiContainer;
import com.logistics.visualizerbasic.gui.GuiLayer;

/**
 * @author yifansun
 *
 */
public class TimeLabelFactory {

	private Visualizer visualizer;
	private GuiLayer gui;
	private GuiContainer container;
	/**
	 * @param container the container to set
	 */
	public void setContainer(GuiContainer container) {
		this.container = container;
	}

	private Scheduler scheduler;

	/**
	 * @param visualizer
	 * @param gui
	 * @param container
	 * @param scheduler
	 */
	public TimeLabelFactory(Visualizer visualizer, GuiLayer gui,
			GuiContainer container, Scheduler scheduler) {
		super();
		this.visualizer = visualizer;
		this.gui = gui;
		this.container = container;
		this.scheduler = scheduler;
	}

	public TimeLabel produceTimeLabel() {
		TimeLabel timeLabel = new TimeLabel(visualizer, gui, container, 
				scheduler);
		return timeLabel;
	}
}
