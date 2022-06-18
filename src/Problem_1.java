import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Problem_1 {
	public static void main(String[] args) throws IOException{
		int t = 1;
		// 티어별 0~30까지
		while(t<=30) {
			System.out.println(t);
		Document doc = Jsoup.connect("https://solved.ac/problems/level/"+t).get();
		Elements d1 = doc.select("div.css-18lc7iz a");
		String[] str = d1.text().split(" ");
		System.out.println(str[str.length-1]);
		for(int j = 1;j<=Integer.parseInt(str[str.length-1]);j++) {
			doc = Jsoup.connect("https://solved.ac/problems/level/"+t+"?page="+j).get();
			Elements d2 = doc.select("div.css-qijqp5 a");
		for(int i = 0;i<d2.size();i+=2) {
			System.out.println(d2.get(i).text()+" "+d2.get(i+1).text());
				}
			}
		t++;
		}
	}
}
