/*

先是getElementsByClassname，然后是展开一下，写一个getElementsByHierarchy，
输入是一个element和'a > b > c'找direct child
*/

export function getElementsByClassName(ele, className) {
  const result = [];
  (function find(target) {
    if (target.classList && target.classList.contains(className)) {
      result.push(target);
    }
    for (const child of target.children) {
      find(child);
    }
  })(ele);
  return result;
}

/**
 *
 *
 * @export
 * @param {HTMLDomElement} ele
 * @param {*} targetPath
 * @returns
 */
export function getElementsByHierarchy(ele, targetPath) {
  const result = [];
  const parts = targetPath.split(">");
  targetPath &&
    (function find(target, index) {
      if (target.classList && target.classList.contains(parts[index])) {
        if (index == parts.length - 1) {
          result.push(target);
        } else {
          for (const child of target.children) {
            find(child, index + 1);
          }
        }
      } else {
        for (const child of target.children) {
          find(child, index);
        }
      }
    })(ele, 0);
  return result;
}
