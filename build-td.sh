cd td
rm -rf build
mkdir build
cd build
cmake -DCMAKE_BUILD_TYPE=Release -DJAVA_HOME=/Users/rinatmuhamedgaliev/.sdkman/candidates/java/current -DOPENSSL_ROOT_DIR=/usr/local/opt/libressl/ -DCMAKE_INSTALL_PREFIX:PATH=../example/java/td -DTD_ENABLE_JNI=ON ..
cmake --build . --target install
cd ..
