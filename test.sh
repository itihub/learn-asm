#!/bin/bash
asm_lib=/c/Users/Admin/.m2/repository/org/ow2/asm/asm/7.3.1/asm-7.3.1.jar
asm_util_lib=/c/Users/Admin/.m2/repository/org/ow2/asm/asm-util/7.3.1/asm-util-7.3.1.jar
# 加载类运行所依赖其他类的路径，通常是类库，jar包之类
java -classpath .:$asm_lib:$asm_util_lib org.objectweb.asm.util.ASMifier org.example.asm.Foo