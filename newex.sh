#!/bin/bash

if [ -n "$1" ]; then
  # 测试第一个参数是否满足 aaa.bbb.ccc.ClasName
  className=$1
  match=$(echo $className | grep -E "^([a-z]+\.)*[A-Z][a-z0-9A-Z]+")
  # match="hello, world"
  if [[ x$match != "x" ]]; then
    fullName=${match//\./\/}
    baseName=`basename ${fullName}`
    dirName=`dirname ${fullName}`
    echo $baseName
    echo $dirName
    prefix="./src"
    ## TODO: 如果已经存在目标文件，需要进行其他的操作

    srcPath="${prefix}/main/java/${fullName}.java"
    testPath="${prefix}/test/java/${fullName}Test.java" 

    mkdir -p ${prefix}/main/java/${dirName}
    mkdir -p ${prefix}/test/java/${dirName}

    # echo $srcPath
    # echo $testPath

    cp "./template_java/Ex.java" $srcPath
    cp "./template_java/ExTest.java" $testPath

    sed -i s/ExNumber/${baseName}/g $srcPath
    sed -i 1s/packageName/${match/%.${baseName}//} $srcPath
    sed -i s/ExNumber/${baseName}/g $testPath
    sed -i 1s/packageName/${match/%.${baseName}//} $testPath

  else
    echo "not valid class name, eg: com.string.Ex01"
  fi
else
  echo "need one arguments"
  exit
fi
