package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.lwjgl.util.vector.Vector3f;

import utils.MyFile;

/**
 * Just some configs. File locations mostly.
 * 
 * @author Karl
 *
 */
public class GeneralSettings {
	
	
	public static BufferedReader MODEL_DAE;
	public static BufferedReader MODEL_DAE2;
	
	public static final MyFile RES_FOLDER = new MyFile("res");
	//C:\Users\f537268\Downloads\OpenGL-Animation-master\Resources\res
	public static final String MODEL_FILE = "model.dae";
	public static final String ANIM_FILE = "model.dae";
	public static final String DIFFUSE_FILE = "diffuse.png";
	
	public static final int MAX_WEIGHTS = 3;
	
	public static final Vector3f LIGHT_DIR = new Vector3f(0.2f, -0.3f, -0.8f);
	
}
