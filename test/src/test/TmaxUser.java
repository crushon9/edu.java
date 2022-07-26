package test;

import java.util.Arrays;

public class TmaxUser {

	public static void main(String[] args) {
//		int[] balance = { -1, 30, 30, 30, 30 };
//		int[][] transaction = { { 1, 2, 10 }, { 2, 3, 20 }, { 3, 4, 5 }, { 3, 4, 30 } };
//		int[] abnomal = { 1 };
//		int[] result = { -1, 0, 20, 15, 55 };

//		int[] balance = { -1, 30, 30, 30, 30 };
//		int[][] transaction = { { 1, 2, 10 }, { 2, 3, 20 }, { 3, 4, 5 }, { 3, 4, 30 } };
//		int[] abnomal = { 2, 3 };
//		int[] result = { -1, 20, 0, 0, 40 };

//		int[] balance = { -1, 40, 30, 50 };
//		int[][] transaction = { { 1, 3, 10 }, { 2, 1, 10 }, { 3, 1, 45 }, { 2, 3, 10 }, { 1, 3, 35 }, { 2, 1, 5 },
//				{ 3, 1, 10 }, { 3, 2, 5 } };
//		int[] abnomal = { 2 };
//		int[] result = { -1, 40, 5, 45 };

		int[] balance = { -1, 100, 1, 1, 1, 1 };
		int[][] transaction = { { 1, 2, 100 }, { 2, 3, 101 }, { 3, 4, 102 }, { 4, 5, 103 }, { 5, 1, 104 } };
		int[] abnomal = { 1 };
		int[] result = { -1, 4, 0, 0, 0, 0 };

		// solution의 결과값 담기
		int[] myResult = solution(balance, transaction, abnomal);
		// 성공여부 검사
		String output = "성공입니다!!";
		if (result.length == myResult.length) {
			for (int i = 0; i < result.length; i++) {
				System.out.println(i + "번째 myResult : " + myResult[i] + ", result : " + result[i]);
				if (myResult[i] != result[i]) {
					output = "실패입니다..";
					break;
				}
			}
		} else {
			output = "실패입니다..";
		}
		System.out.println(output);
	}

	public static int[] solution(int[] balance, int[][] transaction, int[] abnomal) {
		// 3차원배열[user][transaction][0:소유자,1:금액]
		// 주의* 거래시 마지막으로 받은 금액부터 거래
		int[] myResult = new int[balance.length];
		myResult[0] = -1;

		// 초기 잔고 세팅
		int[][][] tranMatrix = new int[balance.length][transaction.length + 1][2];
		for (int user = 1; user < balance.length; user++) {
			tranMatrix[user][0][0] = user;
			tranMatrix[user][0][1] = balance[user];
		}
		System.out.println("tranMatrix : 초기");
		for (int[][] user : tranMatrix) {
			System.out.println(Arrays.deepToString(user));
		}

		// transaction 내용 반영
		for (int tran = 0; tran < transaction.length; tran++) {
			int sender = transaction[tran][0];
			int receiver = transaction[tran][1];
			int tranBal = transaction[tran][2];
			for (int userTran = transaction.length - 1; userTran >= 0; userTran--) {
				int senderLastBal = tranMatrix[sender][userTran][1];
				// 유저의 마지막 잔고와 거래 잔고를 비교
				if (tranMatrix[sender][userTran][1] >= tranBal && tranBal != 0) {
					tranMatrix[receiver][userTran + 1][0] = tranMatrix[sender][userTran][0];
					tranMatrix[receiver][userTran + 1][1] = tranBal;
					tranMatrix[sender][userTran][1] -= tranBal;
					tranBal = 0;
				} else {
					// 문제는 여기서 덮어씌워지네,,, arrayList put에 키밸류로 써야할것                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   같아..
					tranMatrix[receiver][userTran + 1][0] = tranMatrix[sender][userTran][0];
					tranMatrix[receiver][userTran + 1][1] = senderLastBal;
					tranMatrix[sender][userTran][1] = 0;
					tranBal -= senderLastBal;
				}
			}
			System.out.println("transaction : " + tran);
			for (int[][] user : tranMatrix) {
				System.out.println(Arrays.deepToString(user));
			}
		}
		System.out.println("tranMatrix : 최종");
		for (int[][] user : tranMatrix) {
			System.out.println(Arrays.deepToString(user));
		}

		// 거래내역을 유저마다 sum 해서 result에 값넣기
		for (int user = 1; user < balance.length; user++) {
			int balanceSum = 0;
			for (int tran = 0; tran < transaction.length + 1; tran++) {
				// 이상 유저인지 검사9
				int flag = 0;
				for (int abUser : abnomal) {
					if (tranMatrix[user][tran][0] == abUser) {
						flag = -1;
						break;
					}
				}
				// 이상 유저가 아니라면 거래내역 반영
				if (flag != -1) {
					balanceSum += tranMatrix[user][tran][1];
				}
			}
			myResult[user] = balanceSum;
		}
		return myResult;
	}
}
