package com.qfedu.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
/**
 * 常用工具类
 * @author jinyu
 *
 */
public final class CommonUtil {
	private CommonUtil(){
		throw new AssertionError();
	}
	/**
	 * 格式化时间日期
	 * @param pattern 样式
	 * @param str 时间日期对象
	 * @return 日期（日期格式）
	 */
	public static Date stringToDate(String pattern,String str) {
		SimpleDateFormat formatter=new SimpleDateFormat(pattern);
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 将时间格式化字符串
	 * @param pattern 样式
	 * @param str 时间日期对象
	 * @return 日期（字符串格式）
 	 */
	public static String dateToString(String pattern,String str) {
		SimpleDateFormat formatter=new SimpleDateFormat(pattern);
		return formatter.format(pattern);
	}
	/**
	 * 获取文件名的后缀名
	 * @param filename
	 * @return
	 */
	public static String getFilenameSuffix(String filename) {
		int index=filename.lastIndexOf(".");
			return index>0&&index<filename.length()-1?
					filename.substring(index):"";
	}
	/**
	 * 获得全局唯一的文件名
	 * @return 文件名
	 */
	public static String getUniqueFilename(){
		return UUID.randomUUID().toString();
	}

	/**
	 * 压缩图片
	 * @param inputStream 图片二进制输入流
	 * @param file 目标文件
	 * @param width 压缩后的宽度
	 * @param height 压缩后的高度
	 * @throws IOException 读写文件时可能引发的IOException
	 */
	public static void compressImage(InputStream inputStream,File file,
			int width,int height) throws IOException{
		BufferedImage oldImage=ImageIO.read(inputStream);
		//type 1表示三原色构图   BufferedImage.Ty
		BufferedImage newImage=new BufferedImage(width,height,1);
		newImage.getGraphics().drawImage(oldImage, 0, 0,width,height,null);
		ImageIO.write(newImage, "PNG",file);
	}
}
