package java_jericho_parsing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

public class Test {
	
	public static void main(String args[]) throws MalformedURLException, IOException {
		String url = "http://lol.inven.co.kr/dataninfo/champion/manualTool.php";
		
		//해당 URL 페이지를 가져온다.
        Source source = new Source(new URL(url));
        
        //메소드 찾기를 위해 시작부터 끝까지 태그들만 parse 한다     
        source.fullSequentialParse();                
        
        //class명이 scrollingList인 요소들을 모두 읽는다.
        List<Element> element = source.getAllElementsByClass("scrollingList");
        
        //위에서 일어들인 요소들중에서 A태그를 저장한다/
        List<Element> Atag = element.get(0).getAllElements(HTMLElementName.A);
                
        //챔프이름과 주소를 저장하기 위한 해쉬맵
        HashMap<String , String> champInfoMap = new HashMap<String , String>();
        
        
        for(Element obj : Atag){
        	
        	//저장을 위한 임시 변수선언 및 초기화
        	String tmp_champName = obj.getTextExtractor().toString();
        	String tmp_champAdress = obj.getAttributeValue("href");

        	//A태그중에 이름과 주소만 있는 A태그만 필요하고 Img태그가 들어있는
        	//A태그는 필요하지 않기때문에 A태그의 문자열이 공백일때는 저장하지않는다.
        	if(! tmp_champName.equals("") ){        		
        		champInfoMap.put(tmp_champName, tmp_champAdress);
        	}
        }
        
        
        
        
	}
		
}

