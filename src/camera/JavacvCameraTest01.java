package camera;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class JavacvCameraTest01 {
private boolean flag = true;

public String face() throws Exception {
	String savedImageFile = "D:\\images\\cameraGrabber.jpg";
	OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
	grabber.start();
	CanvasFrame canvasFrame = new CanvasFrame("Camera");
	OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
	
	canvasFrame.getCanvas().addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
	flag = false;
	}
	});
	
	IplImage image = null;
	
	while (flag) {
	Thread.sleep(100);
	Frame frame = grabber.grab();
	canvasFrame.showImage(frame);
	image = converter.convert(grabber.grab());
	}
	
	BufferedImage bufferedImage = new BufferedImage(image.width(),
	image.height(), BufferedImage.TYPE_3BYTE_BGR);
	WritableRaster raster = bufferedImage.getRaster();
	DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
	byte[] data = dataBuffer.getData();
	((ByteBuffer) image.createBuffer()).get(data);
	ImageIO.write(bufferedImage, "jpg", new File(savedImageFile));
	grabber.stop();
	canvasFrame.dispose();
	return savedImageFile;
}


public static void main(String[] args) throws Exception {
	JavacvCameraTest01 face = new JavacvCameraTest01();
	face.face();
	}
}