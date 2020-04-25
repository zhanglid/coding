#!/bin/bash

if [ "$1" = '' ]
then
    read -p "Enter problem name: " PROBLEM_NAME
else
    PROBLEM_NAME=$1
fi

if [ "$2" = '' ]
then
    FOLD_NAME="leetcode"
else
    FOLD_NAME=$2
fi

if [ "$3" = '' ]
then
    TYPE="java"
else
    TYPE=$3
fi

createJava() {
    CLASS_FILE_PATH="java-src/main/java/com/zhangliang/${FOLD_NAME}/${PROBLEM_NAME}.java"
    TEST_FILE_PATH="java-src/test/java/com/zhangliang/${FOLD_NAME}/${PROBLEM_NAME}Test.java"

    echo $CLASS_FILE_PATH
    echo $TEST_FILE_PATH

    touch $CLASS_FILE_PATH
    touch $TEST_FILE_PATH

    echo "package com.zhangliang.${FOLD_NAME};" >> $CLASS_FILE_PATH
    echo '/*' >> $CLASS_FILE_PATH
    echo '  Assumptions: ' >> $CLASS_FILE_PATH
    echo '  Approach: ' >> $CLASS_FILE_PATH
    echo '  DataStructure: ' >> $CLASS_FILE_PATH
    echo '  Complexity: ' >> $CLASS_FILE_PATH
    echo '      Time: ' >> $CLASS_FILE_PATH
    echo '      Space: ' >> $CLASS_FILE_PATH
    echo '  !Remeber to comment ' >> $CLASS_FILE_PATH
    echo '*/' >> $CLASS_FILE_PATH
    echo '' >> $CLASS_FILE_PATH
    echo "public class $PROBLEM_NAME {" >> $CLASS_FILE_PATH
    echo '    public int solve() {' >> $CLASS_FILE_PATH
    echo '        ' >> $CLASS_FILE_PATH
    echo '    }' >> $CLASS_FILE_PATH
    echo '}' >> $CLASS_FILE_PATH


    echo "package com.zhangliang.${FOLD_NAME};" >> $TEST_FILE_PATH
    echo 'import static org.junit.Assert.assertEquals;' >> $TEST_FILE_PATH
    echo 'import java.util.Arrays;' >> $TEST_FILE_PATH
    echo 'import org.junit.Test;' >> $TEST_FILE_PATH
    echo '' >> $TEST_FILE_PATH
    echo "public class ${PROBLEM_NAME}Test{" >> $TEST_FILE_PATH
    echo '' >> $TEST_FILE_PATH
    echo '@Test' >> $TEST_FILE_PATH
    echo 'public void testCase() {' >> $TEST_FILE_PATH
    echo "    ${PROBLEM_NAME} s = new ${PROBLEM_NAME}();" >> $TEST_FILE_PATH
    echo '    String ans = s.solve();' >> $TEST_FILE_PATH
    echo '    assertEquals("", ans);' >> $TEST_FILE_PATH
    echo '}' >> $TEST_FILE_PATH
    echo '}' >> $TEST_FILE_PATH
}

createJavaScript() {
    JS_FILE_PATH="javascript-src/${FOLD_NAME}/${PROBLEM_NAME}.js"
    TEST_FILE_PATH="javascript-src/${FOLD_NAME}/__tests/${PROBLEM_NAME}.test.js"

    echo $JS_FILE_PATH
    echo $TEST_FILE_PATH

    touch $JS_FILE_PATH
    touch $TEST_FILE_PATH

    echo '/*' >> $JS_FILE_PATH
    echo '' >> $JS_FILE_PATH
    echo '*/' >> $JS_FILE_PATH


    echo "import {} from \"../${PROBLEM_NAME}.js\";" >> $TEST_FILE_PATH
    echo '' >> $TEST_FILE_PATH
    echo "describe(\"${PROBLEM_NAME}\", () => {" >> $TEST_FILE_PATH
    echo '    test("testCase1", () => {});' >> $TEST_FILE_PATH
    echo "});" >> $TEST_FILE_PATH

};

echo "$TYPE";

if [ "$TYPE" = 'java' ]
then
    createJava
else
    createJavaScript
fi