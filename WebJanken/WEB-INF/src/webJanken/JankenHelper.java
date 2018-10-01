package webJanken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * index.jspのヘルパークラス
 */

public class JankenHelper {

	//コンストラクタ用の変数宣言
	private Janken janken = null;

	/**
	 * コンストラクタ
	 */
	public JankenHelper () {
			janken = new Janken();

	}

	/**
	 * フォームで指定された人数をJankenクラスに渡し、実行結果を得る。
	 */
	public JankenEntity getJankenResult(HttpServletRequest req) {

		JankenEntity jankenEntity = null;

		//フォームで指定された対戦人数を取得する
		int players = Integer.parseInt(req.getParameter("persons"));

		jankenEntity = janken.DoJanken(players);


		//セッションオブジェクトの獲得
		HttpSession session = null;
		session = req.getSession(false);

		//セッションにminfoエンティティをセット
		session.setAttribute("jankenResult", jankenEntity);

		return jankenEntity;


	}

}