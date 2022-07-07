package com.test.toy.etc;

import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03 {
	
	public static void main(String[] args) {
		
		try {
			
			// 크롤링한 데이터 DB에 insert
			
			System.out.println("현재 상영작");
			
			String url = "https://movie.naver.com/movie/running/current.naver";
			
			Document doc = Jsoup.connect(url).get();
			
			Elements list = doc.select("#content .lst_detail_t1 > li");
			
			EtcDAO dao = new EtcDAO();
			
			for (Element item : list) {
				
				// item == <li>
				
				// 영화 제목
				String title = item.select(".tit > a").text();
				// System.out.println(title);
				
				// 개요
				String category = item.select(".info_txt1 dd:nth-child(2) .link_txt").text();
				// System.out.println(category);
				
				String dd = item.select(".info_txt1 dd:nth-child(2)").text();
				String[] temp = dd.split(" \\| ");
				
				System.out.println(Arrays.toString(temp));
				
				String time = "";
				String rdate = "";
				
				if (temp.length == 3) {
					
					// 상영 시간
					 time = temp[1].replace("분", "");
					
					// 개봉일
					rdate = temp[2].replace("개봉", "");
					
				} else if (temp.length == 2) {
					
					// 상영 시간
					 time = temp[0].replace("분", "");
					
					// 개봉일
					rdate = temp[1].replace("개봉", "");
					
				}
				
				// 감독
				String director = item.select(".info_txt1 dd:nth-child(4) span").text();
				
				// 출연
				String actor = item.select(".info_txt1 dd:last-child span").text();
				
				// 포스터
				String poster = item.select(".thumb img").attr("src");
				
				MovieDTO dto = new MovieDTO();
				
				dto.setActor(actor);
				dto.setCategory(category);
				dto.setDirector(director);
				dto.setPoster(poster);
				dto.setRdate(rdate);
				dto.setTime(time);
				dto.setTitle(title);
				
				System.out.println(dao.addMovie(dto));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
