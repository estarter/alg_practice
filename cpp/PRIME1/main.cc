#include <algorithm>
#include <iterator>
#include <iostream>
#include <vector>
#include <math.h>
using std::cout; using std::endl; using std::cin;


bool is_divided_by(const int& number, const std::vector<int> & primes, const int& until) {
    for (int p : primes) {
        // if (p > until) return false;
        if (number == p) return false;
        if (number % p == 0) return true;
    }
    return false;
}

std::vector<int> prime_numbers(const int& to) {
    std::vector<int> result;
    for (int i = 2; i <= to; i++) {
        if (!is_divided_by(i, result, to)) {
            result.push_back(i);
        }
    }
    return result;
}

std::vector<int> prime_numbers_force(int from, int to) {
    std::vector<int> result = prime_numbers(to);
    result.erase(std::remove_if(begin(result), end(result), [from](auto it) {return it < from;}), end(result));
    return result;
}

std::vector<int> prime_numbers(int from, int to) {
    int slice = sqrt(to);
    std::vector<int> first_primes = prime_numbers(slice);
    // cout << "first primes : ";
    // std::copy(begin(first_primes), end(first_primes), std::ostream_iterator<int>(cout, " "));
    // cout << endl;

    std::vector<int> result;
    // std::copy(begin(first_primes), )
    for (int i = from; i <= to; i++) {
        if (!is_divided_by(i, first_primes, from) && i > 1) {
            result.push_back(i);
        }
    }
    return result;
}

int main() {
    int test_amount = 0;
    cin >> test_amount;
    while (test_amount-- > 0) {
        int from, to;
        cin >> from >> to;
        auto result = prime_numbers(from, to);
        // auto result = prime_numbers_force(from, to);
        // auto result = prime_numbers(to);
        std::copy(begin(result), end(result), std::ostream_iterator<int>(cout, " "));
        cout << endl;
    }
}
