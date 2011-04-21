package net.azib.java.lessons.patterns;

public class DecoratorDemo {
	static interface Map {
		public String getRow(int i);
		public void draw();
	}


	static class OriginalMap implements Map {
		protected String[] data;

		OriginalMap() {
			data = new String[] {
			".....S....",
			"....AAA...",
			".F...G...."
			};
			System.out.println("Map is loaded!");
		}

		public String getRow(int i) {
			return data[i];
		}

		public void draw() {
			for (String row : data) {
				System.out.println(row);
			}
		}
	}

	static class LazyMap implements Map { // Virtual Proxy pattern
		private Map original = null;

		private Map getOriginal() {
			if (original == null)
				original = new OriginalMap();
			return original;
		}

		@Override
		public void draw() {
			getOriginal().draw();
		}

		@Override
		public String getRow(int i) {
			return getOriginal().getRow(i);
		}
	}

	static class MapViewport implements Map { // Decorator pattern
		private Map original;
		private int x;
		private int y;
		private int size;

		MapViewport(Map original, int x, int y, int size) {
			this.original = original;
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public String getRow(int i) {
			return original.getRow(i).substring(x, x + size);
		}

		public void draw() {
			drawHBorder();
			for (int i = y; i < y + size; i++) {
				System.out.println("|" + getRow(i) + "|");
			}
			drawHBorder();
		}

		private void drawHBorder() {
			System.out.print("+");
			for (int i = 0; i < size; i++) System.out.print("-");
			System.out.println("+");
		}
	}

	public static void main(String[] args) {
		Map map = new LazyMap();
		System.out.println("LazyMap created");

		map = new MapViewport(map, 4, 0, 3);
		System.out.println("LazyMap wrapped into viewport");

		map.draw();
	}
}
