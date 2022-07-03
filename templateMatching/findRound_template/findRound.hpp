#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"
#include <iostream>
using namespace cv;
using namespace std;

/**
 * @brief 图像预处理
 * 
 * @param src_img 输入图像
 */
void preprocessing(Mat src_img);

/**
 * @brief 寻找轮廓
 * 
 * @param src_img 输入图像
 */
void findContour(Mat src_img);

 Mat shiftFilterImg;  // 均值漂移pyrMeanShiftFiltering彩色图像分割
 Mat grayImg , binaryImg;
 Mat cannyImg;
 Mat open_or_close;
 Mat erodeImg;