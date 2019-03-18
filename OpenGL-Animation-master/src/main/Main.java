package main;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {

	private static boolean somethingIsSelected = false;

	public static void main(String args[]) {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Hello World");
			Display.create();

		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Initializare OPENGL

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		Box box = new Box(100, 100);

		while (!Display.isCloseRequested()) {
			// Render
			glClear(GL_COLOR_BUFFER_BIT);

			if (Mouse.isButtonDown(0) && box.inBounds(Mouse.getX(), Display.getHeight() - Mouse.getY() - 1)
					&& !somethingIsSelected) {
				System.out.println("Box clicked");
				somethingIsSelected = true;
				box.selected = true;

			}

			if (Mouse.isButtonDown(1)) {
				box.selected = false;
				somethingIsSelected = false;
				System.out.println("Box released");
			}

			if (box.selected) {
				box.update(Mouse.getDX(), -Mouse.getDY());
			}

			box.drawQuad();

			Display.update();
//          Display.sync(60);
		}

		Display.destroy();
	}

	private static class Box {

		public int x, y;
		public boolean selected = false;

		Box(int x, int y) {

			this.x = x;
			this.y = y;
		}

		void drawQuad() {
//			glBegin(GL_QUADS);
//			glVertex2i(x, y);
//			glVertex2i(x + 50, y);
//			glVertex2i(x + 50, y + 50);
//			glVertex2i(x, y + 50);
//			glEnd();
			
		    glBegin(3);

		    glVertex2i(300,210);
		    glVertex2i(340,215);
		    glVertex2i(320,250);

		    glEnd();
		}

		void update(int dx, int dy) {
			x = x + dx;
			y = y + dy;
		}

		boolean inBounds(int mouseX, int mouseY) {
			return mouseX > x && mouseX < x + 50 && mouseY > y && mouseY < y + 50;
		}

	}

}