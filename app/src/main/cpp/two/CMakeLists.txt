add_library(
        jnilib SHARED jnilib.cpp
)

target_link_libraries(
        jnilib ${log-lib}
)
