#include "findRound.hpp"

int main()
{
 Mat src_img = imread("findRound_template/4.png");
 preprocessing(src_img);
 findContour(erodeImg);
 
	waitKey(0);
	return 0;
}

// 预处理
void preprocessing(Mat src_img)
{
 Mat mask(src_img.size(), CV_8U, Scalar(0)); //遮罩图层

 // HSV即色相、饱和度、明度 饱和度
 //（S）是指色彩的纯度，越高色彩越纯，低则逐渐变灰 
 //（V）亮度 越高越白 越低越暗
 Scalar scalbL = Scalar(0,0,46);
 Scalar scalbH = Scalar(180,35,190);  // 灰色
	// namedWindow("HSV_gray", WINDOW_AUTOSIZE);
 
 // pyrMeanShiftFiltering(src_img,shiftFilterImg,21,25);
 cvtColor(src_img, grayImg, COLOR_BGR2HSV);
 inRange(grayImg,scalbL,scalbH,mask);
 // imshow("HSV_gray",mask);

 // threshold(mask, binaryImg,85, 255, THRESH_OTSU);
 // namedWindow("thre", WINDOW_AUTOSIZE);
 // imshow("thre",binaryImg);

 // 开闭运算
 Mat kernel = getStructuringElement(MORPH_RECT, Size(9, 9), Point(-1, -1));
	morphologyEx(mask, open_or_close, MORPH_CLOSE, kernel);

 Mat element = getStructuringElement(MORPH_RECT, Size(15, 15), Point(-1, -1));
 dilate(open_or_close, erodeImg, element, Point(-1, -1), 1, 0);
	
 // Canny(mask,cannyImg,30,255);
 imshow("close",erodeImg);

}

void findContour(Mat src_img)
{
 //定义变量
	vector<vector<Point>> contours;
	vector<Vec4i> hierarchy;
	findContours(src_img, contours, hierarchy, RETR_CCOMP, CHAIN_APPROX_SIMPLE);

 //根据面积大小筛选轮廓
	vector<vector<Point>>::iterator iter = contours.begin();
	for (; iter != contours.end();)
	{
		double dconArea = contourArea(*iter);
		if (dconArea < 30000)
		{
			iter = contours.erase(iter); // 清除
		}
		else
		{
			++iter;
		}
	}

 //绘出轮廓
	Mat drawing = Mat::zeros(erodeImg.size(), CV_8UC3);
	for (int i = 0; i < contours.size(); i++)
	{
  Rect rect = boundingRect(contours.at(i));
		Scalar color = Scalar(34, 255, 255);
		// drawContours(drawing, contours, i, color, 2, 8, hierarchy, 0, Point());
  rectangle(erodeImg, rect, Scalar(125, 125, 125),3,8);
	}

 //显示效果图
	imshow("【效果图】", erodeImg);
}