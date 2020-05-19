# xunservice
项目采用Springboot框架，采用Linux底层命令进行底层进程，线程和系统各属性进行读取，以抽象窗口工具包（AWT）为基 础，JfreeChart图表绘制类库进行性能中CPU、内存等信息进行实时获取和展示。
#效果展示
1.2.3获取权限
迅管家应用软件需要获取用户的系统密码来获取系统中的相关信息。因此在迅管家应用软件开始打开时用户需要输入系统密码，来授予软件获取该系统信息的权限。





                       


1.3进程管理操作
用户打开迅管家应用即可看见进程页面。进程页面中用户可以看见进程的名称，优先级，状态，CPU的利用率等信息。点击表头“优先级”，“状态”等字样，即可按照该信息对进程进行排序。

1.3.1结束进程
用户在进程界面选中进程信息，进程界面停止刷新信息。用户右击弹出菜单，点击结束进程。进程页面刷新，即可发现刚才点击的进程消失，进程打开的窗口也随即消失。
用户可以右击来选择查看进程的内从利用率的百分比或具体值。






1.3.2结束进程树
用户在进程界面选中进程信息，进程界面停止刷新信息。用户右击弹出菜单，点击结束进程树。进程页面刷新，即可发现与刚才点击的进程相关联的进程树消失。与进程树中进程相关的窗口应用也会关闭。

1.3.3设置进程优先级
用户在进程界面选中进程信息，进程界面停止刷新信息。用户右击弹出菜单，点击设置优先级。然后再打开的窗口中调节滑块来调节进程的优先级。当发现滑块不能滑动时，代表该进程的优先级不能调节。

1.3.4查看进程文件
用户在进程界面选中进程信息，进程界面停止刷新信息。用户右击弹出菜单，点击打开文件位置，即可在资源管理器中打开进程文件所在的目录。









1.3.5查看进程属性
用户在进程界面选中进程信息，进程界面停止刷新信息。用户右击弹出菜单，点击属性。即可再打开的窗口中查看该进程的具体的属性信息。








1.4应用管理操作
用户点击进程的选项卡，即可看到应用页面。应用页面中用户可以看见应用的名称，优先级，状态，CPU的利用率等信息。

1.4.1结束任务
用户在应用界面选中应用信息，应用界面停止刷新信息。用户右击弹出菜单，点击结束任务，即可关闭打开的电脑中对应的应用。


1.4.2查看应用文件
用户在应用界面选中应用信息，应用界面停止刷新信息。用户右击弹出菜单，点击打开文件位置，即可再资源管理器中打开应用文件所在的目录。





1.4.3查看应用属性
用户在应用界面选中应用信息，应用界面停止刷新信息。用户右击弹出菜单，点击属性。即可再打开的窗口中查看该应用的具体的属性信息。



1.5性能管理
用户点击性能选项卡，可以查看到系统中各种性能的数据以及变化。
1.5.1查看CPU
用户点击性能页面中的CPU按钮即可跳转到CPU页面。用户可以在该页面查看到系统对CPU利用率在一段时间内的折线图。以及系统系统中CPU的详细信息：实时时的CPU的利用率，运行的进程，线程，运行时间等信息。


1.5.2查看内存
用户点击性能页面中的内存按钮即可跳转到内存页面。用户可以在该页面查看到系统在一段时间内的内存使用率变化的折线图。以及系统内存的详细信息：使用中的内存，
可用内存，缓存，虚拟内存等信息。


1.5.3查看磁盘
用户点击性能页面中的磁盘按钮即可跳转到磁盘页面。用户可以在该页面查看到系统在一段时间内的磁盘读取速度变化的折线图。以及系统磁盘的详细信息：磁盘实时的读取速度，容量等信息。





1.6查看网络
用户点击性能页面中的网络按钮即可跳转到网络页面。用户可以在该页面查看到系统在一段时间内的网阔速度变化的折线图。以及系统网络的详细信息：网口接收速度，网口发送速度，IPV6地址，IPV4地址等信息。


1.6.1联网管理操作
用户点击联网的选项卡，即可看到联网页面。应用页面中用户可以看见进程的名称，该进程从网络上接受包的数量，发送包的数量，本地访问地址。


1.6.2结束任务
用户在界面选中联网信息，联网界面停止刷新信息。用户右击弹出菜单，点击结束任务，关闭选中的进程。


1.6.3查看属性
用户在联网界面选中联网信息，联网界面停止刷新信息。用户右击弹出菜单，点击属性。即可再打开的窗口中查看该联网信息的具体的属性信息。





1.7其他操作
1.7.1运行新任务
用户点击菜单栏中的文件，选中运行新任务。在新建任务窗口点击浏览按钮，选中自己想要打开或执行的文件，点击确定。如果文件是可执行文件，则执行选中的文件，如果是不可执行文件，则用相应的软件打开文件。如果用户权限不够，则弹出提示框，提醒用户权限不够。
步骤一：点击文件中的运行新任务

步骤二：点击浏览按钮


步骤三：选择运行的文件，点击“open”按钮


步骤四：点击确定


步骤五：运行任务


1.7.2重新输入系统密码
当用户的系统密码更改时或开始没有输入密码时，用户可以点击菜单栏中的选项的获取权限的按钮，弹出输入密码的框，用户输入系统密码即代表管家应用获取系统磁盘信息权限。用户输入系统密码后，点击确定，之后可在性能中查看系统磁盘信息。
步骤一：点击菜单栏中的选项，选中获取权限。

步骤二：在弹出的窗体中输入linux系统密码。


步骤三：如果输入错误密码。则弹出错误提示框


如果输入正确，则弹出正确的提示框。


1.7.3退出
用户点击菜单栏中的文件，选中退出，则退出迅管家应用。


1.7.4立即刷新
用户点击菜单栏中的查看，选中立即刷新，即可立即刷新进程、应用、联网信息。







1.7.5选择刷新速度
用户点击菜单栏中的速度，用户即可按照自己的使用习惯来选择刷新速度。

