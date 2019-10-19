
add_library(demon SHARED demon.cpp)
target_link_libraries(
        demon ${log-lib}
)
