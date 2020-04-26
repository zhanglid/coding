/*
html, two inputs for width and column. 
Based on inputs values, print a table. eg. input 3, 4
table:
   1  6  7  12
   2  5  8  11
   3  4  9  10
*/

export function printTable(m, n) {
  const col = [...new Array(m).keys()].map((v) => v + 1);
  const board = [...new Array(m)].map((v) => []);
  for (let j = 0; j < n; j++) {
    for (let i = 0; i < m; i++) {
      board[i].push(col[i]);
    }
    col.reverse();
    for (let i = 0; i < m; i++) {
      col[i] += m;
    }
  }
  return board;
}
