- [BQ] 简历里写的东西自己一定要熟悉
- design undo feature.
  - Follow Up: How to make the code generic?
  - Follow Up: 用网页写一个带简单 UI 的计算器。有点 Leetcode 224 的意思，但是 UI 的行为要符合简单的计算器，比如屏幕上显示 1 的时候，输入 2，要变成 12，但是显示 0 的时候，输入 1，就要变成 1 (https://gist.github.com/d6u/2e982bdc965e14ce12a545e6996f0af4)
  - Follow Up: 如果这种 undo 以及 redo 操作是用在占据很大存储空间以及用户量很大的 data 上该怎么办，我说那就给每个数据加上 index，undo 以及 redo 只用在 index 上，最后再用 index 去取数据
- 回文串的题.

  - Follow Up: Can we use 1 line JS?
  - 写个 function isPalindrome
    给了两个例子
    console.log(isPalindrome("racecar")) // true
    console.log(isPalindrome("dog"))     // false

- 说有一个电子支票，用户输入一个 float 类型的数之后，把这个数转换成英文单词，比如 123.45，转换成 "one hundred twenty three and 45 / 100"
  - 写完后在根据截图写一个支票的 HTML 布局，以及大致的 positioning
- 设计一个日历，要写 detail 的 HTML 和 js 代码
- 一个类似 tooltip 的 widget，当用户把鼠标放在 LinkedIn 页面上某个联系人的名字上时，会出现一个类似 tooltip 的预览框，里面有该用户的头像，姓名，degree 以及 title。要求先用 HTML 以及 CSS mock up 下大致的 layout，然后用 AJAX 得到所需要显示的用户信息
  给一个 link，鼠标移到 link 上会出现一个提示语，是那种 bubble chat 的样子的，全部 HTML/JS/CSS，剩一堆时间问问题
  - 给了个图片，用 HTML, CSS 实现。
    有个 link, 然后 hover link 上的时候， 在 link 的上方出现一个 tooltip popup. tooltip 是个 div
- Insert links for each of the members into the content div. The link would be like: `<a href="profile.jsp?id=<memeber.id>"><member.name></a>` 考点就是 DOM Manipulation，怎么向 DOM Tree 里添加新的节点
  - 如果有很多 member 的链接需要一个一个添加到 DOM 里，会造成 reflow 影响页面性能，如何解决
  - 纯 JS 如何在 div 里头添加一行一行的 link，link 含人名和这个人 profile 的链接，
- 设计一个迷你版的 LInkedIn Profile，HTML/JS/CSS   全部都要写 外加一个 like 功能，以及 comment 功能
- memoization function，思路就是利用 hashTable 存之前计算出的结果. 写一个 memorize function。就是可以根据 arguments 来缓存 return 值，第二次输入同样的 args 不会再计算整个 function，而是直接从缓存获取 return value。基本就是考 Closure 和 hash 的用法。我先写了个 single argument function，然后拓展成多个复杂 args 的 function
- [BQ]谈谈你对 client side rendering 以及 server side rendering 的理解
- 写一个 infinite scroll handler.
  给了一个`<ul id="posts"></ul>`
  每次到了页面底部就用 ajax load 更多的内容。用 throttle 优化
- 每个点是个 object, x, y 坐标都给了， 比如{x: 5, y: 5}
  已知 包含所有点的 array, 某一个点，和半径 d, 写一个 function 返回到这个点的距离小于或等于 d 的所有点。
  怎么优化。我当时答得是把整个地图分成小的区域，每一小块 2d 的正方形。然后找这个点所在的方块和周围的几个方块。这样就不用遍历地图里所有的点了。
- linkedin 新加的功能, 页面的右下角可以发 messenger. 对于 messenger 这个 feature, 先列一下有哪些功能要实现。然后对每个功能讲讲怎么实现。
- [BQ] 你想给 LinkedIn 增加哪些新功能
- 写个 function 来 parse query string. 先让你写个带 query string 的 url.
  http://example.com/over/there?name=ferret&id=1  parse 完后生成一个 object {name: "ferret", id: "1"}
  - followup 1: http://example.com/over/there?name=ferret&name=tom&id=1 parse 完后生成一个 object {name: ["ferret", "tom"], id: "1"}
  - followup 2: 如果 url 是 encode,要先 decode
- 给两个 dom element，判断第二个是不是第一的 child。child 可能不是直接 child。解法是从第二个开始找 parent element，直到找到 HTML element 都找不到的话就返回 false
- 用 JavaScript 做简单的数据处理，其实就是实现 lodash 的 groupBy。
- search box auto suggest. 设计一个有 auto complete 功能的 dropdown，类似 google 搜索栏，从前端到后端
  楼主主动加上了 debounce，infinite scroll 还有 cache 的功能，感觉面试官反馈很好
  然后要求写代码，讨论特殊情况
- [System Design] 设计一个 hangman game（Google 一下你就知道）。就是猜字游戏。没有什么 mass scale 的要求，主要注重小功能的实现。比如 HTTP response 的数据结构，数据要不要存 database 里，掉线了怎么重建游戏。后来会一直改 requirement，随机应变就好
  填字母猜单词的游戏。先讲了讲前端 UI 布局，前端数据流设计，然后再说需要哪些 API，参数和返回值分别是什么，数据库里的数据格式怎样，如何反作弊等。讲完后面试官问我如果想给游戏增加不同难度选项怎么弄，我也大致说了下
- 设计一个 dashboard，dashboard 是一个地图，当有新用户注册账号时，需要实时在 dashboard 上显示用户位置？

  - 前端用什么 library？(d3.js)，需要向前端发送哪些数据？（经纬度或者 geohash），push vs pull？怎么实现 push service？（消息队列）？怎么测试？

- 输入数组 endorsements：
  输入格式是
  endorsements = [{skill: 'javascript', user: 'user1'}, {skill: 'css', user: 'user2'}, {skill: 'html', user: 'user3'}, {skill: 'javascript', user: 'user2'}, {skill: 'css', user: 'user3'}, {skill: 'javascript', user: 'user3'}]
  输出
  [{skill: 'javascript', users:['user1', 'user2', 'user3'], count: 3}, {skill: 'css', users:['user2', 'user3'], count: 2},  {skill: 'html', users: ['user3'], count: 1}]

  - 输出需要按照 count 排序 用了一个 map 把 skill 作为 key，遍历 endorsements 数组处理，然后用 Object.values(map)输出结果

- 写一个类似于点赞功能的 ui，点赞之后旁边的数字+1，取消之后-1
  写 html 的时候问了怎么改进 accessiblity 和 symentic 用了一些<header><footer>之类的标签，加了 role 属性。
  写了个 js 函数来处理 button toggle，事件绑定在外层容器上用了事件代理来处理点击操作
- JS 和 DOM 的基础概念，如 Event bubbling，closure 等
- 给了一段关于 Prototype chain 的代码，让我说输出结果
- [BQ] 谈一次失败的经历
- [BQ] 如果你和其他人意见不一致时怎么处理等
- [BQ] 你喜欢和不喜欢的 App，以及 LinkedIn App。我说我不怎么用 LinkedIn App
- [Coding] LeetCode 上 Maximum subarray 的增强版，需要同时输出起始和终止的 index.给一个数组，求最大的 subarray 的 sum 及其坐标
  如 [0, -1, 3, 4, -5, 0] 返回 { result: 7, indexes: [2, 3] }
  循序渐进，各种解法都过一遍，讨论复杂度，然后最优解写代码(Javascript)，bug free
  提前做完，问问题
- [BQ] 如何从 development 到 deployment
- [BQ] 某些情况如何做 technical decision
- 看代码说结果，如何改正

```
1. var Foo = function( a ) {
2. function bar() {
3. return a;
4. }
5. this.baz = function() {
6. return a;
7. };
8. };
9. Foo.prototype = {
10. biz: function() {
11. return a;
12. }
13. };
14. var f = new Foo( 7 );
15. f.bar(); // error, undefined function
16. f.baz(); // 7
17. f.biz(); // undefined
```

- ### 题目一： 看代码猜结果

````javascript
var Foo = function(a) {
  // This function is not defined.
  // Either window or this doesn't have this method.
  function bar() {   
    console.log(a);
  };
  var a = 1;
  // This function is defined and is assigned to `this` Object only.
  // So the function can be accessed from a new created instance.
  // parameter a is accessible from all the nested function defined here.
  this.baz = function() {
      console.log(a);
  };
};
Foo.prototype = {
  // function is defined in prototype.
  // new created instance can access to this function.
  // but this function is defined in a different Object,
  // so it can not access to constructor's parameter.
  biz: function() {   
    console.log(a);
  }
};
var f = new Foo(8);
// Question1: Observe the function above and tell the result they would print
// for the following function calls.
f.bar(); // TypeError, f.bar is not a function.
f.baz(); // 8
f.biz(); // ReferenceError, a is not defined
// followup: how to resolve the errors and print expected values.
var Foo = function(a) {
  // Assign defined function to this Object.
  this.bar = function() {   
    console.log(a);
  };
  // Unchanged
  this.baz = function() {
      console.log(a);
  };
  // Assign parameter a to this Object.
  this.a = a;
};
Foo.prototype = {
  biz: function() {
    // access a from this, which is the created instance.
    console.log(this.a);
  }
};
// The instance before and after.
instance_before = {
  baz: function(){},
  proto: {
    biz: function(){}
  }
}
// The instance after.
instance = {
  bar: function(){},
  baz: function(){},
  a: 8,
  proto: {
    biz: function(){}
  }
}
// Summary
// Function and variable has to be defined in constructor  and assigned to this
// Object to make them accessible to new created instance and functions in
// proto object. Parameter for constructor can only be accessed within the   
// constructor. But constructor and proto are both in the same `this` scope,
// which means they belong to the same instance. proto is an attribute with an
// object as its value. functions in this new object doesn’t have access to  it’s
// parent function’s parameter if only it’s assigned to the `this` scope they share.
// For the given array of members:

- 用js拿第n个斐波拉契数 1，1，2，3，5，8，13。。
- difference between GET and POST
- difference between Class inheritance and prototype inheritance
- difference between Promise and callback
- How to improve the accessibility of a website?
- 操纵DOM
```javascript
var members = [
    {
        name: 'Bill Denbrough',
        id: 1
    },
    {
        name: 'Ben Hanscom',
        id: 2
    },
    {
        name: 'Mike Hanlon',
        id: 3
    },
    {
        name: 'Richie Tozier',
        id: 4
    },
    {
        name: 'Beverly Marsh',
        id: 5
    },
    {
        name: 'Eddie Kaspbrak',
        id: 6
    },
    {
        name: 'Stan Uris',
        id: 7
    }  
];
<div id="content"></div>
// Question: insert links for each of the members into the content div
// The link would be like the example below
<a href="profile.jsp?id=<memeber.id>"><member.name></a>
var contentEl = document.getElementById("content");
var htmlC = [];
members.forEach(function(memeber){
    var name = member.name;
    var id = member.id;
    var link = "profile.jsp?id=" + id;
    var aEl = doucment.createElement('a');
    aEl.setAttribute('href', link);
    aEl.innerText = name;
    htmlC.push(aEl);
});
contentEl.append(htmlC);
// Follow up question:
What the benefits you can get by inserting them at once rather than inserting it each time you create a anchor tag?
// http://codepen.io/stevenz1987/pen/YWEBvQ?editors=1010
````

- CSS preprocessor
- how to make a img accessible
- 怎么 clear float
- 用过 CommonJS, RequireJS 吗？ 说一下怎么用 module (面试的小哥组里在用 RequireJS)
- callback 和 promise 区别
- Lowest Common Ancestor (和 leetcode 上稍微有点不一样，不提供 root，然后互相比较的两个 node 有 left，right，parent 三个属性)
- Isomorphic Strings
- 设计一个 calendar
- Asynchronously iterate through a list (要用到 promise，务必把 promise 的知识复习一下)
- html + javascript
  • 在主页上有很多人的名字（anchor tags），要求写出 anchor（html，就是`<a />`），以及如果 hover 上 anchor 之后显示 popup（里面有个人资料具体信息）的 js 代码，可用 Library。（不用写 CSS）
  • 注意点：同一个名字可能出现多次，JS 要写 cache，而且得 cache promise object

- 给了一个图的链接，其实就是用 html 写个 form，然后简单问了一下如何分成两列，最后写个 Ajax，可以用第三方 library

- 364 Nested List Weight Sum II
- Merge two sorted lists. 时间复杂度，空间复杂度。怎么优化
- 一个整形矩阵，行列都是排好序的。用最快的时间找出所有数字的中值。这个题目以前见过 1 维的情况，不过不容易扩展到 2 维
- coding， 奇尔
- coding， 1)伞溜刘， 2）而摆，   followup，根据 island 大小排序
- 问题是一个数组 求非相邻的数的最大和 例如
  [3,4,5,6,7] -> 3 + 5+ 7
- 给一个 output 是 0 或 1 的随机数生成器，0 的概率是 p，1 的概率是 1-p
      求写一个生成 0，1 概率是 50/50 的函数
- addInterval(int start, int end) & getTotalCoveredLength() 根据加入的 range，返回覆盖地总长。
  - follow up1. 第一个函数 call 1 亿次，第二个 call 很少；第二个函数 call1 亿次，第一个 call 很少
  - follow up2. 第一个函数 call 1 亿次，第二个函数 call 很少的情况下（实际就是刷题网无期了），如果 pairs 很多，sorting 也会很耗事，在实际生产中，会怎么判断 sorting 的时机
- Flip locker for n students, each move for i steps.   一个一位数组表示 locker 开还是关，最开始全部关闭，然后模拟打开、关闭
  - Flip locker for n students, each move for i steps.   一个一位数组表示 locker 开还是关，最开始全部关闭。面试官直接让我用 naive 的方法写的，两个 for 循环
- word ladder 外加打印最短路径
- top k request for past 5 min, 30min 1hour, one day
- 打印 valid 三角形 lc 611. 不过你要打印出来所有三角形
- Weighted nested list I
- find first unique character
- 利特口的 把酒凌
- CSS float & clear-fix
- shortest Word Distance I, II, III
- 有一棵树 求落叶子的顺序。 叶子落下的条件是该叶子没有 children。输入是一个 treeNode， 输出一个`List<Set<TreeNode>>`
- 给一个长 string，所有 char 只会从四个 char 里面选，output 出所有长度为 10 的 duplicate substring，要 ordered，时间复杂度 和如何优化
- 蠡口散司衣+衣吴溜
- 蠡口漆凌溜
- Leetcode 72
- valid number
- 利口 二期二
- 利口 把酒屋
- shortest word distance II
- Tournament Tree
- 高频题 k closet elements to a target
  写了用 deque 的 time O(n) space O(n)，和用 linkedlist 的 time O(n) space O(k)，口述了 two stack 时间优于 O(n)的方法
- isomorphic
- LC 352
- leetcode 339
- 散散久，贰零雾
- 伞伞久问如果不用给的 NestedInterger 接口，怎么存储这样的数据？ 贰零雾 follow up 后面问输入时多个 string 怎么处理
- 贰零龄，武器的变种
- 给一个字符串 S ,看是否能够包括一列目标子串[s1, s2, ..., sn]并且子串在 S 中位置不重合
- 给一列数[n1, n2, ...]可能有元素重复，返回所有可能的排列
- word ladder2
- polish notation 的计算 e.g【1，2，3，+，\*】
- binary search 的应用， 找到比自己大一号的字母
  arr = [a,b,d,f,v,z], key = z, ret= a
  arr = [a,b,d,f,v,z], key = b, ret= d
- 给出了一个 1 维数组，希望能够找出一个点，能使得这个点到数组里面数组的距离和最小（答：找 median），follow up 是如果给了 2D space 里面的一组点，找一个点到其它点的和最小
- leetcode 240
- 撒撒酒， 撒路斯
- permutation of Integer array
- 刘瑶瑶 变形， 只让返回一个valid 数组就行 ， 就做过一遍 貌似还写过dfs 暴力，结果卡了一下经过提示做出来了
- 刘就把
- Validate IP   468
- BST iterator   173
- 利口流食舞
- lc 33
- 散散久  & 三遛似
- 利口144, 145
- design super data structur
- 第一题是string replace，我开始写的是转成流处理，后来提到了kmp，没让我写kmp，我觉得这个地方应该一上来用find或者kmp，当时大脑有点短路 
- factor combinations，要从大到小输出
- shortest word distance II