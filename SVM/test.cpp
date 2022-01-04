#include <opencv2/core.hpp>
#include <opencv2/imgproc.hpp>
#include "opencv2/imgcodecs.hpp"
#include <opencv2/highgui.hpp>
#include <opencv2/ml.hpp>
#include <fstream>

using namespace cv;
using namespace cv::ml;
using namespace std;



int main()
{
  
    //载入训练好的SVM模型
    Ptr<SVM> svm = SVM::load("mnist.xml");


    //随机测试某一个图像看效果，输入为-2时退出，输入-1时则测试本地图片“2.jpg”，注意路径要放到源代码同级目录
    while (1)
    {
              int index;
        cout << "请输入要查看的测试图像下标" << endl;
        cin >> index;
        string filename =  to_string(index);
        cout << "检测图片为：" << filename+".jpg" << endl;
        Mat imgRead = imread(filename+".jpg", 0);
        resize(imgRead,imgRead,Size(28,28));
        Mat img_show = imgRead.clone();
        imgRead.convertTo(imgRead,CV_32FC1);
        imgRead=imgRead/255;
        imgRead=imgRead.reshape(1,1);
        float ret =svm->predict(imgRead);
        cout << ret << endl;
        getchar();
  
            // Mat imgReadScal = Mat::zeros(28, 28, CV_8UC1);
            // Mat show_mat = Mat::zeros(28, 28, CV_32FC1);

            // resize(imgRead, imgReadScal, imgReadScal.size());

            // imgReadScal.convertTo(show_mat, CV_32FC1);

            // show_mat = show_mat / 255;

            // Mat predict_mat = Mat::zeros(1, 28*28, CV_32FC1);
            // memcpy(predict_mat.data, show_mat.data, 28*28 * sizeof(float));
            // float response = svm->predict(predict_mat);

            // // imshow("test", show_mat);
            // cout << "标签值为" << response << endl;
    }
    return 0;
}

