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
 * ���ù�����
 * @author jinyu
 *
 */
public final class CommonUtil {
	private CommonUtil(){
		throw new AssertionError();
	}
	/**
	 * ��ʽ��ʱ������
	 * @param pattern ��ʽ
	 * @param str ʱ�����ڶ���
	 * @return ���ڣ����ڸ�ʽ��
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
	 * ��ʱ���ʽ���ַ���
	 * @param pattern ��ʽ
	 * @param str ʱ�����ڶ���
	 * @return ���ڣ��ַ�����ʽ��
 	 */
	public static String dateToString(String pattern,String str) {
		SimpleDateFormat formatter=new SimpleDateFormat(pattern);
		return formatter.format(pattern);
	}
	/**
	 * ��ȡ�ļ����ĺ�׺��
	 * @param filename
	 * @return
	 */
	public static String getFilenameSuffix(String filename) {
		int index=filename.lastIndexOf(".");
			return index>0&&index<filename.length()-1?
					filename.substring(index):"";
	}
	/**
	 * ���ȫ��Ψһ���ļ���
	 * @return �ļ���
	 */
	public static String getUniqueFilename(){
		return UUID.randomUUID().toString();
	}

	/**
	 * ѹ��ͼƬ
	 * @param inputStream ͼƬ������������
	 * @param file Ŀ���ļ�
	 * @param width ѹ����Ŀ��
	 * @param height ѹ����ĸ߶�
	 * @throws IOException ��д�ļ�ʱ����������IOException
	 */
	public static void compressImage(InputStream inputStream,File file,
			int width,int height) throws IOException{
		BufferedImage oldImage=ImageIO.read(inputStream);
		//type 1��ʾ��ԭɫ��ͼ   BufferedImage.Ty
		BufferedImage newImage=new BufferedImage(width,height,1);
		newImage.getGraphics().drawImage(oldImage, 0, 0,width,height,null);
		ImageIO.write(newImage, "PNG",file);
	}
}
