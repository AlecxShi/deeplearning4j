cmake_minimum_required(VERSION 3.9)
project(tests_cpu)
add_subdirectory(lib/googletest-release-1.8.0)
set(gtest_SOURCE_DIR lib/googletest-release-1.8.0)
#add_subdirectory(libnd4j_tests)
add_subdirectory(layers_tests)