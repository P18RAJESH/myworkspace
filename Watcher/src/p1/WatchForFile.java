package p1;

import java.io.File;
//import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.LinkOption;
import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class WatchForFile {

    public void WatchMyFolder(String path )
    {
    	File dir = new File(path);
    	Path myDir= dir.toPath();
    	Boolean isFolder = Files.notExists(myDir,NOFOLLOW_LINKS);
    	  
		  if (isFolder)
		  {
			  System.out.println("Folder does not exist");
		      throw new IllegalArgumentException("Path: " + myDir + " is not a folder");
		  }
		 
          System.out.println("Watching path: " + myDir);

        try {
           WatchService watcher = myDir.getFileSystem().newWatchService();
           myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

           WatchKey watckKey = watcher.take();

           List<WatchEvent<?>> events = watckKey.pollEvents();
          
           for (WatchEvent event : events) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("Created: " + event.context().toString());
                }
                if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println("Delete: " + event.context().toString());
                }
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("Modify: " + event.context().toString());
                }
            }
           
        }
        catch (Exception e) 
        {
            System.out.println("Error: " + e.toString());
        }
    }
}