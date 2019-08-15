import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kadai2_poker {

	public static void main(String[] args) {

		String card = null;
        String[] column = {};
        String[] pattern = new String[5];
        String[] cnumber = new String[5];
        int[] number = new int[5];
        int min = 0;
        int j = 1;
        int k = 0;
        int cnt = 0;
        boolean a = false;	//ロイヤル判断
        boolean qwe = true;
        boolean rty = true;
        boolean straight = false;
        boolean flush = false;
        boolean four_of_a_kind = false;
        boolean three_of_a_kind = false;
        boolean full_house = false;
        boolean two_pair = false;
        boolean a_pair = false;

        //カード情報入力
		InputStreamReader asd = new InputStreamReader(System.in);
        BufferedReader str = new BufferedReader(asd);
        System.out.println("カードの情報を入力");
        try {
			card = str.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        for(int i = 0; i < 5; i++){
        	column = card.split(" ", 0);
        }
        for(int i = 0; i < 5; i++){
        	pattern[i] = column[i].substring(0, 1);
        	cnumber[i] = column[i].substring(1);
        }
        for(int i = 0; i < 5; i++){
        	if(cnumber[i].equals("A")){
        		number[i] = 1;
        	}else if(cnumber[i].equals("J")){
        		number[i] = 11;
        	}else if(cnumber[i].equals("Q")){
        		number[i] = 12;
        	}else if(cnumber[i].equals("K")){
        		number[i] = 13;
        	}else{
        		number[i] = Integer.parseInt(cnumber[i]);
        	}
        }


        //ポーカーの役判定
        //ストレート
        min = number[0];
        for (int i=1; i < number.length; i++) {
			if (min > number[i]) {
				min = number[i];
			}
		}
        if(min == 1){
        	for(int i = 0; i < number.length && !a; i++){
        		if(number[i] == 10){
        			min = 10;
        			a = true;
        		}
        	}
        }
        for(int i = 0; i < number.length -1 && qwe; i++){
        	rty = false;
        	int zxc = min + j;
        	j++;
        	k = 0;
        	while(k < number.length){
        		if(!a){
        			if(number[k] == zxc){
        				rty = true;
        				break;
        			}
        		}else{
        			if(number[k] != 1){
        				if(number[k] == zxc){
        					rty = true;
        					break;
        				}
        			}else{
        				rty = true;
        			}
        		}
        		k++;
        	}
        	if(!rty){
        		qwe = false;
        	}
        }
        if(qwe){
        	straight = true;
        }
        //if(straight){
        //	System.out.println("この手札はストレートです");
        //}
        //フラッシュ
        qwe = true;
        for(int i = 0; i < number.length -1 && true; i++){
        	if(pattern[0].equals(pattern[i + 1])){
        	}else{
        		qwe = false;
        		break;
        	}
        }
        if(qwe){
        	flush = true;
        }
        //if(flush){
        //	System.out.println("この手札はフラッシュです");
        //}
        //フォーカード
        qwe = true;
        for(int i = 1;i < number.length; i++){
        	if(number[0] == number[i]){
        		cnt++;
        	}
        }
        if(cnt >= 3){
        	four_of_a_kind = true;
        }
        if(!four_of_a_kind){
        	cnt = 0;
        	for(int i = 0; i < 4; i++){
        		if(number[4] == number[i]){
        			cnt++;
        		}
        	}
            if(cnt >= 3){
            	four_of_a_kind = true;
            }
        }
        //if(four_of_a_kind){
        //	System.out.println("この手札はフォーカードです");
        //}
        //スリーカード
        if(!four_of_a_kind){
        	cnt = 0;
            qwe = true;
            for(int i = 1;i < number.length; i++){
            	if(number[0] == number[i]){
            		cnt++;
            	}
            }
            for(int i = 0; i < 4; i++){
            	if(number[4] == number[i]){
            		cnt++;
            	}
            }
            if(number[1] == number[2]){
            	cnt++;
            }
            if(number[1] == number[3]){
            	cnt++;
            }
            if(number[2] == number[3]){
            	cnt++;
            }
            if(cnt == 3){
         	   three_of_a_kind = true;
            }else if(cnt == 4){
         	   full_house = true;
            }
            //if(three_of_a_kind){
            //	System.out.println("この手札はスリーカードです");
            //}
        }
        //ワンペア・ツーペア
        if(!four_of_a_kind && !three_of_a_kind){
            cnt = 0;
            for(int i = 1; i < number.length; i++){
            	if(number[0] == number[i]){
            		cnt++;
            	}
            }
            for(int i = 2; i < number.length; i++){
            	if(number[1] == number[i]){
            		cnt++;
            	}
            }
            for(int i = 3; i < number.length; i++){
            	if(number[2] == number[i]){
            		cnt++;
            	}
            }
            if(number[3] == number[4]){
            	cnt++;
            }
            if(cnt == 2){
            	two_pair = true;
            }else if(cnt == 1){
            	a_pair = true;
            }
            //if(two_pair){
            //	System.out.println("この手札はツーペアです");
            //}
            //if(a_pair){
            //	System.out.println("この手札はワンペアです");
            //}
        }
        //結果出力
        System.out.print("この手札は");
        while(true){
        	if(straight){
        		if(flush){
        			if(a){
        				System.out.println("ロイヤルフラッシュです");
        				break;
        			}else{
        				System.out.println("ストレートフラッシュです");
        				break;
        			}
        		}else{
        			System.out.println("ストレートです");
        			break;
        		}
        	}
        	if(flush){
        		System.out.println("フラッシュです");
        		break;
        	}
        	if(four_of_a_kind){
        		System.out.println("フォーカードです");
        		break;
        	}
        	if(full_house){
        		System.out.println("フルハウスです");
        		break;
        	}
        	if(three_of_a_kind){
        		System.out.println("スリーカードです");
        		break;
        	}
        	if(two_pair){
        		System.out.println("ツーペアです");
        		break;
        	}
        	if(a_pair){
        		System.out.println("ワンペアです");
        		break;
        	}
        	System.out.println("ハイカードです");
        	break;
        }
	}
}
