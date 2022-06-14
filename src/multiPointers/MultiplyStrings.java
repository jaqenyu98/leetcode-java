package multiPointers;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length();
        int n = num2.length();
        // m位数*n位数，结果最大为m+n位，最小为m+n-1位
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                result[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            // 大于10要进位
            if (result[i] >= 10) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = result[0] == 0 ? 1 : 0;
        while (index < m + n) {
            sb.append(result[index++]);
        }
        return sb.toString();
    }
}
