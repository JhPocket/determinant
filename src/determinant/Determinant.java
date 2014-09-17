package determinant;

import java.util.*;

/**
 * 这是一个求解n阶行列式的程序
 * 
 * @author ZJH
 * @date 2014-9-17
 */

public class Determinant {

	private final int signRow = 0;

	private int n;

	private Scanner in;

	public Determinant() {
		// System.out.println("result= " + dealDate(inputArray()));

	}

	private float[][] inputArray() {

		in = new Scanner(System.in);

		System.out.println("请输入n的值");

		while ((n = (int) inputData()) <= 0) {
			System.out.println("n<=0,不符合实际,请重输");
		}

		/**
		 * 接受行列式数据
		 */
		float[][] array = new float[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				array[i][j] = inputData();
			}

		in.close();

		return array;

	}

	private float inputData() {

		float data = 0;

		while (true) {

			try {
				data = in.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("输入错误,请重新输入");
				in.nextLine();
				continue;
			}
			return data;
		}

	}

	/**
	 * 求一个Array数组,signRow行 col列对应的余子式
	 * 
	 * @param array
	 *            要处理数组
	 * @param col
	 *            列号
	 * @return 返回一个余子式
	 */

	float[][] getCofactor(float[][] array, int col) {

		int length = array.length - 1;

		float[][] cofactor = new float[length][length];
		for (int i = 0, m = 0; i <= length; i++)
			for (int j = 0, n = 0; j <= length; j++) {

				if (i != signRow && j != col) {
					cofactor[m][n] = array[i][j];

					n++;
					if (n == length) {
						n = 0;
						m++;
					}

				}

			}

		/**
		 * for (float[] a : cofactor) { for (float i : a) System.out.print(i +
		 * " "); System.out.println(); }
		 **/

		return cofactor;
	}

	float dealDate(float[][] array) {
		float result = 0;

		if (array.length == 2) {
			float t = array[0][0] * array[1][1] - array[0][1] * array[1][0];
			return t;

		} else if (array.length > 2) {

			for (int i = 0; i < array.length; i++) {

				result += Math.pow(-1, signRow + i) * array[signRow][i]
						* dealDate(getCofactor(array, i));

			}
			return result;

		} else

			return array[0][0];
	}

	/*
	 * public static void main(String[] args) { new Determinant(); }
	 */
}
