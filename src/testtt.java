import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class testtt {
	public static void main(String[] args) throws IOException{
		String id = null;
		String sql = null;
		int num = 0;
		int n = 0;
		int p = 4;
		Document doc = Jsoup.connect("https://solved.ac/ranking/o/309#").get();
		Elements name = doc.select("div.css-qijqp5 a");
//		System.out.println(name.text());
		try {
			java.sql.Statement st = null;
			ResultSet rs = null;
			Connection con = null;
			// mysql 연결
			con = DriverManager.getConnection("jdbc:mysql://3.39.230.170:3306/?serverTimezone=UTC&useSSL=false &allowPublicKeyRetrieval=true",
					"Project", "testing00");
			st = con.createStatement();
			// database 선택
			st.executeUpdate("use SWP;");
		Document doc2 = Jsoup.connect("https://solved.ac/profile/"+name.get(36).text()+"/solved").get();
		System.out.println(name.get(36).text());
		Elements page = doc2.select("div.css-18lc7iz a");
		System.out.println(page);
		String[] str = page.text().split(" ");
		System.out.println(str[str.length-1]);
		for(int i = 0;i<Integer.parseInt(str[str.length-1]);i++) {
			Document doc3 = Jsoup.connect("https://solved.ac/profile/"+name.get(36).text()+"/solved?page="+i).get();
			Elements problem = doc3.select("div.css-qijqp5 td");
			System.out.println(problem.text());
			for(int j = 0;j<(problem.size()/4)-1;j++) {
				id = name.get(36).text();
				num = Integer.parseInt(problem.get(p).text());
				p+=4;
				System.out.println(id+" "+num);
				sql = "insert into Solve(USER_ID, PROBLEM_ID) values(?, ?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				pst.setInt(2, num);
				pst.execute();
				pst.close();
		}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
