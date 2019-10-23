package com.microfragment.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
public class PhoneCode {

	private static String code ;
	
	public static void main(String[] args) {
		String phone = "13216161915"; //姝ゅ鍙緭鍏ヤ綘鐨勬墜鏈哄彿鐮佽繘琛屾祴璇�
		getPhonemsg(phone);
		
	}

	public static String getPhonemsg(String mobile) {
		 
		System.out.println(mobile);
		if (mobile == null || mobile == "") {
			
			return "";
		} 
		
		System.setProperty(StaticPeram.defaultConnectTimeout, StaticPeram.Timeout);
		System.setProperty(StaticPeram.defaultReadTimeout, StaticPeram.Timeout);
		
		final String product = StaticPeram.product;
		final String domain = StaticPeram.domain;
		
		final String accessKeyId = StaticPeram.accessKeyId;
		final String accessKeySecret = StaticPeram.accessKeySecret;
		
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
				accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
					domain);
		} catch (ClientException e1) {
			e1.printStackTrace();
		}
		
		//鑾峰彇楠岃瘉鐮�
		code = vcode();
		
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 缁勮璇锋眰瀵硅薄
		SendSmsRequest request = new SendSmsRequest();
		// 浣跨敤post鎻愪氦
		request.setMethod(MethodType.POST);
		// 蹇呭～:寰呭彂閫佹墜鏈哄彿銆傛敮鎸佷互閫楀彿鍒嗛殧鐨勫舰寮忚繘琛屾壒閲忚皟鐢紝鎵归噺涓婇檺涓�1000涓墜鏈哄彿鐮�,鎵归噺璋冪敤鐩稿浜庡崟鏉¤皟鐢ㄥ強鏃舵�х◢鏈夊欢杩�,楠岃瘉鐮佺被鍨嬬殑鐭俊鎺ㄨ崘浣跨敤鍗曟潯璋冪敤鐨勬柟寮�
		request.setPhoneNumbers(mobile);
		// 蹇呭～:鐭俊绛惧悕-鍙湪鐭俊鎺у埗鍙颁腑鎵惧埌
		request.setSignName(StaticPeram.SignName);
		// 蹇呭～:鐭俊妯℃澘-鍙湪鐭俊鎺у埗鍙颁腑鎵惧埌
		request.setTemplateCode(StaticPeram.TemplateCode);
		// 鍙��:妯℃澘涓殑鍙橀噺鏇挎崲JSON涓�,濡傛ā鏉垮唴瀹逛负"浜茬埍鐨�${name},鎮ㄧ殑楠岃瘉鐮佷负${code}"鏃�,姝ゅ鐨勫�间负
		// 鍙嬫儏鎻愮ず:濡傛灉JSON涓渶瑕佸甫鎹㈣绗�,璇峰弬鐓ф爣鍑嗙殑JSON鍗忚瀵规崲琛岀鐨勮姹�,姣斿鐭俊鍐呭涓寘鍚玕r\n鐨勬儏鍐靛湪JSON涓渶瑕佽〃绀烘垚\\r\\n,鍚﹀垯浼氬鑷碕SON鍦ㄦ湇鍔＄瑙ｆ瀽澶辫触
		request.setTemplateParam("{\"code\":\""+code+"\"}");//{ \"number\":\""+code+"\"}
		// 鍙��-涓婅鐭俊鎵╁睍鐮�(鏃犵壒娈婇渶姹傜敤鎴疯蹇界暐姝ゅ瓧娈�)
		// request.setSmsUpExtendCode("90997");
		// 鍙��:outId涓烘彁渚涚粰涓氬姟鏂规墿灞曞瓧娈�,鏈�缁堝湪鐭俊鍥炴墽娑堟伅涓皢姝ゅ�煎甫鍥炵粰璋冪敤鑰�
		request.setOutId("yourOutId");
		// 璇锋眰澶辫触杩欓噷浼氭姏ClientException寮傚父
		SendSmsResponse sendSmsResponse;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
			if (sendSmsResponse.getCode() != null
					&& sendSmsResponse.getCode().equals("OK")) {
				// 璇锋眰鎴愬姛
				System.out.println("鑾峰彇楠岃瘉鐮佹垚鍔燂紒锛侊紒");
			} 
			else{
				System.out.println(sendSmsResponse.getCode());
				System.out.println("鑾峰彇楠岃瘉鐮佸け璐�...");
			} 
		} catch (ServerException e) {
			e.printStackTrace();
			return "鐢变簬绯荤粺缁存姢锛屾殏鏃舵棤娉曟敞鍐岋紒锛侊紒";
		} catch (ClientException e) {
			e.printStackTrace();
			return "鐢变簬绯荤粺缁存姢锛屾殏鏃舵棤娉曟敞鍐岋紒锛侊紒";
		}
		return code;
	}

	public static String vcode(){
		String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
	}

}
