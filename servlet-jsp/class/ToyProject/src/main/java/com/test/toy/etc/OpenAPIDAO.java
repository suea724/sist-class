package com.test.toy.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class OpenAPIDAO {

	public ResultDTO search(HashMap<String, String> map) {
		
		String clientId = "VOVGvRfywj1aG1Fz332E"; //애플리케이션 클라이언트 아이디값"
	    String clientSecret = "22cJ7nSuLq"; //애플리케이션 클라이언트 시크릿값"


	    String text = null;
	    try {
	        text = URLEncoder.encode(map.get("query"), "UTF-8");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("검색어 인코딩 실패",e);
	    }


	    String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&start=" + map.get("currentPage") ;    // json 결과
	    //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


	    Map<String, String> requestHeaders = new HashMap<>();
	    requestHeaders.put("X-Naver-Client-Id", clientId);
	    requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	    String responseBody = get(apiURL,requestHeaders);


	    // System.out.println(responseBody); > 검색 결과를 json으로 출력
	    
	    // Java <-> JSON : JSON Simple 라이브러리 사용
	    
	    try {
			JSONParser parser = new JSONParser();
			
			JSONObject obj = (JSONObject)parser.parse(responseBody);
			
			// System.out.println(obj.get("total"));
			
			JSONArray list = (JSONArray)obj.get("items");
			
			ArrayList<BookDTO> blist = new ArrayList<>();
			
			// 책 리스트
			for (Object item : list) {
				BookDTO dto = new BookDTO();
				JSONObject book = (JSONObject)item;
				
				dto.setAuthor((String)book.get("author"));
				dto.setDiscount((String)book.get("discount"));
				dto.setImage((String)book.get("image"));
				dto.setLink((String)book.get("link"));
				dto.setPrice((String)book.get("price"));
				dto.setPubdate((String)book.get("pubdate"));
				dto.setPublisher((String)book.get("publisher"));
				dto.setTitle((String)book.get("title"));
				
				blist.add(dto);
			}
			
			ResultDTO rdto = new ResultDTO();
			rdto.setList(blist);
			rdto.setTotal(obj.get("total").toString()); // 검색 결과 수
			
			return rdto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return null;
	}


private static String get(String apiUrl, Map<String, String> requestHeaders){
    HttpURLConnection con = connect(apiUrl);
    try {
        con.setRequestMethod("GET");
        for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
            con.setRequestProperty(header.getKey(), header.getValue());
        }


        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
            return readBody(con.getInputStream());
        } else { // 에러 발생
            return readBody(con.getErrorStream());
        }
    } catch (IOException e) {
        throw new RuntimeException("API 요청과 응답 실패", e);
    } finally {
        con.disconnect();
    }
}


private static HttpURLConnection connect(String apiUrl){
    try {
        URL url = new URL(apiUrl);
        return (HttpURLConnection)url.openConnection();
    } catch (MalformedURLException e) {
        throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
    } catch (IOException e) {
        throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
    }
}


private static String readBody(InputStream body){
    InputStreamReader streamReader = new InputStreamReader(body);


    try (BufferedReader lineReader = new BufferedReader(streamReader)) {
        StringBuilder responseBody = new StringBuilder();


        String line;
        while ((line = lineReader.readLine()) != null) {
            responseBody.append(line);
        }


        return responseBody.toString();
    } catch (IOException e) {
        throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
    }
}
}
