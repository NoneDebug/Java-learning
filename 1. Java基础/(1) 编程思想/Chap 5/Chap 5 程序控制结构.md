# 顺序控制

- 程序从上到下逐行地执行，中间没有任何判断和跳转
- 顺序控制举例和注意事项
	- 合法的向前引用（引用定义好的变量）

# 分支控制（if, else, switch）

- 让程序有选择的执行，分支结构有三种
	- 单分支
	- 双分支
	- 多分支

- 单分支
	- 基本语法：```if(条件表达式){执行代码块; （可以有多条语句）}```
	- 说明：若条件表达式为真，则执行{}的代码

- 双分支
	- 基本语法：```if(条件表达式){执行代码块1; （可以有多条语句）} else{执行代码块2}；（可以有多条语句）```
	- 说明：若条件表达式为真，执行代码块1；否则，执行代码块2

- 多分支
	- 基本语法：```if(条件表达式1){执行代码块1；} else if(条件表达式2){执行代码快2;} else if(条件表达式3){执行代码块3;} ... else if(条件表达式n){执行代码块n；} else{执行代码块n+1}```
	- 说明：若条件表达式1为真，执行代码块1，否则，查看条件表达式2，若该式为真，执行代码块2；以此类推。
	- ps：可以没有else

- 嵌套分支
	- 一个分支结构中完整嵌套另一个完整的分支结构，里面的分支结构称为内层分支，外面的称为外层分支。规范：不要超过3层（可读性下降）
	- 基本语法：
	 ```
	 if(){
		 if(){
			//if-else...
		}else{
			//if-else...
		}
	 }
	```

- Switch
	- 基本语法：
	```
	swith(表达式)
		case 常量1:
			语块1;
			break;
		case 常量2:
			语块2;
			break;
		...
		case 常量n:
			语块n;
			break;
		default:
			default语句块
			break;
	```
	- 注意事项和细节讨论
		- 表达式数据类型，应和case后的常量类型一致，或是可以自动转成可以相互比较的类型
		- switch（表达式）中表达式的返回值必须是：byte, short, int, char, enum, String
		- case子句中的值必须是常量，而不是变量
		- default可以没有
		- 没有break，会顺序执行下一个语句块。

- Switch 和 if 的比较
	- 如果判断具体数值不多，且符合byte、short、int、char、enum、String这几种类型，建议使用switch
	- 对区间判断，对结果为boolean类型判断，使用if，if的使用范围更广。
# 循环控制（for, while, dowhile, 多重循环）

## for

- 基本语法：```for(初始语句; 终止语句; 变换语句){循环语句块;}```
- 说明：
	- for关键字，表示循环控制
	- 四要素：(1) 循环变量初始化 (2) 循环条件 (3) 循环操作 (4) 循环变量迭代
	- 循环操作，可以有多个语句，即要执行的代码
	- 如果循环操作（语句）只有一条语句，可以省略{}，但建议不要省略
- 注意事项：
	- 循环条件是一个布尔值的表达式
	- for两边分号不能省略
	- 循环初始值可以有多个语句，但要求变量类型一致，中间用`,`隔开，变量迭代语句也可以有多个。
	- 变量的作用域只能在for中
## while

- 基本语法：```while(条件){循环语句}```
- 当条件满足时，执行循环语句；条件不满足时，不执行循环语句。
- 注意事项：
	- 先判断，再执行
## dowhile

- 基本语法：```do{循环语句}while(条件);```
- 相比while，先执行一次，再判断
## 多重循环

- 循环的叠加（建议叠2层）
# break

- 退出当前循环 或 swtich
- break语句出现在多层嵌套的语句块中时，可以通过**标签**指明要终止的时哪一层的语句块
	- break labelk
	- 说明：
		- break语句可指明退出哪层
		- label1是标签，由程序员指定
		- break后指定哪个label就退出到那里（等价只能用在循环中的goto）
		- 实际开发中，尽量不要使用goto
		- 如果没有指定的break标签，默认退出最近的循环体

# continue

- 在循环中，跳过接下的执行语句，并跳转至条件判断语句。
# return

- 表示跳出所在方法，如果return写在main方法，退出程序
