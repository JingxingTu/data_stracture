package sparseArray;

public class SparseArray {

	public static void main(String[] args) {

		System.out.println(" Original array: ");
		
		int chessArr1[][] = new int[11][11];
		
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		
		// transform array to sparse array
		
		// calculate the number of pieces on the board
		int sum = 0;
		
		for(int i = 0 ; i < 11 ; i++) {
			for(int j = 0; j < 11; j++) {
				
				if(chessArr1[i][j] != 0) {
					sum++ ;
				}
				
			}
		}
		
		System.out.println(sum);
		
		int chessArr2[][] = new int[sum+1][3];
		
		chessArr2[0][0] = 11;
		chessArr2[0][1] = 11;
		chessArr2[0][2] = sum;
		
		int index = 0;
		for(int i = 0 ; i < 11 ; i++) {
			for(int j = 0; j < 11; j++) {
				
				if(chessArr1[i][j] != 0) {
					index++;
					chessArr2[index][0] = i;
					chessArr2[index][1] = j;
					chessArr2[index][2] = chessArr1[i][j];
				}
			}
		}

		
		// show sparse array
		for(int i = 0 ; i < sum+1 ; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.printf("%d\t",chessArr2[i][j]);
				
			}
			System.out.println();
		}
		
		
		
	}

}
