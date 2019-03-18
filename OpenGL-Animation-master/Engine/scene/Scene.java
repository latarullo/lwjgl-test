package scene;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import animatedModel.AnimatedModel;
import animation.Quaternion;
import main.AnimationApp;
import openglObjects.Vao;
import skybox.CubeGenerator;

/**
 * Represents all the stuff in the scene (just the camera, light, and model
 * really).
 * 
 * @author Karl
 *
 */
public class Scene {
	public static boolean show = true;

	private final ICamera camera;

	private final AnimatedModel[] animatedModels;

	private Vector3f lightDirection = new Vector3f(0, -1, 0);

	public Scene(AnimatedModel[] model, ICamera cam) {
		this.animatedModels = model;
		this.camera = cam;
	}

	/**
	 * @return The scene's camera.
	 */
	public ICamera getCamera() {
		return camera;
	}

	public AnimatedModel getAnimatedModel() {
		return animatedModels[0];
	}

	public AnimatedModel[] getAnimatedModels() {
		return animatedModels;
	}

	/**
	 * @return The direction of the light as a vector.
	 */
	public Vector3f getLightDirection() {
		return lightDirection;
	}

	public void setLightDirection(Vector3f lightDir) {
		this.lightDirection.set(lightDir);
	}

	public void getKeyboardInputs() {
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
				animatedModel.setIsMoving(!animatedModel.isMoving());
				}
			}
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			entities.get(0).setSelected(!entities.get(0).isSelected());
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_2)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			entities.get(1).setSelected(!entities.get(1).isSelected());
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.moveMe(new Vector3f(0.1f, 0f, 0f));
				}
			}
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.moveMe(new Vector3f(-0.1f, 0f, 0f));
				}
			}
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.moveMe(new Vector3f(0f, 0f, 0.1f));
				}
			}
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.moveMe(new Vector3f(0f, 0f, -0.1f));
				}
			}
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.setRotation(animatedModel.getRotation()-0.1f);
				}
			}
		}

		
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.setRotation(animatedModel.getRotation()+0.1f);
				}
			}
		}
		
		
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.moveMe(new Vector3f(0f, 0.1f, 0f));
				}
			}
		}

		
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			List<AnimatedModel> entities = AnimationApp.getEntities();
			for (AnimatedModel animatedModel : entities) {
				if (animatedModel.isSelected()) {
					animatedModel.moveMe(new Vector3f(0f, -0.1f, 0f));
				}
			}
		}

		// System.out.println("X: " + Mouse.getX() + " Y: " + Mouse.getY() + " is
		// drawing: " + this.startDrawing);

//		while (Mouse.next()){
//		    if (Mouse.getEventButtonState()) {
//		    	if (Mouse.getEventButton() == 0) {
//		            System.out.println("Left button pressed");
//		            this.show = true;
//		        }
//		    	if (Mouse.getEventButton() == 1) {
//		            System.out.println("Right button pressed");
//		        }
//		    }else {
//		    	if (Mouse.getEventButton() == 0) {
//		            System.out.println("Left button released");
//		            this.show = false;
//		        }
//		    	if (Mouse.getEventButton() == 1) {
//		            System.out.println("Right button released");
//		        }
//		    }
//		}
	}

	public void updateModels() {
		for (AnimatedModel animatedModel : animatedModels) {
			animatedModel.update();
		}
	}
}