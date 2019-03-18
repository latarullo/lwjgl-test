package main;

import org.lwjgl.util.vector.Vector3f;

import animatedModel.AnimatedModel;
import animation.Animation;
import loaders.AnimatedModelLoader;
import loaders.AnimationLoader;
import scene.ICamera;
import scene.Scene;
import utils.MyFile;

public class SceneLoader {

	/**
	 * Sets up the scene. Loads the entity, load the animation, tells the entity
	 * to do the animation, sets the light direction, creates the camera, etc...
	 * 
	 * @param resFolder
	 *            - the folder containing all the information about the animated entity
	 *            (mesh, animation, and texture info).
	 * @return The entire scene.
	 */
	public static Scene loadScene(MyFile resFolder) {
		ICamera camera = new Camera();
		AnimatedModel entity = AnimatedModelLoader.loadEntity(new MyFile(resFolder, GeneralSettings.MODEL_FILE),
				new MyFile(resFolder, GeneralSettings.DIFFUSE_FILE));
		Animation animation = AnimationLoader.loadAnimation(new MyFile(resFolder, GeneralSettings.ANIM_FILE));
		entity.doAnimation(animation);
		
		AnimatedModel entity2 = AnimatedModelLoader.loadEntity(new MyFile(resFolder, GeneralSettings.MODEL_FILE),
				new MyFile(resFolder, GeneralSettings.DIFFUSE_FILE));

		entity2.doAnimation(animation);
		
		AnimationApp.addEntity(entity);
		AnimationApp.addEntity(entity2);
		entity.setPosition(new Vector3f(0, 0, 0));
		entity2.setPosition(new Vector3f(10, 0, 0));
		
		entity.setIsMoving(true);
		entity2.setIsMoving(true);
		
		AnimatedModel[] entities = {entity, entity2};
		//Scene scene = new Scene(entity, camera);
		Scene scene = new Scene(entities, camera);
		scene.setLightDirection(GeneralSettings.LIGHT_DIR);
		return scene;
	}

}
