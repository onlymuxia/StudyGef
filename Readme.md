GEF ѧϰ
===================================  
## README�﷨
----------------------------------- 
1. ���⣺����ʹ�ü���#��ʾ����ȼ��������Ҳ������===���α���Ҳ������-------��������#֮��Ҫ��һ���ո�
*  ���� Paragraph ����������֮������Ҫ����һ�����У�ÿ������ֻҪ��������Tab����������
*  ���� Styling Text��
>б�壺 *This text will be italic*  ����ӦHTML�еı�ǩ��
>���壺**This text will be bold** ����ӦHTML�еı�ǩ��
*  �б� Lists������ŵ��б� Unordered Lists
	* ʵ�ĵ�Բ��
	- ע�⣺ *��-Ҫ���б�����֮��Ҫ�пո� *��ʵ�ĵ�Բ�㣬-�ǿ��ĵ�Բ��
* ����ŵ��б� Ordered List:s
	1. ע�⣺ �б�������б�����֮��Ҫ�пո�
* Ƕ�׵��б� Nested Lists:
	* item ����
		* item ����
			* ע�⣺ Ƕ���б�Ҫ����2���ո� 
* ���� Blockquotes��
	��������ǰ��� > 
* ����� Code Block
	ÿ�д���ǰ��ʹ��4���ո����tab������
	�������
	�����������ź�����ϱ�����Ե����֣�����һ�п�ʼд���룬���һ���ټ������������š�
	```
	public static void main(String[]args){} //Java
	```
	
	
* ���� Links��
		���������ַ���������[]�У��Ѷ�Ӧ��URL�ŵ�С����()�С�����[Sina Blog](blog.sina.com.cn)
		ֻ����ʾͼƬ                                                                                                    ![github](http://github.com/unicorn.png "github")
		���ĳ��ͼƬ����һ����ҳ                                                                      [image]: http://github.com/github.png "github"  
* �﷨��ϸ
[README�﷨](https://github.com/guodongxiaren/README)


## ����һ���򵥵�GEFģ��
### ����������GEF����
  ���� : ģ�͡�����������ͼ
#### Model
##### Node ģ��
		This class will contain the basic properties that all derived classes will be able to use
	���������⣬Node������Ϊһ��������ڵģ���Ҫ������  name���ڵ����� layout�������С��children���ӽڵ㣩parent�����ڵ㣩;
	Enterprise��������address��capital��, Service��������etage�� and Employe��������prenom�� ��Ϊ�������
	
		Each object in the model needs to be associated with a Figure (draw2d) and an EditPart
	��ˣ�����ѧ��Ҳ�����Լ����ࣺHDepartment��������capital��
	���Ƚ���HDepartmentģ�ͣ���ν���HDepartmentFigue����HDepartment��ͼ����ʾ����EditPart��涨��������༭ģ�ͣ�����˫��ѡ�ж�����������View
	
	
#### ʹ��Editor ��Ϊ���� GEF �Ľ���
	���ǵ�Editor���  org.eclipse.ui.part.EditorPart ������ org.eclipse.ui.parts.GraphicalEditor����������
	��Ϊ GraphicalEditor �� '���԰������Ǵ�����ʾ GEF ͼ�ε� ��ͼ Viewer��'
	Ҫ��һ�� ID ���ڱ�ʾ��� Editor
	(
	��ʱ�������� �������:GEF���δ����,GEF�����ֻ�Ǵ���,����һ��OSGI������ˣ�Ҫ�ȵ���������launcher�������ã���Plugin���GEF�Ȳ������Ϊ������
	)
	����ͨ�����·����õ�window
	
```Java
IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
```
	 
#####Editor�������ṩ�� EditInput
		Editing domain ���������ջ command stack�������� palette viewer �ȡ�Editing domain ����֪ͨ��Graphicalviewer �����ɵ� SWT �¼������á�
		��ˣ�һ��Ҫ����һ�� Editing domain�������Editor�Ĺ��캯����ʹ��setEditDomain()����������һ��org.eclipse.gef.DefaultEditDomain��ΪEditing domain��
		����Ҫ˵�����ǣ���Ȼ�� GEF ����һ�� Editing domain ���������ó� Graphicalviewer��ֱ�׵�˵���ǿɻ�ͼ�ģ�����Ϊ���ǵ� DiagramEditor �Ǵ� GraphicalEditor �����ģ�
		���������ȱʡ��Editing domain��DefaultEditDomain �������Ǳ����ó� Graphicalviewer �ġ�
		˵����������ǰ� Graphicalviewer ���� Editor ��ʱ������ʹ�� DefaultEditDomain��'''�����	Graphicalviewer ���� View �л��߷���һ�������� Eclipse Ӧ����ʱ��
		����Ҫ�� org.eclipse.gef.EditDomain	��Ϊ Editing domain'''

##### EditParts Factory
	�˹���ʹ�ù���������EditParts,model,����Ҫ�����ɣ�
	��Ŀǰ����������ֻ��Entreprise��createEditPart����������Ϊ�Լ���ģ��Ҳ���Ӵ˷��������¿������������
	ΪGraphicalViewer���setEditPartFactory����ôGraphicalViewer�ϵ�ͼ��Ӧ�þ���ʹ����ӦEditPartFactory�����˰�

## �ڶ��׶�


PAGE 22


















