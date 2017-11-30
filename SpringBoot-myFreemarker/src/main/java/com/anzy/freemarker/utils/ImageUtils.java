package com.anzy.freemarker.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static void download(String imgUrl,String imageFileName,int ratio){
		try {
			URL url = new URL(imgUrl);
			Image src = ImageIO.read(url);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//绘制缩小后的图片
			thumb.getGraphics().drawImage(src, 0, 0, width/ratio,height/ratio,null);
			//输出的文件流
			File file = new File(imageFileName);
			ImageIO.write(thumb, "jpg", file);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String imgUrl = "https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/"
				+ "baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=58a84c0c5982b2b7b392319650c4a08a"
				+ "/dcc451da81cb39db4f11b35ed0160924aa1830e1.jpg";
		String imageFileName = "D:/aaaa.jpg";
		download(imgUrl, imageFileName,2);
		System.out.println("转换完成");
	}
}
