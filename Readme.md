GEF 学习
===================================  
## README语法
----------------------------------- 
1. 标题：依次使用几个#表示标题等级，大标题也可以用===，次标题也可以用-------。标题与#之间要留一个空格，
*  段落 Paragraph ：两段文字之间至少要留有一个空行，每行文字只要输入两个Tab再输入文字
*  字体 Styling Text：
>斜体： *This text will be italic*  （对应HTML中的标签）
>粗体：**This text will be bold** （对应HTML中的标签）
*  列表 Lists：无序号的列表 Unordered Lists
	* 实心的圆点
	- 注意： *和-要与列表内容之间要有空格， *是实心的圆点，-是空心的圆点
* 有序号的列表 Ordered List:s
	1. 注意： 列表序号与列表内容之间要有空格
* 嵌套的列表 Nested Lists:
	* item 二级
		* item 三级
			* 注意： 嵌套列表要缩进2个空格 
* 引用 Blockquotes：
	引用文字前填加 > 
* 代码快 Code Block
	每行代码前，使用4个空格或者tab缩进。
	代码高亮
	在三个反引号后面加上编程语言的名字，另起一行开始写代码，最后一行再加上三个反引号。
	```
	public static void main(String[]args){} //Java
	```
	
	
* 链接 Links：
		把链接文字放在中括号[]中，把对应的URL放到小括号()中。例如[Sina Blog](blog.sina.com.cn)
		只是显示图片                                                                                                    ![github](http://github.com/unicorn.png "github")
		点击某个图片进入一个网页                                                                      [image]: http://github.com/github.png "github"  
* 语法详细
[README语法](https://github.com/guodongxiaren/README)


## 创建一个简单的GEF模型
### 建立基本的GEF工程
  包括 : 模型、控制器和视图
#### Model
##### Node 模型
		This class will contain the basic properties that all derived classes will be able to use
	如文中所意，Node类是做为一个基类存在的，主要属性有  name（节点名） layout（界面大小）children（子节点）parent（父节点）;
	Enterprise（有属性address，capital）, Service（有属性etage） and Employe（有属性prenom） 做为子类存在
	
		Each object in the model needs to be associated with a Figure (draw2d) and an EditPart
	因此，我们学着也创建自己的类：HDepartment（有属性capital）
	首先建立HDepartment模型，其次建立HDepartmentFigue算是HDepartment的图形显示，而EditPart则规定发如何来编辑模型，比如双击选中动作，打开属性View
	
	
#### 使用Editor 作为操作 GEF 的界面
	我们的Editor类从  org.eclipse.ui.part.EditorPart 的子类 org.eclipse.ui.parts.GraphicalEditor派生而来。
	因为 GraphicalEditor 类 '可以帮助我们创建显示 GEF 图形的 视图 Viewer，'
	要加一个 ID 用于标示这个 Editor
	(
	此时不可运行 问题出在:GEF插件未启动,GEF插件不只是代码,而是一个OSGI程序，因此，要先到启动器（launcher里面配置，将Plugin里的GEF等插件设置为启动）
	)
	可以通过以下方法得到window
	
```Java
IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
```
	 
#####Editor的内容提供者 EditInput
		Editing domain 管理命令堆栈 command stack、工具条 palette viewer 等。Editing domain 还起通知在Graphicalviewer 中生成的 SWT 事件的作用。
		因此，一定要建立一个 Editing domain。这里，在Editor的构造函数中使用setEditDomain()函数设置了一个org.eclipse.gef.DefaultEditDomain作为Editing domain。
		我们要说明的是：虽然对 GEF 来讲一个 Editing domain 必须是设置成 Graphicalviewer（直白点说就是可画图的），因为我们的 DiagramEditor 是从 GraphicalEditor 派生的，
		所以这里的缺省的Editing domain—DefaultEditDomain 其内在是被设置成 Graphicalviewer 的。
		说明：如果我们把 Graphicalviewer 放在 Editor 中时，我们使用 DefaultEditDomain。'''如果把	Graphicalviewer 放在 View 中或者放在一个独立的 Eclipse 应用中时，
		我们要用 org.eclipse.gef.EditDomain	作为 Editing domain'''

##### EditParts Factory
	此工程使用工厂来管理EditParts,model,（主要是生成）
	从目前代码来看，只有Entreprise有createEditPart方法，我们为自己的模型也增加此方法，等下看这个方法作用
	为GraphicalViewer添加setEditPartFactory，那么GraphicalViewer上的图案应该就能使用相应EditPartFactory管理了吧

## 第二阶段


PAGE 22


















