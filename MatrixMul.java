import java.util.Scanner;

class MatrixThread {
	private int[][] A;
	private int[][] B;
	private int[][] C;

	final int row1_, col1_;
	final int row2_, col2_;
	Scanner myscanner = new Scanner(System.in);
	
	
	/////------CONSTRUCTOR TO INITIALIZE MATRICES---/////

	public MatrixThread(int row1, int col1, int row2, int col2) {

		A = new int[row1][col1];

		B = new int[row2][col2];

		C = new int[row1][col2];

		row1_ = row1;
		row2_ = row2;
		col1_ = col1;
		col2_ = col2;

		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				C[i][j] = 0;
			}
		}
	}

	public void SetMatrix() {
		System.out.println("Enter the first Matrix");

		for (int i = 0; i < row1_; i++) {
			for (int j = 0; j < col1_; j++) {
				A[i][j] = myscanner.nextInt();
			}
		}

		System.out.println("Enter the second Matrix");

		for (int i = 0; i < row2_; i++) {
			for (int j = 0; j < col2_; j++) {
				B[i][j] = myscanner.nextInt();

			}
		}
	}
	
	/////MEHTOD FOR MULTIPLYING DIFFERENT ROW OF MATRIX///// 
	
	public void Multiply() {
		Thread mythread1 = new Thread(new Runnable() {

			public void run() {
				for (int j = 0; j < col2_; j++) {
					for (int k = 0; k < col1_; k++) {
						C[0][j] += A[0][k] * B[k][j];
					}
					//System.out.println(C[0][j]);
				}

			}
		});
		Thread mythread2 = new Thread(new Runnable() {

			public void run() {
				for (int j = 0; j < col2_; j++) {
					for (int k = 0; k < col1_; k++) {
						C[1][j] += A[1][k] * B[k][j];
					}
					//System.out.println(C[1][j]);
				}

			}
		});
		Thread mythread3 = new Thread(new Runnable() {

			public void run() {
				for (int j = 0; j < col2_; j++) {
					for (int k = 0; k < col1_; k++) {
						C[2][j] += A[2][k] * B[k][j];
					}
					//System.out.println(C[2][j]);
				}

			}
		});
		mythread1.start();
		mythread2.start();
		mythread3.start();

		try {
			mythread1.join();
			mythread2.join();
			mythread3.join();

			for (int i = 0; i < row1_; i++) {
				for (int j = 0; j < col2_; j++) {
					System.out.print(C[i][j] + "    ");
				}
				System.out.print("\t");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class MatrixMul {
	public static void main(String[] args) {
		MatrixThread ob = new MatrixThread(3, 3, 3, 3);
		ob.SetMatrix();
		ob.Multiply();
	}
}