
# ASM  

ASM是字节码操纵处理框架，不仅能够读字节码，而且还能修改字节码，我们经常是先写好JAVA代码，然后编译(IDE或者javac)生成class文件，最后classloader再把相应的class文件加载到内存，但是有了ASM后，我们可以直接使用ASM生成class文件的字节数组，即面向字节码写JAVA代码，这样可以让JVM动态去加载一个类，但是这个类的class文件并不存在磁盘上，也就是说这个类的class文件是在内存中构建出来的。  

## 使用案例  

对```Foo.java```中```m1```方法做字节码增强，统计方法执行耗时

### 方式一

编写一个增强后源文件```FooEnhance.java```，通过```org.objectweb.asm.util.ASMifier```工具类生成```Foo.java```和```FooEnhance.java```字节码。  
对比两个文件字节码，找出```FooEnhance.java```中方法前和方法后加入的代码对应的字节码，创建自定义MethodVisitor的子类，重写方法，将增强字节码写入，通过自定义  
ClassVisitor的子类