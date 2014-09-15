package com.ajrd;

public class SafeSoft {
	/**
	 * ����
	 */
//	public static final int ENCRYPT = 0;
	/**
	 * ����
	 */
//	public static final int DECRYPT = 1;
	
	static {

		System.loadLibrary("AjrdSafeSoft");
	}

	/**
	 * ��ȡMAC��Ϣ������
	 * 
	 * @param mac_key
	 *            MacУ������
	 * @param data_len
	 *            Ҫ����Mac����������ݳ���
	 * @param data
	 *            ʵ�ʵ������ֽ� Ҫ����Mac�����������
	 * @return Mac������
	 */
//	public native static byte[] GenerateMac(byte[] mac_key, int data_len,
//			byte[] data);

	/**
	 * �������
	 * 
	 * @param key
	 *            ��Կ�ֽ�����
	 * @param pwd
	 *            �����ֽ�����
	 * @param card_num
	 *            �����ֽ�����
	 * @return ���ܺ�������ֽ�����(16��������)
	 */
//	public native static byte[] EncryptPin(byte key[], byte pwd[],
//			byte card_num[]);
//
//	public native static byte[] Byte2Hex(byte s1[], int i1);
//
//	public native static byte[] Hex2Byte(byte s1[], int i1);

	/**
	 * Des�ӽ��� ���ݺ���Կ��ʮ�����Ʊ�ʾ�ģ�16���ֽڡ�
	 * 
	 * @param data
	 *            ��Ҫ���ܻ���ܵ�����
	 * @param key
	 *            ��Կ
	 * @param type
	 *            0 - ���� 1-����
	 * @return
	 */
//	public native static byte[] Des(byte data[], byte key[], int type);
	
	/**
	 * 
	 * @param pwd
	 * @return
	 */
//	public native static byte[] EncryptTlr( byte pwd[] );

//	public static void main(String[] args) {
//		String a1, a2, a3, a4, a5, a6, a7;
//		int len1, len2, len3, len4, len5;
//		;
//		byte b1[], b2[], b3[], b4[], b5[], b6[], b7[];
//		;
//		/*
//		 * byte b5[] = new byte[16];
//		 */
//
//		a1 = "1234567890123456";
//		a2 = "1234567890";
//		a3 = "223456";
//		a4 = "6225100010009999";
//		a5 = "abcdefgh";
//		a6 = "3132333435363738";
//		a7 = "0123450123401230";
//
//		b1 = a1.getBytes();
//		b2 = a2.getBytes();
//		b3 = a3.getBytes();
//		b4 = a4.getBytes();
//		b5 = a5.getBytes();
//		b6 = a6.getBytes();
//		b7 = a7.getBytes();
//
//		len1 = 10;
//		len2 = 8;
//		len3 = 16;
//		len4 = 0;
//		len5 = 1;
//
//		/*
//		 * b5 = new byte();
//		 */
//
//		System.out.println(new String(SafeSoft.EncryptPin(b1, b3, b4)));
//		System.out.println(new String(SafeSoft.GenerateMac(b1, len1, b2)));
//		System.out.println(new String(SafeSoft.Byte2Hex(b5, len2)));
//		System.out.println(new String(SafeSoft.Hex2Byte(b6, len3)));
//
//		System.out.println(new String(SafeSoft.Des(b7, b7, len4)));
//		System.out.println(new String(SafeSoft.Des(b7, b7, len5)));
//	}

	// MAC��7789AFAC888BA28B
	// ���ܺ����룺4F6EEA3427EAB667
	// 4F6EEA3427EAB667
	/**
	 * ȫ���ļ���
	 * @param datas
	 * ���ģ�����������
	 * @param len
	 * ���ȣ��ر�ע����㷽ʽ����
	 * ����ĳ��ȼ��㷽�����£�
		����len+2����С8�ı�������len=6���򷵻س���Ϊ8����len=7���򷵻س���Ϊ16��
	 * @return
	 * ���ģ����͵�����������Ҫ����4�ֽڵĳ���
	 */
	public native static byte[] EncryptMsg(byte datas[], int len);

	/**
	 * ȫ���Ľ���
	 * @param datas
	 * ����
	 * @param len
	 * ���ȣ��ر�ע����㷽ʽ����
	 * �紫��ĳ��Ȳ���Ϊlen��lenһ����8�ı�����������ĳ��ȼ�Ϊlen���ɣ�����ʵ�ʵĳ��ȿ��ܱ�lenС��
		����ֻҪ���ݱ��Ľ�����ɼ��ɣ�����ı��Ĳ��ٽ�����
	 * @return
	 * 
	 */
	public native static byte[] DecryptMsg(byte datas[], int len);

}
