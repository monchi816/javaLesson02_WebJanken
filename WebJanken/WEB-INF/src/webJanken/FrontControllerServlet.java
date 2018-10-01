package webJanken;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * フロントコントローラクラス
 */

@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {

	//オペレーションID
	private static final String index = "1";
	private static final String jankenResult = "2";

    /**
	 * サーブレットのサービス
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
		String page = "";
		String flag = req.getParameter("flag");
		//String link = req.getParameter("link");

		/*if(link != null) {
			// セッションオブジェクトの獲得
			HttpSession session = null;
			session = req.getSession(false);
			// セッションが存在する場合、セッションを破棄
			if(session != null){
				session.invalidate();
			}
		}*/

		if (flag==null) {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = res.getWriter();
			pw.print("flagがnullです。");
		}

		//ページの設定
		if (flag.equals(index)) {
			page = "/index.jsp";
		}else if(flag.equals(jankenResult)){
			page = "/jankenResult.jsp";
		}

		getServletContext().getRequestDispatcher(page).forward(req,res);
		} catch (Exception e) {
		try {
			PrintWriter pw;
			res.setContentType("text/html;charset=UTF-8");
			pw = res.getWriter();
			pw.print("URLエラー");
			pw.close();
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
	}
}
