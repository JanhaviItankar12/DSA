// You are given an even integer n representing the number of houses arranged in a straight line, and a 2D array cost of size n x 3, where cost[i][j] represents the cost of painting house i with color j + 1.

// The houses will look beautiful if they satisfy the following conditions:

// No two adjacent houses are painted the same color.
// First and last last house cannot get same color
// Return the minimum cost to paint the houses such that they look beautiful.

public class PaintHouse4CircularVersion {
    public static void main(String[] args) {
        int cost[][] = { { 100, 200, 400, 500, 300 },
                { 100, 200, 400, 500, 300 },
                { 100, 200, 400, 500, 300 }
        };

        int k = cost[0].length; // no of colors
        int n = cost.length; // no of houses

        int ans = Integer.MAX_VALUE;

        // try all colors possible to first house
        for (int firstColor = 0; firstColor < k; firstColor++) {

            int prev[] = new int[k];

            // force only one fixed color to first house
            for (int i = 0; i < k; i++) {
                if (i == firstColor) { // fixed
                    prev[i] = cost[0][i];
                } else {
                    prev[i] = Integer.MAX_VALUE;
                }
            }

            // now provide colors to all remainin houses
            for (int i = 1; i < n; i++) {

                int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
                int minColor = -1;

                // find min1 and min2 from house painting cost
                for (int j = 0; j < k; j++) {
                    if (prev[j] < min1) {
                        min2 = min1;
                        min1 = prev[j];
                        minColor = j;
                    } else if (prev[j] < min2) {
                        min2 = prev[j];
                    }
                }

                int curr[] = new int[k];
                // now color the house
                for (int j = 0; j < k; j++) {
                    if (j == minColor) {
                        if (min2 == Integer.MAX_VALUE)
                            curr[j] = Integer.MAX_VALUE;
                        else
                            curr[j] = cost[i][j] + min2;
                    } else {
                        if (min1 == Integer.MAX_VALUE)
                            curr[j] = Integer.MAX_VALUE;
                        else
                            curr[j] = cost[i][j] + min1;
                    }
                }

                prev = curr;
            }

            // now find ans from last row to get min Cost
            for (int i = 0; i < k; i++) {
                if (i != firstColor) {
                    ans = Math.min(ans, prev[i]);
                }
            }

        }

        System.out.println(ans);

    }

}
