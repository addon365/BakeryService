package com.addon.BakeryService.controllers;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.Sms;
import com.addon.BakeryService.models.UOM;
import com.addon.BakeryService.models.repos.SmsRepository;

@RestController
@RequestMapping("/api/sms")
@CrossOrigin(origins = "http://localhost:4200")
public class SmsController {
	
	
	@Autowired
	SmsRepository smsRepository;
	
	
	
	
	@PostMapping("/ordermsg")
	public void orderSms(@RequestBody Sms sms) {
		try {
			String message = sms.getMessage();
			String requestUrl = "https://smsapi.24x7sms.com/api_2.0/SendSMS.aspx?" +
			"APIKEY=" + "8Xt6aBwiQoy" +
			"&MobileNo=" + sms.getMobile() +
			"&SenderID=" + "ANUMOD" +
			"&Message=" + URLEncoder.encode(message, "UTF-8") +
			"&ServiceName=" + "TEMPLATE_BASED";
			URL url = new URL(requestUrl);
			HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
			httpsCon.setRequestMethod("GET");
			httpsCon.setConnectTimeout(10000);
			int intresult = httpsCon.getResponseCode();
			String strresult = httpsCon.getResponseMessage();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpsCon.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
			{
			response.append(inputLine);
			}
			in.close();
			smsRepository.save(sms);
			httpsCon.disconnect();
			} catch (Exception e) {
			System.out.println("Error SMS "+e);
		}
	}
	
	@PostMapping("/deliverymsg")
	public void deliverySms(@RequestBody Sms sms) {
		try {
			String message = sms.getMessage();
			String requestUrl = "https://smsapi.24x7sms.com/api_2.0/SendSMS.aspx?" +
			"APIKEY=" + "8Xt6aBwiQoy" +
			"&MobileNo=" + sms.getMobile() +
			"&SenderID=" + "ANUMOD" +
			"&Message=" + URLEncoder.encode(message, "UTF-8") +
			"&ServiceName=" + "TEMPLATE_BASED";
			URL url = new URL(requestUrl);
			HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
			httpsCon.setRequestMethod("GET");
			httpsCon.setConnectTimeout(10000);
			int intresult = httpsCon.getResponseCode();
			String strresult = httpsCon.getResponseMessage();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpsCon.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
			{
			response.append(inputLine);
			}
			in.close();
			smsRepository.save(sms);
			httpsCon.disconnect();
			} catch (Exception e) {
			System.out.println("Error SMS "+e);
		}
	}
}
