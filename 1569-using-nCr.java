class Solution {
    private final int modulo = (int) 1e9 + 7;

    public int numOfWays(int[] nums) {
        List<Integer> resultList = new ArrayList();
        for (int num : nums) {
            resultList.add(num);
        }

        long result = solver(resultList) % modulo;
        return (int) result - 1;
    }

    private long solver(List<Integer> resultList) {
        int size = resultList.size();
        
        if (size <= 2) {
            return 1;
        }
        
        int root = resultList.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int i : resultList) {
            
            if (i < root) {
                left.add(i);
            }
            
            if (i > root) {
                right.add(i);
            }
        }
        
        int leftSize = left.size();
        int rightSize = right.size();
        long temp = combination(leftSize + rightSize, leftSize, rightSize) % modulo;

        long L = solver(left) % modulo;
        long R = solver(right) % modulo;
        temp = (L * temp) % modulo;
        
        return (R * temp) % modulo;
    }

    private long combination(int n, int a, int b) {
        long result = 1;
        
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        
        for (int i = n; i > a; i--) {
            result *= i;
            result = result % modulo;
        }
        
        for (int i = 1; i <= b; i++) {
            while (result % i != 0) {
                result += modulo;
            }
            result /= i;
        }
        
        return result;
    }
}
