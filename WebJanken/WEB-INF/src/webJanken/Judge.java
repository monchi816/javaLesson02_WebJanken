package webJanken;

import java.util.ArrayList;
import java.util.List;

public class Judge {

	private List<Player> players;
	private List<Integer> hands;

	/**
	 * コンストラクタ
	 * 引数はプレイヤーの数
	 */
	public Judge(int playerSize){
		players = new ArrayList<Player>();
		hands = new ArrayList<Integer>();

		//プレイヤーに番号を振る
		for(int i = 0 ; i < playerSize ; i++){
			players.add(new Player("Player"+i));
		}
	}

	/**
	 * じゃんけん実行メソッド
	 */
	public JankenEntity playGame(){
		//プレイヤーの手を決定
		for(int i = 0 ; i < players.size() ; i++){
			Player player = (Player)players.get(i);
			int hand = player.getHand();
			hands.add(new Integer(hand));	//Listにはクラス以外入らないのでintの代わりにIntegerクラスにキャスト
		}

		//勝負の判定する
		List<Player> winners = judge(hands);

		JankenEntity jankenEntity = new JankenEntity(winners, players, hands);

		return jankenEntity;
	}

	/**
	 * じゃんけんの判定をするメソッド
	 */
	private List<Player> judge(List<Integer> hands){

		List<Player> gooPlayers = new ArrayList<Player>();
		List<Player> chokiPlayers = new ArrayList<Player>();
		List<Player> paPlayers = new ArrayList<Player>();

		classify(gooPlayers, chokiPlayers, paPlayers, hands);

		if(gooPlayers.isEmpty()){
			if(chokiPlayers.isEmpty()){
				//全員パー
				return new ArrayList<Player>();	//あいこ
			}
			else{
				if(paPlayers.isEmpty()){
					//全員チョキ
					return new ArrayList<Player>();
				}
				else{
					//チョキとパーでチョキの勝ち
					return chokiPlayers;
				}
			}
		}
		else if(chokiPlayers.isEmpty()){
			if(paPlayers.isEmpty()){
				//全員グー
				return new ArrayList<Player>();
			}
			else{
				//パーとグーでパーの勝ち
				return paPlayers;
			}
		}
		else if(paPlayers.isEmpty()){
			//グーとチョキでグーの勝ち
			return gooPlayers;
		}
		else{
			//グー、チョキ、パーであいこ
			return new ArrayList<Player>();
		}
	}

	/**
	 * 選択された手を数字から文字に変換する
	 */
	private void classify(List<Player> gooPlayers, List<Player> chokiPlayers,
			List<Player> paPlayers, List<Integer> hands){

		for(int i = 0 ; i < hands.size() ; i++ ){
			int hand = ((Integer)hands.get(i)).intValue();
			switch(hand){
				case Player.GOO:
					gooPlayers.add(players.get(i));
					break;
				case Player.CHOKI:
					chokiPlayers.add(players.get(i));
					break;
				case Player.PA:
					paPlayers.add(players.get(i));
					break;
				default:
					break;
			}
		}
	}
}
