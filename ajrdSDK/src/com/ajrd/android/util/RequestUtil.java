package com.ajrd.android.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.widget.DialerFilter;

import com.ajrd.android.util.MyUtil;

/**
 * ���󹤾���
 * @author Shawn
 *
 */
public class RequestUtil {
	
	//�����ĳɹ�
	public static final int REQUEST_SUCCESS = 10001;
	
	//������ʧ��
	public static final int REQUEST_FAIELD  = 10000;
	
	
	/**
	 * ��ȡ���ѽ��
	 * 1���Է�Ϊ��λ
	 * 2��12���ֽڣ�����ǰ�油0
	 * @param sum
	 * �༭��������
	 * @return
	 * �Է�Ϊ��λ��12���ֽڽ��
	 */
	public static String getSumOfConsume(String sum){
		Double d1 = Double.parseDouble(sum);
		Double t_sum = (d1*100);
		String str_sum = String.valueOf(t_sum);
		StringBuilder sb = new StringBuilder();
		int len = str_sum.length();
		if(len==1){
			sb.append("00000000000");
		}else if(len==2){
			sb.append("0000000000");
		}else if(len==3){
			sb.append("000000000");
		}else if(len==4){
			sb.append("00000000");
		}else if(len==5){
			sb.append("0000000");
		}else if(len==6){
			sb.append("000000");
		}else if(len==7){
			sb.append("00000");
		}else if(len==8){
			sb.append("0000");
		}else if(len==9){
			sb.append("000");
		}else if(len==10){
			sb.append("00");
		}else if(len==11){
			sb.append("00");
		}
		sb.append(str_sum);
		
		return sb.toString();
	}
	/**
	 * ��ȡ���ѽ��
	 * 1���Է�Ϊ��λ
	 * 2��12���ֽڣ�����ǰ�油0
	 * @param sum
	 * �༭��������
	 * @return
	 * �Է�Ϊ��λ��12���ֽڽ��
	 */
	public static String getSumOfConsume2(String sum){
		System.out.println("sum:"+sum);
		DecimalFormat format = new DecimalFormat(".00");
		BigDecimal money = ((BigDecimal.valueOf(Double.valueOf(sum))));
		System.out.println("money:"+money);
//		String str4 = format.format(money);
//		System.out.println("str4:"+str4);
		
		double price = money.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		L.e("price", ""+price);
		
		String str4 = format.format(price);
		L.e("str4:",""+str4);
		String[] mPrices= str4.split("\\.");
		StringBuilder sb3 = new StringBuilder();
		for(int i=0;i<mPrices.length;i++){
			sb3.append(mPrices[i]);
		}
		System.out.println("��Ǯ:"+sb3.toString());
		String data = sb3.toString();
		
//		int i_sum = Integer.parseInt(sum);
//		int t_sum = (i_sum*100);
//		System.out.println("sum:"+sum);
//		Double double1 = Double.valueOf(sum);
//		System.out.println("double1:"+""+double1);
//		Double double2 = (double1*100);
//		System.out.println("double2:"+""+double2);
//		String str_sum = String.valueOf(double2);
//		String str_sum =double1.toString();
//		String str_sum  = String.valueOf(money);
//		System.out.println("��"+str_sum);
//		String[] str = str_sum.split("\\.");
//		String data = str[0];
//		System.out.println("���:"+data);
		StringBuilder sb = new StringBuilder();
		int len = data.length();
		if(len==1){
			sb.append("00000000000");
		}else if(len==2){
			sb.append("0000000000");
		}else if(len==3){
			sb.append("000000000");
		}else if(len==4){
			sb.append("00000000");
		}else if(len==5){
			sb.append("0000000");
		}else if(len==6){
			sb.append("000000");
		}else if(len==7){
			sb.append("00000");
		}else if(len==8){
			sb.append("0000");
		}else if(len==9){
			sb.append("000");
		}else if(len==10){
			sb.append("00");
		}else if(len==11){
			sb.append("00");
		}
		sb.append(data);
		return sb.toString();
	}
	
	
	
	
	/**
	 * ��ȡLLVAR��ʽ������
	 * @param data
	 * ԭʼ����
	 * @return
	 */
	public static String getLLVARData(String data){
		StringBuilder sb = new StringBuilder();
		int len = data.length();
		if(len>0&&len<=9){
			sb.append("0");
		}
//		byte[] b_len = MyUtil.hexStringToByte(String.valueOf(len));
		
//		sb.append(new String(b_len));
		sb.append(len);
		sb.append(data);
		return sb.toString();
	}
	
	/**
	 * ��ȡLLLVAR��ʽ������
	 * @param data
	 * ԭʼ����
	 * @return
	 */
	public static String getLLLVARData(String data){
		StringBuilder sb = new StringBuilder();
		int len = data.length();
		if(len>9&&len<=99){
			sb.append("00");
		}else if(len>99&&len<=999){
			sb.append("0");
		}
		sb.append(len);
		sb.append(data);
		return sb.toString();
	}
	

	
	
	
	
	
	
	
	/**
	 * ��ȡ�������ĳ��ȵı���
	 * @param datas
	 * ����
	 * @return
	 */
	public static byte[] getMiWenData4(int len,byte[] datas){
		L.e("getMiWenData4", "getMiWenData4");
		L.e("len:", ""+len);
		byte[] one_zeor= "0".getBytes();
		byte[] two_zeros = "00".getBytes();
//		StringBuilder sb = new StringBuilder();
	
		if(len>0&&len<=99){
			L.e("len>0&&len<=99", ""+(len>0&&len<=99));
			byte[] mLen = MyUtil.byteMerger(two_zeros, String.valueOf(len).getBytes());
			L.e("mLen:", ""+new String(mLen));
			return MyUtil.byteMerger(mLen, datas);
		}else if(len>99&&len<=999){
			L.e("len>99&&len<=999", ""+(len>99&&len<=999));
			byte[] mLen = MyUtil.byteMerger(one_zeor, String.valueOf(len).getBytes());
			L.e("mLen:", ""+new String(mLen));
			return MyUtil.byteMerger(mLen, datas);
		}else if(len>999){
			L.e("len>999:", ""+(len>999));
			return MyUtil.byteMerger(String.valueOf(len).getBytes(), datas);
		}
		
		return null;
		
	}
	/**
	 * ��ȡ�������ĳ��ȵı���
	 * @param datas
	 * ����
	 * @return
	 */
	public static byte[] getMiWenData(byte[] datas){
		L.e("getMiWenData", "getMiWenData");
		int len = datas.length;
		String str_len = String.valueOf(datas.length);
		L.e("len:", ""+len);
		byte[] one_zeor= "0".getBytes();
		byte[] two_zeros = "00".getBytes();
		if(len>0&&len<=99){
			byte[] mLen = MyUtil.byteMerger(two_zeros, str_len.getBytes());
			L.e("mLen:", ""+new String(mLen));
			return MyUtil.byteMerger(mLen, datas);
		}else if(len>99&&len<=999){
			byte[] mLen = MyUtil.byteMerger(one_zeor, str_len.getBytes());
			L.e("mLen:", ""+new String(mLen));
			return MyUtil.byteMerger(mLen, datas);
		}else{
			byte[] mLen = str_len.getBytes();
			L.e("mLen:", ""+new String(mLen));
			return MyUtil.byteMerger(mLen, datas);
		}
		
	}
	
	//�������ص��� 
	public static boolean isNumeric(String str){ 
		try { 
			Integer.parseInt(str); 
			return true; 
		} catch (NumberFormatException e) { 
			return false; 
		} 
	}
	
	/**
	 * �����ļ��ϱ���ͷ����
	 * @param isoMsg
	 * ������ʵ����
	 * @return
	 */
	public static String getDataAppendLen(String hex_data){
		StringBuilder sb2 = new StringBuilder();
		int len2 = hex_data.length();
		int rea_len = (len2/2);
		if(rea_len>99&&rea_len<999){
			sb2.append("0");
		}else if(rea_len>9&&rea_len<=99){
			sb2.append("00");
		}
		sb2.append(rea_len);
		StringBuilder sb = new StringBuilder();
		sb.append(DigitalTrans.stringToHexString(sb2.toString()));
		sb.append(hex_data);
		return sb.toString();
	}
	
	
}
