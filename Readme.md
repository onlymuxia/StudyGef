GEF ѧϰ
===================================  
## README�﷨
----------------------------------- 
1. ���⣺����ʹ�ü���#��ʾ����ȼ��������Ҳ������===���α���Ҳ������-------��������#֮��Ҫ��һ���ո�
*. ���� Paragraph ����������֮������Ҫ����һ�����У�ÿ������ֻҪ��������Tab����������
*. ���� Styling Text��
	б�壺 *This text will be italic*  ����ӦHTML�еı�ǩ��
	���壺**This text will be bold** ����ӦHTML�еı�ǩ��
*. �б� Lists��
	����ŵ��б� Unordered Lists
	* item
	- item
	ע�⣺ *��-Ҫ���б�����֮��Ҫ�пո� *��ʵ�ĵ�Բ�㣬-�ǿ��ĵ�Բ��
*.����ŵ��б� Ordered List:s
	1. item
	ע�⣺ �б�������б�����֮��Ҫ�пո�
*.Ƕ�׵��б� Nested Lists:
	1. item
	  1.1 item
	ע�⣺ Ƕ���б�Ҫ����2���ո� 
*.���� Blockquotes��
	��������ǰ��� > 
*.����� Code Block
	��ÿ�д���ǰ��ʹ��4���ո����tab������
	���磺
    ## Title
	    if x > y:
	        print x
	
*.���� Links��
���������ַ���������[]�У��Ѷ�Ӧ��URL�ŵ�С����()�С�����[Sina Blog](blog.sina.com.cn)
ֻ����ʾͼƬ                                                                                                    ![github](http://github.com/unicorn.png "github")
���ĳ��ͼƬ����һ����ҳ                                                                      [image]: http://github.com/github.png "github"  
10.�﷨��ϸ
[README�﷨](https://github.com/guodongxiaren/README)
## ����һ��t�򵥵�GEFģ��
### ����������GEF����
                 ���� : ģ�͡�����������ͼ
#### ʹ��Editor ��Ϊ���� GEF �Ľ���
	���ǵ�Editor���  org.eclipse.ui.part.EditorPart ������ org.eclipse.ui.parts.GraphicalEditor����������
	��Ϊ GraphicalEditor �� '���԰������Ǵ�����ʾ GEF ͼ�ε� ��ͼ Viewer��'
	Ҫ��һ�� ID ���ڱ�ʾ��� Editor
	(
	��ʱ�������� �������:GEF���δ����,GEF�����ֻ�Ǵ���,����һ��OSGI������ˣ�Ҫ�ȵ���������launcher�������ã���Plugin���GEF�Ȳ������Ϊ������
	)
	����ͨ�����·����õ�window
'''java
	 IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
	 
	 
#####Editor�������ṩ�� EditInput
		Editing domain ���������ջ command stack�������� palette viewer �ȡ�Editing domain ����֪ͨ��Graphicalviewer �����ɵ� SWT �¼������á�
		��ˣ�һ��Ҫ����һ�� Editing domain�������Editor�Ĺ��캯����ʹ��setEditDomain()����������һ��org.eclipse.gef.DefaultEditDomain��ΪEditing domain��
		����Ҫ˵�����ǣ���Ȼ�� GEF ����һ�� Editing domain ���������ó� Graphicalviewer��ֱ�׵�˵���ǿɻ�ͼ�ģ�����Ϊ���ǵ� DiagramEditor �Ǵ� GraphicalEditor �����ģ�
		���������ȱʡ��Editing domain��DefaultEditDomain �������Ǳ����ó� Graphicalviewer �ġ�
		˵����������ǰ� Graphicalviewer ���� Editor ��ʱ������ʹ�� DefaultEditDomain��'''�����	Graphicalviewer ���� View �л��߷���һ�������� Eclipse Ӧ����ʱ��
		����Ҫ�� org.eclipse.gef.EditDomain	��Ϊ Editing domain'''


#### Model
	
## �ڶ��׶�



















