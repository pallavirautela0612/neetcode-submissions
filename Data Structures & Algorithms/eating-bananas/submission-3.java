class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int minPile = 1;
        int maxPile = 0;

        for (int pile : piles) {

            maxPile = Math.max(maxPile, pile);
        }

        int k = maxPile;

        while (minPile <= maxPile) {

            int midPile = minPile + (maxPile - minPile)/2;
            long hoursTaken = eatBananas(piles, h, midPile);

            if (hoursTaken <= h) {

                k = midPile;
                maxPile = midPile -1;
            } else {

                minPile = midPile + 1;
            }
        }

        return k;
    }

    private long eatBananas(int[] piles, int h, int k) {

        long hoursTaken = 0;

        for (int i = 0; i < piles.length; i++) {

            if (piles[i]%k == 0) {

                hoursTaken += piles[i]/k;
            } else {

                hoursTaken += piles[i]/k +1;
            }
        }

        return hoursTaken;
    }
}
