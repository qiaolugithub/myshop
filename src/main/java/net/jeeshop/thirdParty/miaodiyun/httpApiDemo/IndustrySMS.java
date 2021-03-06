package net.jeeshop.thirdParty.miaodiyun.httpApiDemo;

import net.jeeshop.thirdParty.miaodiyun.httpApiDemo.common.Config;
import net.jeeshop.thirdParty.miaodiyun.httpApiDemo.common.HttpUtil;
/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	/*private static String to = "15937149616";
	private static String smsContent = "【燊活馆】您的验证码为010101，2分钟内输入有效。";*/

	/**
	 * 验证码通知短信
	 */
	public static String execute(String to,String smsContent)
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
        if(result.indexOf("00104")!=-1) {
            return "您今日的验证码发送次数已经达到上限，请明日再试!";
        }
        if(result.indexOf("00000")!=-1) {
            return "success";
        }
        System.out.println("result:" + System.lineSeparator() + result);
        return "发送失败，稍后重试！";
	}
}
