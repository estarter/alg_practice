#include <algorithm>
#include <iterator>
#include <iostream>
#include <vector>
#include <list>
#include <deque>
#include <math.h>
#include "gtest/gtest.h"
#include "gmock/gmock.h"
using std::cout; using std::endl; using std::cin;

// typedef std::deque<int> CONT;
typedef std::list<int> CONT;


bool is_divided_by(const int& number, const CONT & primes) {
    for (int p : primes) {
        // if (number == p) return false;
        if (number % p == 0) return true;
    }
    return false;
}

TEST(prime_numbers, is_divided_by) {
    CONT v = {2, 3};
    // ASSERT_FALSE(is_divided_by(2, v));
    // ASSERT_FALSE(is_divided_by(3, v));
    ASSERT_FALSE(is_divided_by(5, v));

    ASSERT_TRUE(is_divided_by(4, v));
    ASSERT_TRUE(is_divided_by(6, v));
}

CONT prime_numbers(const int to) {
    CONT result;
    for (int i = 2; i <= to; i++) {
        if (!is_divided_by(i, result)) {
            result.push_back(i);
        }
    }
    return result;
}
TEST(prime_numbers, simple) {
    CONT v {2, 3};
    ASSERT_THAT(v, ::testing::ContainerEq(prime_numbers(3)));
    ASSERT_THAT(v, ::testing::ContainerEq(prime_numbers(4)));
    v = {2, 3, 5};
    ASSERT_THAT(v, ::testing::ContainerEq(prime_numbers(5)));
    ASSERT_THAT(v, ::testing::ContainerEq(prime_numbers(6)));
}

// CONT prime_numbers_force(const int& from, const int& to) {
//     CONT result = prime_numbers(to);
//     result.erase(std::remove_if(begin(result), end(result), [from](auto it) {return it < from;}), end(result));
//     return result;
// }
// TEST(prime_numbers, force) {
//     CONT v{2, 3, 5, 7};
//     ASSERT_THAT(v, ::testing::ContainerEq(prime_numbers_force(1, 10)));
//     v = {11, 13, 17, 19};
//     ASSERT_THAT(v, ::testing::ContainerEq(prime_numbers_force(10, 20)));
//     v = {31, 37, 41, 43, 47};
//     ASSERT_THAT(v, ::testing::ContainerEq(prime_numbers_force(30, 50)));
// }

CONT prime_numbers(const int from, const int to) {
    int slice = sqrt(to);
    CONT first_primes = prime_numbers(slice);

    CONT result;
    for (int i = from; i <= to; i++) {
        if (i > 1 && !is_divided_by(i, first_primes)) {
            result.push_back(i);
        }
    }
    std::copy_if(rbegin(first_primes),
                 rend(first_primes),
                 std::front_inserter(result),
                 [from](int num) {return num >= from;});
    return result;
}
TEST(prime_numbers, fast) {
    ASSERT_THAT((CONT {2, 3, 5, 7}), ::testing::ContainerEq(prime_numbers(1, 10)));
    ASSERT_THAT((CONT {11, 13, 17, 19}), ::testing::ContainerEq(prime_numbers(10, 20)));
    ASSERT_THAT((CONT {31, 37, 41, 43, 47}), ::testing::ContainerEq(prime_numbers(30, 50)));
}


int main(int argc, char **argv) {
    if (argc == 2 && std::string(*(argv+1)) == "test") {
        ::testing::GTEST_FLAG(throw_on_failure) = true;
        ::testing::InitGoogleMock(&argc, argv);
        ::testing::InitGoogleTest(&argc, argv);
        return RUN_ALL_TESTS();
    }

    int test_amount = 0;
    cin >> test_amount;
    while (test_amount-- > 0) {
        int from, to;
        cin >> from >> to;
        auto result = prime_numbers(from, to);
        // auto result = prime_numbers_force(from, to);
        std::copy(begin(result), end(result), std::ostream_iterator<int>(cout, " "));
        cout << endl;
    }
}
