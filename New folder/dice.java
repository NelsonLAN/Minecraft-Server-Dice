import java.util.*;
public class dice{
	public static void main(String[] args){		
		int[] dice = new int[99];		
		int proceed = 1;  // proceed != 0 == Continue to roll another dice set

		Scanner input = new Scanner(System.in);
		while (proceed !=0){		
			System.out.print("\n Continue? If NOT, enter other number exclude '0'. ");
			proceed = input.nextInt();
			if (proceed == 0){
				System.out.print("End program.");
				break;
			}
			int qty = 0;
			int faces = 0;
			clear_dice(dice,qty);	
	        int[][] multi_type = new int [11][5];  
	        /*  0  1  2  3  4 
	          ------------------
	        0 | 12 12 12 12 12  //qty
	        1 | 20  6  8 10  4  //faces
	        2 | --null...null--
	        3 |  a  b  c  d  e
	        . |  .
	        . |   .
	        10| ............[10][4]
	        */
			System.out.print("Enter Selection");
			System.out.print("Enter 1 for SINGLE TYPE of dice, 2 otherwise.");
			System.out.print("But you only can roll up to 5 TYPES (Different Faces) of dices ; and up to 12 qty of dices.");	
			int selection = input.nextInt();
			switch (selection){
				case 1:
					qty = dice_qty();
					faces = dice_face();				
					dice = roll_dice(qty,faces,dice);
					print_dice(dice,qty);
					break;
				case 2:
				    System.out.print("Enter total type of dices.");
				    int types_of_multi_dice = input.nextInt();
					multi_type = enter_info_for_multi_dice(types_of_multi_dice, multi_type);
					multi_type = roll_multi_dice(types_of_multi_dice,multi_type);
					break;
				default:
					break;
			}
		}					
	}

	public static int dice_qty(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter qty of dice(s)");
		int qty = input.nextInt();
		return qty;
	}

	public static int dice_face(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter faces of dice(s)");
		int faces = input.nextInt();
		return faces;
	}
	
	public static int[] roll_dice(int qty, int faces, int[] dice ){
		Random rand01 = new Random();
		for (int i = 0; i <= qty -1 ; i++){
			dice[i] = rand01.nextInt((faces-1)+1)+1;
		}	
		return dice;						
	}
	public static void print_dice(int[] dice, int qty){
		int q = qty;
		for (int i = 0; i <= q -1 ; i++){
			System.out.print(dice[i] +"\t");	
		}
	}
	public static void clear_dice(int[] dice,int qty){
		int q = qty;	
		for (int i = 0; i <= q -1 ; i++){
			dice[i] = 0;	
		}
	}
	public static int[][] enter_info_for_multi_dice(int qty, int[][] multi_type ){
	    Scanner input = new Scanner(System.in);
	    int q = qty;
	    for (int i = 0 ; i<= q-1; i++){
	        System.out.print("Enter qty of dice(s)");
	        multi_type[0][i] = input.nextInt();
	        System.out.print("Enter faces of dice(s)");
	        multi_type[1][i] = input.nextInt();
	    }
	    return multi_type;
	}
	public static int[][] roll_multi_dice(int qty, int[][] multi_type){
	    Random rand01 = new Random();
	    int type = qty;
	    for (int i = 0 ; i<= type-1;i++ ){   // total type of dice
	        for (int j = 0; j<= multi_type[i][0] -2 ; j++){  // total roll of dice
	            multi_type[i][3+j] = rand01.nextInt((multi_type[i][1]-1)+1)+1;
	        }
	    }
	    return multi_type;
	}
	public static void print_multi_dice(int qty, int[][] multi_type){
	    int type = qty;
        for (int i = 0 ; i<= type-1;i++ ){ 
	        System.out.print("Set" + i + " of Dice with face" + multi_type[i][1]);
	        for (int j = 3; j<= multi_type[i][0] -2 ; j++){
	            System.out.print(multi_type[i][3+j] +"\t");	
	        }
            
    }
	/*public static void clear_multi_dice(){
	   
	}*/
    }
}
