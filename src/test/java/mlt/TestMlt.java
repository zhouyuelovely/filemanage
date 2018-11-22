package mlt;


public class TestMlt {

	public static void main(String[] args) {
		
		int number = 0;
		for (int row = 0;row<=7;row++) {//8行
		//声明一个列col
		
		for (int col = 1;col <=7-row;col++) {//(int col = 1;col>=7;col++)
		}
		/*System.out.printf("%4s","");*/
		//空格s代表string,字符串；为了输出的时候对齐；%4s表示输出一个string类型的数
		//print left half of the row
		for(int col = 0;col<=row;col++) {
			number =(int)Math.pow(2, col);
			System.out.printf("%4d",number);//整数部分占4个格，余数不要
		}
	//print the right half of the row
			for (int col =row-1;col>=0;col--) {
				number =(int)Math.pow(2, col);
			}
		}//start a new line
		System.out.println('\n');

	}

}