/** 
 * �ļ�����javavcCameraTest.java 
 * ����������windowsƽ̨������ͷ������Ƶ 
 * �޸�ʱ�䣺2016��6��13�� 
 * �޸����ݣ� 
 * 	1.�ı����ﵽ�ܹ��洢ͼƬ�����ص�Ŀ��
 *  2.ע�������ͼ���ļ�
 *  3.�Աȹ���ͨ���ĸ�SDK��ʵ��
 *  4.����windows���������Ȩ�޵Ĺ���
 * 
 */  
package camera;  
  
import javax.swing.JFrame;  
  
import org.bytedeco.javacv.CanvasFrame;  
import org.bytedeco.javacv.OpenCVFrameConverter;  
import org.bytedeco.javacv.FrameGrabber.Exception;  
import org.bytedeco.javacv.OpenCVFrameGrabber;  
  
/** 
 * ���ñ�������ͷ������Ƶ 
 * @author eguid   
 * @version 2016��6��13��   
 * @see javavcCameraTest   
 * @since  javacv1.2 
 */  
  
public class JavavcCamera  {  
	
//	public static void main(String[] args) throws Exception, InterruptedException  {  
//		    OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);    
//		    grabber.start();   //��ʼ��ȡ����ͷ����  
//		    CanvasFrame canvas = new CanvasFrame("����ͷ");//�½�һ������  
//		    canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//		    canvas.setAlwaysOnTop(true);  
//		      
//		    while(true){  
//		        if(!canvas.isDisplayable())  
//		        {//�����Ƿ�ر�  
//		            grabber.stop();//ֹͣץȡ  
//		            System.exit(2);//�˳�  
//		        }  
//		        canvas.showImage(grabber.grab());//��ȡ����ͷͼ�񲢷ŵ���������ʾ�� �����Frame frame=grabber.grab(); frame��һ֡��Ƶͼ��  
//		  
//		        Thread.sleep(50);//50����ˢ��һ��ͼ��  
//		    }  
//		}
	
	
	
	public void GrabberImage() throws Exception {
		OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
		grabber.start();
	}
	
	
	
	}  