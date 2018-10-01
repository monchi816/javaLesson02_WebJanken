package webJanken;



public class Player {

		//じゃんけんの手
		public final static int GOO = 0;
		public final static int CHOKI = 1;
		public final static int PA = 2;

		//Playerの名前
		private String name;


		/**
		 * コンストラクタ
		 * @param name
		 */
		public Player(String name){
			this.name = name;
		}


		/**
		 * 名前(name)を返すメソッド
		 * @return
		 */
		public String getName(){
			return name;
		}

		/**
		 * 手(hand)を返すメソッド
		 */
		public int getHand(){
			//手を選ぶ
			return selectHand();
		}

		/**
		 * 手(hand)を選択するメソッド
		 */
		private int maxSize = 3;
		private int selectHand(){
			//乱数を利用して手を選択する
			return (int)(Math.random()*maxSize);
		}


		public static String valueOf(int hand){
			String handText = null;

			switch(hand){
				case GOO:
					handText = "GOO";
					break;
				case CHOKI:
					handText = "CHOKI";
					break;
				case PA:
					handText = "PA";
					break;
				default:
					handText = "";
				break;
			}
				return handText;
		}
}
