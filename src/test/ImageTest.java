package test;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author hulinqi
 * @date 2020/4/21 --  19:13
 * @purpuse
 */
public class ImageTest {
    @Test
    public  void test(){
        try {
            BufferedImage img = ImageIO.read(new File("E:\\ideaWorkspace\\面试学习\\src\\images\\bulletD.gif"));
            Assert.assertNotNull(img);

            BufferedImage img2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("\\images\\bulletD.gif"));
            Assert.assertNotNull(img2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
