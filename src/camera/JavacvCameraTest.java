package camera;

import javax.swing.JFrame;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.CanvasFrame;  
import org.bytedeco.javacv.OpenCVFrameConverter;  
import org.bytedeco.javacv.FrameGrabber.Exception;  
import org.bytedeco.javacv.OpenCVFrameGrabber; 

public class JavacvCameraTest
{
    static OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();

    public static void main(String[] args) throws Exception, InterruptedException
    {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //��ʼ��ȡ����ͷ����
        CanvasFrame canvas = new CanvasFrame("����ͷ");//�½�һ������
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);
        int ex = 0;
        while(true)
        {
            if(!canvas.isDisplayable())
            {//�����Ƿ�ر�
                grabber.stop();//ֹͣץȡ
                System.exit(2);//�˳�
                break;
            }       
            canvas.showImage(grabber.grab());//��ȡ����ͷͼ�񲢷ŵ���������ʾ�� �����Frame frame=grabber.grab(); frame��һ֡��Ƶͼ��
            opencv_core.Mat mat = converter.convertToMat(grabber.grabFrame());
            ex++;
            opencv_imgcodecs.imwrite("d:\\img\\" + ex + ".png", mat);
            Thread.sleep(200);//50����ˢ��һ��ͼ��
        }
    }
}