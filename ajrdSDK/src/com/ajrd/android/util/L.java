package com.ajrd.android.util;

public class L {
	public static boolean isDebug = true;
	
	public static boolean LoginDebug = false;

	public static boolean ConsumeDebug = false;
	
	//��ȡ��֤�����
	public static boolean GetSyntaCodeDebug = false;
	/**
	 * ��ѯ����
	 */
	public static boolean QUERY_DEBUG = false;
	/**
	 * ��ȡ���ѡ���ֵ�б����
	 */
	public static boolean GET_DEAL_LIST_DEBUG  = false;
	
	
	/**
	 * �����MEP�ϰ�Ļ������Բ��Բ鿴����Ա���Ľ��׻���
	 */
	public static final boolean MEP_BOSS_TEST = false;
	
	/**
	 * û���������
	 */
	public static boolean NO_NET_DEBUG = false;
	
	/**
	 * û�г�ֵ�ͳ�ֵ�������ݵ���
	 */
	public static boolean NOT_RECHARGE_DEBUG = false;
	
	/**
	 * û������
	 */
	public static boolean NO_CARD_DEBUG = false;
	
	/**
	 * û���ֻ�
	 */
	public static boolean NO_PHONE = false;
	
	
	/**
	 * �������ز�����
	 */
	public static boolean NO_DUAN_XIN_WANG_GUAN = true;
	
	/**
	 * ���ѵ�ʱ���Ƿ񱣴���֤����Ϣ
	 */
	public static boolean IS_SAVE_CHECK_CODE = false;
	
	
	public static void v(String tag, String msg) {
		if (isDebug)
			android.util.Log.v(tag, msg);
	}

	public static void v(String tag, String msg, Throwable t) {
		if (isDebug)
			android.util.Log.v(tag, msg, t);
	}

	public static void d(String tag, String msg) {
		if (isDebug)
			android.util.Log.d(tag, msg);
	}

	public static void d(String tag, String msg, Throwable t) {
		if (isDebug)
			android.util.Log.d(tag, msg, t);
	}

	public static void i(String tag, String msg) {
		if (isDebug)
			android.util.Log.i(tag, msg);
	}

	public static void i(String tag, String msg, Throwable t) {
		if (isDebug)
			android.util.Log.i(tag, msg, t);
	}

	public static void w(String tag, String msg) {
		if (isDebug)
			android.util.Log.w(tag, msg);
	}

	public static void w(String tag, String msg, Throwable t) {
		if (isDebug)
			android.util.Log.w(tag, msg, t);
	}

	public static void e(String tag, String msg) {
		if (isDebug)
			android.util.Log.e(tag, msg);
	}

	public static void e(String tag, String msg, Throwable t) {
		if (isDebug)
			android.util.Log.e(tag, msg, t);
	}
}
