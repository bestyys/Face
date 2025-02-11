/** 
 * 文件名：javavcCameraTest.java 
 * 描述：调用windows平台的摄像头窗口视频 
 * 修改时间：2016年6月13日 
 * 修改内容： 
 * 	1.改变代码达到能够存储图片到本地的目的
 *  2.注册的人脸图像文件
 *  3.对比功能通过哪个SDK来实现
 *  4.关于windows上面软件的权限的管理。
 * 
 */  
package camera;  
  
import javax.swing.JFrame;  
  
import org.bytedeco.javacv.CanvasFrame;  
import org.bytedeco.javacv.OpenCVFrameConverter;  
import org.bytedeco.javacv.FrameGrabber.Exception;  
import org.bytedeco.javacv.OpenCVFrameGrabber;  
  
/** 
 * 调用本地摄像头窗口视频 
 * @author eguid   
 * @version 2016年6月13日   
 * @see javavcCameraTest   
 * @since  javacv1.2 
 */  
  
public class JavavcCamera  {  
	
//	public static void main(String[] args) throws Exception, InterruptedException  {  
//		    OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);    
//		    grabber.start();   //开始获取摄像头数据  
//		    CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口  
//		    canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//		    canvas.setAlwaysOnTop(true);  
//		      
//		    while(true){  
//		        if(!canvas.isDisplayable())  
//		        {//窗口是否关闭  
//		            grabber.stop();//停止抓取  
//		            System.exit(2);//退出  
//		        }  
//		        canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像  
//		  
//		        Thread.sleep(50);//50毫秒刷新一次图像  
//		    }  
//		}
	
	
	
	public void GrabberImage() throws Exception {
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		grabber.start();
	}
	
	
	
	}  