package main;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;

import animatedModel.AnimatedModel;
import renderEngine.RenderEngine;
import scene.Scene;

public class AnimationApp {
	static List<AnimatedModel> entities = new ArrayList<>();
	public static Scene scene;

	/**
	 * Initialises the engine and loads the scene. For every frame it updates the
	 * camera, updates the animated entity (which updates the animation),
	 * renders the scene to the screen, and then updates the display. When the
	 * display is close the engine gets cleaned up.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RenderEngine engine = RenderEngine.init();
		 scene = SceneLoader.loadScene(GeneralSettings.RES_FOLDER);

		while (!Display.isCloseRequested()) {
			scene.getKeyboardInputs();
			scene.getCamera().move();
			//scene.getAnimatedModel().update();
			scene.updateModels();
			engine.renderScene(scene);
			engine.update();
		}

		engine.close();
	}

	public static void addEntity(AnimatedModel entity) {
		entities.add(entity);	
	}

	public static List<AnimatedModel> getEntities() {
		return entities;
	}
	
}
