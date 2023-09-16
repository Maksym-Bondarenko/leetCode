class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = 0;    // as 1000 is the lowest possible salary, we can use 0
        int total = 0;
        int employees = salary.length;

        for(int sal : salary) {
            if(sal < min)
                min = sal;
            if(sal > max)
                max = sal;
            total += sal;
        }

        // need to use Double, because Integer-Divide is not precise enough
        return (double) (total - min - max) / (double) (employees - 2);
    }
}