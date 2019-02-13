import java.util.*;
public class dice{
	public static void main(String[] args){		
		int[] dice = new int[99];		
		int proceed = 1;

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
					
			System.out.print("Enter Selection");
			System.out.print("Enter 1 for SINGLE TYPE of dice, 2 otherwise.");		
			int selection = input.nextInt();			
			switch (selection){
				case 1:
					qty = dice_qty();
					faces = dice_face();				
					dice = roll_dice(qty,faces,dice);
					print_dice(dice,qty);
					break;
				case 2:
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

}
