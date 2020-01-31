/*
用js拿第n个斐波拉契数 1，1，2，3，5，8，13
*/

export function fibonacci(size) {
    const result = [];
    if (size < 1) {
        return result;
    }
    result[0] = 1;
    while (result.length < size) {
        const index = result.length - 1;
        result.push(result[index] + (index - 1 >= 0 ? result[index - 1] : 0));
    }
    return result;
}
