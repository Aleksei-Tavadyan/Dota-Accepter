import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import javax.swing.filechooser.FileSystemView;

public class Screenshot {
    Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize();
    private int vert = sSize.height;
    private int hor = sSize.width;
    public boolean resolutionCheck = false;
    int resolution = 0; // 0 - 1920x1080, 1 - 1536

    public void Take (String name, String ScreenPath) throws IOException {
        File target = new File(ScreenPath);
        System.out.println(ScreenPath);
        System.out.println(target);
        ImageIO.write(grabScreen(), "jpeg", new File(ScreenPath, name));

        if (vert != 1080) {
            resolutionCheck = true;
        }


    }

    public boolean getResolutionCheck() {
        return this.resolutionCheck;
    }





    private static BufferedImage grabScreen() {
        try {
            return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (SecurityException e) {
        } catch (AWTException e) {
        }
        return null;
   }

}
