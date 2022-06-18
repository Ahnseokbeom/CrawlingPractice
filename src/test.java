import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class test {
	public static void main(String[] args) throws IOException{
		// 각티어별 문제 총 페이지 수 계산
		Document doc = Jsoup.connect("https://solved.ac/ranking/o/309").get();
		Elements a = doc.select("div.css-qijqp5 a");
		System.out.println(a.get(1).text());
		Document doc2 = Jsoup.connect("https://solved.ac/profile/shg9411/solved").get();
		Elements d = doc2.select("div.css-qijqp5 td");
		System.out.println(d.get(0).text()+" "+d.get(4).text()+" "+d.get(8).text());
		System.out.println(d.get(396).text());

//		System.out.println(Arrays.toString(str));
//		System.out.println(str[0]+" "+str[2]+" "+str[199]);

	}

}
