package webJanken;

import java.util.List;

/**
 * じゃんけんに関する情報を保持するエンティティクラス
 */

public class JankenEntity {

	//じゃんけんに関する情報を保持するList
	private List<Player> winners;			//勝者の情報
	private List<Player> players;			//対戦者の情報
	private List<Integer> hands;			//対戦者の手の情報


	/**
	 * コンストラクタ
	 */
	public JankenEntity() {

	}

	/**
	 * コンストラクタ
	*/

	public JankenEntity(List<Player> winners, List<Player> players, List<Integer> hands) {
		this.winners = winners;
		this.players = players;
		this.hands = hands;
	}

	//getter
	/**
	 * 勝者情報を取得
	 * @return 勝者情報
	 */
	public List<Player> getWinners() {
		return winners;
	}

	/**
	 * 対戦者情報を取得
	 * @return 対戦者情報
	 */
	public List<Player> getPlayers() {
		return players;
	}
	/**
	 * 対戦者の手の情報を取得
	 * @return 対戦者の手の情報
	 */
	public List<Integer> getHands() {
		return hands;
	}


	//setter
	/**
	 * 勝者情報の設定
	 * @param winners 勝者情報
	 */
	public void setWinners(List<Player> winners) {
		this.winners = winners;
	}

	/**
	 * 対戦者情報の設定
	 * @param players 対戦者情報
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * 対戦者の手の情報の設定
	 * @param hands 対戦者の手の情報
	 */
	public void setHands(List<Integer> hands) {
		this.hands = hands;
	}
}
