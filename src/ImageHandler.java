import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class ImageHandler extends Screenshot{
    public void crop(String path) throws IOException {


        BufferedImage image = ImageIO.read(new File(path,"A.jpg"));
        if (getResolutionCheck()) {
            BufferedImage out = image.getSubimage(850, 500, 200, 50);
        }
        else {
            BufferedImage out = image.getSubimage(850, 500, 200, 50); 
        }
        File dir = new File(path,"test1.jpg");
        dir.setWritable(true);
        ImageIO.write(out, "jpg", dir);


    }
    public boolean getColor(String path) throws IOException {
        BufferedImage resultImg = ImageIO.read(new File(path,"test1.jpg"));
        Raster raster = resultImg.getRaster();
        ColorModel model = resultImg.getColorModel();
        int x = 5;
        int y = 5;
        Object data = raster.getDataElements(x, y, null);
        int argb = model.getRGB(data);
        Color color = new Color(argb, true);
        System.out.println(color);

       /* String red = color.toString().substring(17,19);
        System.out.println(red);

        String green = color.toString().substring(22,24);
        System.out.println(green);

        String blue = color.toString().substring(27,29);
        System.out.println(blue);*/

        String resultStr = color.toString();
        System.out.println("CHECK IT!  = "+resultStr);

        if (resultStr.equals("java.awt.Color[r=53,g=83,b=71]")) {
            System.out.println("It works!");
            return true;
        }
        else {
            System.out.println("Keep working...");
            return false;
        }
        }
    }


