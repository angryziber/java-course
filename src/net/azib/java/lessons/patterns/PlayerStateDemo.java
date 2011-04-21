package net.azib.java.lessons.patterns;

public class PlayerStateDemo {
	State currentState = new NoDiscState();
	int currentTrack = 0;

	public void play() {currentState = currentState.play();}
	public void nextTrack() {currentState = currentState.nextTrack();}
	public void prevTrack() {currentState = currentState.prevTrack();}
	public void stop() {currentState = currentState.stop();}
	public void openOrClose() {currentState = currentState.openOrClose();}

	abstract class State {
		public State play() {return this;}
		public State nextTrack() {return this;}
		public State prevTrack() {return this;}
		public State stop() {return this;}
		public State openOrClose() {return this;}
	}

	class NoDiscState extends State {
		@Override
		public State openOrClose() {
			// check if disc is loaded
			return new StoppedState();
		}
	}

	class StoppedState extends State {
		@Override
		public State play() {
			return new PlayingState();
		}

		@Override
		public State openOrClose() {
			return new NoDiscState();
		}
	}

	class PlayingState extends State {
		@Override
		public State openOrClose() {
			return new NoDiscState();
		}

		@Override
		public State stop() {
			return new StoppedState();
		}

		@Override
		public State play() {
			return null; //return new PausedState();
		}

		@Override
		public State nextTrack() {
			// skip to next track
			currentTrack ++;
			return this;
		}

		@Override
		public State prevTrack() {
			// skip to prev track
			currentTrack --;
			return this;
		}
	}

	public static void main(String[] args) {
		PlayerStateDemo player = new PlayerStateDemo();
		System.out.println(player.currentState);

		player.openOrClose();
		System.out.println(player.currentState);

		player.play();
		System.out.println(player.currentState);

		player.nextTrack();
		System.out.println(player.currentState);

		player.stop();
		System.out.println(player.currentState);
	}
}
