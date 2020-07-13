# 1. 栈和队列

## 1.1 设计一个有getMin功能的栈

### 题目

​	实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。

### 要求

​	1. pop、push、getMin操作的时间复杂度都是$$O(1)$$

​	2. 设计的栈类型可以使用现成的栈结构

### 难度

​	士 一颗星

### 解答

​	设计思路为使用两个stack，一个用来存储正常stack数据，一个用来存储每次的最小值。有两种具体实现方式：

第一种设计方案：

-  压入数据规则

  假如当前数据为value，先将其压入stackData。然后判断stackMin是否为空

  - 如果stackMin为空，则直接将value压入stackMin
  - 如果value小于等于getMin的值，则将value压入stackMin
  - 如果value大于getMin的值，则stackMin中不压入任何数据
  - ![image-20200713152114196](image-20200713152114196.png)

- 弹出数据规则

  ​	先在stackData中弹出栈顶元素，记为value，然后比较getMin的元素与value哪个更小。

  ​	通过上文提到的压入规则可知，stackMin中存在的元素是从栈底到栈顶逐渐变小的，stackMin栈顶的元素既是stackMin栈的最小值，也是当前stackData栈的最小值。所以不会出现value比stackMin的栈顶元素更小的情况，value只可能大于或等于stackMin的栈顶元素。

  - 仅当value等于stackMin的栈顶元素时，stackMin弹出栈顶元素

- 获取最小值

  由上文的压入和弹出数据规则可知，stackMIn始终记录着stackData的最小值，所以，stackMin的栈顶元素始终是当前stackData中的最小值

> tips：
>
> ​	所有pop或peek操作需提前校验是否为空

- 代码位置：com.tangwan.zuochengyun.chapter01_StackAndQueue.T01_GetMinFromStack.MyStack1



第二种设计方案：

- 压入数据规则

  假如当前数据为value，先将其压入stackData。然后判断stackMin是否为空

  - 如果stackMin为空，则直接将value压入stackMin
  - 如果value小于getMin的值，则将value压入stackMin
  - 如果value大于等于getMin的值，则stackMin中压入getMin

  - ![image-20200713153619808](image-20200713153619808.png)

- 弹出数据规则

  stackData弹出，stackMin也弹出，因为stackData和stackMin是一对一的。

- 获取最小值：同上述方案

- 代码位置：com.tangwan.zuochengyun.chapter01_StackAndQueue.T01_GetMinFromStack.MyStack2

### 点评

方案一和方案二都是用stackMin栈保存着stackData每一步的最小值。

共同点：

- 所有操作的时间复杂度都是 $$O(1)$$、空间复杂度都为$$O(n)$$

区别：

- 方案一中stackMin压入时稍省时间，但是弹出操作稍费时间
- 方案二中stackMin压入时稍费时间，但是弹出操作稍省时间

### 完整代码位置

​	com.tangwan.zuochengyun.chapter01_StackAndQueue.T01_GetMinFromStack



## 1.2 由两个栈组成的队列

### 题目：

​	编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）

### 难度：

​	尉 两颗星

### 解答：

​	栈的特点是FILO，而队列的特点是FIFO。使用两个栈正好能把顺序反过来实现类似队列的操作.

​	具体实现是：

-  一个栈作为压入，在压入数据的时候只往这个栈中压入，记为stackPush
- 另一个栈作为弹出栈，在弹出数据的时候只从这个栈弹出，记为stackPop



​	因为数据压入栈的时候，顺序是FILO的，那么只要把stackPush中的数据再压入stackPop中，顺序就变成FIFO了。

​	例如，将1~5依次压入stackPush，那么从stackPush的栈顶到栈底为5~1，此时依次再讲5~1倒入stackPop，那么从stackPop的栈顶到栈底就变成了1~5.再从stackPop弹出时，顺序就像队列一样，如下图所示。

![image-20200713170741628](image-20200713170741628.png)



> tips：
>
> 上述过程需注意两点：
>
> 1. 如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入
> 2. 如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
>
> 违反了以上两点都会发生错误。



### 代码

​	com.tangwan.zuochengyun.chapter01_StackAndQueue.T02_QueueConsistingOfTwoStacks

