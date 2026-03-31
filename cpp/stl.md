## vector常用

1.初始化

```cpp
vector<int> nums;
vector<int> nums(5);// 5个元素
vector<int> nums(10,6);	// 10个元素 均为6
vector<int> nums = {1,2,3,4,5};

// 二维数组
vector<vector<int>> grid = {{7, 6, 3}, {6, 6, 1}};
```





2.访问

可以类似数组一样中括号随机寻址



3.获取大小

```cpp
nums.size();
```



