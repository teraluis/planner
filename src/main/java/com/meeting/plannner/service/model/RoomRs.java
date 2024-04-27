package com.meeting.plannner.service.model;

import lombok.Builder;
import lombok.Data;

/**
 * Simple meetings (RS) between colleagues on site only require a room larger than 3
 */
@Data
@Builder
public class RoomRs extends Room {
	
	private boolean screen;
	private boolean camera;
	private boolean speaker;
	private boolean whiteBoard;

	public RoomRs(String name, int maxCapacity, boolean pandemie) {			
		super(name, maxCapacity, pandemie, RoomType.RS);
		screen = false;
		camera = false;
		speaker = false;
		whiteBoard = false;
	}

	public boolean isScreen() {
		return screen;
	}

	public void setScreen(boolean screen) {
		this.screen = screen;
	}

	public boolean isCamera() {
		return camera;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public boolean isSpeaker() {
		return speaker;
	}

	public void setSpeaker(boolean speaker) {
		this.speaker = speaker;
	}

	public boolean isWhiteBoard() {
		return whiteBoard;
	}

	public void setWhiteBoard(boolean whiteBoard) {
		this.whiteBoard = whiteBoard;
	}

	
}
