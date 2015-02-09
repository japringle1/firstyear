package uk.ac.sheffield.com1003.objectville.composition;

public class Castle {

	private String name;
	private boolean doorLocked, flagRaised;
	private Knight guard;

	public Castle(String name, boolean doorLocked, boolean flagRaised,
			Knight guard) {
		this.name = name;
		this.doorLocked = doorLocked;
		this.flagRaised = flagRaised;
		this.guard = guard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDoorLocked() {
		return doorLocked;
	}

	public void setDoorLocked(boolean doorLocked) {
		this.doorLocked = doorLocked;
	}

	public boolean isFlagRaised() {
		return flagRaised;
	}

	public void setFlagRaised(boolean flagRaised) {
		this.flagRaised = flagRaised;
	}

	public Knight getGuard() {
		return guard;
	}

	public void setGuard(Knight guard) {
		this.guard = guard;
	}
}
