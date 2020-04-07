import java.awt.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException, AWTException {

        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath = URLDecoder.decode(path, "UTF-8");
        decodedPath = decodedPath.substring(1,decodedPath.length()-17); //17!!!!!
        Screenshot temp = new Screenshot();
        Clicker click = new Clicker();
        ImageHandler handler = new ImageHandler();
        SimpleGUI app = new SimpleGUI();
        //app.setVisible(true);
        app.infoBox("Please open Dota2 window", "TNX Corp");
        LogWindow log = new LogWindow("Logger",300,150);


        Timer t = new Timer();
        String finalDecodedPath = decodedPath;
        log.showInfo(decodedPath+String.format("%n"));
        t.schedule(new TimerTask()
        {
            @Override
            public void run() {
                try {
                    temp.Take("A.jpg", finalDecodedPath);
                    log.showInfo("Still working..."+String.format("%n"));
                } catch (IOException e) {
                    e.printStackTrace();
                    log.showInfo("Error!Current dir is "+ finalDecodedPath+String.format("%n"));
                }
                try {
                    handler.crop(finalDecodedPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(handler.getColor(finalDecodedPath))
                    {
                        click.moveMouse();
                        t.cancel();
                        t.purge();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }

            }, 0, 5000);
            }
}
