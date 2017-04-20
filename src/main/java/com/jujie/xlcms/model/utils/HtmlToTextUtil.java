package com.jujie.xlcms.model.utils;

public class HtmlToTextUtil {

	
	//去除标签得到文字
public  String htmlToText(String htmlText){
	
    String textcontent = htmlText.replaceAll("</?[^>]+>", ""); //剔出<html>的标�?  
    textcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");//去除字符串中的空�?,回车,换行�?,制表�?  
      
    return textcontent;
}


 
}
