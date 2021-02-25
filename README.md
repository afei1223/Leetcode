# leetcode

准备在力扣上刷题了，但是不知道这个项目该取什么名字好，直接就叫leetcode吧。

这里收录的是每日一题，以及坚持下来的打卡，有时候可能会用c去实现。到时候再整理吧。

因为我是做android的嘛，所以直接用java实现了，好在算法上对语言没要求。

## 项目结构

MainActivity是显示按钮的页面，每一个按钮对应一道题。点击后跳转solutionActivity，在这里输入，获取到输入后根据题目进行运算。

这两块地方没必要去看，具体算法实现和解法思路都在Solution中，后面跟的是题号，例Solution1004，即1004题的解法。

## 题目总结

### 滑动窗口系列

用于解决最长连续子序列问题

#### 题号链接
* [1004 最大连续1的个数 III （滑动窗口算法总结）](https://leetcode-cn.com/problems/max-consecutive-ones-iii/)
* [697  数组的度](https://leetcode-cn.com/problems/degree-of-an-array/)
* [1052 爱生气的书店老板](https://leetcode-cn.com/problems/grumpy-bookstore-owner/)
* [1438 绝对差不超过限制的最长连续子数组](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)

#### 算法总结和模版

```java
/**
     * 优秀解法 3ms  39mb
     *
     * 算法很巧妙，一时间有点难消化。
     * 总的来说，先有两个游标，right和left。right开始向右走，每一次循环都向右走
     * 接下来是两个if，
     *  第一个if中ans为所有1的计数器，有多少个1。
     *  第二个if是为了让left开始走，这个时候把left想像成一个框，left和right就是左边界和右边界。
     *  那么left什么时候向右移动呢，目前统计的ans+k即为当时最长的子序列的长度。
     *  当right+1-left大于这个值的时候，说明，目前这个框的长度太长了，也就是0太多了。
     *  这个时候这个框里的字符串是不符合题目要求的。所以左边界开始移动。
     *  当左边界移动的时候，发现刚刚扔掉的那个字符刚好是1，那ans就必须减一，不然长度就多了。
     *  注意，这个时候，左边界和右边界中间的字符串，刚好是符合题目要求的。
     *  但是right每次while循环就会加1，直到加到数组的上限，那么后面左右边界中的字符串也会变得不符合题意。
     *  但是无所谓，因为right是每一轮都向右走，但是left不会，他每不走一轮，最长子序列的长度就是多长1。
     *  所以最后结果就是数组长度，即right所在的最后一点减去left坐标的位置。
     *
     * 这个算法很巧妙，写的时候要想象有个框，当多一个符合条件的时候，框就会长一点。
     * 当下一个不符合条件的时候，整个框就相当于平移一格。
     *
     * 总结一下，就是如果框内的字符串符合连续性，且接下来的参数不会打破这个连续性，那这个框会不断增长。（他的右侧会不断拉长）
     * 当开始不符合连续性之后，这个框就会开始平移，平移到下一个符合要求的地方。
     * 到结束都没有符合要求的话，那这个框的长度就是最长的子序列的长度。
     *
     * ps：如果需要记录最长子序列怎么办呢，个人愚见：
     *      当left不增长时，则说明，这个时候框里的字符串，符合要求，把left记录下来，当left开始变化时，记录下此时right的位置。
     *      这个时候的left和right即为最长的字符串的左右坐标。
     *
     * ps: 如果要求最短子序列怎么办呢，个人愚见：
     *      将if改换为while，if只进行一轮，即只走一步，但是while可以走到符合要求为止。
     *
     *
     * ps: 听说这种算法叫做滑动窗口。
     *
     * 可以归纳一下，感觉所有最长子序列都可以用这种解法。遍历一遍。
     * */
    public int longestOnes1(int[] A, int K) {
        int ans = 0;
        int left = 0;
        //此时ans=队列中所有的1
        for (int right = 0; right < A.length; right++) {
            if(A[right] == 1){
                ans++;
            }
            if(right - left + 1 > K + ans){
                if(A[left] == 1){
                    ans--;
                }
                left++;
            }
        }
        return A.length - left;
    }
```

### 其他
* 766 [托普利茨矩阵](https://leetcode-cn.com/problems/toeplitz-matrix/)
* 832 [反转图像]( https://leetcode-cn.com/problems/flipping-an-image/)
* 867 [转置矩阵]( https://leetcode-cn.com/problems/transpose-matrix/submissions/)
