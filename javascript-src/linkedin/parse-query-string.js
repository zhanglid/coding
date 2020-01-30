/*
写个 function 来 parse query string. 先让你写个带 query string 的 url. 
http://example.com/over/there?name=ferret&id=1
parse 完后生成一个 object {name: "ferret", id: "1"}

followup 1: http://example.com/over/there?name=ferret&name=tom&id=1
parse 完后生成一个 object {name: ["ferret", "tom"], id: "1"}

followup 2: 如果 url 是 encode,要先 decode
*/

export function parse(s = "") {
    const parts = s.split("?");
    if (parts.length < 1) {
        return {};
    }
    return parts[parts.length - 1]
        .split("&")
        .map(part => part.split("="))
        .filter(pair => pair && pair.length === 2)
        .reduce(
            (result, [field, value]) => ({
                ...result,
                [field]:
                    result[field] === undefined
                        ? value
                        : Array.isArray(result[field])
                        ? [...result[field], value]
                        : [result[field], value]
            }),
            {}
        );
}
