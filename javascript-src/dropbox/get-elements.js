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

export function getElementsByHierarchy(ele, targetPath) {
    const result = [];
    targetPath &&
        (function find(target, path) {
            if (
                path.substring(path.length - targetPath.length) === targetPath
            ) {
                result.push(target);
            }
            for (const child of target.children) {
                const name = child.className || "";
                find(child, `${path} > ${name}`);
            }
        })(ele, ele.className || "");
    return result;
}
