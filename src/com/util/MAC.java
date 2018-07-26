package com.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MAC {

    public static String getLocalMac() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            //获取网卡，获取地址
            byte[] mac = new byte[0];
            mac = NetworkInterface.getByInetAddress(addr).getHardwareAddress();

            StringBuffer sb = new StringBuffer("");
            for(int i=0; i<mac.length; i++) {
                if(i!=0) {
                    sb.append(":");
                }
                //字节转换为整数
                int temp = mac[i]&0xff;
                String str = Integer.toHexString(temp);
                if(str.length()==1) {
                    sb.append("0"+str);
                }else {
                    sb.append(str);
                }
            }
            return sb.toString().toLowerCase();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getLocalMac());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
