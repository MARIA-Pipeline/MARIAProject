/**
* @author Guillaume Lobet | Universite de Liege
* @date: 2013-02-15
* 
* Plugin containing usefull function for the analysis of Arabidopsis rosette size
* 
**/

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.prefs.Preferences;

import ij.ImageJ;
import ij.plugin.frame.PlugInFrame;


public class MARIA_ extends PlugInFrame{
	
	static MARIA_ instance, fop;
	public static Preferences prefs;


	private static final long serialVersionUID = -2516812747038073446L;

	public MARIA_() {
		super("Friend of phenotyping");
		
		new MARIAInterface();
	}
	
	public static void main(String args[]) {
		if(args.length > 0){
			new RootAnalysis(new File(args[0]), 
					args[1], Float.valueOf(args[2]), 2.54f, 
					true, 50, false, false, false, false
					);		
		}
		else{
			prefs = Preferences.userRoot().node("/ImageJ/plugins");
			ImageJ ij = new ImageJ();
			fop = new MARIA_();
			ij.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					fop.dispose();
					System.exit(0);
				}
			});
		}
	}
}
