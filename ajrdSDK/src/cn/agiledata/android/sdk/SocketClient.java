package cn.agiledata.android.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import android.os.Handler;
import android.os.Message;

import com.ajrd.SafeSoft;
import com.ajrd.android.util.DigitalTrans;
import com.ajrd.android.util.MyUtil;
import com.ajrd.android.util.RequestUtil;

/**
 * SocketͨѶ��
 * @author Shawn
 *
 */
public final class SocketClient extends Thread{
	
	private static String IP = "211.147.70.11";
	private static int PORT = 6613;
	private String mIp;
	private int mPort;
	private Socket client;
	private InputStream is;
	private OutputStream os;
	private byte[] mRequest;
	private Handler mHandler;
	public SocketClient(String ip,int port,byte[] request,Handler handler){
		mIp=ip;
		mPort=port;
//		mRequest = request;
		//==============�����ȫ���ģ����м���==============

		byte[] datas = MyUtil.subBytes(request,4,request.length-4);
		int len=MyUtil.getMyDataLen(Integer.parseInt(new String(MyUtil.cutOutByte(request,4))));
		byte[] len2 = MyUtil.subBytes(request,0,4);
		int len3 = Integer.parseInt(new String(len2));
		
		byte[] mydatas = SafeSoft.EncryptMsg(datas,len3);
		mRequest = RequestUtil.getMiWenData4(len,mydatas);
		
		
		//==============�����ȫ���ģ����м���==============
		mHandler = handler;
		client = new Socket();
		System.out.println("mRequest����:"+DigitalTrans.byte2hex(mRequest));
	}
	
	
	public SocketClient(byte[] request,Handler handler){
		mIp=IP;
		mPort=PORT;
//		mRequest = request;
		//==============�����ȫ���ģ����м���==============

		byte[] datas = MyUtil.subBytes(request,4,request.length-4);
		int len=MyUtil.getMyDataLen(Integer.parseInt(new String(MyUtil.cutOutByte(request,4))));
		byte[] len2 = MyUtil.subBytes(request,0,4);
		int len3 = Integer.parseInt(new String(len2));
		
		byte[] mydatas = SafeSoft.EncryptMsg(datas,len3);
		mRequest = RequestUtil.getMiWenData4(len,mydatas);
		
		
		//==============�����ȫ���ģ����м���==============
		mHandler = handler;
		client = new Socket();
		System.out.println("mRequest����:"+DigitalTrans.byte2hex(mRequest));
	}
	
	
	@Override
	public void run() {
		try {
			System.out.println("SocketClient-----run()");
			InetSocketAddress addr = new InetSocketAddress(mIp, mPort);
//			client = new Socket(mIp, mPort);
			client.connect(addr, 60000);
			if(client.isConnected()&&!client.isInputShutdown()){
				os = client.getOutputStream();
				is = client.getInputStream();
				os.write(mRequest);
				os.flush();
				Thread.sleep(2000);
				//---------������Ҫ�ģ����û�з��ص�ʱ�򣬻�����ѭ����---
				int len=0;
				while(len==0){
					len= is.available();
				}
				byte[] bytes=new byte[len];
				is.read(bytes);
				//======================�������ȫ���Ľ���=============================
				System.out.println("response���ģ�"+DigitalTrans.byte2hex(bytes));
				//���ĳ���
				byte[] b_ret_miwen_len = MyUtil.subBytes(bytes,0,4);
				//���ĳ��ȣ�����
				int int_ret_miwen_len = Integer.parseInt(new String(b_ret_miwen_len));
				System.out.println("int_ret_miwen_len:"+""+int_ret_miwen_len);
				//�����������ݣ�����������
				byte[] b_ret_miwen_datas = MyUtil.subBytes(bytes,4,bytes.length-4);
				//���ܺ�ķ��ر��ģ�����������
				byte[] m_ret_minwen_datas = SafeSoft.DecryptMsg(b_ret_miwen_datas, int_ret_miwen_len);
				
				//���ܺ�ķ��ر��ģ����ϱ��ĳ���
				byte[] m_ret_minwen_datas_append_header_len = RequestUtil.getMiWenData(m_ret_minwen_datas);
				//--------------------
				String hex_response = DigitalTrans.byte2hex(m_ret_minwen_datas_append_header_len);
				System.out.println("response����:"+hex_response);
				//======================�������ȫ���Ľ���=============================
				//����ɹ����أ����������������洦��
				if(hex_response!=null&&hex_response.length()>0){
					Message message = new Message();
					message.what = RequestUtil.REQUEST_SUCCESS;
					message.obj = hex_response;
					mHandler.sendMessage(message);
				}else{
					//û�з����⣬���ͻ�ȡ����ʧ�ܣ������洦��
					Message message = new Message();
					message.what = RequestUtil.REQUEST_FAIELD;
					mHandler.sendMessage(message);
				}
			
			}
		}catch(SocketTimeoutException e){
			e.printStackTrace();
			Message message = new Message();
			message.what = RequestUtil.REQUEST_FAIELD;
			message.obj = "���ӳ�ʱ";
			mHandler.sendMessage(message);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			Message message = new Message();
			message.what = RequestUtil.REQUEST_FAIELD;
			message.obj = "������Ϊ��������������ԭ�������Ϸ�����";
			mHandler.sendMessage(message);
			
		} catch (IOException e) {
			e.printStackTrace();
			Message message = new Message();
			message.what = RequestUtil.REQUEST_FAIELD;
			message.obj = "�����쳣";
			mHandler.sendMessage(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Message message = new Message();
			message.what = RequestUtil.REQUEST_FAIELD;
			message.obj = e.getMessage();
			mHandler.sendMessage(message);
		} 
		finally{
			try{
				if(client!=null){
					os.close();
					is.close();
					client.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	

}
