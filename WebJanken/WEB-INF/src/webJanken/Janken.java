package webJanken;


/**
 * じゃんけんを実行するメインクラス
 */
public class Janken {

	public JankenEntity DoJanken(int players){

		Judge judge = null;

		if(players >= 1){
			try{
				judge = new Judge(players);
			}catch(NumberFormatException ex){
				System.out.println("どっかでエラーだお。頑張って探してね。");
			}
		}
		else{
			System.out.println("プレイヤーの人数が適切ではありません。");
		}

		JankenEntity jankenEntity = judge.playGame();

		return jankenEntity;
	}
}



