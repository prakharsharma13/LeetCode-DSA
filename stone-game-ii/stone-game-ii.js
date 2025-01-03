/**
 * @param {number[]} piles
 * @return {number}
 */
var stoneGameII = function (piles) {
  const n = piles.length;
  const dp = Array.from(Array(n + 1), () => Array(2 * (n + 1)).fill(0));
  let sumTilEnd = 0, minOpponent;

  for (let i = n - 1; i >= 0; i--) {
    sumTilEnd += piles[i];
    for (let m = 1; m <= n; m++) {
      if (i + 2 * m >= n) {
        dp[i][m] = sumTilEnd;
        continue;
      }

      minOpponent = dp[i + 1][m];

      for (let x = 2; x <= 2 * m; x++) {
        minOpponent = Math.min(minOpponent, dp[i + x][Math.max(m, x)]);
      }

      dp[i][m] = sumTilEnd - minOpponent;
    }
  }

  return dp[0][1];
};