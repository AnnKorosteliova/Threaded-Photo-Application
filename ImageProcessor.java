package utils.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.twelvemonkeys.image.ResampleOp;

public class ImageProcessor {

	public void resizeImage(File originalImageFle, File resampledImageFile) throws IOException {
		//javax standart loading
		BufferedImage originalImage = ImageIO.read(originalImageFle);
						
		//using library: twelvemonkeys - resize
		BufferedImage resampledImage = new ResampleOp(200,200).filter(originalImage, null);
						
		//javax standart saving
		ImageIO.write(resampledImage, "jpeg", resampledImageFile);
	}
	
}
