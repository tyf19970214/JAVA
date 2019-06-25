package com.xuexin.utils;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * @Title: 视觉二维码工具类.java
 * @Package com.xuexin.visualqrcode
 * @Description: TODO(生成二维码)
 * @author 原作者:黄本豪(图片只可读取本地) 现作者:滕一帆(图片可读取远程)
 * @date 2019年06月23日 下午4:14:04
 * @version V2.0
 */

public class VisualQRCode {

	private static int version(char level, int dataBitlength) {
		// http://www.qrcode.com/en/about/version.html
		switch (level) {
		case 'L': {
			if (dataBitlength <= 144 - 9) {
				return 1;
			} else if (dataBitlength <= 272 - 9) {
				return 2;
			} else if (dataBitlength <= 440 - 9) {
				return 3;
			} else if (dataBitlength <= 640 - 9) {
				return 4;
			} else if (dataBitlength <= 864 - 9) {
				return 5;
			} else if (dataBitlength <= 1088 - 9) {
				return 6;
			} else if (dataBitlength <= 1248 - 9) {
				return 7;
			} else if (dataBitlength <= 1552 - 9) {
				return 8;
			} else if (dataBitlength <= 1856 - 9) {
				return 9;
			} else if (dataBitlength <= 2192 - 17) {
				return 10;
			} else if (dataBitlength <= 2592 - 17) {
				return 11;
			} else if (dataBitlength <= 2960 - 17) {
				return 12;
			} else if (dataBitlength <= 3424 - 17) {
				return 13;
			} else if (dataBitlength <= 3688 - 17) {
				return 14;
			} else if (dataBitlength <= 4184 - 17) {
				return 15;
			} else if (dataBitlength <= 4712 - 17) {
				return 16;
			} else if (dataBitlength <= 5176 - 17) {
				return 17;
			} else if (dataBitlength <= 5768 - 17) {
				return 18;
			} else if (dataBitlength <= 6360 - 17) {
				return 19;
			} else if (dataBitlength <= 6888 - 17) {
				return 20;
			}
			// else if (dataBitlength <= 7456 - 25) {
			// return 21;
			// } else if (dataBitlength <= 8048 - 25) {
			// return 22;
			// } else if (dataBitlength <= 8752 - 25) {
			// return 23;
			// } else if (dataBitlength <= 9392 - 25) {
			// return 24;
			// } else if (dataBitlength <= 10208 - 25) {
			// return 25;
			// } else if (dataBitlength <= 10960 - 25) {
			// return 26;
			// } else if (dataBitlength <= 11744 - 25) {
			// return 27;
			// } else if (dataBitlength <= 12248 - 25) {
			// return 28;
			// } else if (dataBitlength <= 13048 - 25) {
			// return 29;
			// } else if (dataBitlength <= 13880 - 25) {
			// return 30;
			// } else if (dataBitlength <= 14744 - 33) {
			// return 31;
			// } else if (dataBitlength <= 15640 - 33) {
			// return 32;
			// } else if (dataBitlength <= 16568 - 33) {
			// return 33;
			// } else if (dataBitlength <= 17528 - 33) {
			// return 34;
			// } else if (dataBitlength <= 18448 - 33) {
			// return 35;
			// } else if (dataBitlength <= 19472 - 33) {
			// return 36;
			// } else if (dataBitlength <= 20528 - 33) {
			// return 37;
			// } else if (dataBitlength <= 21616 - 33) {
			// return 38;
			// } else if (dataBitlength <= 22496 - 33) {
			// return 39;
			// } else if (dataBitlength <= 23648 - 33) {
			// return 40;
			// }
			else {
				return 0;
			}
		}
		case 'M': {
			if (dataBitlength <= 128 - 9) {
				return 1;
			} else if (dataBitlength <= 224 - 9) {
				return 2;
			} else if (dataBitlength <= 352 - 9) {
				return 3;
			} else if (dataBitlength <= 512 - 9) {
				return 4;
			} else if (dataBitlength <= 688 - 9) {
				return 5;
			} else if (dataBitlength <= 864 - 9) {
				return 6;
			} else if (dataBitlength <= 992 - 9) {
				return 7;
			} else if (dataBitlength <= 1232 - 9) {
				return 8;
			} else if (dataBitlength <= 1456 - 9) {
				return 9;
			} else if (dataBitlength <= 1728 - 17) {
				return 10;
			} else if (dataBitlength <= 2032 - 17) {
				return 11;
			} else if (dataBitlength <= 2320 - 17) {
				return 12;
			} else if (dataBitlength <= 2672 - 17) {
				return 13;
			} else if (dataBitlength <= 2920 - 17) {
				return 14;
			} else if (dataBitlength <= 3320 - 17) {
				return 15;
			} else if (dataBitlength <= 3624 - 17) {
				return 16;
			} else if (dataBitlength <= 4056 - 17) {
				return 17;
			} else if (dataBitlength <= 4504 - 17) {
				return 18;
			} else if (dataBitlength <= 5016 - 17) {
				return 19;
			} else if (dataBitlength <= 5352 - 17) {
				return 20;
			}
			// else if (dataBitlength <= 5712 - 25) {
			// return 21;
			// } else if (dataBitlength <= 6256 - 25) {
			// return 22;
			// } else if (dataBitlength <= 6880 - 25) {
			// return 23;
			// } else if (dataBitlength <= 7312 - 25) {
			// return 24;
			// } else if (dataBitlength <= 8000 - 25) {
			// return 25;
			// } else if (dataBitlength <= 8496 - 25) {
			// return 26;
			// } else if (dataBitlength <= 9024 - 25) {
			// return 27;
			// } else if (dataBitlength <= 9544 - 25) {
			// return 28;
			// } else if (dataBitlength <= 10136 - 25) {
			// return 29;
			// } else if (dataBitlength <= 10984 - 25) {
			// return 30;
			// } else if (dataBitlength <= 11640 - 33) {
			// return 31;
			// } else if (dataBitlength <= 13048 - 33) {
			// return 32;
			// } else if (dataBitlength <= 13048 - 33) {
			// return 33;
			// } else if (dataBitlength <= 13800 - 33) {
			// return 34;
			// } else if (dataBitlength <= 14496 - 33) {
			// return 35;
			// } else if (dataBitlength <= 15312 - 33) {
			// return 36;
			// } else if (dataBitlength <= 15936 - 33) {
			// return 37;
			// } else if (dataBitlength <= 16816 - 33) {
			// return 38;
			// } else if (dataBitlength <= 17728 - 33) {
			// return 39;
			// } else if (dataBitlength <= 18672 - 33) {
			// return 40;
			// }
			else {
				return 0;
			}
		}
		case 'Q': {
			if (dataBitlength <= 104 - 9) {
				return 1;
			} else if (dataBitlength <= 176 - 9) {
				return 2;
			} else if (dataBitlength <= 272 - 9) {
				return 3;
			} else if (dataBitlength <= 384 - 9) {
				return 4;
			} else if (dataBitlength <= 496 - 9) {
				return 5;
			} else if (dataBitlength <= 608 - 9) {
				return 6;
			} else if (dataBitlength <= 704 - 9) {
				return 7;
			} else if (dataBitlength <= 880 - 9) {
				return 8;
			} else if (dataBitlength <= 1056 - 9) {
				return 9;
			} else if (dataBitlength <= 1232 - 17) {
				return 10;
			} else if (dataBitlength <= 1440 - 17) {
				return 11;
			} else if (dataBitlength <= 1648 - 17) {
				return 12;
			} else if (dataBitlength <= 1952 - 17) {
				return 13;
			} else if (dataBitlength <= 2088 - 17) {
				return 14;
			} else if (dataBitlength <= 2360 - 17) {
				return 15;
			} else if (dataBitlength <= 2600 - 17) {
				return 16;
			} else if (dataBitlength <= 2936 - 17) {
				return 17;
			} else if (dataBitlength <= 3176 - 17) {
				return 18;
			} else if (dataBitlength <= 3560 - 17) {
				return 19;
			} else if (dataBitlength <= 3880 - 17) {
				return 20;
			}
			// else if (dataBitlength <= 4096 - 25) {
			// return 21;
			// } else if (dataBitlength <= 4544 - 25) {
			// return 22;
			// } else if (dataBitlength <= 4912 - 25) {
			// return 23;
			// } else if (dataBitlength <= 5312 - 25) {
			// return 24;
			// } else if (dataBitlength <= 5744 - 25) {
			// return 25;
			// } else if (dataBitlength <= 6032 - 25) {
			// return 26;
			// } else if (dataBitlength <= 6464 - 25) {
			// return 27;
			// } else if (dataBitlength <= 6968 - 25) {
			// return 28;
			// } else if (dataBitlength <= 7288 - 25) {
			// return 29;
			// } else if (dataBitlength <= 7880 - 25) {
			// return 30;
			// } else if (dataBitlength <= 8264 - 33) {
			// return 31;
			// } else if (dataBitlength <= 8920 - 33) {
			// return 32;
			// } else if (dataBitlength <= 9368 - 33) {
			// return 33;
			// } else if (dataBitlength <= 9848 - 33) {
			// return 34;
			// } else if (dataBitlength <= 10288 - 33) {
			// return 35;
			// } else if (dataBitlength <= 10832 - 33) {
			// return 36;
			// } else if (dataBitlength <= 11408 - 33) {
			// return 37;
			// } else if (dataBitlength <= 12016 - 33) {
			// return 38;
			// } else if (dataBitlength <= 12656 - 33) {
			// return 39;
			// } else if (dataBitlength <= 13328 - 33) {
			// return 40;
			// }
			else {
				return 0;
			}
		}
		case 'H': {
			if (dataBitlength <= 72 - 9) {
				return 1;
			} else if (dataBitlength <= 128 - 9) {
				return 2;
			} else if (dataBitlength <= 208 - 9) {
				return 3;
			} else if (dataBitlength <= 288 - 9) {
				return 4;
			} else if (dataBitlength <= 368 - 9) {
				return 5;
			} else if (dataBitlength <= 480 - 9) {
				return 6;
			} else if (dataBitlength <= 528 - 9) {
				return 7;
			} else if (dataBitlength <= 688 - 9) {
				return 8;
			} else if (dataBitlength <= 800 - 9) {
				return 9;
			} else if (dataBitlength <= 976 - 17) {
				return 10;
			} else if (dataBitlength <= 1120 - 17) {
				return 11;
			} else if (dataBitlength <= 1264 - 17) {
				return 12;
			} else if (dataBitlength <= 1440 - 17) {
				return 13;
			} else if (dataBitlength <= 1576 - 17) {
				return 14;
			} else if (dataBitlength <= 1784 - 17) {
				return 15;
			} else if (dataBitlength <= 2024 - 17) {
				return 16;
			} else if (dataBitlength <= 2264 - 17) {
				return 17;
			} else if (dataBitlength <= 2504 - 17) {
				return 18;
			} else if (dataBitlength <= 2728 - 17) {
				return 19;
			} else if (dataBitlength <= 3080 - 17) {
				return 20;
			}
			// else if (dataBitlength <= 3248 - 25) {
			// return 21;
			// } else if (dataBitlength <= 3536 - 25) {
			// return 22;
			// } else if (dataBitlength <= 3712 - 25) {
			// return 23;
			// } else if (dataBitlength <= 4112 - 25) {
			// return 24;
			// } else if (dataBitlength <= 4304 - 25) {
			// return 25;
			// } else if (dataBitlength <= 4768 - 25) {
			// return 26;
			// } else if (dataBitlength <= 5024 - 25) {
			// return 27;
			// } else if (dataBitlength <= 5288 - 25) {
			// return 28;
			// } else if (dataBitlength <= 5608 - 25) {
			// return 29;
			// } else if (dataBitlength <= 5960 - 25) {
			// return 30;
			// } else if (dataBitlength <= 6344 - 33) {
			// return 31;
			// } else if (dataBitlength <= 6760 - 33) {
			// return 32;
			// } else if (dataBitlength <= 7208 - 33) {
			// return 33;
			// } else if (dataBitlength <= 7688 - 33) {
			// return 34;
			// } else if (dataBitlength <= 7888 - 33) {
			// return 35;
			// } else if (dataBitlength <= 8432 - 33) {
			// return 36;
			// } else if (dataBitlength <= 8768 - 33) {
			// return 37;
			// } else if (dataBitlength <= 9136 - 33) {
			// return 38;
			// } else if (dataBitlength <= 9776 - 33) {
			// return 39;
			// } else if (dataBitlength <= 10208 - 33) {
			// return 40;
			// }
			else {
				return 0;
			}
		}
		default: {
			return 0;
		}
		}
	}

	private static int size(int version) {
		// 二维码的size介绍
		// http://www.qrcode.com/en/about/version.html
		if (version >= 1 && version <= 20) {
			return (version - 1) * 4 + 21;
		} else {
			return 0;
		}
	}

	private static boolean isFixed(int size, int x, int y) {
		if (x < 8 && y < 8) {
			return true;
		} else if (x > (size(size) - 1) - 8 && y < 8) {
			return true;
		} else if (x < 8 && y > (size(size) - 1) - 8) {
			return true;
		} else if (size != 1 && (x > (size(size) - 1) - 9 && x < (size(size) - 1) - 3 && y > (size(size) - 1) - 9 && y < (size(size) - 1) - 3)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 创建视觉二维码
	 * 
	 * @param content
	 *            二维码内容、网址，必需
	 * @param bgPath
	 *            背景图片路径，必需
	 * @param outPath
	 *            二维码输出路径，必需
	 * @param Level
	 *            二维码容错等级，必需
	 * @param DF
	 *            颜色，必需
	 * @param startX
	 *            二维码X轴起点，非必须，默认为图片的左上角
	 * @param startY
	 *            二维码Y轴起点，非必须，默认为图片的左上角
	 * @param QRCodeWidth
	 *            二维码的宽度，非必须，默认为背景图最小边
	 * @param isDeformation
	 *            是否把背景图变成方形，非必须，默认不改变图片形状
	 * @param fillPositionDetectionShapeModel
	 *            二维码四个大码眼的形状，目前只支持方形和圆方形
	 * @param fillShapeModel
	 *            二维码点的形状，目前只支持方形和圆形
	 * @throws IOException
	 */
	public static void createQRCode(Object object, String bgPath, String outPath, char Level, Color DF, Integer startX, Integer startY, Integer QRCodeWidth, Boolean isDeformation,
			Integer fillPositionDetectionShapeModel, Integer fillShapeModel) throws IOException {

		// 网格大小18*18
		int UNIT_WIDTH = 54;

		// 二维码颜色
		DF = new Color(DF.getRed(), DF.getGreen(), DF.getBlue(), (int) (255 * 0.75));
		Color LB = new Color(255, 255, 255, (int) (255 * 0.25));
		Color LF = new Color(255, 255, 255, (int) (255 * 0.75));
		// 二维码内容
		byte[] buff = null;
		try {
			buff = object.toString().getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			throw e;
		}

		// 1 byte = 8 bit
		int dataBitlength = buff.length * 8;

		int version = version(Level, dataBitlength);

		Qrcode qrcode = new Qrcode();

		// 错误修正容量
		// L水平 7%的字码可被修正
		// M水平 15%的字码可被修正
		// Q水平 25%的字码可被修正
		// H水平 30%的字码可被修正
		// QR码有容错能力，QR码图形如果有破损，仍然可以被机器读取内容，最高可以到7%~30%面积破损仍可被读取。
		// 相对而言，容错率愈高，QR码图形面积愈大。所以一般折衷使用15%容错能力。

		qrcode.setQrcodeErrorCorrect(Level);/* L','M','Q','H' */
		qrcode.setQrcodeEncodeMode('B');/* "N","A" or other */
		// 二维码介绍网址 http://www.qrcode.com/en/about/version.html
		qrcode.setQrcodeVersion(version);/* 0-20 */

		boolean[][] bRect = qrcode.calQrcode(buff);

		// 二维码长宽
		int QRCodeWidthTemp = bRect.length * UNIT_WIDTH + 2 * UNIT_WIDTH;
		
		//读取远程图片
		URL url=new URL(bgPath);
		 //打开链接  
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        //设置请求方式为"GET"  
        conn.setRequestMethod("GET");  
        //超时响应时间为5秒  
        conn.setConnectTimeout(5 * 1000);  
        //通过输入流获取图片数据  
        InputStream inStream = conn.getInputStream();  
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性  
        
/*        try {
			byte[] data = readInputStream(inStream);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  */
        //new一个文件对象用来保存图片，默认保存当前工程根目录 
	/*	File file = new File(bgPath);
		if (!file.exists()) {
			throw new RuntimeException("background image is not exist.");
		}*/
        
        
        
        
		Image imgbg = ImageIO.read(inStream);

		// 默认是方形
		if (fillShapeModel == null) {
			fillShapeModel = FILL_SHAPE_MODEL_RECTANGLE;
		}

		// 默认是方形
		if (fillPositionDetectionShapeModel == null) {
			fillPositionDetectionShapeModel = POSITION_DETECTION_SHAPE_MODEL_RECTANGLE;
		}

		int bgImageWidth = imgbg.getWidth(null);
		int bgImageHeight = imgbg.getHeight(null);

		if (startX == null) {
			startX = 0;
		}
		if (startY == null) {
			startY = 0;
		}

		if (isDeformation == null) {
			isDeformation = false;
		}
		// 图片变成方形
		if (isDeformation == true) {
			if (bgImageWidth > bgImageHeight) {
				bgImageHeight = bgImageWidth;
			} else {
				bgImageWidth = bgImageHeight;
			}
		}

		// 如果二维码的宽是默认，则取最大的值
		if (QRCodeWidth == null) {
			QRCodeWidth = bgImageHeight - startY > bgImageWidth - startX ? bgImageWidth - startX : bgImageHeight - startY;
		}

		// 开始位置加上宽或高大于背景图的边长
		if ((startX + QRCodeWidth > bgImageWidth) || (startY + QRCodeWidth > bgImageHeight)) {
			throw new RuntimeException("qrcode startX and QRCodeWidth or startY and QRCodeWidth is greater than background image width or height.");
		}

		// 按比例进行缩放
		int bgImageWidthTemp = bgImageWidth * QRCodeWidthTemp / QRCodeWidth;
		int bgImageHeightTemp = bgImageHeight * QRCodeWidthTemp / QRCodeWidth;
		int startXTemp = (int) Math.floor(((double) bgImageWidthTemp / bgImageWidth * startX));
		int startYTemp = (int) Math.floor(((double) bgImageHeightTemp / bgImageHeight * startY));

		if (startXTemp < UNIT_WIDTH) {
			startXTemp = UNIT_WIDTH;
		}
		if (startYTemp < UNIT_WIDTH) {
			startYTemp = UNIT_WIDTH;
		}

		BufferedImage bi = new BufferedImage(bgImageWidthTemp, bgImageHeightTemp, BufferedImage.TYPE_INT_RGB);
		// createGraphics
		Graphics2D g = bi.createGraphics();

		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, bgImageWidthTemp, bgImageHeightTemp);

		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f)); // 透明度设置开始
		g.drawImage(imgbg, 0, 0, bgImageWidthTemp, bgImageHeightTemp, null);

		// 设置不要齿（画出的图形会圆滑）
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// 画四个大码眼
		fillPositionDetectionShape(g, DF, LF, LB, QRCodeWidthTemp, UNIT_WIDTH, startXTemp, startYTemp, version, fillPositionDetectionShapeModel);

		for (int i = 0; i < bRect.length; i++) {
			for (int j = 0; j < bRect.length; j++) {
				// Color b = bRect[i][j] ? DB : LB;
				Color f = bRect[i][j] ? DF : LF;
				if (isFixed(version, i, j)) {

				} else if (bRect[i][j]) {
					// 画黑色的点
					g.setColor(f);
					fillShape(g, fillShapeModel, UNIT_WIDTH, startXTemp, startYTemp, i, j);
				} else {
					// 画白色的点，主要是遮住图片有颜色的部分，这样才能读出二维码
					int arrColor[] = new int[324];
					arrColor = bi.getRGB(startXTemp + i * UNIT_WIDTH + 3, startYTemp + j * UNIT_WIDTH + 3, UNIT_WIDTH - 6, UNIT_WIDTH - 6, arrColor, 0, 4);
					for (int k = 0; k < arrColor.length; k++) {
						if (arrColor[k] != -1) {
							g.setColor(LB);
							fillShape(g, fillShapeModel, UNIT_WIDTH, startXTemp, startYTemp, i, j);
							continue;
						}
					}
				}
			}

		}

		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); // 透明度设置结束

		// resize imageCode
		bi = resizeImage(bi, bgImageWidth, bgImageHeight);

		File f = new File(outPath);

		try {
			ImageIO.write(bi, "jpg", f);
		} catch (IOException e) {
			throw e;
		}
	}

	public static int POSITION_DETECTION_SHAPE_MODEL_RECTANGLE = 1;
	public static int POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE = 2;

	/**
	 * 画四个大马眼
	 * 
	 * @param g
	 * @param DF
	 * @param LF
	 * @param LB
	 * @param QRCodeWidthTemp
	 * @param UNIT_WIDTH
	 * @param startXTemp
	 * @param startYTemp
	 * @param version
	 * @param fillPositionDetectionShapeModel
	 */
	private static void fillPositionDetectionShape(Graphics2D g, Color DF, Color LF, Color LB, int QRCodeWidthTemp, int UNIT_WIDTH, int startXTemp, int startYTemp, int version,
			int fillPositionDetectionShapeModel) {
		if (fillPositionDetectionShapeModel == POSITION_DETECTION_SHAPE_MODEL_RECTANGLE) {
			// 添加一层遮罩
			g.setColor(LB);
			// g.fillRect(startXTemp, startYTemp, QRCodeWidthTemp,
			// QRCodeWidthTemp);
			g.fillRect(startXTemp - UNIT_WIDTH, startYTemp - UNIT_WIDTH, QRCodeWidthTemp, QRCodeWidthTemp);

			// 画四个圆滑的大码眼
			Stroke stroke = g.getStroke(); // 得到当前的画刷
			float thick = UNIT_WIDTH * 1f; // 设置画刷的粗细
			// 左上角
			g.setColor(LF);
			g.fillRect(startXTemp + 1 * UNIT_WIDTH, startYTemp + 1 * UNIT_WIDTH, 5 * UNIT_WIDTH, 5 * UNIT_WIDTH);
			g.setColor(DF);
			g.fillRect(startXTemp + 2 * UNIT_WIDTH, startYTemp + 2 * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER)); // 设置新的画刷
			g.setColor(LF);
			g.drawRect(startXTemp + UNIT_WIDTH / 2 - UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 - UNIT_WIDTH, 8 * UNIT_WIDTH, 8 * UNIT_WIDTH);
			g.setColor(DF);
			g.drawRect(startXTemp + UNIT_WIDTH / 2, startYTemp + UNIT_WIDTH / 2, 6 * UNIT_WIDTH, 6 * UNIT_WIDTH);
			g.setStroke(stroke); // 将画刷复原

			// 右上角
			g.setColor(LF);
			g.fillRect(startXTemp + (size(version) - 6) * UNIT_WIDTH, startYTemp + 1 * UNIT_WIDTH, 5 * UNIT_WIDTH, 5 * UNIT_WIDTH);
			g.setColor(DF);
			g.fillRect(startXTemp + (size(version) - 5) * UNIT_WIDTH, startYTemp + 2 * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER)); // 设置新的画刷
			g.setColor(LF);
			g.drawRect(startXTemp + UNIT_WIDTH / 2 + (size(version) - 8) * UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 - UNIT_WIDTH + 0, 8 * UNIT_WIDTH, 8 * UNIT_WIDTH);
			g.setColor(DF);
			g.drawRect(startXTemp + UNIT_WIDTH / 2 + (size(version) - 7) * UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 + 0, 6 * UNIT_WIDTH, 6 * UNIT_WIDTH);
			g.setStroke(stroke); // 将画刷复原

			// 左下角
			g.setColor(LF);
			g.fillRect(startXTemp + 1 * UNIT_WIDTH, startYTemp + (size(version) - 6) * UNIT_WIDTH, 5 * UNIT_WIDTH, 5 * UNIT_WIDTH);
			g.setColor(DF);
			g.fillRect(startXTemp + 2 * UNIT_WIDTH, startYTemp + (size(version) - 5) * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER)); // 设置新的画刷
			g.setColor(LF);
			g.drawRect(startXTemp + UNIT_WIDTH / 2 - UNIT_WIDTH + 0, startYTemp + UNIT_WIDTH / 2 + (size(version) - 8) * UNIT_WIDTH, 8 * UNIT_WIDTH, 8 * UNIT_WIDTH);
			g.setColor(DF);
			g.drawRect(startXTemp + UNIT_WIDTH / 2 + 0, startYTemp + UNIT_WIDTH / 2 + (size(version) - 7) * UNIT_WIDTH, 6 * UNIT_WIDTH, 6 * UNIT_WIDTH);
			g.setStroke(stroke); // 将画刷复原

			// 右下角
			g.setColor(LF);
			g.fillRect(startXTemp + (size(version) - 8) * UNIT_WIDTH, startYTemp + (size(version) - 8) * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH);
			g.setColor(DF);
			g.fillRect(startXTemp + (size(version) - 7) * UNIT_WIDTH, startYTemp + (size(version) - 7) * UNIT_WIDTH, 1 * UNIT_WIDTH, 1 * UNIT_WIDTH);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER)); // 设置新的画刷
			g.setColor(DF);
			g.drawRect(startXTemp + UNIT_WIDTH / 2 + (size(version) - 9) * UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 + (size(version) - 9) * UNIT_WIDTH, 4 * UNIT_WIDTH, 4 * UNIT_WIDTH);
			g.setStroke(stroke); // 将画刷复原

		} else if (fillPositionDetectionShapeModel == POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE) {
			// 添加一层遮罩
			g.setColor(LB);
			// g.fillRect(startXTemp, startYTemp, QRCodeWidthTemp,
			// QRCodeWidthTemp);
			g.fillRoundRect(startXTemp - UNIT_WIDTH, startYTemp - UNIT_WIDTH, QRCodeWidthTemp, QRCodeWidthTemp, (int) (UNIT_WIDTH * 4.5), (int) (UNIT_WIDTH * 4.5));

			// 画四个圆滑的大码眼
			Stroke stroke = g.getStroke(); // 得到当前的画刷
			float thick = UNIT_WIDTH * 1f; // 设置画刷的粗细
			// 左上角
			g.setColor(LF);
			g.fillRoundRect(startXTemp + 1 * UNIT_WIDTH, startYTemp + 1 * UNIT_WIDTH, 5 * UNIT_WIDTH, 5 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);
			g.setColor(DF);
			g.fillRoundRect(startXTemp + 2 * UNIT_WIDTH, startYTemp + 2 * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND)); // 设置新的画刷
			g.setColor(LF);
			g.drawRoundRect(startXTemp + UNIT_WIDTH / 2 - UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 - UNIT_WIDTH, 8 * UNIT_WIDTH, 8 * UNIT_WIDTH, (int) (UNIT_WIDTH * 3.8), (int) (UNIT_WIDTH * 3.8));
			g.setColor(DF);
			g.drawRoundRect(startXTemp + UNIT_WIDTH / 2, startYTemp + UNIT_WIDTH / 2, 6 * UNIT_WIDTH, 6 * UNIT_WIDTH, UNIT_WIDTH * 2, UNIT_WIDTH * 2);
			g.setStroke(stroke); // 将画刷复原

			// 右上角
			g.setColor(LF);
			g.fillRoundRect(startXTemp + (size(version) - 6) * UNIT_WIDTH, startYTemp + 1 * UNIT_WIDTH, 5 * UNIT_WIDTH, 5 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);
			g.setColor(DF);
			g.fillRoundRect(startXTemp + (size(version) - 5) * UNIT_WIDTH, startYTemp + 2 * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND)); // 设置新的画刷
			g.setColor(LF);
			g.drawRoundRect(startXTemp + UNIT_WIDTH / 2 + (size(version) - 8) * UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 - UNIT_WIDTH + 0, 8 * UNIT_WIDTH, 8 * UNIT_WIDTH, (int) (UNIT_WIDTH * 3.8),
					(int) (UNIT_WIDTH * 3.8));
			g.setColor(DF);
			g.drawRoundRect(startXTemp + UNIT_WIDTH / 2 + (size(version) - 7) * UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 + 0, 6 * UNIT_WIDTH, 6 * UNIT_WIDTH, UNIT_WIDTH * 2, UNIT_WIDTH * 2);
			g.setStroke(stroke); // 将画刷复原

			// 左下角
			g.setColor(LF);
			g.fillRoundRect(startXTemp + 1 * UNIT_WIDTH, startYTemp + (size(version) - 6) * UNIT_WIDTH, 5 * UNIT_WIDTH, 5 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);
			g.setColor(DF);
			g.fillRoundRect(startXTemp + 2 * UNIT_WIDTH, startYTemp + (size(version) - 5) * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND)); // 设置新的画刷
			g.setColor(LF);
			g.drawRoundRect(startXTemp + UNIT_WIDTH / 2 - UNIT_WIDTH + 0, startYTemp + UNIT_WIDTH / 2 + (size(version) - 8) * UNIT_WIDTH, 8 * UNIT_WIDTH, 8 * UNIT_WIDTH, (int) (UNIT_WIDTH * 3.8),
					(int) (UNIT_WIDTH * 3.8));
			g.setColor(DF);
			g.drawRoundRect(startXTemp + UNIT_WIDTH / 2 + 0, startYTemp + UNIT_WIDTH / 2 + (size(version) - 7) * UNIT_WIDTH, 6 * UNIT_WIDTH, 6 * UNIT_WIDTH, UNIT_WIDTH * 2, UNIT_WIDTH * 2);
			g.setStroke(stroke); // 将画刷复原

			// 右下角
			g.setColor(LF);
			g.fillRoundRect(startXTemp + (size(version) - 8) * UNIT_WIDTH, startYTemp + (size(version) - 8) * UNIT_WIDTH, 3 * UNIT_WIDTH, 3 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);
			g.setColor(DF);
			g.fillRoundRect(startXTemp + (size(version) - 7) * UNIT_WIDTH, startYTemp + (size(version) - 7) * UNIT_WIDTH, 1 * UNIT_WIDTH, 1 * UNIT_WIDTH, UNIT_WIDTH * 1, UNIT_WIDTH * 1);

			g.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND)); // 设置新的画刷
			g.setColor(DF);
			g.drawRoundRect(startXTemp + UNIT_WIDTH / 2 + (size(version) - 9) * UNIT_WIDTH, startYTemp + UNIT_WIDTH / 2 + (size(version) - 9) * UNIT_WIDTH, 4 * UNIT_WIDTH, 4 * UNIT_WIDTH,
					UNIT_WIDTH * 1, UNIT_WIDTH * 1);
			g.setStroke(stroke); // 将画刷复原
		} else {
			throw new RuntimeException("fillPositionDetectionShapeModel is not exist.");
		}
	}

	public static int FILL_SHAPE_MODEL_RECTANGLE = 1;
	public static int FILL_SHAPE_MODEL_CIRCLE = 2;

	/**
	 * 画二维码的小点
	 * 
	 * @param g
	 * @param fillShapeModel
	 * @param UNIT_WIDTH
	 * @param startXTemp
	 * @param startYTemp
	 * @param i
	 * @param j
	 */
	private static void fillShape(Graphics2D g, int fillShapeModel, int UNIT_WIDTH, int startXTemp, int startYTemp, int i, int j) {
		if (fillShapeModel == FILL_SHAPE_MODEL_RECTANGLE) {
			// 画矩形
			g.fillRect(startXTemp + i * UNIT_WIDTH + 9, startYTemp + j * UNIT_WIDTH + 9, UNIT_WIDTH - 18, UNIT_WIDTH - 18);
		} else if (fillShapeModel == FILL_SHAPE_MODEL_CIRCLE) {
			// 画圆点
			g.fillOval(startXTemp + i * UNIT_WIDTH + 15, startYTemp + j * UNIT_WIDTH + 15, UNIT_WIDTH / 2 - 2, UNIT_WIDTH / 2 - 2);
		} else {
			throw new RuntimeException("ShapeModel is not exist.");
		}
	}

	/**
	 * 重新设置图片的宽高
	 * 
	 * @param originalImage
	 * @param IMG_WIDTH
	 * @param IMG_HEIGHT
	 * @return
	 */
	private static BufferedImage resizeImage(BufferedImage originalImage, int IMG_WIDTH, int IMG_HEIGHT) {
		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
		// g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		return resizedImage;
	}

	
	//二进制读取图片
	public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        //创建一个Buffer字符串  
        byte[] buffer = new byte[1024];  
        //每次读取的字符串长度，如果为-1，代表全部读取完毕  
        int len = 0;  
        //使用一个输入流从buffer里把数据读取出来  
        while( (len=inStream.read(buffer)) != -1 ){  
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
            outStream.write(buffer, 0, len);  
        }  
        //关闭输入流  
        inStream.close();  
        //把outStream里的数据写入内存  
        return outStream.toByteArray();  
    }  
	
}
