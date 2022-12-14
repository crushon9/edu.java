package test;

import java.util.ArrayList;

public class KakaoBannedId {

	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "abc1**" };
		solution(user_id, banned_id);

	}

	public static int solution(String[] user_id, String[] banned_id) {
		int[][] result = new int[user_id.length][banned_id.length];

		for (int ban = 0; ban < banned_id.length; ban++) {
			ArrayList<Integer> starList = new ArrayList<Integer>();
			for (int strIndex = 0; strIndex < banned_id[ban].length(); strIndex++) {
				if (banned_id[ban].charAt(strIndex) == '*') {
					starList.add(strIndex);
				}
			}

			String[] user_id_temp = new String[user_id.length];
			for (int user = 0; user < user_id.length; user++) {
				StringBuilder builder = new StringBuilder(user_id[user]);
				for (int list = 0; list < starList.size(); list++) {
					if (user_id[user].length() > starList.get(list)) {
						builder.setCharAt(starList.get(list), '*');
					}
				}
				user_id_temp[user] = builder.toString();
				if (user_id_temp[user].equals(banned_id[ban])) {
					result[user][ban] = 1;
				}
			}
		}

		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < result[0].length; col++) {
				System.out.print(result[row][col] + " ");
			}
			System.out.println();
		}

		int down = 1;
		for (int row = 0; row < result.length; row++) {
			int num = 0;
			for (int col = 0; col < result[0].length; col++) {
				num += result[row][col];
			}
			if (num == 0 || num == 1) {
				num = 1;
			}
			down = down * num;
		}

		int up = 1;
		for (int col = 0; col < result[0].length; col++) {
			int num = 0;
			for (int row = 0; row < result.length; row++) {
				num += result[row][col];
			}
			up = up * num;
		}

		int answer = up / down;
		System.out.println(answer);
		return answer;
	}
}
