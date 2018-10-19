
package com.kafang.atgo.restful.sms;

import com.alibaba.fastjson.JSONObject;
import com.kafang.atgo.restful.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JsonReqClient extends AbsRestClient {

	@Value("${rest_server}")
	private String server;

	@Autowired
	private HttpClientUtil httpClientUtil;

	private StringBuffer getStringBuffer() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(server).append("/ol/sms");
		return sb;
	}

	@Override
	public String sendSms(String sid, String token, String appid, String templateid, String param, String mobile,
			String uid) {

		String result = "";

		try {
			String url = getStringBuffer().append("/sendsms").toString();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);

			String body = jsonObject.toJSONString();

			log.info("body = " + body);

			result = httpClientUtil.postJson(url, body, null);

		} catch (Exception e) {
			log.error("sendSms sid:{},token:{},appid:{},templateid:{},param:{},mobile:{},uid:{}, error: {}", sid, token,
					appid, templateid, param, mobile, uid, e);
		}
		return result;
	}

	@Override
	public String sendSmsBatch(String sid, String token, String appid, String templateid, String param, String mobile,
			String uid) {

		String result = "";

		try {
			String url = getStringBuffer().append("/sendsms_batch").toString();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);

			String body = jsonObject.toJSONString();

			log.info("body = " + body);

			result = httpClientUtil.postJson(url, body, null);

		} catch (Exception e) {
			log.error("sendSmsBatch sid:{},token:{},appid:{},templateid:{},param:{},mobile:{},uid:{}, error: {}", sid,
					token, appid, templateid, param, mobile, uid, e);
		}
		return result;
	}

	@Override
	public String addSmsTemplate(String sid, String token, String appid, String type, String template_name,
			String autograph, String content) {

		String result = "";

		try {
			String url = getStringBuffer().append("/addsmstemplate").toString();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("type", type);
			jsonObject.put("template_name", template_name);
			jsonObject.put("autograph", autograph);
			jsonObject.put("content", content);

			String body = jsonObject.toJSONString();

			log.info("body = " + body);

			result = httpClientUtil.postJson(url, body, null);

		} catch (Exception e) {
			log.error(
					"addSmsTemplate sid:{},token:{},appid:{},type:{},template_name:{},autograph:{},content:{}, error: {}",
					sid, token, appid, type, template_name, autograph, content, e);
		}
		return result;
	}

	@Override
	public String getSmsTemplate(String sid, String token, String appid, String templateid, String page_num,
			String page_size) {

		String result = "";

		try {
			String url = getStringBuffer().append("/getsmstemplate").toString();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("page_num", page_num);
			jsonObject.put("page_size", page_size);

			String body = jsonObject.toJSONString();

			log.info("body = " + body);

			result = httpClientUtil.postJson(url, body, null);

		} catch (Exception e) {
			log.error("getSmsTemplate sid:{},token:{},appid:{},templateid:{},page_num:{},page_size:{}, error: {}", sid,
					token, appid, templateid, page_num, page_size, e);
		}
		return result;
	}

	@Override
	public String editSmsTemplate(String sid, String token, String appid, String templateid, String type,
			String template_name, String autograph, String content) {

		String result = "";

		try {
			String url = getStringBuffer().append("/editsmstemplate").toString();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("type", type);
			jsonObject.put("template_name", template_name);
			jsonObject.put("autograph", autograph);
			jsonObject.put("content", content);

			String body = jsonObject.toJSONString();

			log.info("body = " + body);

			result = httpClientUtil.postJson(url, body, null);

		} catch (Exception e) {
			log.error(
					"editSmsTemplate sid:{},token:{},appid:{},type:{},template_name:{},autograph:{},content:{}, error: {}",
					sid, token, appid, type, template_name, autograph, content, e);
		}
		return result;
	}

	@Override
	public String deleterSmsTemplate(String sid, String token, String appid, String templateid) {

		String result = "";

		try {
			String url = getStringBuffer().append("/deletesmstemplate").toString();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);

			String body = jsonObject.toJSONString();

			log.info("body = " + body);

			result = httpClientUtil.postJson(url, body, null);

		} catch (Exception e) {
			log.error("editSmsTemplate sid:{},token:{},appid:{},templateid:{}, error: {}", sid, token, appid,
					templateid, e);
			log.error("", e);
		}
		return result;
	}

}
